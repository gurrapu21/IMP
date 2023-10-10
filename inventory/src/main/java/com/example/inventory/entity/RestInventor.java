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
public class RestInventor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String materialId;
	private Long ResetQty;
	private Long locationNumber;
	private Date resetDate;

	public String getMaterialId() {
		return materialId;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public long getResetQty() {
		return ResetQty;
	}

	public void setResetQty(long resetQty) {
		ResetQty = resetQty;
	}

	public Long getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(Long locationNumber) {
		this.locationNumber = locationNumber;
	}

	public Date getResetDate() {
		return resetDate;
	}

	public void setResetDate(Date resetDate) {
		this.resetDate = resetDate;
	}

	public RestInventor(String materialId, long resetQty, Long locationNumber, Date resetDate) {
		super();
		this.materialId = materialId;
		ResetQty = resetQty;
		this.locationNumber = locationNumber;
		this.resetDate = resetDate;
	}

	public RestInventor() {
		super();
	}

}
