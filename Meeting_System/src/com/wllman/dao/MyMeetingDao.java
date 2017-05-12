package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Meeting;

public class MyMeetingDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;

	public List<Meeting> selectAllMeetingsByParId(int participantsid) {
		con = DBConnection.getConnection();
		List<Meeting> list = new ArrayList<Meeting>();
		String sql = "select * from meeting,meetingparticipants where meeting.meetingid=meetingparticipants.meetingid and meetingparticipants.employeeid="
				+ participantsid;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Meeting meeting = new Meeting();
				meeting.setMeetingid(res.getInt("meetingid"));
				meeting.setMeetingname(res.getString("meetingname"));
				meeting.setRoomid(res.getInt("roomid"));
				meeting.setReservationistid(res.getInt("reservationistid"));
				meeting.setNumberofparticipants(res.getInt("numberofparticipants"));
				meeting.setStarttime(res.getTimestamp("starttime"));
				meeting.setEndtime(res.getTimestamp("endtime"));
				meeting.setReservationtime(res.getTimestamp("reservationtime"));
				meeting.setCanceledtime(res.getTimestamp("canceledtime"));
				meeting.setDescription(res.getString("description"));
				meeting.setStatus(res.getString("status"));
				list.add(meeting);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pre.close();
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Meeting> selectAllNewMeetings(int participantsid) {
		con = DBConnection.getConnection();
		List<Meeting> list = new ArrayList<Meeting>();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		Timestamp sevenDays = new Timestamp(System.currentTimeMillis() + 7 * 24* 3600 * 1000);
		String nowTime = now.toString();
		String sevenDaysTime = sevenDays.toString();
		System.out.println(nowTime);
		System.out.println(sevenDaysTime);
		String sql = "select * from meeting,meetingparticipants where meeting.meetingid=meetingparticipants.meetingid and"+ " meetingparticipants.employeeid="+ participantsid+ " and meeting.starttime>'"+ nowTime+ "'and meeting.starttime<'"+ sevenDaysTime+ "' and status='0'";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Meeting meeting = new Meeting();
				meeting.setMeetingid(res.getInt("meetingid"));
				meeting.setMeetingname(res.getString("meetingname"));
				meeting.setRoomid(res.getInt("roomid"));
				meeting.setReservationistid(res.getInt("reservationistid"));
				meeting.setNumberofparticipants(res.getInt("numberofparticipants"));
				meeting.setStarttime(res.getTimestamp("starttime"));
				meeting.setEndtime(res.getTimestamp("endtime"));
				meeting.setReservationtime(res.getTimestamp("reservationtime"));
				meeting.setCanceledtime(res.getTimestamp("canceledtime"));
				meeting.setDescription(res.getString("description"));
				meeting.setStatus(res.getString("status"));
				list.add(meeting);
			}
			for(int i = 0;i < list.size();i++ ) {
				System.out.print(((Meeting)list.get(i)).getMeetingid());
				System.out.print(((Meeting)list.get(i)).getMeetingname());
				System.out.print(((Meeting)list.get(i)).getRoomid());
				System.out.print("\n");
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pre.close();
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Meeting> selectAllCanceledMeetings(int participantsid) {
		con = DBConnection.getConnection();
		List<Meeting> list = new ArrayList<Meeting>();
		Timestamp now = new Timestamp(System.currentTimeMillis());
		String nowTime = now.toString();

		String sql = "select * from meeting,meetingparticipants where meeting.meetingid=meetingparticipants.meetingid and"
				+ " meetingparticipants.employeeid="
				+ participantsid
				+ " and meeting.starttime>'" + nowTime + "'and status='1'";
		try {

			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Meeting meeting = new Meeting();
				meeting.setMeetingid(res.getInt("meetingid"));
				meeting.setMeetingname(res.getString("meetingname"));
				meeting.setRoomid(res.getInt("roomid"));
				meeting.setReservationistid(res.getInt("reservationistid"));
				meeting.setNumberofparticipants(res.getInt("numberofparticipants"));
				meeting.setStarttime(res.getTimestamp("starttime"));
				meeting.setEndtime(res.getTimestamp("endtime"));
				meeting.setReservationtime(res.getTimestamp("reservationtime"));
				meeting.setCanceledtime(res.getTimestamp("canceledtime"));
				meeting.setDescription(res.getString("description"));
				meeting.setStatus(res.getString("status"));
				list.add(meeting);
			}
			for(int i = 0;i < list.size();i++ ) {
				System.out.print(((Meeting)list.get(i)).getMeetingid());
				System.out.print(((Meeting)list.get(i)).getMeetingname());
				System.out.print(((Meeting)list.get(i)).getRoomid());
				System.out.print("\n");
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pre.close();
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
