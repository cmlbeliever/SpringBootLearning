package com.cml.learn.jpa.db.bean;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.cml.learn.jpa.framework.db.converter.DateToDateTimeConverter;

@Entity
@Table(name = "t_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	private User user;

	private String orderName;
	private String orderNumber;

	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime createTime;
	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public DateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(DateTime updateTime) {
		this.updateTime = updateTime;
	}

}
