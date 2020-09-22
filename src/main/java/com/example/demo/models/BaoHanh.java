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
@Table(name="baohanh")
public class BaoHanh {
@Id
@Column(name="id")
private long id;
@Column(name="mabh")
private String mabh;
@Column(name="thoigianbh")
private int thoigianbh;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date ngaybatdau;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date ngayketthuc;
@Column(name="dienthoaiid")
private long dienthoaiid;
@Column(name="madt")
private String madt;

@Column(name="isdelete")
private int isdelete;




 
public BaoHanh() {
	super();
}
public BaoHanh(long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}

public BaoHanh(long id, String mabh, int thoigianbh, Date ngaybatdau, Date ngayketthuc, long dienthoaiid, String madt,
		int isdelete) {
	super();
	this.id = id;
	this.mabh = mabh;
	this.thoigianbh = thoigianbh;
	this.ngaybatdau = ngaybatdau;
	this.ngayketthuc = ngayketthuc;
	this.dienthoaiid = dienthoaiid;
	this.madt = madt;
	this.isdelete = isdelete;
}


public String getMadt() {
	return madt;
}

public void setMadt(String madt) {
	this.madt = madt;
}


public BaoHanh(long id) {
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
public int getThoigianbh() {
	return thoigianbh;
}
public void setThoigianbh(int thoigianbh) {
	this.thoigianbh = thoigianbh;
}
public Date getNgaybatdau() {
	return ngaybatdau;
}
public void setNgaybatdau(Date ngaybatdau) {
	this.ngaybatdau = ngaybatdau;
}
public Date getNgayketthuc() {
	return ngayketthuc;
}
public void setNgayketthuc(Date ngayketthuc) {
	this.ngayketthuc = ngayketthuc;
}
public long getDienthoaiid() {
	return dienthoaiid;
}
public void setDienthoaiid(long dienthoaiid) {
	this.dienthoaiid = dienthoaiid;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

}
