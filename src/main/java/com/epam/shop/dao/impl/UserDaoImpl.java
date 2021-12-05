package com.epam.shop.dao.impl;


import com.epam.shop.dao.api.UserDao;

import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.exception.string_exception.DaoUserExceptionString;
import com.epam.shop.dao.model.User;
import com.epam.shop.dao.model.UserRole;
import com.epam.shop.dao.sql_query.UserSql;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);
    private static final ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
    private static UserDao instance;


    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public User save(User user) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (UserSql.SQL_SAVE_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getAccount());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, UserRole.USER.getId());
            preparedStatement.setString(4, user.getRegistrationDate().toString());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    user.setRole(UserRole.USER);
                }
            }

        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_SAVE_USER_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_SAVE_USER_EXCEPTION, e);
        }
        return user;
    }

    @Override
    public User update(User user) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserSql.SQL_UPDATE_USER_PASSWORD)) {

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_UPDATE_USER_PASSWORD_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_UPDATE_USER_PASSWORD_EXCEPTION, e);
        }
        return user;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UserSql.SQL_DELETE_USER)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_DELETE_USER_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_DELETE_USER_EXCEPTION, e);
        }
    }

    @Override
    public User findById(Integer id) throws DaoException {
        User user = null;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (UserSql.SQL_FIND_USER_BY_ID)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setAccount(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setRegistrationDate(resultSet.getTimestamp(4).toLocalDateTime());
                    user.setRole(UserRole.getById(resultSet.getInt(5)));
                }

            }
        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_FIND_USER_BY_ID_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_FIND_USER_BY_ID_EXCEPTION, e);
        }
        return user;
    }

    @Override
    public User findByUserName(User user) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (UserSql.SQL_FIND_USER_BY_ACCOUNT_NAME)) {
            preparedStatement.setString(1, user.getAccount());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {


                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setAccount(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setRegistrationDate(resultSet.getTimestamp(4).toLocalDateTime());
                    user.setRole(UserRole.getById(resultSet.getInt(5)));

                }
            }

        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_FIND_USER_BY_NAME_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_FIND_USER_BY_NAME_EXCEPTION, e);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> list = new ArrayList<>();
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (UserSql.SQL_FIND_ALL_USERS)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {


                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setAccount(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setRegistrationDate(resultSet.getTimestamp(4).toLocalDateTime());
                    user.setRole(UserRole.getById(resultSet.getInt(5)));
                    list.add(user);

                }
            }

        } catch (SQLException e) {
            logger.error(DaoUserExceptionString.SQL_FIND_ALL_USERS_EXCEPTION, e);
            throw new DaoException(DaoUserExceptionString.SQL_FIND_ALL_USERS_EXCEPTION, e);
        }
        return list;
    }
}

