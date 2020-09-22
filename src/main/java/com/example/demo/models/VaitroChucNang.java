package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vaitrochucnang")
public class VaitroChucNang {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="idvt")
	private Long idvt;
	@Column(name="idcn")
	private Long idcn;
	@Column(name="isdelete")
	private int isdelete;
	public VaitroChucNang() {
		super();
	}
	
	

	public VaitroChucNang(Long id, Long idvt) {
		super();
		this.id = id;
		this.idvt = idvt;
	}



	public VaitroChucNang(Long id, Long idvt, Long idcn, int isdelete) {
		super();
		this.id = id;
		this.idvt = idvt;
		this.idcn = idcn;
		this.isdelete = isdelete;
	}
	public VaitroChucNang(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public VaitroChucNang(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdvt() {
		return idvt;
	}
	public void setIdvt(Long idvt) {
		this.idvt = idvt;
	}
	public Long getIdcn() {
		return idcn;
	}
	public void setIdcn(Long idcn) {
		this.idcn = idcn;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
