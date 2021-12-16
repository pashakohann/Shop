package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.dto.model.ProductDto;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;

public interface BasketService<T extends AbstractModelDto<K>,K> {
      Map<T,Integer> addProduct(ProductDto product)throws ServerException;
      Map<T,Integer> deleteProduct(ProductDto product)throws ServerException;
      Map<T,Integer>lookBasket()throws ServerException;
      Map<T,Integer>clearBasket()throws ServerException;
      int basketSize();
      List<ProductDto> backToListProducts();

}
