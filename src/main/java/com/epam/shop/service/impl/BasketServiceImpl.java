package com.epam.shop.service.impl;


import com.epam.shop.service.api.BasketService;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketServiceImpl implements BasketService<ProductDto, BasketServiceImpl> {
    private Map<ProductDto, Integer> basket;

    public BasketServiceImpl(Map<ProductDto, Integer> basket) {
        this.basket = basket;
    }


    @Override
    public Map<ProductDto, Integer> addProduct(ProductDto product) throws ServiceException {
        boolean isProduct = false;

        for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                isProduct = true;
                entry.setValue(entry.getValue() + 1);
            }
        }
        if (!isProduct) {
            basket.put(product, 1);
        }


        return basket;
    }

    @Override
    public BasketServiceImpl deleteProduct(int productId) throws ServiceException {

        boolean isProduct = false;
        ProductDto productDto = null;
        for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getId().equals(productId)) {
                if (entry.getValue() > 1) {
                    isProduct = true;
                    entry.setValue(entry.getValue() - 1);
                }

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
        return this;
    }

    @Override
    public Map<ProductDto, Integer> lookBasket() throws ServiceException {
        return basket;
    }

    @Override
    public BasketServiceImpl clearBasket() throws ServiceException {
        this.basket = new HashMap<>();
        return this;
    }

    @Override
    public int basketSize() {
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
    public List<ProductDto> backToListProducts() {
        List<ProductDto> list = new ArrayList<>();
        int sizeBasket = 0;

        for (Map.Entry<ProductDto, Integer> entry : basket.entrySet()) {
            int iter = 0;
            while (entry.getValue() != iter) {
                list.add(entry.getKey());
                iter++;
            }
        }
        return list;
    }
}
