package com.wllman.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.SigninDao;
import com.wllman.vo.Signin;

/**
 * Servlet implementation class SigninServlet
 */
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
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

	    int employeeid=(Integer)session.getAttribute("employeeid");
	    Timestamp starttime=new Timestamp(System.currentTimeMillis());
	    InetAddress iAddress =null;
	    String ip =iAddress.getLocalHost().getHostAddress();
	    
	    SigninDao dao=new SigninDao();
		
		List<Signin>list =dao.selectsiSignins(employeeid);
		request.setAttribute("list", list);
		
		Signin signin=new Signin(employeeid,starttime,ip);
		System.out.println("12345678");
		boolean flag=dao.EmployeeSignin(signin);
		System.out.println("12345678？？？");
		System.out.println(flag);
		if(flag){
			request.setAttribute("msg", "qiandao");
			System.out.println(flag);
			int role = (Integer)session.getAttribute("role");
			if (role == 1) {
				request.getRequestDispatcher("signin.jsp").forward(request, response);	
			}else{
				request.getRequestDispatcher("usersignin.jsp").forward(request, response);	
			}
			
			System.out.println(flag);
		}
	}

}
