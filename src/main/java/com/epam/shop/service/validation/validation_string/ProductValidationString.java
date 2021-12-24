package com.epam.shop.service.validation.validation_string;

public interface ProductValidationString {

    String PRODUCT_COST_REGEX = "^(([1-9]([0-9]{0,5})[.][0-9]{1})|([1-9]([0-9]{0,5})))$";
    String LINK_REGEX = "^.*((.jpeg)|(.jpg)|(.png)){1}$";
    int PRODUCT_NAME_SYMBOLS = 5;
    int SYMBOLS_IN_LINK = 200;
    int QUANTITY_FIELDS = 3;
    String SPLIT_STRING_REGEX = "&&&";

}
