package com.epam.shop.service.impl;



import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.ProductConverterImpl;
import com.epam.shop.service.dto.model.OrderDto;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceProductExceptionString;
import com.epam.shop.service.factory.FactoryService;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.ProductValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static ProductService instance;
    private final Validator<ProductDto, Integer> validatorInstance = ProductValidatorImpl.getInstance();
    private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
    private final Converter<ProductDto, Product, Integer> converter = ProductConverterImpl.getConverterInstance();




    private ProductServiceImpl() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    @Override
    public ProductDto create(ProductDto model) throws ServiceException {
        ProductDto productDto;
        validatorInstance.validate(model);
        try {
            productDto = converter.convert(FactoryDao.getProductImpl().save(converter.convert(model)));
        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.SAVE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.SAVE_PRODUCT_EXCEPTION, e);
        }
        return productDto;
    }

    @Override
    public ProductDto update(ProductDto model) throws ServiceException {
        validatorInstance.validate(model);
        try {
            FactoryDao.getProductImpl().update(converter.convert(model));
        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.UPDATE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.UPDATE_PRODUCT_EXCEPTION, e);
        }
        return model;
    }

    @Override
    public void delete(ProductDto model) throws ServiceException {
        List<OrderDto> listOrderDto;
        try {
            listOrderDto = FactoryService.getOrderServiceInstance().getAll();
            for (OrderDto order : listOrderDto
            ) {
                for (ProductDto product : order.getListProducts()
                ) {
                    if (product.getId().equals(model.getId())) {
                        throw new ServiceException(ServiceProductExceptionString.DELETE_PRODUCT_FROM_USER);
                    }
                }
            }
            FactoryDao.getProductImpl().delete(model.getId());
        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.DELETE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.DELETE_PRODUCT_EXCEPTION, e);
        }
    }

    @Override
    public ProductDto getById(Integer id) throws ServiceException {
        ProductDto productDto;
        try {
            productDto = converter.convert(FactoryDao.getProductImpl().findById(id));

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCT_BY_ID_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCT_BY_ID_EXCEPTION, e);
        }
        return productDto;
    }

    @Override
    public List<ProductDto> getAll() throws ServiceException {
        List<ProductDto> listProductDto = new ArrayList<>();
        try {
            for (Product product : FactoryDao.getProductImpl().findAll()) {
                listProductDto.add(converter.convert(product));
            }
        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_ALL_PRODUCTS_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_ALL_PRODUCTS_EXCEPTION, e);
        }
        return listProductDto;
    }


    @Override
    public List<ProductDto> findProductsByBrand(Integer idBrand) throws ServiceException {
        List<ProductDto> listProductsDao = new ArrayList<>();
        try {
            for (Product product : FactoryDao.getProductImpl().findAllByBrand(idBrand)) {
                listProductsDao.add(converter.convert(product));
            }

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_EXCEPTION, e);
        }
        return listProductsDao;
    }

    @Override
    public List<ProductDto> findProductsByCategory(Integer idCategory) throws ServiceException {
        List<ProductDto> listProductsDao = new ArrayList<>();
        try {
            for (Product product : FactoryDao.getProductImpl().findAllByCategory(idCategory)) {
                listProductsDao.add(converter.convert(product));
            }

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCTS_BY_CATEGORY_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCTS_BY_CATEGORY_EXCEPTION, e);
        }
        return listProductsDao;
    }

    @Override
    public List<ProductDto> findProductsByCategoryAndBrand(Integer category, Integer brand) throws ServiceException {
        List<ProductDto> listProductsDao = new ArrayList<>();
        try {
            for (Product product : FactoryDao.getProductImpl().findAllByCategoryAndBrand(category, brand)) {
                listProductsDao.add(converter.convert(product));
            }

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION, e);
        }
        return listProductsDao;
    }
}

