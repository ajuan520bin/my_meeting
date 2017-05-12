package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.MeetingRoomDao;
import com.wllman.vo.Meetingroom;

/**
 * Servlet implementation class AddMeetingRoomSerlvet
 */
public class AddMeetingRoomSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMeetingRoomSerlvet() {
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
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		int  roomnum=Integer.parseInt(request.getParameter("roomnum"));
		String roomname=request.getParameter("roomname");
		int capacity=Integer.parseInt(request.getParameter("capacity"));
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		
		MeetingRoomDao dao=new MeetingRoomDao();
		Meetingroom meetingroom=new Meetingroom(roomnum,roomname,capacity,status,description);
		
		try {
			boolean flag=dao.addRoom(meetingroom);
			System.out.println(flag);
			if(flag){
				request.setAttribute("msg", "娣诲姞涓�釜浼氳瀹ゆ垚鍔烝ddMeetingRoomServlet");
				System.out.println(flag);
				int role = (Integer)session.getAttribute("role");
				if (role == 1) {
					request.getRequestDispatcher("addmeetingroom.jsp").forward(request, response);	
				}else{
					request.getRequestDispatcher("useraddmeetingroom..jsp").forward(request, response);	
				}
				
				System.out.println(flag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
