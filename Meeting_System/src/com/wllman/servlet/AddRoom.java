package com.wllman.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.MeetingRoomDao;
import com.wllman.vo.Meetingroom;

public class AddRoom extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddRoom() {
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
		Meetingroom mr=new Meetingroom(); 
		
		String numstr=request.getParameter("num");
		numstr = new String(numstr.getBytes("ISO8859_1"), "UTF-8");
		String name=request.getParameter("name");
		name = new String(name.getBytes("ISO8859_1"), "UTF-8");
		String cstr=request.getParameter("capacity");
		cstr = new String(cstr.getBytes("ISO8859_1"), "UTF-8");
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		description = new String(description.getBytes("ISO8859_1"), "UTF-8");
		int capacity=Integer.parseInt(cstr);
		int num=Integer.parseInt(numstr);
	
		
		mr.setRoomname(name);
		mr.setCapacity(capacity);
		mr.setStatus(status);
		mr.setDescription(description);
		mr.setRoomnum(num);
		System.out.println(num);
		
		MeetingRoomDao mrd=new MeetingRoomDao();
		try {
			mrd.addRoom(mr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
