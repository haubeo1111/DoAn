package com.example.demo.models;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class NhanVien {
private int id;
private String name;
private String address;
private String phone;
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Temporal(TemporalType.DATE)
private Date birthday;
private int gender;
private String degree;
private String image;
private int isdelete;
private int chucvu;
private String manv;



public NhanVien(String name, String address, String phone, Date birthday, int gender, String degree, String image,
		int chucvu, String manv) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.chucvu = chucvu;
	this.manv = manv;
}

public NhanVien(int id, String name, String address, String phone, Date birthday,int gender, String degree,
		String image, int chucvu, String manv) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.chucvu = chucvu;
	this.manv = manv;
}

public NhanVien(int id, String name, String address, String phone, Date birthday,int gender, String degree,
		String image, int isdelete, int chucvu, String manv) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.isdelete = isdelete;
	this.chucvu = chucvu;
	this.manv = manv;
}

public String getManv() {
	return manv;
}

public void setManv(String manv) {
	this.manv = manv;
}

public NhanVien(int id, String name, String address, String phone, Date birthday,int gender, String degree,
		String image, int isdelete, int chucvu) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.isdelete = isdelete;
	this.chucvu = chucvu;
}

public NhanVien(int id, String name, String phone, String image,int chucvu) {
	super();
	this.id = id;
	this.name = name;
	this.phone = phone;
	this.image = image;
	this.chucvu = chucvu;
}

public NhanVien(int id) {
	super();
	this.id = id;
}

public NhanVien(int id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}

public NhanVien(int id, String name, String address, String phone, Date birthday,int gender, String degree,
		String image, int chucvu) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.chucvu = chucvu;
}

public NhanVien(String name, String address, String phone, Date birthday,int gender, String degree, String image,
		int chucvu) {
	super();
	this.name = name;
	this.address = address;
	this.phone = phone;
	this.birthday = birthday;
	this.gender = gender;
	this.degree = degree;
	this.image = image;
	this.chucvu = chucvu;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getChucvu() {
	return chucvu;
}

public void setChucvu(int chucvu) {
	this.chucvu = chucvu;
}

public NhanVien() {
	super();
}

public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public int getGender() {
	return gender;
}

public void setGender(int gender) {
	this.gender = gender;
}
public String getDegree() {
	return degree;
}
public void setDegree(String degree) {
	this.degree = degree;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
