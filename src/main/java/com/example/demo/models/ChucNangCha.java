package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chucnangcha")
public class ChucNangCha {
	@Id
	@Column(name="id")
	private Long id;
	@Column(name="tencn")
	private String tencn;
	@Column(name="cnurl")
	private String cnurl;
	@Column(name="macn")
	private String macn;
	
	@Column(name="mota")
	private String mota;
	@Column(name="maapi")
	private String maapi;
	@Column(name="congkhai")
	private boolean congkhai;
	@Column(name="isdelete")
	private int isdelete;
	public ChucNangCha() {
		super();
	}
	
	public ChucNangCha(Long id) {
		super();
		this.id = id;
	}

	public ChucNangCha(Long id, int isdelete) {
		super();
		this.id = id;
		this.isdelete = isdelete;
	}

	public ChucNangCha(Long id, String tencn, String cnurl, String macn, String mota, String maapi, boolean congkhai,
			int isdelete) {
		super();
		this.id = id;
		this.tencn = tencn;
		this.cnurl = cnurl;
		this.macn = macn;
		this.mota = mota;
		this.maapi = maapi;
		this.congkhai = congkhai;
		this.isdelete = isdelete;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTencn() {
		return tencn;
	}
	public void setTencn(String tencn) {
		this.tencn = tencn;
	}
	public String getCnurl() {
		return cnurl;
	}
	public void setCnurl(String cnurl) {
		this.cnurl = cnurl;
	}
	public String getMacn() {
		return macn;
	}
	public void setMacn(String macn) {
		this.macn = macn;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getMaapi() {
		return maapi;
	}
	public void setMaapi(String maapi) {
		this.maapi = maapi;
	}
	public boolean isCongkhai() {
		return congkhai;
	}
	public void setCongkhai(boolean congkhai) {
		this.congkhai = congkhai;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
}
