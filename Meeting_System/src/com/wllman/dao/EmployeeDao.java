package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.wllman.util.DBConnection;
import com.wllman.vo.Employee;


public class EmployeeDao {

	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;

	public List<Employee> selectEmployeesByNameStatus(String employeename,
			String username, String status) {
		con = DBConnection.getConnection();

		List<Employee> list = new ArrayList<Employee>();

		String usernamesql, employeenamesql, statussql;

		if (employeename == null || employeename.equals("")) {
			employeenamesql = "";
		} else {
			employeenamesql = " and employeename='" + employeename + "'";
		}

		if (username == null || username.equals("")) {
			usernamesql = "";
		} else {
			usernamesql = " and username='" + username + "'";
		}

		if (status == null || status.equals("") || status.equals("3")) {
			statussql = "";
		} else {
			statussql = " and status='" + status + "'";
		}

		String sql = "select * from Employee where role='2' " + usernamesql
				+ employeenamesql + statussql;
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			while (res.next()) {
				Employee employee = new Employee();
				employee.setEmployeeid(res.getInt("employeeid"));
				employee.setEmployeename(res.getString("employeename"));
				employee.setUsername(res.getString("username"));
				employee.setPhone(res.getString("phone"));
				employee.setEmail(res.getString("email"));
				employee.setStatus(res.getString("status"));
				employee.setDepartmentid(res.getInt("departmentid"));
				employee.setPassword(res.getString("password"));
				employee.setRole(res.getString("role"));
				list.add(employee);
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

	
	public List<Employee> selectAllEmployee(){
		con = DBConnection.getConnection();
		 List<Employee> list=new ArrayList<Employee>();
		
		 try {
			
			String sql="select * from employee where (role='2' or role = '1') and status='1'";
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			System.out.print("?????????????");

			while(res.next()){
				Employee employee=new Employee();
				employee.setEmployeeid(res.getInt("employeeid"));
				employee.setEmployeename(res.getString("employeename"));
				employee.setUsername(res.getString("username"));
				employee.setPhone(res.getString("phone"));
				employee.setEmail(res.getString("email"));
				employee.setStatus(res.getString("status"));
				employee.setDepartmentid(res.getInt("departmentid"));
				employee.setPassword(res.getString("password"));
				employee.setRole(res.getString("role"));
				list.add(employee);
			}
			for(int i = 0;i < list.size();i++ ) {
				System.out.print(((Employee)list.get(i)).getEmployeename());
				System.out.print("\n");
			}
			return list;
		 } catch (SQLException e) {
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
	
	public void updateStatus(int employeeid,String status){
		con = DBConnection.getConnection();
		System.out.println(employeeid + "    " + status);
		  String sql="update employee set status='"+status+"'where employeeid="+employeeid;
		  try {		
			  pre = con.prepareStatement(sql);
			pre.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	  
	  }
}