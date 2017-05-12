package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.VoteDao;
import com.wllman.vo.VoteChoice;

/**
 * Servlet implementation class ShowChoiceServlet
 */
public class ShowChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowChoiceServlet() {
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
		VoteDao dao = new VoteDao();
		int voteid = Integer.valueOf(request.getParameter("voteid"));
		List<VoteChoice> list;
		try {
			list = dao.showVoteChoice(voteid);
			request.setAttribute("list", list);
			int role = (Integer)session.getAttribute("role");
			if (role == 1) {
				request.getRequestDispatcher("showchoice.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("usershowchoice.jsp").forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		request.setAttribute("list", list);
//		request.getRequestDispatcher("showchoice.jsp").forward(request, response);
	}

}
