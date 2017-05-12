package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wllman.dao.DepartmentDao;

/**
 * Servlet implementation class DeleteDepartmentServlet
 */
public class DeleteDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		System.out.println("DeleteSer");
		int  departmentid=Integer.parseInt(request.getParameter("departmentid"));
		
		System.out.println(departmentid+"departmentid");
		DepartmentDao dao=new DepartmentDao();
		try {
			int flag=dao.delete(departmentid);
			if(flag>0){
				System.out.println("删除部门成功DeleteDSer");
				//request.setAttribute("msg", "删除成功");
				request.getRequestDispatcher("AddDepartmentServlet").forward(request, response);
			}else{
				System.out.println("删除部门失败DeleteDSer");
				//request.setAttribute("msg", "删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
