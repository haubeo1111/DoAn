package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qluser")
public class QLUser {
@Id
@Column(name="id")
private Long id;
@Column(name="tendangnhap")
private String tendangnhap;
@Column(name="hoten")
private String hoten;
@Column(name="email")
private String email;
@Column(name="chucnang")
private String chucnang;
@Column(name="idphongban")
private Long idphongban;
@Column(name="idchucvu")
private Long idchucvu;
@Column(name="idvaitro")
private Long idvaitro;
@Column(name="idgroupuser")
private Long idgroupuser;
@Column(name="isdelete")
private int isdelete;
public QLUser() {
	super();
}
public String getChucnang() {
	return chucnang;
}

public Long getIdvaitro() {
	return idvaitro;
}
public void setIdvaitro(Long idvaitro) {
	this.idvaitro = idvaitro;
}

public QLUser(String tendangnhap) {
	super();
	this.tendangnhap = tendangnhap;
}
public QLUser(Long id, String tendangnhap, String hoten, String email, String chucnang, Long idphongban, Long idchucvu,
		Long idvaitro, Long idgroupuser, int isdelete) {
	super();
	this.id = id;
	this.tendangnhap = tendangnhap;
	this.hoten = hoten;
	this.email = email;
	this.chucnang = chucnang;
	this.idphongban = idphongban;
	this.idchucvu = idchucvu;
	this.idvaitro = idvaitro;
	this.idgroupuser = idgroupuser;
	this.isdelete = isdelete;
}
public void setChucnang(String chucnang) {
	this.chucnang = chucnang;
}

public QLUser(Long id, String tendangnhap, String hoten, String email, Long idphongban, Long idchucvu,
		Long idgroupuser, int isdelete) {
	super();
	this.id = id;
	this.tendangnhap = tendangnhap;
	this.hoten = hoten;
	this.email = email;
	
	this.idphongban = idphongban;
	this.idchucvu = idchucvu;
	this.idgroupuser = idgroupuser;
	this.isdelete = isdelete;
}
public QLUser(Long id) {
	super();
	this.id = id;
}
public QLUser(Long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
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
public String getHoten() {
	return hoten;
}
public void setHoten(String hoten) {
	this.hoten = hoten;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public Long getIdphongban() {
	return idphongban;
}
public void setIdphongban(Long idphongban) {
	this.idphongban = idphongban;
}
public Long getIdchucvu() {
	return idchucvu;
}
public void setIdchucvu(Long idchucvu) {
	this.idchucvu = idchucvu;
}
public Long getIdgroupuser() {
	return idgroupuser;
}
public void setIdgroupuser(Long idgroupuser) {
	this.idgroupuser = idgroupuser;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}




}
