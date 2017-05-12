package com.wllman.vo;

import java.sql.Timestamp;

public class Vote {
	private int voteid;
	private String votename;
	private Timestamp starttime;
	private Timestamp endtime;
	private int promoterid;
	private String description;
	
	
	
	public Vote() {
		super();
	}
	
	public Vote(int voteid) {
		super();
		this.voteid = voteid;
	}

	public Vote(int voteid, String votename, Timestamp starttime,
			Timestamp endtime, int promoterid, String description) {
		super();
		this.voteid = voteid;
		this.votename = votename;
		this.starttime = starttime;
		this.endtime = endtime;
		this.promoterid = promoterid;
		this.description = description;
	}

	public int getVoteid() {
		return voteid;
	}
	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}
	public String getVotename() {
		return votename;
	}
	public void setVotename(String votename) {
		this.votename = votename;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getEndtime() {
		return endtime;
	}
	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
	public int getPromoterid() {
		return promoterid;
	}
	public void setPromoterid(int promoterid) {
		this.promoterid = promoterid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}