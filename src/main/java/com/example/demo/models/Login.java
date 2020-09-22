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
@Table(name="login")
public class Login {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="tendangnhap")
	private String tendangnhap;
	@Column(name="password")
	private String password;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaylogin;
	@Column(name="isdelete")
	private int isdelete;
	public Login() {
		super();
	}
	public Login(Long id, String tendangnhap, String password, int isdelete) {
		super();
		this.id = id;
		this.tendangnhap = tendangnhap;
		this.password = password;
		this.isdelete = isdelete;
	}
	public Login(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public Login(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
