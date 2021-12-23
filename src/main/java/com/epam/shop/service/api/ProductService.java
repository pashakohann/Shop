package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

import java.util.List;

/**
 * @see Service
 *
 */
public interface ProductService extends Service<ProductDto, Integer> {

    /**
     *
     * @param idCategory what category to search for
     * @return returns what was found
     * @throws ServiceException if failed to get products
     */
    List<ProductDto> findProductsByCategory(Integer idCategory) throws ServiceException;


    /**
     *
     * @param category id from category
     * @param brand id from brand
     *
     * @return returns for this category what brands are there
     * @throws ServiceException if failed to get products
     */
    List<ProductDto> findProductsByCategoryAndBrand(int category, int brand) throws ServiceException;


    /**
     *
     * @param productId delete product by id
     * @throws ServiceException if failed to delete the product
     */
    void deleteById(int productId) throws ServiceException;


}
