<%@page import="kr.or.ddit.vo.MemberVO"%>
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
	MemberVO memVo = (MemberVO)request.getAttribute("selectOne");
%>
	<form action="<%=request.getContextPath()%>/MemberDeleteServlet.do">
		<table border = 1>
			<tr>
				<td>회원ID</td>
				<td><%=memVo.getMem_id()%></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><%=memVo.getMem_pass()%></td>
			</tr>
			
			<tr>
				<td>회원이름</td>
				<td><%=memVo.getMem_name()%></td>
			</tr>
			
			<tr>
				<td>전화번호</td>
				<td><%=memVo.getMem_ph()%></td>
			</tr>
			
			<tr>
				<td>회원주소</td>
				<td><%=memVo.getMem_addr()%></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type = "button" value = "수정" onClick ="location.href='member/updateMember.jsp'">
					<input type = "submit" value = "삭제" >
					<input type = "button" value = "회원목록" onClick = "location.href='member/index.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>