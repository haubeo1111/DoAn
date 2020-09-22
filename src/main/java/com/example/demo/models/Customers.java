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
@Table(name="customers")
public class Customers {
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE)
	//@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;
    @Column(name="gender")
	private int gender;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
   @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;
    @Column(name="isdelete")
   	private int isdelete;
	public Customers() {
		super();
	}
	public Customers(Long id) {
		super();
		this.id = id;
	}
	
	
	public Customers(Long id, String name, int gender, Date birthday, String email, String phone, String password,
			String address, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.isdelete = isdelete;
	}
	public Customers(Long id, String name, int gender, Date birthday, String email, String phone, String password,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
