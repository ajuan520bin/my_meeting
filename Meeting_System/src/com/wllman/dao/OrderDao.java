package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Meetingroom;

public class OrderDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;

	public List<Meetingroom> selectMeetingRoomsByTime(Timestamp starttime,
			Timestamp endtime, int capacity) {
		con = DBConnection.getConnection();
		List<Meetingroom> list = new ArrayList<Meetingroom>();
		List<Integer>list2= new ArrayList<Integer>();
//		ArrayList list2 = new ArrayList();
		
		String start = starttime.toString();
		String end = endtime.toString();
		

		String sql = "(select meeting.roomid from meeting, meetingroom where meeting.roomid = meetingroom.roomid  and( (meeting.starttime>'"
				+ start
				+ "' and meeting.endtime >'"
				+ end
				+ "' ) or (meeting.starttime<'"
				+ start
				+ "' and meeting.starttime <'"
				+ end
				+ "')) and meetingroom.capacity >'"
				+ capacity
				+ "') union (select roomid from meetingroom where capacity > '"
				+ capacity
				+ "' and roomid not in (select roomid from meeting))";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			System.out.println("select");

			while (res.next()) {
//				Meetingroom meetingroom = new Meetingroom();
				int roomid = Integer.parseInt(res.getString("roomid"));
//				meetingroom.setRoomid(Integer.parseInt(res.getString("roomid")));
//				meetingroom.setRoomnum(Integer.parseInt(res
//						.getString("roomnum")));
//				meetingroom.setCapacity(Integer.parseInt(res
//						.getString("capacity")));
//				meetingroom.setRoomname(res.getString("roomname"));
//				meetingroom.setStatus(res.getString("status"));
//				meetingroom.setDescription(res.getString("description"));

				list2.add(roomid);
			}
			for (int i = 0; i < list2.size(); i++) { 
				System.out.println(list2.get(i));
			}
			for (int i = 0; i < list2.size(); i++) {
				System.out.println(i);
				sql = "select * from meetingroom where roomid = ?";
				pre = con.prepareStatement(sql);
				pre.setString(1, list2.get(i)+"");
				System.out.println(i);
				res = pre.executeQuery();
				System.out.println(i);
				while(res.next()) {
					Meetingroom meetingroom = new Meetingroom();
				meetingroom.setRoomid(Integer.parseInt(res.getString("roomid")));
				meetingroom.setRoomnum(Integer.parseInt(res
						.getString("roomnum")));
				meetingroom.setCapacity(Integer.parseInt(res
						.getString("capacity")));
				meetingroom.setRoomname(res.getString("roomname"));
				meetingroom.setStatus(res.getString("status"));
				meetingroom.setDescription(res.getString("description"));
				list.add(meetingroom);
				}	
			}	
			//
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
