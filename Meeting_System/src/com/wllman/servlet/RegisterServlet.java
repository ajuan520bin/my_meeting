package com.wllman.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wllman.dao.LoginDao;
import com.wllman.vo.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String employeename=request.getParameter("employeename");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String departmentid=request.getParameter("departmentid");
		//Integer integer = Integer.valueOf(departmentid);
		
		System.out.println(employeename);
		LoginDao dao=new LoginDao();
		Employee employee=new Employee(employeename, username, password, Integer.valueOf(departmentid), email, phone, "0", "2");
		if (employeename==null||employeename.equals("")||username==null||username.equals("")||password==null||password.equals("")||Integer.valueOf(departmentid)==null||Integer.valueOf(departmentid).equals("")||email==null||email.equals("")||phone==null||phone.equals("")) {
			request.setAttribute("msg", "yonghumingbuweikong");			
		}else {
			boolean flag=dao.insert(employee);
			if (flag) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
				
			}
		}
	}

}
