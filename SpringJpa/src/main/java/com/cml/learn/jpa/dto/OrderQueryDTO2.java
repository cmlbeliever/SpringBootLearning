package com.cml.learn.jpa.dto;

public class OrderQueryDTO2 {

	private String orderName;

	public OrderQueryDTO2(String orderName) {
		super();
		this.orderName = orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderName() {
		return orderName;
	}

}
