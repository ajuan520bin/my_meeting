<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@page import="java.util.*"%>  
<%@page import="javax.mail.*"%>  
<%@page import="javax.mail.internet.*"%>  
<%@page import="javax.activation.*"%> 
 
<%  
String recipient="000@qq.com";  
String sender="aaa@sina.com";  
String subject="hello";  
String text="hello, this is my first jsp mail!";  
     
String host="smtp.sina.com.cn";  
String username="aaa@sina.com";  
String password="000";  
    
   Properties props=new Properties();  
   
   props.put("mail.smtp.host",host);  
   props.put("mail.smtp.port","25");  
   props.put("mail.smtp.auth","true");  
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
   
    Session mailsession=Session.getDefaultInstance(props);  
  boolean sessionDebug=false;  
   mailsession.setDebug(sessionDebug);  
  
  MimeMessage message=new MimeMessage(mailsession);  
    
   message.setFrom(new InternetAddress(sender));  
   message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));  
  message.setSubject(subject, "UTF-8");  
   message.setText(text);  
  message.saveChanges();  
    
   Transport transport=mailsession.getTransport("smtp");  
   transport.connect(host, username, password);  
   transport.sendMessage(message, message.getAllRecipients());  
   transport.close();      
 
%>  

<!DOCTYPE html>  
<html>  
  <head>  
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
       <title>sendmail</title>  
   </head>  
  <body>  
     <h1>邮件已经发送！</h1>  
 </body>  
</html>  
