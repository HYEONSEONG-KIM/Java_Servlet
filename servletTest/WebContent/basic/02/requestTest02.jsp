<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request 연습 Form(숫자 입력은 정수형으로만 입력)</h2>
	<hr>
	<form method = "post" action = "/servletTest/RequestTest02.do">
		<table>
			<tr>
				<td><input type = "text" size = "10" name = "num1"></td>
				<td>
					<select name = "op">
						<option value = "+"> + </option>
						<option value = "-"> - </option>
						<option value = "*"> * </option>
						<option value = "/"> / </option>
						<option value = "%"> % </option>
					</select>
				</td>
				<td><input type = "text" size = "10" name = "num2"></td>
				<td><input type = "submit" value = "확인"></td>
			</tr>
		</table>
	</form>
	<!-- 
		결과예시) 20 * 30 = 600
		
	 -->
</body>
</html>