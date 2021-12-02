package com.epam.shop.dao.impl;

import com.epam.shop.dao.api.AccountDao;

import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.exception.dao_exception_string.DaoAccountExceptionStrings;
import com.epam.shop.dao.model.Account;
import com.epam.shop.dao.sql_string.AccountSql;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private static AccountDaoImpl instance;
    private static Logger logger = LogManager.getLogger(AccountDaoImpl.class);
    private static ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();

    private AccountDaoImpl() {

    }

    public static AccountDao getInstance() {
        if (instance == null) {
            instance = new AccountDaoImpl();
        }
        return instance;
    }

    @Override
    public Account save(Account account) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (AccountSql.SQL_SAVE_ACCOUNT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getDateOfBirth().toString());
            preparedStatement.setString(4, account.getTelephoneNumber());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getCity());
            preparedStatement.setString(7, account.getStreet());
            preparedStatement.setInt(8, account.getFlat());
            preparedStatement.setDouble(9, account.getAmount());
            preparedStatement.setInt(10, account.getUserId());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    account.setId(resultSet.getInt(1));

                }
            }

        } catch (SQLException e) {
            logger.error(DaoAccountExceptionStrings.SQL_SAVE_ACCOUNT_EXCEPTION, e);
            throw new DaoException(DaoAccountExceptionStrings.SQL_SAVE_ACCOUNT_EXCEPTION, e);
        }
        return account;
    }

    @Override
    public Account update(Account account) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (AccountSql.SQL_UPDATE_ACCOUNT_INFORMATION)) {
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getLastName());
            preparedStatement.setString(3, account.getDateOfBirth().toString());
            preparedStatement.setString(4, account.getTelephoneNumber());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getCity());
            preparedStatement.setString(7, account.getStreet());
            preparedStatement.setInt(8, account.getFlat());
            preparedStatement.setDouble(9, account.getAmount());
            preparedStatement.setInt(10, account.getUserId());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            logger.error(DaoAccountExceptionStrings.SQL_UPDATE_ACCOUND_INFORMATION_EXCEPTION, e);
            throw new DaoException(DaoAccountExceptionStrings.SQL_UPDATE_ACCOUND_INFORMATION_EXCEPTION, e);
        }
        return account;
    }

    @Override
    public void delete(Integer userId) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (AccountSql.SQL_DELETE_ACCOUNT)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            logger.error(DaoAccountExceptionStrings.SQL_DELETE_ACCOUNT_EXCEPTION, e);
            throw new DaoException(DaoAccountExceptionStrings.SQL_DELETE_ACCOUNT_EXCEPTION, e);
        }

    }

    @Override
    public Account findById(Integer userId) throws DaoException {
        Account account = null;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (AccountSql.FIND_ACCOUNT_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);

            String FIND_ACCOUNT_BY_USER_ID = "SELECT id,first_name,last_name,date_of_birth,telephone_number,email,city,street,flat,amout WHERE user_id=?";
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    account = new Account();
                    account.setId(resultSet.getInt(1));
                    account.setFirstName(resultSet.getString(2));
                    account.setLastName(resultSet.getString(3));
                    account.setDateOfBirth(resultSet.getDate(4).toLocalDate());
                    account.setTelephoneNumber(resultSet.getString(5));
                    account.setEmail(resultSet.getString(6));
                    account.setCity(resultSet.getString(7));
                    account.setStreet(resultSet.getString(8));
                    account.setFlat(resultSet.getInt(9));
                    account.setAmount(resultSet.getDouble(10));
                }
            }


        } catch (SQLException e) {
            logger.error(DaoAccountExceptionStrings.FIND_ACCOUND_BY_USER_ID_EXCEPTION, e);
            throw new DaoException(DaoAccountExceptionStrings.FIND_ACCOUND_BY_USER_ID_EXCEPTION, e);
        }
        return account;
    }

    @Override
    public List<Account> findAll() throws DaoException {
        List<Account> list = new ArrayList<>();
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement = connection.prepareStatement
                     (AccountSql.SQL_FIND_ALL_ACCOUNTS)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account.Builder()
                            .withId(resultSet.getInt(1))
                            .withFirstName(resultSet.getString(2))
                            .withLastName(resultSet.getString(3))
                            .withDateOfBirth(resultSet.getDate(4).toLocalDate())
                            .withTelephoneNumber(resultSet.getString(5))
                            .withEmail(resultSet.getString(6))
                            .withCity(resultSet.getString(7))
                            .withStreet(resultSet.getString(8))
                            .withFlat(resultSet.getInt(9))
                            .withAmount(resultSet.getDouble(10))
                            .withUserId(resultSet.getInt(11))
                            .build();
                    list.add(account);

                }
            }
        } catch (SQLException e) {
            logger.error(DaoAccountExceptionStrings.SQL_FIND_ALL_ACCOUNTS_EXCEPTION, e);
            throw new DaoException(DaoAccountExceptionStrings.SQL_FIND_ALL_ACCOUNTS_EXCEPTION, e);
        }
        return list;
    }
}
