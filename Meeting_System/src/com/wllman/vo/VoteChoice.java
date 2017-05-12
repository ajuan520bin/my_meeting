package com.wllman.vo;

public class VoteChoice {
	private int voteid;
	private int choiceid;
	private String choicename;
	private int count;
	
	public VoteChoice() {
		super();
	}
	
	public int getVoteid() {
		return voteid;
	}
	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}
	public int getChoiceid() {
		return choiceid;
	}
	public void setChoiceid(int choiceid) {
		this.choiceid = choiceid;
	}
	public String getChoicename() {
		return choicename;
	}
	public void setChoicename(String choicename) {
		this.choicename = choicename;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
