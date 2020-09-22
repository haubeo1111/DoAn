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
@Table(name="tangkem")
public class TangKem {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private  Long id;
	@Column(name="name")
	private String name;
	@Column(name="matk")
	private String matk;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaynhap;
	@Column(name="hinhanh")
	private String hinhanh;
	@Column(name="soluong")
	private Long soluong;
	@Column(name="gianhap")
	private Double gianhap;
    
    @Column(name="isdelete")
   	private int isdelete;

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

	public String getMatk() {
		return matk;
	}

	public void setMatk(String matk) {
		this.matk = matk;
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

	public Double getGianhap() {
		return gianhap;
	}

	public void setGianhap(Double gianhap) {
		this.gianhap = gianhap;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	public TangKem(Long id, String name, String matk, Date ngaynhap, String hinhanh, Long soluong, Double gianhap,
			int isdelete) {
		super();
		this.id = id;
		this.name = name;
		this.matk = matk;
		this.ngaynhap = ngaynhap;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.gianhap = gianhap;
		this.isdelete = isdelete;
	}

	public TangKem() {
		super();
	}

	public TangKem(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}

	public TangKem(Long id) {
		super();
		this.id = id;
	}
    

    
	
}
