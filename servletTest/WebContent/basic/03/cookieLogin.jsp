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
	String cookieUserId = "";
	String chk = "";
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie cookie : cookies){
			if("ID".equals(cookie.getName())){
				cookieUserId = cookie.getValue();
				chk = "checked";
				
			}
		}
		
	}

%>
	<h2>cookie LoginPage</h2>
	<form method = "post" action="/servletTest/CookieLoginServlet.do">
		<label>ID : </label><input type = "text" value = "<%=cookieUserId%>" name = "userid" placeholder = "ID를 입력하세요"><br>
		<label>PASS : </label><input type = "password" name = "pass" placeholder = "PassWord를 입력하세요"><br>
		<input type="checkbox" name="chkid" <%=chk%>>  id기억하기<br>
		<input type = "submit" value = "Login">
	</form>
</body>
</html>