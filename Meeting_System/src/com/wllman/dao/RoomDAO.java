package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wllman.util.DBConnection;
import com.wllman.vo.Employee;

public class RoomDAO {

	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	public Employee login(String username, String password) {
		con = DBConnection.getConnection();
		String sql = "select * from employee where username=? and password=?";	
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1,username);
			pre.setString(2, password);
			
			res = pre.executeQuery();
			
			while (res.next()) {
				Employee employee = new Employee();
				employee.setEmployeeid(res.getInt("employeeid"));
				employee.setUsername(res.getString("username"));
				employee.setPassword(res.getString("password"));
				employee.setEmployeename(res.getString("employeename"));
				employee.setDepartmentid(res.getInt("departmentid"));
				employee.setEmail(res.getString("email"));
				employee.setPhone(res.getString("phone"));
				employee.setRole(res.getString("role"));
				employee.setStatus(res.getString("status"));
				
				return employee;
			}
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
