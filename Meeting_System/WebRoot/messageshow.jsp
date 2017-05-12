<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.wllman.util.*,com.wllman.dao.*,com.wllman.vo.*,java.util.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
	
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/amcharts.js"></script>
<script src="js/serial.js"></script>
<script src="js/light.js"></script>
<script src="js/radar.js"></script>
<link href="css/barChart.css" rel='stylesheet' type='text/css' />
<link href="css/fabochart.css" rel='stylesheet' type='text/css' />
<!--clock init-->
<script src="js/css3clock.js"></script>
<!--Easy Pie Chart-->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<!--//skycons-icons-->
<style type="text/css">
.btn{
  
     background: #00C6D7; 
     color:#fff;
     width:80px;
    font-size:12px;
    
}
</style>
<script type="text/javascript">
function del(id){
   if(confirm("确认删除吗？")){
       alert("deleteMessage?id="+id)
       location.href="deleteMessage?id="+id;
   }
}

</script>
</head>
<%
   MessageDao md=new MessageDao();
   int id=(Integer)session.getAttribute("employeeid");
   List<Message> ms=md.selectMessageByAcceptid(id);
 %>
<body>

				
	         <table class="table">
						
							<tr class="success">
								<td><b>发送人</b></td>
								<td><b>主题</b></td>
								<td><b>状态</b></td>
								<td><b>查看详情</b></td>
								<td><b>删除</b></td>
							</tr>
							
							
<%for(int k=0;k<ms.size();k++){ %>

                               <% 
                                 String tt="warning";
								String state="已读";  
								if(ms.get(k).getStatus()==0) {
								state="未读";
								tt="info";
								}
								 %>
							
								<tr class=<%=tt %>>
									<td><b>管理员</b></td>
									<td><%=ms.get(k).getSubject()%></td>
								
									<td><%=state%></td>
									<td><input type="button" value="查看" 
									class="btn"
									onclick="location.href='viewMessage.jsp?id=<%=ms.get(k).getMesid()%>' "/></td>
									
									<td><input type="button" value="删除" 
									class="btn"
									onclick="del(<%=ms.get(k).getMesid()%>) "/></td>
									
									
								</tr>
							<%
							} %>

						</table>
						</div>
</body>
</html>