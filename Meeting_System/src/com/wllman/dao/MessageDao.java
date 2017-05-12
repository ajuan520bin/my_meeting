package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Meetingroom;
import com.wllman.vo.Message;

public class MessageDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;

	// 根据收件人列出消息
	public List<Message> selectMessageByAcceptid(int id) {
		con = DBConnection.getConnection();
		List<Message> list = new ArrayList<Message>();

		String sql = "select * from message where acceptid=" + id;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();

			while (res.next()) {
				Message mes = new Message();
				mes.setSenderid(Integer.parseInt(res.getString("senderid")));
				mes.setAcceptid(Integer.parseInt(res.getString("acceptid")));
				mes.setMessage(res.getString("message"));
				mes.setStatus(Integer.parseInt(res.getString("status")));
				mes.setMesid(Integer.parseInt(res.getString("mesid")));
				mes.setSubject(res.getString("subject"));
				list.add(mes);
			}
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

	
	public String getMessageById(int id) {
		con = DBConnection.getConnection();
		String message="";

		String sql = "select message from message where mesid=" + id;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();

			if(res.next()){
				message=res.getString(1);
			}
			return message;
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

		return message;

	}
	
	public String changeStatus(int id) {
		con = DBConnection.getConnection();
		String message="";

		String sql = "update message set status=1 where mesid=" + id;
		try {
			pre = con.prepareStatement(sql);
			pre.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return message;

	}
	// 计算未读的消息数
	public int countUnread(int acceptid) {
		con = DBConnection.getConnection();
		int count = 0;
		String sql = "select count(*) from message where acceptid=" +acceptid+" and status=0";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			if(res.next()){
				count=res.getInt(1);
			}
			return count;

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
		return count;
	}
	
	
	public void deleteMessage(int mesid) {
		con = DBConnection.getConnection();
		List<Message> list = new ArrayList<Message>();
		int count = 0;
		String sql = "delete from message where mesid=" + mesid;
		try {
			pre = con.prepareStatement(sql);
			 pre.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 添加一个会议室,添加成功返回true；状态可用为1，不可用为0
	public boolean addMessage(Message m) throws SQLException {
		con = DBConnection.getConnection();

		String sql = "insert into message"
				+ "(senderid,acceptid,subject,message,status)"
				+ " values(?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, m.getSenderid());
			pre.setInt(2, m.getAcceptid());
			pre.setString(3, m.getSubject());
			pre.setString(4, m.getMessage());
			pre.setInt(5, m.getStatus());
			int i = pre.executeUpdate();
			if (i > 0) {
				System.out.println("添加信息成功");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
			pre.close();
		}
		return false;
	}
}
