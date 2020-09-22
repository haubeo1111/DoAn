package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="vidu")
public class vidu {
	@Min(value = 18,message="khong duoc thap hon 18")
	@Id
	@Column(name="id")
	private  Long id;
	@NotNull(message="khong duoc bo trong")
	@Size(min=3,max=15)
	@Column(name="name")
	private String name;
	@NotEmpty(message="khong duoc bo trong")
	@Email(message="email khong hop le")
	@Column(name="email")
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public vidu(@Min(value = 18, message = "khong duoc thap hon 18") Long id,
			@NotNull(message = "khong duoc bo trong") @Size(min = 3, max = 15) String name,
			@NotEmpty(message = "khong duoc bo trong") @Email(message = "email khong hop le") String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public vidu() {
		super();
	}
	
}
