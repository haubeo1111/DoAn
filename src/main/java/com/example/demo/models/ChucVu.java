package com.example.demo.models;

public class ChucVu {
private int id;
private String macv;
private String tencv;
private int isdelete;




public ChucVu(int id) {
	super();
	this.id = id;
}



public ChucVu(int id, String macv, String tencv) {
	super();
	this.id = id;
	this.macv = macv;
	this.tencv = tencv;
}



public ChucVu(int id, String macv, String tencv, int isdelete) {
	super();
	this.id = id;
	this.macv = macv;
	this.tencv = tencv;
	this.isdelete = isdelete;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public int getIsdelete() {
	return isdelete;
}



public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}



public String getMacv() {
	return macv;
}



public void setMacv(String macv) {
	this.macv = macv;
}



public String getTencv() {
	return tencv;
}



public void setTencv(String tencv) {
	this.tencv = tencv;
}



public ChucVu(String macv, String tencv) {
	super();
	this.macv = macv;
	this.tencv = tencv;
}



public ChucVu() {
	super();
}



}
