package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.ChucVu;

public class NhanViendto {
	private int id;
	private String name;
	private String address;
	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private int gender;
	private String degree;
	private MultipartFile image;
	private int isdelete;
	private int chucvu;
	private String manv;
	public NhanViendto() {
		super();
	}
	
	public NhanViendto(MultipartFile image) {
		super();
		this.image = image;
	}

	public NhanViendto(int id, String name, String address, String phone, Date birthday, int gender, String degree,
			MultipartFile image, int isdelete, int chucvu, String manv) {
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
	public NhanViendto(int id, String name, String address, String phone, Date birthday, int gender, String degree,
			MultipartFile image, int chucvu, String manv) {
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
	public NhanViendto(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getChucvu() {
		return chucvu;
	}
	public void setChucvu(int chucvu) {
		this.chucvu = chucvu;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}

	

	
}
