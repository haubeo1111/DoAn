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
@Table(name="tienluong")
public class TienLuong {
	@Id
	@Column(name="id")
	private  Long id;
	@Column(name="idemployee")
	private  Long idemployee;
	@Column(name="luong")
	private  Long luong;
	@Column(name="luongthuc")
	private  Long luongthuc;
	@Column(name="songay")
	private  int songay ;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaydauthang;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaycuoithang;
	@Column(name="isdelete")
	private  int isdelete ;
	public TienLuong() {
		super();
	}
	public TienLuong(Long id, Long idemployee, Long luong, Long luongthuc, int songay, Date ngaydauthang,
			Date ngaycuoithang, int isdelete) {
		super();
		this.id = id;
		this.idemployee = idemployee;
		this.luong = luong;
		this.luongthuc = luongthuc;
		this.songay = songay;
		this.ngaydauthang = ngaydauthang;
		this.ngaycuoithang = ngaycuoithang;
		this.isdelete = isdelete;
	}
	public TienLuong(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public TienLuong(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(Long idemployee) {
		this.idemployee = idemployee;
	}
	public Long getLuong() {
		return luong;
	}
	public void setLuong(Long luong) {
		this.luong = luong;
	}
	public Long getLuongthuc() {
		return luongthuc;
	}
	public void setLuongthuc(Long luongthuc) {
		this.luongthuc = luongthuc;
	}
	public int getSongay() {
		return songay;
	}
	public void setSongay(int songay) {
		this.songay = songay;
	}
	public Date getNgaydauthang() {
		return ngaydauthang;
	}
	public void setNgaydauthang(Date ngaydauthang) {
		this.ngaydauthang = ngaydauthang;
	}
	public Date getNgaycuoithang() {
		return ngaycuoithang;
	}
	public void setNgaycuoithang(Date ngaycuoithang) {
		this.ngaycuoithang = ngaycuoithang;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
