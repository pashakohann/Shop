package com.epam.shop.service.exception.string_exception;

public interface ServiceProductExceptionString {
    String PRODUCT_COST_EXCEPTION = "You entered an invalid product cost...You should enter 1.0 to 999999.9 Example:99.0 or 111.2";
    String SAVE_PRODUCT_EXCEPTION = "Failed to save product";
    String DELETE_PRODUCT_EXCEPTION = "Failed to save product";
    String FIND_ALL_PRODUCTS_EXCEPTION = "Couldn't find any products";
    String FIND_PRODUCTS_BY_BRAND_EXCEPTION = "Couldn't find any products for this brand";
    String FIND_PRODUCTS_BY_CATEGORY_EXCEPTION = "Couldn't find any products for this category";
    String FIND_PRODUCT_BY_ID_EXCEPTION = "Couldn't find product for this id";
    String FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION = "Couldn't find products for this brand and category";
    String UPDATE_PRODUCT_EXCEPTION = "Failed to update product";
    String PRODUCT_NAME_SYMBOLS_EXCEPTION = "product description must be more than 5 characters";
    String FILL_ALL_FIELDS_EXCEPTION = "You should fill all fields";


}
