package com.epam.shop.dao.impl;


import com.epam.shop.dao.api.OrderDao;
import com.epam.shop.dao.connection_pool.api.ConnectionPool;
import com.epam.shop.dao.connection_pool.impl.ConnectionPoolImpl;
import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.exception.string_exception.DaoOrderExceptionString;
import com.epam.shop.dao.model.Order;
import com.epam.shop.dao.model.Product;
import com.epam.shop.dao.sql_query.OrderSql;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private static OrderDao instance;
    private static Logger logger = LogManager.getLogger(OrderDaoImpl.class);
    private static ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();


    private OrderDaoImpl() {

    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDaoImpl();
        }
        return instance;
    }

    @Override
    public Order save(Order order) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_SAVE_ORDER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setBigDecimal(1, order.getOrderCost());
            preparedStatement.setInt(2, order.getUserId());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(order.getOrderDate()));
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    order.setId(resultSet.getInt(1));
                }
                addProductsInOrder(order);
            }

        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_SAVE_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_SAVE_ORDER_EXCEPTION, e);
        }
        return order;
    }

    @Override
    public Order update(Order order) throws DaoException {

        deleteAllProductInOrder(order.getId());
        addProductsInOrder(order);

        return order;
    }

    @Override
    public void delete(Integer orderId) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_DELETE_ORDER)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_DELETE_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_DELETE_ORDER_EXCEPTION);
        }
    }

    public void deleteProductInOrder(Integer productId) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_DELETE_PRODUCT_IN_ORDER)) {
            preparedStatement.setInt(1, productId);

        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_DELETE_PRODUCT_IN_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_DELETE_PRODUCT_IN_ORDER_EXCEPTION, e);
        }
    }

    public void deleteAllProductInOrder(Integer orderId) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_DELETE_ALL_PRODUCTS_FROM_ORDER)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_DELETE_PRODUCT_IN_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_DELETE_PRODUCT_IN_ORDER_EXCEPTION, e);
        }
    }

    @Override
    public Order findById(Integer id) throws DaoException {
        Order order = null;
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_FIND_ORDER_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    order = new Order();
                    order.setId(resultSet.getInt(1));
                    order.setOrderDate(resultSet.getTimestamp(2).toLocalDateTime());
                    order.setOrderCost(resultSet.getBigDecimal(3));
                    order.setUserId(resultSet.getInt(4));
                    order.setListProducts(findAllProductsFromOrder(order.getId()));

                }
            }
        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_FIND_ORDER_BY_ID_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_FIND_ORDER_BY_ID_EXCEPTION, e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> listOrders = new ArrayList<>();
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_FIND_ALL_ORDERS)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt(1));
                    order.setOrderDate(resultSet.getTimestamp(2).toLocalDateTime());
                    order.setOrderCost(resultSet.getBigDecimal(3));
                    order.setUserId(resultSet.getInt(4));
                    order.setListProducts(findAllProductsFromOrder(order.getId()));
                    listOrders.add(order);
                }

            }
        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_FIND_ALL_ORDERS_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_FIND_ALL_ORDERS_EXCEPTION, e);
        }
        return listOrders;
    }

    public List<Product> findAllProductsFromOrder(Integer idOrder) throws DaoException {
        List<Product> list = new ArrayList<>();
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_FIND_ALL_PRODUCTS_FROM_ORDER)) {
            preparedStatement.setInt(1, idOrder);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt(1));
                    product.setName(resultSet.getString(2));
                    product.setCost(resultSet.getBigDecimal(3));
                    product.setCategoryId(resultSet.getInt(4));
                    product.setBrandId(resultSet.getInt(5));

                    list.add(product);
                }
            }
        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_FIND_ALL_PRODUCTS_FROM_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_FIND_ALL_PRODUCTS_FROM_ORDER_EXCEPTION, e);
        }

        return list;
    }

    @Override
    public void addProductsInOrder(Order order) throws DaoException {
        try (Connection connection = connectionPool.takeConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(OrderSql.SQL_ADD_PRODUCTS_IN_ORDER)) {
            for (Product product : order.getListProducts()) {
                preparedStatement.setInt(1, order.getId());
                preparedStatement.setInt(2, product.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.error(DaoOrderExceptionString.SQL_ADD_PRODUCTS_IN_ORDER_EXCEPTION, e);
            throw new DaoException(DaoOrderExceptionString.SQL_ADD_PRODUCTS_IN_ORDER_EXCEPTION, e);
        }
    }
}
