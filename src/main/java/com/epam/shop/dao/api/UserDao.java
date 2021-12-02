package com.epam.shop.dao.api;

import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.User;

public interface UserDao extends Dao<User,Integer>{
    User findByUserName(User user) throws DaoException;
}
