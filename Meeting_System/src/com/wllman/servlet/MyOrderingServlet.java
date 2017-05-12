package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wllman.dao.MeetingDao;
import com.wllman.vo.Meeting;

/**
 * Servlet implementation class MyOrderingServlet
 */
public class MyOrderingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderingServlet() {
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
		int reservationistid=(Integer) session.getAttribute("employeeid");
		MeetingDao dao = new MeetingDao();
		//dao.selectAllMeetingsByReserId(reservationistid);
		List<Meeting> list =dao.selectAllMeetingsByReserId(reservationistid);
		request.setAttribute("list", list);
		System.out.println(reservationistid);
		for(int i = 0;i < list.size();i++ ) {
			System.out.print(((Meeting)list.get(i)).getMeetingid());
			System.out.print(((Meeting)list.get(i)).getMeetingname());
			System.out.print(((Meeting)list.get(i)).getNumberofparticipants());
			System.out.print(((Meeting)list.get(i)).getReservationistid());
			System.out.print(((Meeting)list.get(i)).getRoomid());
			System.out.print("\n");
			
		}
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			request.getRequestDispatcher("myordering.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("usermyordering.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
