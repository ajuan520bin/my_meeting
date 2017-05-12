package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wllman.dao.MyMeetingDao;
import com.wllman.vo.Meeting;

/**
 * Servlet implementation class MyMeetingServlet
 */
public class MyMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMeetingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int participantsid=(Integer) session.getAttribute("employeeid");
		MyMeetingDao dao = new MyMeetingDao();
		//dao.selectAllMeetingsByParId(participantsid);
		List<Meeting> list =dao.selectAllMeetingsByParId(participantsid);
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		//if (role == 1) {
		request.getRequestDispatcher("mymeeting.jsp").forward(request, response);
		//}else {
			request.getRequestDispatcher("usermymeeting.jsp").forward(request, response);
		//}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
