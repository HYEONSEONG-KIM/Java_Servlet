<%@page import="kr.or.ddit.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.service.IMemberService"%>
<%@page import="kr.or.ddit.dao.IMemberDao"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memList");
	
%>
<form action="<%=request.getContextPath()%>/MemberSelectServlet.do">
	<table border = 1>
		<tr>
			<td colspan="5">
				<input type = "button" value = "회원추가"  onClick="location.href='member/insertMember.jsp'">
			</td>
		</tr>
	
		
		
		<tr>
			<th>ID</th>
			<th>비밀번호</th>
			<th>이 름</th>
			<th>전 화</th>
			<th>주 소</th>
		</tr>
		
		<%
		if(memList != null){
			for(MemberVO vo : memList){
%>			
			<tr>
				<td><a href = "<%=request.getContextPath()%>/MemberSelectOneServlet.do?memId=<%=vo.getMem_id()%>">
				<%=vo.getMem_id()%></a></td>
				<td><%=vo.getMem_pass() %></td>
				<td><%=vo.getMem_name() %></td>
				<td><%=vo.getMem_ph() %></td>
				<td><%=vo.getMem_addr()%></td>
			</tr>
	
	
	<%		
			}
		}
%>	
	
	
	</table>
	<input type = "submit" value = "조회">
</form>
</body>
</html>