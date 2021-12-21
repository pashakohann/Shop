package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Account;

public interface AccountDao extends Dao<Account,Integer> {
    Account findByUserId(int userId) throws DaoException;
}
