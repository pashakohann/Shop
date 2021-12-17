package com.epam.shop.service.api;

import com.epam.shop.service.dto.model.AccountDto;
import com.epam.shop.service.exception.ServiceException;

public interface AccountService extends Service<AccountDto,Integer> {

    AccountDto findByUserId(int userId) throws ServiceException;
}
