<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터 Ajax로 처리</title>
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(function(){
		$('#strBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/JsonTest.do',
				type : 'post',
				data : 'choice=str',
				success : function(data){	//서버에서 처리된 결과가 data변수에 저장
					$("#result").html(data);
					
				},
				dataType : 'json'
			})
		})
		
			$('#arrayBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/JsonTest.do',
				type : 'post',
				data : 'choice=array',
				success : function(data){	//서버에서 처리된 결과가 data변수에 저장
					res = "";
				$.each(data,function(i,v){
					res += i + "번째" + v + "<br>";
				})
					$("#result").html(res);
					
				},
				dataType : 'json'
			})
		})
		
		$('#objBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/JsonTest.do',
				type : 'post',
				data : 'choice=obj',
				success : function(data){	//서버에서 처리된 결과가 data변수에 저장
					res = "<h2>Object 응답결과</h2>";
					res += "ID : " + data.id + "<br>";
					res += "NAME : " + data.name + "<br>";
					$("#result").html(res);
					
				},
				dataType : 'json'
			})
		})
		
			$('#listBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/JsonTest.do',
				type : 'post',
				data : 'choice=list',
				success : function(data){	//서버에서 처리된 결과가 data변수에 저장
					res = "";
					$.each(data, function(i,v){
						res += i + "번째 ID : " + v.id + "<br>";
						res += i + "번째 NAME : " + v.name + "<hr>";
						
					})
					$("#result").html(res);
					
				},
				dataType : 'json'
			})
		})
		
			$('#mapBtn').on('click', function(){
			$.ajax({
				url : '<%=request.getContextPath()%>/JsonTest.do',
				type : 'post',
				data : 'choice=map',
				success : function(data){	//서버에서 처리된 결과가 data변수에 저장
					res = "";
				// 방법1
				// data가 Map이거나 객체일 경우에 변수 i에는 변수명 또는 key값이 문자열로 저장
				// 변수 v에는 '변수에 저장된 데이터 값' 이나 value값이 저장
				 	/* $.each(data, function(i,v){
						res += i + " : "+ v + "<br>";
						
					}) */
					res += "이름 : " + data.name + "<br>";
					res += "전화 : " + data.tel + "<br>";
					res += "주소 : " + data.addr + "<br>";
					$("#result").html(res); 
					
				},
				dataType : 'json'
			})
		})
	});
</script>

</head>
<body>
	<form>
		<input type = "button" id = "strBtn" value = "문자열">
		<input type = "button" id = "arrayBtn" value = "배열">
		<input type = "button" id = "objBtn" value = "객체">
		<input type = "button" id = "listBtn" value = "리스트">
		<input type = "button" id = "mapBtn" value = "Map객체">
	</form>
	<hr>
	<h3>응답결과</h3>
	<div id= "result"></div>
</body>
</html>