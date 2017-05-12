package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.MeetingDao;
import com.wllman.dao.MeetingParticipantsDao;
import com.wllman.vo.Meeting;
import com.wllman.vo.MeetingParticipants;

/**
 * Servlet implementation class OrderMeetingServlet
 */
public class OrderMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String[]  employeeid= request.getParameterValues("XXX");
		String meetingname=request.getParameter("meetingname");
		String description=request.getParameter("description");
		
		HttpSession session=request.getSession();
		int roomid=(Integer) session.getAttribute("roomid");
		//int meetingid=(Integer) session.getAttribute("meetingid");
	//	System.out.println(meetingid);

		int reservationistid=(Integer) session.getAttribute("employeeid");
		Timestamp starttime=(Timestamp) session.getAttribute("starttime");
		Timestamp endtime=(Timestamp) session.getAttribute("endtime");
		Timestamp reservationtime=new Timestamp(System.currentTimeMillis());

		MeetingDao dao1 = new MeetingDao();
		MeetingParticipantsDao dao2=new MeetingParticipantsDao();
		
		System.out.println("Meetingname:" + meetingname);
		System.out.println("Roomid:" + roomid);
		System.out.println("NumOfPar:" + employeeid.length);
		System.out.println("Starttime:" + starttime);
		System.out.println("Endtime:" + endtime);
		System.out.println("Restime:" + reservationtime);
		System.out.println("Des:" + description);
		Meeting meeting=new Meeting(meetingname,roomid,reservationistid,employeeid.length,starttime,endtime,reservationtime,null,description,"0");
		
		
		boolean flag1;
		try {
			flag1 = dao1.OrderMeeting(meeting);
			System.out.println(flag1);
			if(flag1){
				request.setAttribute("msg", "添加一个会议成功OrderMeetingServlet");
				System.out.println(flag1);
				int role = (Integer)session.getAttribute("role");
				if (role == 1) {
					request.getRequestDispatcher("index.jsp").forward(request, response);	
				}else{
					request.getRequestDispatcher("userindex.jsp").forward(request, response);	
				}
				
				System.out.println(flag1);
				
				
				for(int i=0;i<employeeid.length;i++){
					MeetingParticipants meetingparticipants=new MeetingParticipants(dao1.getMeetingNum(),Integer.parseInt(employeeid[i]));
					boolean flag2 =dao2.updateMeetingParticipants(meetingparticipants);
					System.out.println(flag2+"flag2");
				}
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
