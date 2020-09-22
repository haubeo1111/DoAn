package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class TangKemDTO {
	private  Long id;
	
	private String name;
	
	private String matk;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaynhap;
	
	private MultipartFile hinhanh;
	
	private Long soluong;
	
	private Double gianhap;
   

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


	public MultipartFile getHinhanh() {
		return hinhanh;
	}


	public void setHinhanh(MultipartFile hinhanh) {
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


	public TangKemDTO(Long id, String name, String matk, Date ngaynhap, MultipartFile hinhanh, Long soluong,
			Double gianhap, int isdelete) {
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


	public TangKemDTO() {
		super();
	}


	public TangKemDTO(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}


	public TangKemDTO(Long id) {
		super();
		this.id = id;
	}
	
	

}
