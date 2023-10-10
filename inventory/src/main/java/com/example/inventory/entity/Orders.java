package com.example.inventory.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer orderId;
	private String userId;
	private Date localDate;
	private Time localTime;
	private Long locationNumber;
	private String materialId;
	private Long orderQuantity;
	private String orderStatus;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getLocalDate() {
		return localDate;
	}
	public void setLocalDate(Date localDate) {
		this.localDate = localDate;
	}
	public Time getLocalTime() {
		return localTime;
	}
	public void setLocalTime(Time localTime) {
		this.localTime = localTime;
	}
	public Long getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(Long locationNumber) {
		this.locationNumber = locationNumber;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialNumber) {
		this.materialId = materialNumber;
	}
	public Long getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	public Orders(String userId, Date localDate, Time localTime, Long locationNumber,
			String materialId, Long orderQuantity, String orderStatus) {
		
		super();
		this.userId = userId;
		this.localDate = localDate;
		this.localTime = localTime;
		this.locationNumber = locationNumber;
		this.materialId = materialId;
		this.orderQuantity = orderQuantity;
		this.orderStatus = orderStatus;
		
	}
	
	public Orders() {
		super();
	}
	
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", localDate=" + localDate + ", localTime="
				+ localTime + ", locationNumber=" + locationNumber + ", materialId=" + materialId + ", orderQuantity="
				+ orderQuantity + ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
		
}
