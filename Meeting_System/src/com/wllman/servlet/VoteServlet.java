package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wllman.dao.VoteDao;

/**
 * Servlet implementation class VoteServlet
 */
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VoteDao dao = new VoteDao();
		int voteid = Integer.valueOf(request.getParameter("voteid"));
		int choiceid = Integer.valueOf(request.getParameter("choiceid"));
		int count = Integer.valueOf(request.getParameter("count"));
		try {
			boolean flag = dao.doVote(voteid,choiceid,count);
			if(flag) {
				request.getRequestDispatcher("ShowChoiceServlet").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//request.getRequestDispatcher("showchoice.jsp").forward(request, response);
	}

}
