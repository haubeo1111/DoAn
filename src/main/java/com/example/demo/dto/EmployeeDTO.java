package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.ChucVu;

public class EmployeeDTO {
private long id;
	
	//@Column(name = "name", nullable = false)
	private String name;
	
	//@Column(name = "phone")
	private String address;
	private String phone;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	//@Column(name = "gender")
	private int gender;
	//@Column(name = "degree")
	private String degree;
	//@Column(name = "image")
	private MultipartFile image;
	//@Column(name = "isdelete")
	private int isdelete;
	//@Column(name = "chucvu")
	private int chucvuid;
	//@Column(name = "manv")
	private String manv;
	
	public EmployeeDTO(long id) {
		super();
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public EmployeeDTO(long id, String name, String address, String phone, Date birthday, int gender, String degree,
			MultipartFile image, int isdelete, int chucvuid, String manv) {
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
		this.chucvuid = chucvuid;
		this.manv = manv;
	}

	public EmployeeDTO(long id, String name, String address, String phone, Date birthday, int gender, String degree,
			MultipartFile image, int chucvuid, String manv) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.degree = degree;
		this.image = image;
		this.chucvuid = chucvuid;
		this.manv = manv;
	}

	public EmployeeDTO(long id, String name, String phone, Date birthday, int gender, String degree, MultipartFile image,
			int chucvuid, String manv) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.degree = degree;
		this.image = image;
		this.chucvuid = chucvuid;
		this.manv = manv;
	}
	public EmployeeDTO(long id, String name, String phone, Date birthday, int gender, String degree, MultipartFile image,
			int isdelete, int chucvuid, String manv) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.gender = gender;
		this.degree = degree;
		this.image = image;
		this.isdelete = isdelete;
		this.chucvuid = chucvuid;
		this.manv = manv;
	}
	public EmployeeDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public int getChucvuid() {
		return chucvuid;
	}

	public void setChucvuid(int chucvuid) {
		this.chucvuid = chucvuid;
	}

	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	
}
