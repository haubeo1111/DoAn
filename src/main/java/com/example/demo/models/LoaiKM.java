package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loaiKM")
public class LoaiKM {
@Id
@Column(name="id")
private int id;

@Column(name="makm")
private String makm;
@Column(name="loaikm")
private String loaikm;
@Column(name="phantram")
private int phantram;

@Column(name="isdelete")
private int isdelete;

public LoaiKM(int id, String makm, String loaikm, int phantram, int isdelete) {
	super();
	this.id = id;
	this.makm = makm;
	this.loaikm = loaikm;
	this.phantram = phantram;
	this.isdelete = isdelete;
}
public int getPhantram() {
	return phantram;
}
public void setPhantram(int phantram) {
	this.phantram = phantram;
}
public LoaiKM(int id, String makm, String loaikm, int isdelete) {
	super();
	this.id = id;
	this.makm = makm;
	this.loaikm = loaikm;
	this.isdelete = isdelete;
}
public LoaiKM() {
	super();
}
public LoaiKM(int id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public LoaiKM(int id) {
	super();
	this.id = id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMakm() {
	return makm;
}
public void setMakm(String makm) {
	this.makm = makm;
}
public String getLoaikm() {
	return loaikm;
}
public void setLoaikm(String loaikm) {
	this.loaikm = loaikm;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

}
