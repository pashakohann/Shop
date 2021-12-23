package com.epam.shop.service.api;


import com.epam.shop.service.dto.model.AbstractModelDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.impl.BasketServiceImpl;


import java.util.List;
import java.util.Map;

/**
 *
 * @param <T> which should inherit from the T
 * @param <K> anyone who inherits this implementation
 */
public interface BasketService<T extends AbstractModelDto,K extends BasketServiceImpl> {

      /**
       *
       * @param product  to be added to the basket
       * @return Returns a map with all the contents in the basket
       * @throws ServiceException if failed to add product
       */
      Map<T,Integer> addProduct(ProductDto product)throws ServiceException;

      /**
       *
       * @param productId to be deleted to the basket
       * @return this object
       * @throws ServiceException if failed to delete product by id
       */
      K deleteProduct(int productId)throws ServiceException;

      /**
       *
       * @return Returns a map with all the contents in the basket
       * @throws ServiceException if failed to look the basket
       */
      Map<T,Integer>lookBasket()throws ServiceException;

      /**
       *
       * @return  this object with an empty basket
       * @throws ServiceException if failed to clear the basket
       */
      K clearBasket()throws ServiceException;

      /**
       *
       * @return number of products
       * @throws ServiceException if failed to do it
       */
      int basketSize() throws ServiceException;

      /**
       *
       * @return product list from map
       * @throws ServiceException if failed to return list
       */
      List<ProductDto> backToListProducts() throws ServiceException;

}
