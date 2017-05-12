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
 * Servlet implementation class JumpToOrderServlet
 */
public class JumpToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JumpToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int roomid=Integer.parseInt(request.getParameter("roomid"));
		session.setAttribute("roomid", roomid);
		
		EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.selectAllEmployee();
		System.out.println("************");
		System.out.println(list);
		
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
	  	if (role == 1) {
	  		request.getRequestDispatcher("ordermeetingname.jsp").forward(request, response);
	  	}else{
	  		request.getRequestDispatcher("userordermeetingname.jsp").forward(request, response);
	  	}
		
		
		
	}

}
