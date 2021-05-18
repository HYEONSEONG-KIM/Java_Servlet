package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		
		String userId = request.getParameter("userid");
		String pass = request.getParameter("pass");
		String chkId = request.getParameter("chkid");
		
		Cookie userCookie = new Cookie("ID", userId);
		
		// 체크박스 체크 여부에 따라 쿠키 저장
		if(chkId != null) {
			response.addCookie(userCookie);
		}else {	// 체크박스 해제
			userCookie.setMaxAge(0);
			response.addCookie(userCookie);
		}
		
		if(userId != null && pass != null) {
			if("test".equals(userId) && "1234".equals(pass)) {
				response.sendRedirect(request.getContextPath() + "/basic/03/cookieMain.jsp");
			}else {
				response.sendRedirect(request.getContextPath() + "/basic/03/cookieLogin.jsp");
			}
		}
		

		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}














