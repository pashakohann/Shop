package com.epam.shop.dao.api;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.model.Account;

/**
 * extend {@see Dao}
 */
public interface AccountDao extends Dao<Account,Integer> {
    /**
     *
     * @param userId - id from {@see User} for finding his profile
     * @return profile from user
     * @throws DaoException if there was an error
     */
    Account findByUserId(int userId) throws DaoException;
}
