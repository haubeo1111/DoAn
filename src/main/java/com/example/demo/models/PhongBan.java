package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phongban")
public class PhongBan {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private  Long id;
	@Column(name="name")
	private String name;
	@Column(name="mapb")
	private String mapb;
	@Column(name="isdelete")
	private int isdelete;
	public PhongBan() {
		super();
	}
	public PhongBan(Long id, String name, String mapb, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.mapb = mapb;
		this.isdelete = isdelete;
	}
	public PhongBan(Long id) {
		super();
		this.id = id;
	}
	public PhongBan(Long id, int isdelete) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMapb() {
		return mapb;
	}
	public void setMapb(String mapb) {
		this.mapb = mapb;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
