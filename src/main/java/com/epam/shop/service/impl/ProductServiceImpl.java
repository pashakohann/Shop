package com.epam.shop.service.impl;


import com.epam.shop.dao.exception.DaoException;
import com.epam.shop.dao.factory.FactoryDao;
import com.epam.shop.dao.model.Product;
import com.epam.shop.service.api.ProductService;
import com.epam.shop.service.converter.api.Converter;
import com.epam.shop.service.converter.impl.ProductConverterImpl;
import com.epam.shop.service.dto.model.ProductDto;
import com.epam.shop.service.exception.ServiceException;
import com.epam.shop.service.exception.string_exception.ServiceProductExceptionString;
import com.epam.shop.service.validation.api.Validator;
import com.epam.shop.service.validation.impl.ProductValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;

/**
 * @see ProductService
 * @see com.epam.shop.service.api.Service
 */
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
    public  ProductDto create(ProductDto product) throws ServiceException {

        try {
            validatorInstance.validate(product);
            return converter.convert(FactoryDao.getProductImpl().save(converter.convert(product)));

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.SAVE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.SAVE_PRODUCT_EXCEPTION, e);
        }
    }

    @Override
    public ProductDto update(ProductDto productDto) throws ServiceException {

        try {
            validatorInstance.validate(productDto);
            FactoryDao.getProductImpl().update(converter.convert(productDto));
            return productDto;

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.UPDATE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.UPDATE_PRODUCT_EXCEPTION, e);
        }

    }

    @Override
    public void deleteById(int productId) throws ServiceException {
        try {

            FactoryDao.getProductImpl().delete(productId);

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.SQL_DELETE_PRODUCT_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.SQL_DELETE_PRODUCT_EXCEPTION, e);
        }
    }

    @Override
    public ProductDto getById(Integer id) throws ServiceException {

        try {
            return converter.convert(FactoryDao.getProductImpl().findById(id));
        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCT_BY_ID_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCT_BY_ID_EXCEPTION, e);
        }

    }

    @Override
    public List<ProductDto> getAll() throws ServiceException {


        try {
            List<ProductDto> listProductDto = new ArrayList<>();
            for (Product product : FactoryDao.getProductImpl().findAll()) {
                listProductDto.add(converter.convert(product));
            }

            return listProductDto;

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_ALL_PRODUCTS_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_ALL_PRODUCTS_EXCEPTION, e);
        }
    }

    @Override
    public List<ProductDto> findProductsByCategory(Integer idCategory) throws ServiceException {

        try {
            List<ProductDto> listProducts = new ArrayList<>();

            for (Product product : FactoryDao.getProductImpl().findAllByCategory(idCategory)) {
                listProducts.add(converter.convert(product));
            }

            return listProducts;

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCTS_BY_CATEGORY_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCTS_BY_CATEGORY_EXCEPTION, e);
        }

    }

    @Override
    public List<ProductDto> findProductsByCategoryAndBrand(int category, int brand) throws ServiceException {

        try {

            List<ProductDto> listProductsDao = new ArrayList<>();

            for (Product product : FactoryDao.getProductImpl().findAllByCategoryAndBrand(category, brand)) {
                listProductsDao.add(converter.convert(product));
            }

            return listProductsDao;

        } catch (DaoException e) {
            logger.error(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION, e);
            throw new ServiceException(ServiceProductExceptionString.FIND_PRODUCTS_BY_BRAND_AND_CATEGORY_EXCEPTION, e);
        }
    }
}

