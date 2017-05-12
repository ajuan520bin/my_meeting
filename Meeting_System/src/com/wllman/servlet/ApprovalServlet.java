package com.wllman.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wllman.dao.EmployeeDao;

/**
 * Servlet implementation class ApprovalServlet
 */
public class ApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalServlet() {
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
		int employeeid=Integer.parseInt(request.getParameter("employeeid"));
		String approval =request.getParameter("approval");
		EmployeeDao dao=new EmployeeDao();
		
		if(approval!=null&&approval.equals("1")){
			dao.updateStatus(employeeid,"1");
			request.getRequestDispatcher("ApprovalEmployeeServlet?code=approve").forward(request, response);
		}
		
		if(approval!=null&&approval.equals("0")){
			dao.updateStatus(employeeid,"2");
			request.getRequestDispatcher("ApprovalEmployeeServlet?code=approve").forward(request, response);
		}
		
	}

}
