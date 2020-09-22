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
@Table(name="dienthoai")
public class DienThoai {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id",nullable = false)
	private  Long id;
	@Column(name="name")
	private String name;
	@Column(name="madt")
	private String madt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaynhap;
	@Column(name="hinhanh")
	private String hinhanh;
	@Column(name="soluong")
	private Long soluong;
	@Column(name="giaban")
	private Double giaban;
    @Column(name="maloaidt")
	private String maloaidt;
    @Column(name="isdelete")
   	private int isdelete;
    
	public DienThoai(Long id, String name, String madt, Date ngaynhap, String hinhanh, Long soluong, Double giaban,
			String maloaidt, int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.madt = madt;
		this.ngaynhap = ngaynhap;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
		this.isdelete = isdelete;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public DienThoai() {
		super();
	}
	
	public DienThoai(Long id) {
		super();
		this.id = id;
	}

	public DienThoai(Long id, String name, String madt, Date ngaynhap, String hinhanh,
			Long soluong,
			Double giaban,
			String maloaidt) {
		super();
		this.id = id;
		this.name = name;
		this.madt = madt;
		this.ngaynhap = ngaynhap;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.giaban = giaban;
		this.maloaidt = maloaidt;
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
	public String getMadt() {
		return madt;
	}
	public void setMadt(String madt) {
		this.madt = madt;
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
	public String getMaloaidt() {
		return maloaidt;
	}
	public void setMaloaidt(String maloaidt) {
		this.maloaidt = maloaidt;
	}
    
	
}
