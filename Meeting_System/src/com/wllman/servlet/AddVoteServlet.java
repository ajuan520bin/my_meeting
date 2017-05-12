package com.wllman.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.VoteDao;

/**
 * Servlet implementation class AddVoteServlet
 */
public class AddVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVoteServlet() {
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

		request.setCharacterEncoding("utf-8");
		
//		String choicename = request.getParameter("QWERT");
//		System.out.println("Choicename : "+choicename);
		
		String[]  choicename = request.getParameterValues("XXX");
 		for(int i=0;i<choicename.length;i++){
			System.out.println(choicename[i]);
		}


		String votename=request.getParameter("votename");
		String description=request.getParameter("description");
		
		HttpSession session=request.getSession();
		int promoterid=(Integer) session.getAttribute("employeeid");
		Timestamp starttime=Timestamp.valueOf(request.getParameter("starttime"));
		Timestamp endtime=Timestamp.valueOf(request.getParameter("endtime"));
		VoteDao dao = new VoteDao();

		try {
			boolean flag1 = dao.addVote(votename,description,promoterid,starttime,endtime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<choicename.length;i++){
			int voteid = dao.getVoteNum();
			boolean flag2;
			try {
				System.out.println("voteid:"+voteid);
				System.out.println("choiceid:" + (i+1));
				System.out.println("choicename:"+choicename[i]);
				flag2 = dao.addVoteChoice(voteid,i+1,choicename[i]);
				System.out.println(flag2+"flag2");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		// int voteid = Integer.valueOf(request.getParameter("voteid"));
		// List<VoteChoice> list = dao.showVoteChoice(voteid);

		// request.setAttribute("list", list);
		request.getRequestDispatcher("ShowVoteServlet").forward(request, response);
	}

}
