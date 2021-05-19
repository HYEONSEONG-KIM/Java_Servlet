package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionLogin.do")
public class sessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; cahrset=utf-8");
		
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		session.setAttribute("id", id);
		if(id.equals("admin") && pass.equals("1234")) {
			response.sendRedirect(request.getContextPath() + "/basic/04/sessionLogin.jsp");
			session.setAttribute("state", "ok");
		}else {
			response.sendRedirect(request.getContextPath() + "/basic/04/sessionLogin.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
