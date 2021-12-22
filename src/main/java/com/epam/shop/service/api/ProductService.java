package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

import java.util.List;

public interface ProductService extends Service<ProductDto, Integer> {


    List<ProductDto> findProductsByCategory(Integer idCategory) throws ServiceException;

    List<ProductDto> findProductsByCategoryAndBrand(Integer category, Integer brand) throws ServiceException;

    void deleteById(int productId) throws ServiceException;


}
