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
@Table(name="bangchamcong")
public class BangChamCong {
	@Id
	@Column(name="id")
	private long id;
	@Column(name="idemployee")
	private Long idemployee;
	@Column(name="tinhtrang")
	private int tinhtrang;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaycham;
	@Column(name="isdelete")
	private int isdelete;
	public BangChamCong() {
		super();
	}
	public BangChamCong(long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public BangChamCong(long id) {
		super();
		this.id = id;
	}
	public BangChamCong(long id, Long idemployee, int tinhtrang, Date ngaycham, int isdelete) {
		super();
		this.id = id;
		this.idemployee = idemployee;
		this.tinhtrang = tinhtrang;
		this.ngaycham = ngaycham;
		this.isdelete = isdelete;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(Long idemployee) {
		this.idemployee = idemployee;
	}
	public int getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public Date getNgaycham() {
		return ngaycham;
	}
	public void setNgaycham(Date ngaycham) {
		this.ngaycham = ngaycham;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
