package com.wllman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wllman.util.DBConnection;
import com.wllman.vo.Department;

public class DepartmentDao {
	
	PreparedStatement pre = null;
	ResultSet res = null;
	Connection con = null;
	
	public List<Department> selectDepartments(){
		con = DBConnection.getConnection();
		List<Department> list = new ArrayList<Department>();
		
		String sql="select * from department ";
		try {
			pre = con.prepareStatement(sql);
			res = pre.executeQuery();
			System.out.println("select");

			while(res.next()){
				Department department=new Department();
				department.setDepartmentid(Integer.parseInt(res.getString("departmentid")));
				department.setDepartmentname(res.getString("departmentname"));
				
				list.add(department);
			//	System.out.println(res.getString("departmentname"));
			}
//			for(int i = 0;i<list.size();i++) {
//				System.out.println(((Department)list.get(i)).getDepartmentname());
//			}
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
	
	public boolean addDepartment (Department department) throws SQLException{
		con = DBConnection.getConnection();

		String sql="insert into department" +"(departmentname)" +" values(?)";
		System.out.println("insert");
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1, department.getDepartmentname());

			int i=pre.executeUpdate();
			if(i>0){
				System.out.println("添加一个部门成功Dao");
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
	//删除部门
		public int delete(int departmentid) throws SQLException{
			con = DBConnection.getConnection();
			String sql="delete from department where departmentid=?";

			try {
				pre=con.prepareStatement(sql);
				pre.setInt(1, departmentid);
				int i=pre.executeUpdate();
				if(i>0){
					System.out.println("删除部门成功DepartmentDao");
					return i;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con.close();
				pre.close();
			}
			return 0;	
		}
}
