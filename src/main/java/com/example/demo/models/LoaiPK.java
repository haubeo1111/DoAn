package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loaipk")
public class LoaiPK {
@Id
@Column(name="maloaipk")
private String maloaipk;
@Column(name="tenloaipk")
private String tenloaipk;
@Column(name="isdelete")
private int isdelete;
public LoaiPK(String maloaipk, String tenloaipk, int isdelete) {
	super();
	this.maloaipk = maloaipk;
	this.tenloaipk = tenloaipk;
	this.isdelete = isdelete;
}
public LoaiPK() {
	super();
}
public String getMaloaipk() {
	return maloaipk;
}
public void setMaloaipk(String maloaipk) {
	this.maloaipk = maloaipk;
}
public String getTenloaipk() {
	return tenloaipk;
}
public void setTenloaipk(String tenloaipk) {
	this.tenloaipk = tenloaipk;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}
public LoaiPK(String maloaipk) {
	super();
	this.maloaipk = maloaipk;
}

}
