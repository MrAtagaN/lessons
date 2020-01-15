package com.plekhanov.webService.dao;

import com.plekhanov.webService.entities.Auto;
import org.springframework.data.repository.CrudRepository;

public interface AutoDao extends CrudRepository<Auto, Long> {
}
