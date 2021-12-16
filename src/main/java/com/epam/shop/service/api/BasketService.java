package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.impl.BasketServiceImpl;

import java.rmi.ServerException;
import java.util.List;
import java.util.Map;
//class Transaction<T extends Person & Accountable>{}
public interface BasketService<T extends AbstractModelDto,K extends BasketServiceImpl> {
      Map<T,Integer> addProduct(ProductDto product)throws ServerException;
      K deleteProduct(int productId)throws ServerException;
      Map<T,Integer>lookBasket()throws ServerException;
      K clearBasket()throws ServerException;
      int basketSize();
      List<ProductDto> backToListProducts();

}
