package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaitro")
public class VaiTro {
@Id
@Column(name="id")
private Long id;
@Column(name="tenvt")
private String tenvt;
@Column(name="mavt")
private String mavt;


@Column(name="isdelete")
private int isdelete;
public VaiTro() {
	super();
}

public VaiTro(Long id) {
	super();
	this.id = id;
}

public VaiTro(Long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}

public VaiTro(Long id, String tenvt, String mavt, int isdelete) {
	super();
	this.id = id;
	this.tenvt = tenvt;
	this.mavt = mavt;
	this.isdelete = isdelete;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTenvt() {
	return tenvt;
}

public void setTenvt(String tenvt) {
	this.tenvt = tenvt;
}

public String getMavt() {
	return mavt;
}

public void setMavt(String mavt) {
	this.mavt = mavt;
}

public int getIsdelete() {
	return isdelete;
}

public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}


}
