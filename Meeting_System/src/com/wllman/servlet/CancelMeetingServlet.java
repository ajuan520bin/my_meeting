package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wllman.dao.MeetingDao;

/**
 * Servlet implementation class CancelMeetingServlet
 */
public class CancelMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelMeetingServlet() {
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
				// String[]  employeeid= request.getParameterValues("XXX");
				// String meetingname=request.getParameter("meetingname");
				int meetingid = Integer.valueOf(request.getParameter("meetingid"));
				System.out.println("MeetingID : " + meetingid);

				// HttpSession session=request.getSession();

				// int roomid=(Integer) session.getAttribute("roomid");
				//int meetingid=(Integer) session.getAttribute("meetingid");
				//System.out.println(meetingid);

				// int reservationistid=(Integer) session.getAttribute("employeeid");
				// Timestamp starttime=(Timestamp) session.getAttribute("starttime");
				// Timestamp endtime=(Timestamp) session.getAttribute("endtime");
				Timestamp canceledtime=new Timestamp(System.currentTimeMillis());
				System.out.println("canceledtime : " + canceledtime);

				MeetingDao dao1 = new MeetingDao();
				// MeetingParticipantsDao dao2=new MeetingParticipantsDao();
				
				
				// Meeting meeting=new Meeting(meetingname,roomid,reservationistid,employeeid.length,
				// 		starttime,endtime,reservationtime,null,description,"0");
				
				
				boolean flag1;
				try {
					flag1 = dao1.CancelMeeting(meetingid,canceledtime);
					System.out.println(flag1);
					if(true){
						// request.setAttribute("msg", "娣诲姞涓€涓細璁垚鍔烵rderMeetingServlet");
						System.out.println(flag1);
						request.getRequestDispatcher("MyOrderingServlet").forward(request, response);	
						System.out.println(flag1);
					}	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		

	}

}