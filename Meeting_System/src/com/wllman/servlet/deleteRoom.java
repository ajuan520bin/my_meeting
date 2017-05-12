package com.wllman.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.MeetingDao;
import com.wllman.dao.MeetingRoomDao;
import com.wllman.dao.MessageDao;
import com.wllman.vo.Meeting;
import com.wllman.vo.Message;

public class deleteRoom extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deleteRoom() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	    HttpSession session=request.getSession();
	    String temp=request.getParameter("id");
	    int id=Integer.parseInt(temp);
	    MeetingRoomDao mr=new MeetingRoomDao();
	    try {
			mr.deleteRoom(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//通知相关人员
		 MeetingDao md=new MeetingDao();
		 List<Meeting> list=md.getReserveidByRoomid(id);
		 String subject="会议室不可用通知";
		 String meetingname="";
         String reservationtime="";
         MessageDao messageDao=new MessageDao();
		 for(int i=0;i<list.size();i++){
			 Message m=new Message();
			 m.setAcceptid(list.get(i).getReservationistid());
			 m.setSubject(subject);
			 m.setSenderid(1999);
			 m.setMessage("管理员通知：<br/>你在"+list.get(i).getReservationtime()
					 +"预订的会议室目前不能使用！<br/>请另行预约，非常抱歉！");
			 try {
				messageDao.addMessage(m);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			 
		 }
		request.getRequestDispatcher("manageRoom.jsp").forward(request, response);
	    
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
