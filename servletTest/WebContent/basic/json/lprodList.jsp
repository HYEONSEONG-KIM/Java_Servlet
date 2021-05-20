<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
		
		$(function(){
			
			$('#lprodBtn').on('click',function(){
				
				$.ajax({
					url : '<%=request.getContextPath()%>/lprod/lprodList.do',
					type : 'get',
					data : {"lprod" : "lprod"},
					success : function(data){
							res = "<h2>lprod List</h2>";
						$.each(data,function(i,v){
							
							res += "ID : " + v.lprod_id + "<br>";
							res += "NM : " + v.lprod_nm + "<br>";
							res += "GU : " + v.lprod_gu + "<hr>";
							
						})
						$('#result').html(res);
					},
					errorr : function(xhr){
						alert(xhr.status)
					},
					dataType : "json"
					
				})
				
			})
		})
	
</script>

<title>Insert title here</title>
<!-- 
	아래의 버튼을 클릭하면 Oracle의 Lprod테이블의 전체 목록을 가져와 출력
	(자료를 가져오는 것은 Servlet에서 처리해서 ajax로 가져옴
	 서블릿 이름 : LprodListServlet, URL매핑 : /lprod/lprodList.do)
 -->
</head>
<body>
	<form>
		<input type = "button" id = "lprodBtn" value = "Lprod자료 가져오기">
	</form>
	<h2>Lprod 자료 목록</h2>
	<div id = "result"></div>
</body>
</html>