<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@
	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="700px" height="100px" align="center">
			<tr>
				<td>choiceid</td>
				<td>choicename</td>
				<td>count</td>
				<td>vote</td>
			</tr>
			<c:forEach items="${requestScope.list}" var="emp">
				<tr>
					<td>${emp.choiceid}</td>
					<td>${emp.choicename}</td>
					<td>${emp.count}</td>
					<td><a href="VoteServlet?voteid=${emp.voteid}&choiceid=${emp.choiceid}&count=${emp.count}">click</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>