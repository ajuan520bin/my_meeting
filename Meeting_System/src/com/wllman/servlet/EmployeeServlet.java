package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.EmployeeDao;
import com.wllman.vo.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		System.out.println("WTF");

		String employeename=request.getParameter("employeename");
		String username=request.getParameter("username");
		String status=request.getParameter("status");
		System.out.println(employeename);
		System.out.println(username);
		System.out.println(status);
		
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.selectEmployeesByNameStatus(employeename, username, status);
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			request.getRequestDispatcher("showemployees.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("usershowemployees.jsp").forward(request, response);
		}
		

		
	}

}
