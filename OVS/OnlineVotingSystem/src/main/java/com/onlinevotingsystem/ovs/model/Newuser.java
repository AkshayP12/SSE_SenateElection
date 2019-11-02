package com.onlinevotingsystem.ovs.model;

public class Newuser {

	private String fname;
	private String lname;
	private String uniqueId;
	
	public Newuser(String fname, String lname, String uniqueId) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uniqueId = uniqueId;
	}
	public Newuser() {
		// TODO Auto-generated constructor stub
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
}
