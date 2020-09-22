package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="phucap")
public class PhuCap {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="tenphucap")
	private String tenphucap;
	@Column(name="sotien")
	private double sotien;
	@Column(name="idchucvu")
	private int idchucvu;
	@Column(name="isdelete")
	private int isdelete;

	public PhuCap() {
		super();
	}

	public int getIdchucvu() {
		return idchucvu;
	}

	public void setIdchucvu(int idchucvu) {
		this.idchucvu = idchucvu;
	}

	public PhuCap(Long id, String tenphucap, double sotien, int idchucvu, int isdelete) {
		super();
		this.id = id;
		this.tenphucap = tenphucap;
		this.sotien = sotien;
		this.idchucvu = idchucvu;
		this.isdelete = isdelete;
	}

	public PhuCap(Long id) {
		super();
		this.id = id;
	}

	public PhuCap(Long id, String tenphucap, double sotien, int isdelete) {
		super();
		this.id = id;
		this.tenphucap = tenphucap;
		this.sotien = sotien;
		this.isdelete = isdelete;
	}

	public PhuCap(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenphucap() {
		return tenphucap;
	}

	public void setTenphucap(String tenphucap) {
		this.tenphucap = tenphucap;
	}

	public double getSotien() {
		return sotien;
	}

	public void setSotien(double sotien) {
		this.sotien = sotien;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
