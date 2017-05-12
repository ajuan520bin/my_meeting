package com.wllman.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig config;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	 public void doFilter(ServletRequest arg0, ServletResponse arg1,
	            FilterChain arg2) throws IOException, ServletException {
	        // TODO Auto-generated method stub
	        HttpServletRequest req = (HttpServletRequest)arg0;
	        HttpServletResponse resp =(HttpServletResponse) arg1;
	        HttpSession session = req.getSession();
	        PrintWriter out=resp.getWriter();
	        resp.setCharacterEncoding("gbk");
	           // 获得用户请求的URI
	        String path = req.getRequestURI();
	        // 从session取得已经登录验证的凭证 我这里的demo用的是password来作为登录凭证
	        String password = (String) session.getAttribute("password");
	        // login.jsp页面无需过滤(根据自己项目的要求来)
	        if((path.indexOf("/user/login")>-1)
	        		||(path.indexOf("/login.jsp")>-1)
	        		||(path.indexOf("/queryTicket.jsp")>-1) 
	        		||(path.indexOf("register.jsp")>-1)
	        		||(path.endsWith("My12306"))
	        		||(path.endsWith("My12306/"))
	        		||(path.indexOf("index.jsp")>-1)
	        		
	        		
	        		){
	        	System.out.println(path);
	        	arg2.doFilter(req, resp);
	            return;
	        }
	        else{
	        	if(session.getAttribute("user") == null){
					out.print("<script>alert('请先登录!');location.href='login.jsp'</script>");
					
	        	}
	        	else{
	        		arg2.doFilter(req, resp);
	        		
	        	}
	        }
	    }
	    public void init(FilterConfig arg0) throws ServletException {
	        // TODO Auto-generated method stub
	    }
	
}
