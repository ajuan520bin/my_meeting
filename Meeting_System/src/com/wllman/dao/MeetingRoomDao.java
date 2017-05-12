package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Meetingroom;

public class MeetingRoomDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	//查看一个会议室详情
		public List<Meetingroom> selectOneRoom(int roomid){
			con = DBConnection.getConnection();
			List<Meetingroom> list = new ArrayList<Meetingroom>();

			String sql="select * from meetingroom where roomid="+roomid;
			try {
				pre = con.prepareStatement(sql);
				res = pre.executeQuery();
				
				while(res.next()){
					Meetingroom meetingroom=new Meetingroom();
					meetingroom.setRoomid(Integer.parseInt(res.getString("roomid")));
					meetingroom.setRoomnum(Integer.parseInt(res.getString("roomnum")));
					meetingroom.setCapacity(Integer.parseInt(res.getString("capacity")));
					meetingroom.setRoomname(res.getString("roomname"));
					meetingroom.setStatus(res.getString("status"));
					meetingroom.setDescription(res.getString("description"));	
					
					list.add(meetingroom);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
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
		
	public List<Meetingroom> selectMeetingrooms() {
		con = DBConnection.getConnection();
		List<Meetingroom> list = new ArrayList<Meetingroom>();
		
		String sql="select * from meetingroom ";
		
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			while(res.next()){
				Meetingroom meetingroom=new Meetingroom();
				meetingroom.setRoomid(Integer.parseInt(res.getString("roomid")));
				meetingroom.setRoomnum(Integer.parseInt(res.getString("roomnum")));
				meetingroom.setCapacity(Integer.parseInt(res.getString("capacity")));
				meetingroom.setRoomname(res.getString("roomname"));
				meetingroom.setStatus(res.getString("status"));
				meetingroom.setDescription(res.getString("description"));	
				
				list.add(meetingroom);
			}
			return list;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	//添加一个会议室,添加成功返回true；状态可用为1，不可用为0
		public boolean addRoom (Meetingroom meetingroom) throws SQLException{
			con = DBConnection.getConnection();

			String sql="insert into meetingroom" +
						"(roomnum,roomname,capacity,status,description)" +" values(?,?,?,?,?)";
			try {
				pre=con.prepareStatement(sql);
				pre.setInt(1,meetingroom.getRoomnum());
				pre.setString(2, meetingroom.getRoomname());
				pre.setInt(3,meetingroom.getCapacity());
				pre.setString(4, meetingroom.getStatus());
				pre.setString(5, meetingroom.getDescription());
				
				int i=pre.executeUpdate();
				if(i>0){
					System.out.println("添加一个会议室成功MRDao");
					return true;
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.close();
				pre.close();
			}		
			return false;
			
		}
		
		//添加一个会议室,添加成功返回true；状态可用为1，不可用为0
		public boolean updateRoom (Meetingroom meetingroom) throws SQLException{
			con = DBConnection.getConnection();
			String sql="update meetingroom set roomname=?,roomnum=?,capacity=?,status=?,description=? where roomid=?";
			try {
				pre=con.prepareStatement(sql);
				pre.setInt(2,meetingroom.getRoomnum());
				pre.setString(1, meetingroom.getRoomname());
				pre.setInt(3,meetingroom.getCapacity());
				pre.setString(4, meetingroom.getStatus());
				pre.setString(5, meetingroom.getDescription());
				pre.setInt(6, meetingroom.getRoomid());
				System.out.println(meetingroom.getRoomid());
				int i=pre.executeUpdate();
				if(i>0){
					System.out.println("修改一个会议室成功MRDao");
					return true;
				}
				else{
					System.out.println("议室成功MRDao");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.close();
				pre.close();
			}		
			return false;
			
		}
		
		
		//添加一个会议室,添加成功返回true；状态可用为1，不可用为0
		public boolean deleteRoom (int id) throws SQLException{
			con = DBConnection.getConnection();

			String sql="delete from meetingroom where roomid="+id;
			try {
				pre=con.prepareStatement(sql);
				
				int i=pre.executeUpdate();
				if(i>0){
				//	System.out.println("修改一个会议室成功MRDao");
					return true;
				}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.close();
				pre.close();
			}		
			return false;
			
		}
}



