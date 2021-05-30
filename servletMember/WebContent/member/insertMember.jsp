<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		
		$('#check').on('click', function(){
			id = $('#id').val().trim();
			if(id.length < 1){
				alert("ID를 입력하세요");
				return false;
			}
						
			$.ajax({
				url : '<%=request.getContextPath()%>/MemberIdCheck.do',
				type : 'post',
				data : {'id' : id},
				success : function(data){
					if(data == null){
						alert("사용가능한 ID입니다")
					}else{
						alert("이미 존재하는 ID입니다")
					}
				},
				error : function(xhr){
					alert(xhr.status);
				},
				dataType : 'json'
			})
			
		})
	
	})
	
</script>
</head>
<body>

<form action="<%=request.getContextPath()%>/MemberInsrtServlet.do">
	<table border = 1>
		<tr>
			<td>회원ID</td>
			<td>
			<input name = "mem_id" id = "id" type = "text">
			<input type = "button" id = "check" value = "중복체크">
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td><input name = "mem_pass" id = "pass" type = "password"></td>
		</tr>
		
		<tr>
			<td>비밀번호 확인</td>
			<td><input name = "passcheck" id = "passcheck" type = "password"></td>
		</tr>
		
		<tr>
			<td>회원이름</td>
			<td><input name = "mem_name" id = "name" type = "text"></td>
		</tr>
		
		<tr>
			<td>전화번호</td>
			<td><input name = "mem_ph" id = "ph" type = "text"></td>
		</tr>
		
		<tr>
			<td>회원주소</td>
			<td><input name = "mem_addr" id = "addr" type = "text"></td>
		</tr>
	
		<tr>
			<td colspan="5">
			<input type = "submit" value = "저장">
			<input type = "reset" value = "취소">
			<input type = "button" value = "이전화면" onClick = "location.href='index.jsp'">
			
			</td>
		</tr>
	</table>
</form>	

<span id = "result"></span>
</body>
</html>