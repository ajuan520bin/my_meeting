package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.CompareTime;
import com.wllman.util.DBConnection;
import com.wllman.vo.Meeting;
import com.wllman.vo.Meetingroom;



public class MeetingDao {
	
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	
	public int getMeetingNum(){
		con = DBConnection.getConnection();
		String sql="select count(meetingid) from meeting";
		try {
			pre=con.prepareStatement(sql);
			res=pre.executeQuery();
			while (res.next()){
				System.out.println(res.getInt("count(meetingid)"));

				return res.getInt("count(meetingid)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<Meeting> selectAllMeetingsByReserId(int reservationistid){
		con = DBConnection.getConnection();
		List<Meeting> list = new ArrayList<Meeting>();
		Meeting meeting=null;	
		
		String sql="select * from meeting where reservationistid="+reservationistid+" and status = 0";
		System.out.println(reservationistid);
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while(res.next()){
				meeting=new Meeting();
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
				//System.out.println("1");
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

	//insert a meeting
	public boolean OrderMeeting(Meeting meeting) throws SQLException{
		con = DBConnection.getConnection();
		String sql="insert into meeting"+
					"(meetingname,roomid,reservationistid,numberofparticipants,"
					+ "starttime,endtime,reservationtime,canceledtime,description,status)"
					+"values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pre=con.prepareStatement(sql);
			//pre.setInt(1, meeting.getMeetingid());
			pre.setString(1, meeting.getMeetingname());
			pre.setInt(2, meeting.getRoomid());
			pre.setInt(3, meeting.getReservationistid());
			pre.setInt(4, meeting.getNumberofparticipants());
			pre.setTimestamp(5, meeting.getStarttime());
			pre.setTimestamp(6, meeting.getEndtime());
			pre.setTimestamp(7, meeting.getReservationtime());
			pre.setTimestamp(8, meeting.getCanceledtime());
			pre.setString(9, meeting.getDescription());
			pre.setString(10, meeting.getStatus());

			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("添加一个会议成功MDao");
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
	//查看一个会议详情
		public List<Meeting> selectOneMeeting(int meetingid){
			con = DBConnection.getConnection();
			List<Meeting> list = new ArrayList<Meeting>();

			String sql="select * from meeting where meetingid="+meetingid;
			try {
				pre = con.prepareStatement(sql);
				res = pre.executeQuery();
				
				while(res.next()){
					Meeting meeting=new Meeting();
					meeting.setMeetingid(Integer.parseInt(res.getString("meetingid")));
					System.out.println(res.getString("meetingid"));

					meeting.setMeetingname(res.getString("meetingname"));
					System.out.println(res.getString("meetingname"));

					meeting.setRoomid(Integer.parseInt(res.getString("roomid")));
					meeting.setReservationistid(Integer.parseInt(res.getString("reservationistid")));
					meeting.setNumberofparticipants(res.getInt("numberofparticipants"));
					meeting.setStarttime(res.getTimestamp("starttime"));
					meeting.setEndtime(res.getTimestamp("endtime"));
					meeting.setReservationtime(res.getTimestamp("reservationtime"));
					meeting.setCanceledtime(res.getTimestamp("canceledtime"));
					meeting.setStatus(res.getString("status"));
					meeting.setDescription(res.getString("description"));	
				
					list.add(meeting);
				}
				System.out.println(list);

				System.out.println("查看会议MeetingDao");
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
		
		public boolean CancelMeeting(int meetingid,Timestamp canceledtime) throws SQLException{
			con = DBConnection.getConnection();
			String sql="UPDATE meeting SET canceledtime = '"+ canceledtime +"' , status = 1 WHERE meetingid = '"+ meetingid +"' ";
			try {
				pre=con.prepareStatement(sql);
				//pre.setInt(1, meeting.getMeetingid());
				// pre.setString(1, meeting.getMeetingname());
				// pre.setInt(2, meeting.getRoomid());
				// pre.setInt(3, meeting.getReservationistid());
				// pre.setInt(4, meeting.getNumberofparticipants());
				// pre.setTimestamp(5, meeting.getStarttime());
				// pre.setTimestamp(6, meeting.getEndtime());
				// pre.setTimestamp(7, meeting.getReservationtime());
				// pre.setTimestamp(8, meeting.getCanceledtime());
				// pre.setString(9, meeting.getDescription());
				// pre.setString(10, meeting.getStatus());

				int i=pre.executeUpdate();
				if(i>0){
					System.out.println("取消一个会议成功MDao");
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

	
		public boolean ifRoomEmptyByTime(String starttime,
				String endtime,int id,String date) {
			boolean flag=false;
			con = DBConnection.getConnection();
			List<Meetingroom> list = new ArrayList<Meetingroom>();
			List<Integer>list2= new ArrayList<Integer>();
//			ArrayList list2 = new ArrayList();
			
			starttime=date+" "+starttime;
			endtime=date+" "+endtime;
			System.out.println(starttime);
			System.out.println(endtime);
			
			String sql ="select starttime,endtime from meeting where roomid="+id;
			try {
				pre = con.prepareStatement(sql);
				res = pre.executeQuery();
				
				while (res.next()) {
//					Meetingroom meetingroom = new Meetingroom();
					String start = res.getString("starttime");
					String end=res.getString("endtime");
					if((CompareTime.compare_date(start, starttime)&&!CompareTime.compare_date(end, endtime))||
							(!CompareTime.compare_date(start, starttime)&&CompareTime.compare_date(end, starttime))||
							(!CompareTime.compare_date(start, endtime)&&CompareTime.compare_date(end, endtime))||
							(!CompareTime.compare_date(start, starttime)&&CompareTime.compare_date(end, endtime)))
							{
						flag=true;
						break;
					}
					else{
						flag=false;
					}
				}
				//System.out.println(flag);
				return flag;
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
			return flag;
		}
		
		
		
		public List<Meeting> RoomInfoByDay(String date,int id) {
			List<Meeting> meetings=new ArrayList<Meeting>();
			con = DBConnection.getConnection();
			List<Meetingroom> list = new ArrayList<Meetingroom>();
			List<Integer>list2= new ArrayList<Integer>();
//			ArrayList list2 = new ArrayList();
			String startofday=date+" "+"00:00:00";
			String endofday=date+" "+"23:59:59";
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			String nowTime = now.toString();
			String sql ="select * from meeting where roomid="+id
			 +" and starttime>'"+startofday+"' and endtime<'"+endofday+"'";
			
			
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
					meetings.add(meeting);	
					System.out.println(meeting.toString());
				}
				//System.out.println(flag);
				return meetings;
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
		
		
		public List<Meeting> AllRoomInfoByDay(String date) {
			List<Meeting> meetings=new ArrayList<Meeting>();
			con = DBConnection.getConnection();
			List<Meetingroom> list = new ArrayList<Meetingroom>();
			List<Integer>list2= new ArrayList<Integer>();
//			ArrayList list2 = new ArrayList();
			String startofday=date+" "+"00:00:00";
			String endofday=date+" "+"23:59:59";
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			String nowTime = now.toString();
		    System.out.println(startofday);
		    System.out.println(endofday);
			String sql ="select * from meeting where"
			 +"starttime>'"+startofday+"' and endtime<'"+endofday+"'";
			
			
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
					meetings.add(meeting);	
					System.out.println(meeting.toString());
				}
				//System.out.println(flag);
				return meetings;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetingDao md=new MeetingDao();
		md.selectOneMeeting(2);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}

	}
	
	public List<Meeting> getReserveidByRoomid(int id) {
		con = DBConnection.getConnection();
		List<Meeting> list = new ArrayList<Meeting>();
		//List<Integer>list2= new ArrayList<Integer>();	
		String sql ="select * from meeting where roomid="+id;
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
				System.out.println(meeting.toString());
				}
			return list;
		}	
		 catch (SQLException e) {
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
		return list;
	}
	
	
	

}
