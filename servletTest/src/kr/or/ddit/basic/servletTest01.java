package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 	서블릿이란? -	서블릿 컨테이너에 의해 관리되는 자바 기반 웹 컴포넌트로써
 * 				동적인 웹 컨텐츠 생성을 가능하게 해줌
 * 
 * 	요청 URL주소 : http://localhost:8080/servletTest/servletTest01.do
 * 	- http : 프로토콜
 * 	- localhost : 서버의 컴퓨터이름(도메인명) or IP주소
 * 	- 8080 : port번호(80번일 경우 생략가능 - http의 기본 port가 80이므로)
 * 	- /servletTest : 컨텍스트 패스(보통 '웹 프로젝트 이름'으로 지정)
 * 	- /servletTest01.do : 서블릿 요청 URL패턴(서블릿을 구분해서 호출할 때 사용)
 */

/*
 * 	이 예제는 배포 서술자(DD, Deployment Descriptor => web.xml)를 이용해서
 * 	실행할 Sevlet을 설정하여 처리하는 예제
 */

// Servlet클래스는 'HttpServlet'클래스를 상속해서 작성
public class servletTest01 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// 이 부분에서는 대부분 service()메서드 또는 doGet()메서드나  doPost()메서드를
	// 재정의해서 처리할 내용을 구현
	
	// doGet()메서드나 doPost()메서드는 Service()메서드에서 자동으로 호출해줌
	// 위 메서드의 매개변수에는 아래의 객체가 자동으로 셋팅
	// - HttpServletRequest객체 => 서비스 요청에 관련된 정보 및 메서드들을 관리하는 객체
	// - HttpServletResponse객체 => 서비스 응답에 관련된 정보 및 메서드들을 관리하는 객체
	
	// doGet()메서드 => GET방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8"); 	// 응답 문서의 인코딩 방식 지정
		resp.setContentType("text/html; charset=UTF-8");	// 응답 문서의 ContentType 지정
		
		// 처리한 내용을 응답으로 보내기 위해 PrintWriter객체를 생성 => 응답 객체에서 구해옴
		PrintWriter out = resp.getWriter();
		
		// 처리한 내용을 출력 (HTML코드를 작성)
		// 방법1) append()메서드 이용하기 
		out.append("<html>");
		out.append("<head>")
			.append("<meta charset = 'utf-8'>")
			.append("<title>첫번째Servlet 연습</title>")
			.append("</head>")
			.append("<body>")
			.append("<h1 style='text-align:center;'>")
			.append("안녕하세요. 첫번째 Servlet 프로그램입니다.<br>")
			.append("Servlet at :" + req.getContextPath())
			.append("</h1>")
			.append("</body>")
			.append("</html>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}



















