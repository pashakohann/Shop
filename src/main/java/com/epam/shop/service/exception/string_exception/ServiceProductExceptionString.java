package com.epam.shop.service.exception.string_exception;
/**
 * Exception strings for our product implementation on the services layer
 */
public interface ServiceProductExceptionString {
    String PRODUCT_COST_EXCEPTION = "You entered an invalid product cost...You should enter 1.0 to 999999.9 Example:99.0 or 111.2";
    String SAVE_PRODUCT_EXCEPTION = "Failed to save product";
    String SQL_DELETE_PRODUCT_EXCEPTION = "Failed to delete product,maybe the product was ordered";
    String FIND_ALL_PRODUCTS_EXCEPTION = "Couldn't find any products";
    String FIND_PRODUCTS_BY_CATEGORY_EXCEPTION = "Couldn't find any products for this category";
    String FIND_PRODUCT_BY_ID_EXCEPTION = "Couldn't find product for this id";
    String FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION = "Couldn't find products for this brand and category";
    String UPDATE_PRODUCT_EXCEPTION = "Failed to update product";
    String PRODUCT_NAME_SYMBOLS_EXCEPTION = "product description must be more than 5 characters but less then 65";
    String FILL_ALL_FIELDS_EXCEPTION = "You should fill all fields";
    String DELETE_PRODUCT_FROM_USER = "You cannot delete ordered products, you should delete them from the user's orders";
    String SYMBOLS_IN_LINK_EXCEPTION = "The number of characters in the link must not exceed 200.";
    String FORMAT_PHOTO_EXCEPTION = "For displaying the photo look for the link with .jpeg .jpg .png";
    String FILL_FIELDS_EXCEPTION  = "You must fill in all fields";

}
