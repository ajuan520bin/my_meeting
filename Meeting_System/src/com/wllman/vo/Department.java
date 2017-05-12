package com.wllman.vo;

public class Department {
	private int departmentid;
	private String departmentname;

	public Department() {
		super();
	}

	public Department(String departmentname) {
		super();
		this.departmentname = departmentname;
	}
	
	public Department(int departmentid, String departmentname) {
		super();
		this.departmentid = departmentid;
		this.departmentname = departmentname;
	}
	
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
}
