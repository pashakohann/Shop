package com.epam.shop.service.converter.impl;



import com.epam.shop.dao.model.Product;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.dto.model.ProductDto;


public class ProductConverterImpl implements Converter<ProductDto, Product, Integer> {
    private static Converter<ProductDto, Product, Integer> converterInstance;


    private ProductConverterImpl() {
    }

    public static Converter<ProductDto, Product, Integer> getConverterInstance() {
        if (converterInstance == null) {
            converterInstance = new ProductConverterImpl();
        }
        return converterInstance;
    }

    @Override
    public ProductDto convert(Product model) {
        ProductDto productDto = new ProductDto();
        productDto.setId(model.getId());
        productDto.setCost(model.getCost());
        productDto.setName(model.getName());
        productDto.setCategoryId(model.getCategoryId());
        productDto.setBrandId(model.getBrandId());
        return productDto;
    }

    @Override
    public Product convert(ProductDto modelDto) {
        Product product = new Product();
        product.setId(modelDto.getId());
        product.setCost(modelDto.getCost());
        product.setName(modelDto.getName());
        product.setCategoryId(modelDto.getCategoryId());
        product.setBrandId(modelDto.getBrandId());
        return product;
    }
}
