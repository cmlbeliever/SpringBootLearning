package com.cml.learn.jpa.db.write;

import org.springframework.data.repository.CrudRepository;

import com.cml.learn.jpa.db.bean.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
