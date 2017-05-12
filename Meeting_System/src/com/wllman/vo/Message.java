package com.wllman.vo;

public class Message {
	int senderid;
	int acceptid;
	int status;
	String message;
	String subject;
	int mesid;
	public Message(int senderid, int acceptid, int status, String message,
			String subject, int mesid) {
		super();
		this.senderid = senderid;
		this.acceptid = acceptid;
		this.status = status;
		this.message = message;
		this.subject = subject;
		this.mesid = mesid;
	}
	public Message(int senderid, int acceptid, int status, String message,
			String subject) {
		super();
		this.senderid = senderid;
		this.acceptid = acceptid;
		this.status = status;
		this.message = message;
		this.subject = subject;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSenderid() {
		return senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}
	public int getAcceptid() {
		return acceptid;
	}
	public void setAcceptid(int acceptid) {
		this.acceptid = acceptid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMesid() {
		return mesid;
	}
	public void setMesid(int mesid) {
		this.mesid = mesid;
	}
}
