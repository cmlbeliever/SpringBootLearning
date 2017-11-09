package com.cml.learn.jpa.db.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;

import com.cml.learn.jpa.framework.db.converter.DateToDateTimeConverter;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1148417078117097629L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	private String userEmail;

	@Column(name = "user_passwd")
	private String password;

	private String token;

	@Transient
	private String newToken;

	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime birthday;

	private String nickName;

	private Short gender;

	private String mobile;
	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime createDate;
	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime lastLoginDate;
	@Convert(converter = DateToDateTimeConverter.class)
	private DateTime updateDate;

	public DateTime getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(DateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public DateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public DateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Short getGender() {
		return gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(DateTime birthday) {
		this.birthday = birthday;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewToken() {
		return newToken;
	}

	public void setNewToken(String newToken) {
		this.newToken = newToken;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", password=" + password + ", token=" + token + ", newToken=" + newToken
				+ ", birthday=" + birthday + ", nickName=" + nickName + ", gender=" + gender + ", mobile=" + mobile + ", createDate=" + createDate
				+ ", lastLoginDate=" + lastLoginDate + ", updateDate=" + updateDate + "]";
	}

}
