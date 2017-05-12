package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import com.wllman.dao.EmployeeDao;
import com.wllman.vo.Employee;

/**
 * Servlet implementation class ApprovalEmployeeServlet
 */
public class ApprovalEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovalEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		EmployeeDao dao=new EmployeeDao();
		List<Employee> list=dao.selectEmployeesByNameStatus("", "", "0");
		request.setAttribute("list", list);
		for(int i = 0;i < list.size();i++ ) {
			System.out.print(((Employee)list.get(i)).getEmployeename());
			System.out.print("\n");
			
		}
		HttpSession session=request.getSession();
		int role = (Integer)session.getAttribute("role");
		//if (role == 1) {
			request.getRequestDispatcher("approval.jsp").forward(request, response);
		//}else{
			request.getRequestDispatcher("userapproval.jsp").forward(request, response);
		//}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
		//String code=request.getParameter("code");
		

//		if(code!=null&code.equals("approve")){
//			request.getRequestDispatcher("approval.jsp").forward(request, response);
//		}
		
	}
	

}
