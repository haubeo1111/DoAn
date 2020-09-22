package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loaidt")
public class LoaiDT {
	@Id
	
	@Column(name="maloaidt")
	private String maloaidt;
	@Column(name="tenloaidt")
	private String tenloaidt;
	@Column(name="isdelete")
	private int isdelete;
	
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public LoaiDT(String maloaidt, int isdelete) {
		super();
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}
	public LoaiDT(String maloaidt, String tenloaidt, int isdelete) {
		super();
		this.maloaidt = maloaidt;
		this.tenloaidt = tenloaidt;
		this.isdelete = isdelete;
	}
	public LoaiDT(String maloaidt, String tenloaidt) {
		super();
		this.maloaidt = maloaidt;
		this.tenloaidt = tenloaidt;
	}
	public LoaiDT() {
		super();
	}
	public LoaiDT(String maloaidt) {
		super();
		this.maloaidt = maloaidt;
	}
	public String getMaloaidt() {
		return maloaidt;
	}
	public void setMaloaidt(String maloaidt) {
		this.maloaidt = maloaidt;
	}
	public String getTenloaidt() {
		return tenloaidt;
	}
	public void setTenloaidt(String tenloaidt) {
		this.tenloaidt = tenloaidt;
	}
	
}
