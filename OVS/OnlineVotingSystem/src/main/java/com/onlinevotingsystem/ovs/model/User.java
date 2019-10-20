package com.onlinevotingsystem.ovs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "auth_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auth_user_id")
	private int id;
	
	@NotNull(message="First Name is mandatory")
	@Column(name = "first_name")
	private String name;

	@NotNull(message="Last Name is mandatory")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message="Unique id is mandatory")
	@Column(name = "Unique_id")
	private String unique_id;

	@NotNull(message="Email is mandatory")
	@Email(message = "Email is invalid")
	@Column(name = "email")
	private String email;

	@NotNull(message="Password is mandatory")
	@Length(min=5, message = "Password should be atleast of 5 characters ")
	@Column(name = "password")
	private String password;

//	@Column(name = "mobile")
	//private String mobile;

	@Column(name = "status")
	private String status;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUnique_id() {
		return unique_id;
	}

	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//public String getMobile() {
		//return mobile;
	//}

	//public void setMobile(String mobile) {
		//this.mobile = mobile;
	//}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
