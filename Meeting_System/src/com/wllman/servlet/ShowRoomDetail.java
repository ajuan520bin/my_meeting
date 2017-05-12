package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.MeetingRoomDao;
import com.wllman.vo.Meetingroom;

/**
 * Servlet implementation class ShowRoomDetail
 */
public class ShowRoomDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int roomid=Integer.parseInt(request.getParameter("roomid"));
	//	session.setAttribute("roomid", roomid);
		
		MeetingRoomDao dao=new MeetingRoomDao();
		List<Meetingroom> list=dao.selectOneRoom(roomid);
		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
		request.getRequestDispatcher("showroomdetail.jsp").forward(request, response);	
		}else {
			request.getRequestDispatcher("usershowroomdetail.jsp").forward(request, response);
		}
	}

}
