package com.epam.shop.service.impl;


import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceBasketExceptionString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see BasketService
 */
public class BasketServiceImpl implements BasketService<ProductDto, BasketServiceImpl> {
    private Map<ProductDto, Integer> basket;

    public BasketServiceImpl() {
        basket = new HashMap<>();

    }

    @Override
    public Map<ProductDto, Integer> addProduct(ProductDto product) throws ServiceException {
        boolean isProduct = false;

        if (product == null) {
            throw new ServiceException(ServiceBasketExceptionString.ADD_PRODUCT_EXCEPTION);
        } else {

            for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {

                if (entry.getKey().getId().equals(product.getId())) {
                    isProduct = true;
                    entry.setValue(entry.getValue() + 1);
                }
            }

            if (!isProduct) {
                basket.put(product, 1);
            }
        }

        return basket;
    }

    @Override
    public BasketServiceImpl deleteProduct(int productId) throws ServiceException {
        boolean isProduct = false;

        if (productId == 0) {

            throw new ServiceException(ServiceBasketExceptionString.DELETE_PRODUCT_EXCEPTION);

        } else {

            ProductDto productDto = null;
            for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {

                if (entry.getKey().getId().equals(productId) && entry.getValue() > 1) {

                    isProduct = true;
                    entry.setValue(entry.getValue() - 1);
                }
            }
            if (!isProduct) {

                for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
                    if (entry.getKey().getId().equals(productId)) {
                        productDto = entry.getKey();
                    }
                }
                basket.remove(productDto);
            }
        }

        return this;
    }

    @Override
    public Map<ProductDto, Integer> lookBasket() throws ServiceException {
        if (basket == null) {

            throw new ServiceException(ServiceBasketExceptionString.LOOK_BASKET_EXCEPTION);

        }

        return basket;
    }

    @Override
    public BasketServiceImpl clearBasket() throws ServiceException {
        if (this.basket == null) {
            throw new ServiceException(ServiceBasketExceptionString.CLEAR_BASKET_EXCEPTION);

        } else {

            this.basket = new HashMap<>();
        }

        return this;
    }

    @Override
    public int basketSize() throws ServiceException {
        int sizeBasket = 0;

        for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
            int iter = 0;

            while (entry.getValue() != iter) {
                sizeBasket++;
                iter++;
            }
        }
        return sizeBasket;
    }

    @Override
    public List<ProductDto> backToListProducts() throws ServiceException {
        List<ProductDto> list = new ArrayList<>();

        if (basket == null) {

            throw new ServiceException(ServiceBasketExceptionString.BACK_TO_LIST_EXCEPTION);

        } else {

            for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
                int iter = 0;
                while (entry.getValue() != iter) {
                    list.add(entry.getKey());
                    iter++;
                }
            }
        }
        return list;
    }
}
