package com.epam.shop.dao.impl;


import com.epam.shop.dao.api.ProductDao;
import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.exception.dao_exception_string.DaoProductExceptionStrings;
import com.epam.shop.dao.model.Product;
import com.epam.shop.dao.sql_string.ProductSql;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static ProductDao instance;
    private static Logger logger = LogManager.getLogger(ProductDaoImpl.class);
    private static ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();


    private ProductDaoImpl() {

    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    @Override
    public Product save(Product product) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_SAVE_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getCost());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.setInt(4, product.getBrendId());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    product.setId(resultSet.getInt(1));
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_SAVE_PRODUCT_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_SAVE_PRODUCT_EXCEPTION, e);
        }

        return product;
    }

    @Override
    public Product update(Product product) throws DaoException {

        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_UPDATE_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getCost());
            preparedStatement.setInt(3, product.getCategoryId());
            preparedStatement.setInt(4, product.getBrendId());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_UPDATE_PRODUCT_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_UPDATE_PRODUCT_EXCEPTION, e);
        }

        return product;
    }

    @Override
    public void delete(Integer id) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_DELETE_PRODUCT_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_DELETE_PRODUCT_EXCEPTION, e);
        }
    }


    @Override
    public Product findById(Integer id) throws DaoException {
        Product product = null;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_FIND_PRODUCT_BY_ID)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCategoryId(resultSet.getInt(3));
                    product.setBrendId(resultSet.getInt(4));
                    product.setCost(resultSet.getDouble(5));
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_FIND_PRODUCT_BY_ID_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_FIND_PRODUCT_BY_ID_EXCEPTION, e);
        }

        return product;
    }

    @Override
    public List<Product> findAllByBrand(Integer brandId) throws DaoException {
        List<Product> list;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_FIND_ALL_PRODUCTS_WITH_BRAND)) {
            preparedStatement.setInt(1, brandId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCategoryId(resultSet.getInt(3));
                    product.setBrendId(resultSet.getInt(4));
                    product.setCost(resultSet.getDouble(5));
                    list.add(product);
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_BREND_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_BREND_EXCEPTION, e);
        }
        return list;
    }

    @Override
    public List<Product> findAllByCategory(Integer categoryId) throws DaoException {
        List<Product> list;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_FIND_ALL_PRODUCTS_WITH_CATEGORY)) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCategoryId(resultSet.getInt(3));
                    product.setBrendId(resultSet.getInt(4));
                    product.setCost(resultSet.getDouble(5));
                    list.add(product);
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_CATEGORY_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_CATEGORY_EXCEPTION, e);
        }
        return list;
    }

    @Override
    public List<Product> findAllByCategoryAndBrand(Integer category, Integer brand) throws DaoException {
        List<Product> list;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_FIND_ALL_PRODUCTS_WITH_BRAND_AND_CATEGORY)) {
            preparedStatement.setInt(1, brand);
            preparedStatement.setInt(2, category);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCategoryId(resultSet.getInt(3));
                    product.setBrendId(resultSet.getInt(4));
                    product.setCost(resultSet.getDouble(5));

                    list.add(product);
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_BREND_AND_CATEGORY_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_WITH_BREND_AND_CATEGORY_EXCEPTION, e);
        }
        return list;
    }

    @Override
    public List<Product> findAll() throws DaoException {
        List<Product> list;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(ProductSql.SQL_FIND_ALL_PRODUCTS)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                list = new ArrayList<>();
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCategoryId(resultSet.getInt(3));
                    product.setBrendId(resultSet.getInt(4));
                    product.setCost(resultSet.getDouble(5));
                    list.add(product);
                }
            }

        } catch (SQLException e) {
            logger.error(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_EXCEPTION, e);
            throw new DaoException(DaoProductExceptionStrings.SQL_FIND_ALL_PRODUCTS_EXCEPTION, e);
        }
        return list;
    }
}
