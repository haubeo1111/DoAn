package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="groupusercn")
public class GroupUserCN {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="idgroupuser")
	private Long idgroupuser;
	@Column(name="idcn")
	private Long idcn;
	@Column(name="isdelete")
	private int isdelete;
	public GroupUserCN() {
		super();
	}
	public GroupUserCN(Long id, Long idgroupuser, Long idcn, int isdelete) {
		super();
		this.id = id;
		this.idgroupuser = idgroupuser;
		this.idcn = idcn;
		this.isdelete = isdelete;
	}
	public GroupUserCN(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}
	public GroupUserCN(Long id) {
		super();
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdgroupuser() {
		return idgroupuser;
	}
	public void setIdgroupuser(Long idgroupuser) {
		this.idgroupuser = idgroupuser;
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
