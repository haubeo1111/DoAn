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
@Table(name="tkloaidt")
public class TKLoaiDT {
    @Id
	@Column(name="id")
	private long id;
	@Column(name="maloaidt")
	private String maloaidt;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngaybatdau;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date ngayketthuc;
	@Column(name="idtangkem")
	private long idtangkem;
	@Column(name="isdelete")
	private int isdelete;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMaloaidt() {
		return maloaidt;
	}
	public void setMaloaidt(String maloaidt) {
		this.maloaidt = maloaidt;
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
	public long getIdtangkem() {
		return idtangkem;
	}
	public void setIdtangkem(long idtangkem) {
		this.idtangkem = idtangkem;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public TKLoaiDT() {
		super();
	}
	public TKLoaiDT(long id, String maloaidt, Date ngaybatdau, Date ngayketthuc, long idtangkem, int isdelete) {
		super();
		this.id = id;
		this.maloaidt = maloaidt;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
		this.idtangkem = idtangkem;
		this.isdelete = isdelete;
	}
	public TKLoaiDT(long id) {
		super();
		this.id = id;
	}
	public TKLoaiDT(long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	
}
