package com.cml.learn.flyway;

import com.cml.learn.flyway.repository.City;
import com.cml.learn.flyway.repository.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.sql.SQLException;

@SpringBootApplication
public class FlywayApplication {
    public static void main(String[] args) throws SQLException {
        ConfigurableApplicationContext app = SpringApplication.run(FlywayApplication.class, args);

        CityRepository cityRepository = app.getBean(CityRepository.class);

        City city = new City("shanghai", "on");
        cityRepository.save(city);
        System.out.println("save result==>city Id:" + city.getId());

        city = new City("杭州", "off");
        cityRepository.save(city);
        System.out.println("save result==>city Id:" + city.getId());

        Page<City> cities = cityRepository.findAll(new PageRequest(0, 100));
        System.out.println("result===>" + cities.getContent());

//        app.close();
    }
}