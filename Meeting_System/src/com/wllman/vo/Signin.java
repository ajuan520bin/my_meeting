package com.wllman.vo;

import java.sql.Timestamp;

public class Signin {
	private int employeeid;
	private Timestamp starttime;
	private String ip;
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public  Signin(){
		super();
	}
	public Signin(int employeeid){
		super();
		this.employeeid=employeeid;
	}
	public Signin(int employeeid,Timestamp starttime,String ip){
		super();
		this.employeeid=employeeid;
		this.starttime=starttime;
		this.ip=ip;
	}

}
