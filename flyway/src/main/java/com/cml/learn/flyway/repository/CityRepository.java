package com.cml.learn.flyway.repository;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface CityRepository extends CrudRepository<City, Long> {

	Page<City> findAll(Pageable pageable);

	City findByNameAndStateAllIgnoringCase(String name, String state);

}