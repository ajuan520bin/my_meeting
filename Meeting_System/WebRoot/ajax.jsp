<%@ page contentType="text/html; charset=gb2312" import="com.wllman.vo.*,com.wllman.dao.*"%>  
      
    <%  
    
    MessageDao md=new MessageDao();
    int id=(Integer)session.getAttribute("employeeid");
    int count=md.countUnread(id);
    //���������Ϣ�ĸ�ʽ���ַ���  
    response.setContentType("text/xml; charset=UTF-8");  
    response.setHeader("Cache-Control","no-cache");  
    out.println("<response>");  
      
    
    out.println("<name>"+count+"</name>");  
   
    out.println("</response>");  
   // out.close();  
%>