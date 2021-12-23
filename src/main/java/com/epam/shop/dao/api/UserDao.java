package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.User;


/**
 * @see Dao
 */
public interface UserDao extends Dao<User,Integer>{

    /**
     *
     * @param user accepts a user and searches by his name
     * @return  the user if there is one
     * @throws DaoException if the search failed
     */
    User findByUserName(User user) throws DaoException;
}
