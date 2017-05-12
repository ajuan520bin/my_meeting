package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.wllman.util.DBConnection;
import com.wllman.vo.Employee;

public class LoginDao {
	
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
	
	public boolean insert(Employee employee) {
		con = DBConnection.getConnection();
		String sql = "insert into employee(employeename,username,password,phone,email,departmentid,role,status) values(?,?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, employee.getEmployeename());
			pre.setString(2, employee.getUsername());
			pre.setString(3, employee.getPassword());
			pre.setString(4, employee.getPhone());
			pre.setString(5, employee.getEmail());
			pre.setInt(6, employee.getDepartmentid());
			pre.setString(7, employee.getRole());
			pre.setString(8, employee.getStatus());

			int i = pre.executeUpdate();
			if (i > 0) {
				System.out.println("添加成功");
				return true;

			}
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
		return false;
	}
}
