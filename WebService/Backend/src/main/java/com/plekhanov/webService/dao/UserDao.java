package com.plekhanov.webService.dao;

import com.plekhanov.webService.dao.custom.UserDaoCustomMethods;
import com.plekhanov.webService.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> , UserDaoCustomMethods {
}
