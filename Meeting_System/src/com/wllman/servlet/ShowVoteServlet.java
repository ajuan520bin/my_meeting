package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.VoteDao;
import com.wllman.vo.Vote;

/**
 * Servlet implementation class ShowVoteServlet
 */
public class ShowVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowVoteServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		VoteDao dao = new VoteDao();
		List<Vote> list = dao.selectVotes();

		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			request.getRequestDispatcher("showvote.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("usershowvote.jsp").forward(request, response);
		}
		
	}

}
