package com.epam.shop.service.impl;

//
//public class UserServiceImpl implements Service<UserDto,Integer> {
//    private Dao<User,Integer> userDao = new DaoUserImpl();
//    private UserConverter converter = new UserConverter();
//    private Validator<UserDto> validator = new ValidatorImpl();
//
//
//    @Override
//    public UserDto create(UserDto user) throws ServerException {
//        //validation
//        validator.validate(user);
//        return converter.convert(userDao.save(converter.convert(user)));
//    }
//
//    @Override
//    public UserDto update(UserDto user) {
//        return null;
//    }
//
//    @Override
//    public void delete(UserDto user) {
//
//    }
//
//    @Override
//    public UserDto getById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public UserDto getAll() {
//        return null;
//    }
//}
