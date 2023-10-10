package com.example.inventory.entity;

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
public class Inventory {
	
	@Id
	private int id;
	private long locationNumber;
	private String materialId;
	private long resetQty;
	private long orderQuantity;
	private long availableQuantity;
	private Date updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getLocationNumber() {
		return locationNumber;
	}
	public void setLocationNumber(long locationNumber) {
		this.locationNumber = locationNumber;
	}
	public String getMaterialNumber() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public long getResetQty() {
		return resetQty;
	}
	public void setResetQty(long resetQty) {
		this.resetQty = resetQty;
	}
	public long getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Inventory(int id, int locationNumber, String materialId, long resetQty, long orderQuantity,
			long availableQuantity, Date updateDate) {
		super();
		this.id = id;
		this.locationNumber = locationNumber;
		this.materialId = materialId;
		this.resetQty = resetQty;
		this.orderQuantity = orderQuantity;
		this.availableQuantity = availableQuantity;
		this.updateDate = updateDate;
	}
	public Inventory() {
		super();
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", locationNumber=" + locationNumber + ", materialId=" + materialId
				+ ", resetQty=" + resetQty + ", orderQuantity=" + orderQuantity + ", availableQuantity="
				+ availableQuantity + ", updateDate=" + updateDate + "]";
	}
	
	
	
	
	
}
