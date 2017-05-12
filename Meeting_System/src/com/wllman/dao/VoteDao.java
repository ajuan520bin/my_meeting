package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Vote;
import com.wllman.vo.VoteChoice;

public class VoteDao {
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	public int getVoteNum(){
		con = DBConnection.getConnection();
		String sql="select count(voteid) from vote";
		try {
			pre=con.prepareStatement(sql);
			res=pre.executeQuery();
			while (res.next()){
				System.out.println(res.getInt("count(voteid)"));

				return res.getInt("count(voteid)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public List<Vote> selectVotes() {
		con = DBConnection.getConnection();
		List<Vote> list = new ArrayList<Vote>();
		
		String sql="select * from vote ";
		
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			while(res.next()){
				Vote vote=new Vote();
				vote.setVoteid(res.getInt("voteid"));
				vote.setVotename(res.getString("votename"));
				vote.setStarttime(res.getTimestamp("starttime"));
				vote.setEndtime(res.getTimestamp("endtime"));
				vote.setDescription(res.getString("description"));
				vote.setPromoterid(res.getInt("promoterid"));	
				
				list.add(vote);
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
	//添加一个投票,添加成功返回true；状态可用为1，不可用为0
	public boolean addVote (String votename,String description,int promoterid,Timestamp starttime,Timestamp endtime) throws SQLException{
		con = DBConnection.getConnection();

		String sql="insert into vote" +
					"(votename,description,promoterid,starttime,endtime)" +" values(?,?,?,?,?)";
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1,votename);
			pre.setString(2, description);
			pre.setInt(3,promoterid);
			pre.setTimestamp(4, starttime);
			pre.setTimestamp(5, endtime);
				
			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("添加一个投票成功VoteDao");
				return true;
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pre.close();
				//res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return false;
			
	}

	public List<VoteChoice> showVoteChoice(int voteid) throws SQLException{
		con = DBConnection.getConnection();
		List<VoteChoice> list = new ArrayList<VoteChoice>();

		String sql="select * from votechoice where voteid = "+ voteid;

		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			
			while(res.next()){
				VoteChoice votechoice=new VoteChoice();

				votechoice.setVoteid(res.getInt("voteid"));
				votechoice.setChoiceid(res.getInt("choiceid"));
				votechoice.setChoicename(res.getString("choicename"));
				votechoice.setCount(res.getInt("count"));
				list.add(votechoice);
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
	
	public boolean addVoteChoice (int voteid,int choiceid,String choicename) throws SQLException{
		con = DBConnection.getConnection();

		String sql="insert into votechoice" +
					" (voteid,choiceid,choicename) " +" values(?,?,?)";
		try {
			pre=con.prepareStatement(sql);
			pre.setInt(1,voteid);
			pre.setInt(2, choiceid);
			pre.setString(3,choicename);

				
			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("添加一个投票选项成功VoteDao");
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

	public boolean doVote (int voteid,int choiceid,int count) throws SQLException{
		con = DBConnection.getConnection();
		count++;
		String sql="update votechoice set count = "+ count +" where voteid = "+ voteid +" and choiceid = " + choiceid;
		try {
			pre=con.prepareStatement(sql);
				
			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("投票成功VoteDao");
				return true;
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pre.close();
				//res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return false;
			
	}
}
