package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wllman.util.DBConnection;
import com.wllman.vo.MeetingParticipants;

public class MeetingParticipantsDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	public boolean updateMeetingParticipants(MeetingParticipants meetingparticipants) throws SQLException {
		con = DBConnection.getConnection();
		String sql="insert into meetingparticipants"+
					"(meetingid,employeeid)"
					+"values(?,?)";
		try {
			pre=con.prepareStatement(sql);
			pre.setInt(1, meetingparticipants.getMeetingid());
			pre.setInt(2, meetingparticipants.getEmployeeid());
			System.out.println(meetingparticipants.getMeetingid());
			System.out.println(meetingparticipants.getEmployeeid());

		
			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("添加一个meetingParticipants成功");
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
