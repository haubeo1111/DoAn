package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qlchucnangnv")
public class QLChucNangNV {
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="cnxem")
	private boolean cnxem;
	@Column(name="cnthem")
	private boolean qhthem;
	@Column(name="cnsua")
	private boolean cnsua;
	@Column(name="cnxoa")
	private boolean cnxoa;
	@Column(name="cntimkiem")
	private boolean cntimkiem;
	@Column(name="idnhanvien")
	private Long idnhanvien;
	
	@Column(name="isdelete")
	private Long isdelete;

	public QLChucNangNV() {
		super();
	}

	public QLChucNangNV(Long id) {
		super();
		this.id = id;
	}

	public QLChucNangNV(Long id, boolean cnxem, boolean qhthem, boolean cnsua, boolean cnxoa, boolean cntimkiem,
			Long idnhanvien, Long isdelete) {
		super();
		this.id = id;
		this.cnxem = cnxem;
		this.qhthem = qhthem;
		this.cnsua = cnsua;
		this.cnxoa = cnxoa;
		this.cntimkiem = cntimkiem;
		this.idnhanvien = idnhanvien;
		this.isdelete = isdelete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCnxem() {
		return cnxem;
	}

	public void setCnxem(boolean cnxem) {
		this.cnxem = cnxem;
	}

	public boolean isQhthem() {
		return qhthem;
	}

	public void setQhthem(boolean qhthem) {
		this.qhthem = qhthem;
	}

	public boolean isCnsua() {
		return cnsua;
	}

	public void setCnsua(boolean cnsua) {
		this.cnsua = cnsua;
	}

	public boolean isCnxoa() {
		return cnxoa;
	}

	public void setCnxoa(boolean cnxoa) {
		this.cnxoa = cnxoa;
	}

	public boolean isCntimkiem() {
		return cntimkiem;
	}

	public void setCntimkiem(boolean cntimkiem) {
		this.cntimkiem = cntimkiem;
	}

	public Long getIdnhanvien() {
		return idnhanvien;
	}

	public void setIdnhanvien(Long idnhanvien) {
		this.idnhanvien = idnhanvien;
	}

	public Long getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Long isdelete) {
		this.isdelete = isdelete;
	}
	
}
