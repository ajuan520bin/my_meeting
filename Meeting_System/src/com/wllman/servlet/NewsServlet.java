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
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
		System.out.println("22224454322");
		MyMeetingDao dao = new MyMeetingDao();
		//dao.selectAllMeetingsByParId(participantsid);
		List<Meeting> sevendaylist =dao.selectAllNewMeetings(participantsid);
		request.setAttribute("sevendaylist", sevendaylist);
		for(int i = 0;i < sevendaylist.size();i++ ) {
			System.out.print(((Meeting)sevendaylist.get(i)).getMeetingid());
			System.out.print(((Meeting)sevendaylist.get(i)).getMeetingname());
			System.out.print(((Meeting)sevendaylist.get(i)).getRoomid());
			System.out.print("\n");
			
		}
		
	
		List<Meeting> cancellist=dao.selectAllCanceledMeetings(participantsid);
		request.setAttribute("cancellist", cancellist);
		for(int i = 0;i < cancellist.size();i++ ) {
			System.out.print(((Meeting)cancellist.get(i)).getMeetingid());
			System.out.print(((Meeting)cancellist.get(i)).getMeetingname());
			System.out.print(((Meeting)cancellist.get(i)).getRoomid());
			System.out.print("\n");
			
		}
		int role = (Integer)session.getAttribute("role");
		//int role=1;
		if (role == 1) {
		request.getRequestDispatcher("news.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("usernews.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
