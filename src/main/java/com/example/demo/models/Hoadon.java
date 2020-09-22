package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="hoadon")
public class Hoadon {
@Id
@Column(name="id")
private Long id;
@Column(name="status")
private String status;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date createddate;
@Column(name="customerid")
private Long customerid;
@Column(name="isdelete")
private int isdelete;
public Hoadon() {
	super();
}
public Hoadon(Long id, String status, Date createddate, Long customerid, int isdelete) {
	super();
	this.id = id;
	this.status = status;
	this.createddate = createddate;
	this.customerid = customerid;
	this.isdelete = isdelete;
}
public Hoadon(Long id, String status, Date createddate, Long customerid) {
	super();
	this.id = id;
	this.status = status;
	this.createddate = createddate;
	this.customerid = customerid;
}
public Hoadon(Long id) {
	super();
	this.id = id;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getCreateddate() {
	return createddate;
}
public void setCreateddate(Date createddate) {
	this.createddate = createddate;
}
public Long getCustomerid() {
	return customerid;
}
public void setCustomerid(Long customerid) {
	this.customerid = customerid;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}


}
