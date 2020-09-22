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
@Table(name="tangca")
public class TangCa {
	@Id
	@Column(name="id")
	private  Long id;
	@Column(name="idemployee")
	private  Long idemployee;
	@Column(name="gio")
	private  int gio;
	@Column(name="tien")
	private  long tien;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaytang;
	@Column(name="isdelete")
	private  int isdelete;
	public TangCa() {
		super();
	}
	
	public long getTien() {
		return tien;
	}

	public void setTien(long tien) {
		this.tien = tien;
	}

	public TangCa(Long id, Long idemployee, int gio, long tien, Date ngaytang, int isdelete) {
		super();
		this.id = id;
		this.idemployee = idemployee;
		this.gio = gio;
		this.tien = tien;
		this.ngaytang = ngaytang;
		this.isdelete = isdelete;
	}

	public TangCa(Long id, Long idemployee, int gio, Date ngaytang, int isdelete) {
		super();
		this.id = id;
		this.idemployee = idemployee;
		this.gio = gio;
		this.ngaytang = ngaytang;
		this.isdelete = isdelete;
	}
	public TangCa(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public TangCa(Long id) {
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
	public int getGio() {
		return gio;
	}
	public void setGio(int gio) {
		this.gio = gio;
	}
	public Date getNgaytang() {
		return ngaytang;
	}
	public void setNgaytang(Date ngaytang) {
		this.ngaytang = ngaytang;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
