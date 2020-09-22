package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userchucnang")
public class UserChucNang {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="iduser")
	private Long iduser;
	@Column(name="idcn")
	private Long idcn;
	@Column(name="isdelete")
	private int isdelete;
	public UserChucNang() {
		super();
	}
	public UserChucNang(Long id, Long iduser, Long idcn, int isdelete) {
		super();
		this.id = id;
		this.iduser = iduser;
		this.idcn = idcn;
		this.isdelete = isdelete;
	}
	public UserChucNang(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
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
