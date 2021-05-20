<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	String id = (String)session.getAttribute("id");
/* 	if(id == null){
		id = "";
	}
	 */
	String state = (String)session.getAttribute("state");
	
	if(id == null){
%>
	<form method = "post" action="/servletTest/sessionLogin.do">
		<table border = "1">
			<tr>
				<td>ID :</td>
				<td>
					<input type = "text" value="<%=id %>" name = "id" placeholder="ID를 입력하세요">
				</td>
			</tr>
			<tr>
				<td>PASS :</td>
				<td>
					<input type = "text" value="" name = "pass" placeholder="PASS를 입력하세요">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type = "submit" value = "Login">
				</td>
			</tr>
		
		</table>
	</form>
	
<%}else{
%>
	<h2><%=id %>님 환영합니다</h2>
	<a href = "/servletTest/sessionLogout.do">로그아웃</a>

<%	
}
%>
	
	
	

	
</body>
</html>





















