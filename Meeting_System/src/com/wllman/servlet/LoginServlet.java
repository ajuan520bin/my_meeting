package com.wllman.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.wllman.dao.LoginDao;
import com.wllman.vo.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username =request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		LoginDao dao = new LoginDao();
		Employee employee=dao.login(username, password);
		if(employee!=null){
			HttpSession session = request.getSession();
			//Employee loginedEmployee = employee.getLoginedEmployee();
			int role = Integer.valueOf(employee.getRole());
			session.setAttribute("role", role);
			session.setAttribute("employeename", employee.getEmployeename());
			session.setAttribute("employeeid", employee.getEmployeeid());
			request.setAttribute("employeename", employee.getEmployeename());
			if(role == 1) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("userindex.jsp").forward(request, response);
			}
			
			System.out.println("1");
			
			
		}else {
			request.setAttribute("msg", "用户名密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("0");
		}
	}

}
