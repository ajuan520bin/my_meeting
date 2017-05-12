package com.wllman.vo;

public class Meetingroom {
	private Integer roomid;
	private Integer roomnum;
	private Integer capacity;
	private String 	roomname;
	private String  status;
	private String 	description;
	
	public Meetingroom() {
		super();
	}
	
	public Meetingroom(Integer roomid) {
		super();
		this.roomid = roomid;
	}
	
	public Meetingroom(Integer roomnum, String roomname, Integer capacity,String status, String description) {
		super();
	
		this.roomnum = roomnum;
		this.capacity = capacity;
		this.roomname = roomname;
		this.status = status;
		this.description = description;
	}
	
	public Meetingroom(Integer roomid, Integer roomnum, String roomname, Integer capacity,String status, String description) {
		super();
		this.roomid = roomid;
		this.roomnum = roomnum;
		this.capacity = capacity;
		this.roomname = roomname;
		this.status = status;
		this.description = description;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(Integer roomnum) {
		this.roomnum = roomnum;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
