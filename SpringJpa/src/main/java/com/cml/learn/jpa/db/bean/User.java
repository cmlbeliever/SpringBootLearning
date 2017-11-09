package com.cml.learn.jpa.db.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.cml.learn.jpa.framework.db.converter.DateToDateTimeConverter;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id()
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String username;

	private String password;

	private String nickname;

	// mappedBy 对应bean的属性
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Order> orders;

	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime createTime;
	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime updateTime;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
