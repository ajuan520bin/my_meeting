package com.wllman.vo;

public class MeetingParticipants {
	private int meetingid;
	private int employeeid;
	
	public int getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public MeetingParticipants(int meetingid, int employeeid) {
		super();
		this.meetingid = meetingid;
		this.employeeid = employeeid;
	}
	public MeetingParticipants() {
		super();
	}
	public MeetingParticipants(int employeeid) {
		super();
		this.employeeid = employeeid;
	}
	
	
	

}
