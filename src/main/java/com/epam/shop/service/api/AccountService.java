package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;

/**
 * @see Service
 *
 */
public interface AccountService extends Service<AccountDto,Integer> {

    /**
     *
     * @param userId from your user
     * @return profile that was found
     * @throws ServiceException if the user wasn't found
     */
    AccountDto findByUserId(int userId) throws ServiceException;
}
