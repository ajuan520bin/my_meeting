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
 * Servlet implementation class ShowMyMeetingDetail
 */
public class ShowMyMeetingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyMeetingDetail() {
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
		int meetingid=Integer.parseInt(request.getParameter("meetingid"));
		System.out.println(meetingid+"meetingid");
		
		MeetingDao dao=new MeetingDao();
		List<Meeting> list=dao.selectOneMeeting(meetingid);
		
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
		request.getRequestDispatcher("showmeetingdetail.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("usershowmeetingdetail.jsp").forward(request, response);
		}
	}

}
