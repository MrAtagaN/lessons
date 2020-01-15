package com.plekhanov.webService.dao.custom;

import com.plekhanov.webService.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class UserDaoCustomMethodsImpl implements UserDaoCustomMethods {

    @Autowired
    @Lazy
    UserDao userDao;

    @Override
    public long customMethod() {
       return userDao.count();
    }
}
