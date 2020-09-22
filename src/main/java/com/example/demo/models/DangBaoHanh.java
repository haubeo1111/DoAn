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
@Table(name="dangbaohanh")
public class DangBaoHanh {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="mabh")
	private String mabh;
	@Column(name="tendienthoai")
	private String tendt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaybatdau;
	@Column(name="madt")
	private String madt;
	@Column(name="idcustomer")
	private long idcustomer;

	@Column(name="isdelete")
	private int isdelete;
	public DangBaoHanh() {
		super();
	}
	public DangBaoHanh(long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	
	public DangBaoHanh(long id, String mabh, String tendt, Date ngaybatdau, String madt, long idcustomer,
			int isdelete) {
		super();
		this.id = id;
		this.mabh = mabh;
		this.tendt = tendt;
		this.ngaybatdau = ngaybatdau;
		this.madt = madt;
		this.idcustomer = idcustomer;
		this.isdelete = isdelete;
	}
	
	public DangBaoHanh(long id) {
		super();
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMabh() {
		return mabh;
	}
	public void setMabh(String mabh) {
		this.mabh = mabh;
	}
	public String getTendt() {
		return tendt;
	}
	public void setTendt(String tendt) {
		this.tendt = tendt;
	}
	public Date getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Date ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
	}
	public long getIdcustomer() {
		return idcustomer;
	}
	public void setIdcustomer(long idcustomer) {
		this.idcustomer = idcustomer;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
