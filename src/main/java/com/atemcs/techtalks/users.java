package com.atemcs.techtalks;

public class users {

	private int empid;
	private String name;
	private String password;
	private String email;
	public users(int empid, String name, String password, String email) {
		super();
		this.empid = empid;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public users() {
		super();
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
