package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class PhuKienDTO {
private  Long id;
private String mapk;
	private String tenpk;
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaynhap;
	
	private MultipartFile hinhanh;
	
	private Long soluong;
	
	private Double giaban;
   

	private String maloaipk;
	private int isdelete;
	
	public PhuKienDTO(Long id, String mapk, String tenpk, Date ngaynhap, MultipartFile hinhanh, Long soluong,
			Double giaban, String maloaipk, int isdelete) {
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
	public PhuKienDTO(Long id, String tenpk, Date ngaynhap, MultipartFile hinhanh, Long soluong, String maloaipk,
			Double giaban, String mapk, int isdelete) {
		super();
		this.id = id;
		this.tenpk = tenpk;
		this.ngaynhap = ngaynhap;
		this.hinhanh = hinhanh;
		this.soluong = soluong;
		this.maloaipk = maloaipk;
		this.giaban = giaban;
		this.mapk = mapk;
		this.isdelete = isdelete;
	}
	public PhuKienDTO() {
		super();
	}
	public PhuKienDTO(Long id) {
		super();
		this.id = id;
	}
	public PhuKienDTO(Long id, int isdelete) {
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
	public String getMaloaipk() {
		return maloaipk;
	}
	public void setMaloaipk(String maloaipk) {
		this.maloaipk = maloaipk;
	}
	public Double getGiaban() {
		return giaban;
	}
	public void setGiaban(Double giaban) {
		this.giaban = giaban;
	}
	public String getMapk() {
		return mapk;
	}
	public void setMapk(String mapk) {
		this.mapk = mapk;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
