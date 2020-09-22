package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bangluong")
public class BangLuong {
@Id
@Column(name="id")
private int id;
@Column(name="maluong")
private String maluong;
@Column(name="hesoluong")
private float hesoluong;
@Column(name="chucvuid")
private int   chucvuid;
@Column(name="isdelete")
private int isdelete;
public BangLuong() {
	super();
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMaluong() {
	return maluong;
}
public void setMaluong(String maluong) {
	this.maluong = maluong;
}
public float getHesoluong() {
	return hesoluong;
}
public void setHesoluong(float hesoluong) {
	this.hesoluong = hesoluong;
}
public int getChucvuid() {
	return chucvuid;
}
public void setChucvuid(int chucvuid) {
	this.chucvuid = chucvuid;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}
public BangLuong(int id, String maluong, float hesoluong, int chucvuid, int isdelete) {
	super();
	this.id = id;
	this.maluong = maluong;
	this.hesoluong = hesoluong;
	this.chucvuid = chucvuid;
	this.isdelete = isdelete;
}
public BangLuong(int id) {
	super();
	this.id = id;
}
public BangLuong(int id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}

}
