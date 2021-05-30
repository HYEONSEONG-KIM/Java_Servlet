<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/MemberUpdateServlet.do">
	<table border = 1>
		<tr>
			<td>회원ID</td>
			<td>
			<input name = "mem_id" id = "id" type = "text" value = "<%=session.getAttribute("id")%>">
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input name = "mem_pass" id = "pass" type = "password"></td>
		</tr>
		
		
		<tr>
			<td>회원이름</td>
			<td><input name = "mem_name" id = "name" type = "text" value = "<%=session.getAttribute("name")%>"></td>
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td><input name = "mem_ph" id = "ph" type = "text" value = "<%=session.getAttribute("ph")%>"></td>
		</tr>
		
		<tr>
			<td>회원주소</td>
			<td><input name = "mem_addr" id = "addr" type = "text" value = "<%=session.getAttribute("addr")%>"></td>
		</tr>
	
		<tr>
			<td colspan="5">
			<input type = "submit" value = "저장">
			<input type = "reset" value = "취소">
			<input type = "button" value = "회원목록" onClick = "location.href='index.jsp'">
			
			</td>
		</tr>
	</table>
</form>	
</body>
</html>