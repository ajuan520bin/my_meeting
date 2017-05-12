package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wllman.dao.DepartmentDao;
import com.wllman.vo.Department;

/**
 * Servlet implementation class AddDepartmentServlet
 */
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 显示部门
		DepartmentDao dao = new DepartmentDao();
		List<Department> list = dao.selectDepartments();
		request.setAttribute("list", list);
		System.out.println("显示部门1111");

		// 添加部门
		request.setCharacterEncoding("utf-8");
		String departmentname = request.getParameter("departmentname");

		if (departmentname != null && departmentname != "") {
			DepartmentDao dao1 = new DepartmentDao();
			Department department = new Department(departmentname);

			System.out.println(departmentname + "AddDS");

			boolean flag;
			try {

				flag = dao1.addDepartment(department);
				System.out.println(flag + "flag AddDS");

				if (flag) {
					request.setAttribute("msg", "添加一个部门成功 ");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		DepartmentDao dao1 = new DepartmentDao();
		List<Department> list2 = dao1.selectDepartments();
		request.setAttribute("list", list2);
		System.out.println("显示部门2");

		request.getRequestDispatcher("adddepartment.jsp").forward(request,
				response);
	}

}
