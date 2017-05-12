package com.wllman.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wllman.dao.DepartmentDao;
import com.wllman.vo.Department;

/**
 * Servlet implementation class ShowDepartmentServlet
 */
public class ShowDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDepartmentServlet() {
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
		request.setCharacterEncoding("utf-8");
		request.setAttribute("msg", "添加一个部门成功 ");

		DepartmentDao dao=new DepartmentDao();
		
		List<Department> list = dao.selectDepartments();
//		for(int i = 0;i<list.size();i++) {
//			System.out.println(((Department)list.get(i)).getDepartmentname());
//		}

		request.setAttribute("list", list);
		int role = (Integer)session.getAttribute("role");
		if (role == 1) {
			request.getRequestDispatcher("showdepartment.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("usershowdepartment.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
