package com.wllman.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.OrderDao;
import com.wllman.vo.Meetingroom;

/**
 * Servlet implementation class AvailableRoomServlet
 */
public class AvailableRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvailableRoomServlet() {
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
		//int participantsid=(Integer) session.getAttribute("employeeid");
		//Timestamp starttime=(Timestamp)request.getParameter("starttime");
		Timestamp starttime = Timestamp.valueOf(request.getParameter("starttime"));
		Timestamp endtime = Timestamp.valueOf(request.getParameter("endtime"));
		session.setAttribute("starttime", starttime);
		session.setAttribute("endtime", endtime);
		int capacity = Integer.valueOf(request.getParameter("capacity"));
		session.setAttribute("capacity", capacity);
		OrderDao dao = new OrderDao();
		List<Meetingroom> list = dao.selectMeetingRoomsByTime(starttime, endtime, capacity);
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		//if (role == 1) {
			request.getRequestDispatcher("showavailablemeetingroom.jsp").forward(request, response);
		//}else{
		//	request.getRequestDispatcher("usershowavailablemeetingroom.jsp").forward(request, response);
		//}
		
	}

}
