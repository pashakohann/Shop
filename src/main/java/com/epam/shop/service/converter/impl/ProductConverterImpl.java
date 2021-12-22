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
    public ProductDto convert(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setCost(product.getCost());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setBrandId(product.getBrandId());
        productDto.setPhotoLink(product.getPhotoLink());
        return productDto;
    }

    @Override
    public Product convert(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCost(productDto.getCost());
        product.setName(productDto.getName());
        product.setCategoryId(productDto.getCategoryId());
        product.setBrandId(productDto.getBrandId());
        product.setPhotoLink(productDto.getPhotoLink());
        return product;
    }
}
