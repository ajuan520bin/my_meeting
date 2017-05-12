package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Signin;

public class SigninDao {
	
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	public boolean EmployeeSignin (Signin signin){
		con = DBConnection.getConnection();

		String sql="insert into signin" +"(employeeid,starttime,ip)" +" values(?,?,?)";
		System.out.println("insert");
		try {
			pre=con.prepareStatement(sql);
			pre.setInt(1, signin.getEmployeeid());
			pre.setTimestamp(2,signin.getStarttime());
			pre.setString(3, signin.getIp());

			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("qiandaochenggong");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				con.close();
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;	
	}
	public List<Signin> selectsiSignins(int employeeid){
		con = DBConnection.getConnection();
		List<Signin> list = new ArrayList<Signin>();
		
		String sql="select * from signin where employeeid = " + employeeid;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			System.out.println("select");

			while(res.next()){
				Signin signin = new Signin();
				signin.setEmployeeid(res.getInt("employeeid"));
				signin.setStarttime(res.getTimestamp("starttime"));
				signin.setIp(res.getString("ip"));
				System.out.println("ahhhhhhhhhhh");
				list.add(signin);
				
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

}
