<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript"
	src="JavaScript/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<form action="AddVoteServlet" method="post">

		添加投票：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="votename"><br>
		添加投票：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			type="text" name="description"><br>

	Starttime:<input class="Wdate" type="text" id="starttime"
					name="starttime"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					<br>
	Endtime:<input class="Wdate" type="text" id="endtime"
					name="endtime"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					<br>
			<input type=button	onclick="document.body.insertAdjacentHTML('beforeEnd','<input type=text name='XXX' > ')"value=添加投票选项>
		
		<script>var i=1</script>
<input type=button onclick="document.body.insertAdjacentHTML('beforeEnd','<input type=text name='+i+' > ')" value=添加>
		
		<input type="submit" value="添加"> 
		<input
			type="reset" value="重置">
	</form>


</body>
</html>