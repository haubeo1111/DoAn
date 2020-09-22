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
@Table(name="phukien")
public class PhuKien {
	private static final long serialVersionUID = 1L;
@Id
@Column(name="id")
private long id;
@Column(name="mapk")
private String mapk;
@Column(name="tenpk")
private String tenpk;
@DateTimeFormat(pattern = "dd/MM/yyyy")
@Temporal(TemporalType.DATE)
private Date ngaynhap;
@Column(name="hinhanh")
private String hinhanh;
@Column(name="soluong")
private Long soluong;
@Column(name="giaban")
private Double giaban;
@Column(name="maloaipk")
private String maloaipk;
@Column(name="isdelete")
private int isdelete;

public String getMaloaipk() {
	return maloaipk;
}
public void setMaloaipk(String maloaipk) {
	this.maloaipk = maloaipk;
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Double giaban,
		String maloaipk, int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.maloaipk = maloaipk;
	this.isdelete = isdelete;
}
public PhuKien() {
	super();
}
public PhuKien(long id, String mapk, String tenpk, Date ngaynhap, String hinhanh, Long soluong, Double giaban,
		int isdelete) {
	super();
	this.id = id;
	this.mapk = mapk;
	this.tenpk = tenpk;
	this.ngaynhap = ngaynhap;
	this.hinhanh = hinhanh;
	this.soluong = soluong;
	this.giaban = giaban;
	this.isdelete = isdelete;
}
public PhuKien(long id, int isdelete) {
	super();
	this.id = id;
	this.isdelete = isdelete;
}
public PhuKien(long id) {
	super();
	this.id = id;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMapk() {
	return mapk;
}
public void setMapk(String mapk) {
	this.mapk = mapk;
}
public String getTenpk() {
	return tenpk;
}
public void setTenpk(String tenpk) {
	this.tenpk = tenpk;
}
public Date getNgaynhap() {
	return ngaynhap;
}
public void setNgaynhap(Date ngaynhap) {
	this.ngaynhap = ngaynhap;
}
public String getHinhanh() {
	return hinhanh;
}
public void setHinhanh(String hinhanh) {
	this.hinhanh = hinhanh;
}
public Long getSoluong() {
	return soluong;
}
public void setSoluong(Long soluong) {
	this.soluong = soluong;
}
public Double getGiaban() {
	return giaban;
}
public void setGiaban(Double giaban) {
	this.giaban = giaban;
}
public int getIsdelete() {
	return isdelete;
}
public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

}
