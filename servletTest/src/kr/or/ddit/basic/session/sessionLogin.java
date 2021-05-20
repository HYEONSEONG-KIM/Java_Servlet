package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/basic/04/sessionLogin.jsp");
		rd.forward(request, response);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; cahrset=utf-8");
		
//		HttpSession session = request.getSession();
		
		
//		String id = request.getParameter("id");
//		String pass = request.getParameter("pass");
		
//		session.setAttribute("id", id);
//		if(id.equals("admin") && pass.equals("1234")) {
//			session.setAttribute("state", "ok");
//			response.sendRedirect(request.getContextPath() + "/basic/04/sessionLogin.jsp");
//		}else {
//			response.sendRedirect(request.getContextPath() + "/basic/04/sessionLogin.jsp");
//		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		
		if(id.equals("admin") && pass.equals("1234")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
//			session.setAttribute("state", "ok");
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("/basic/04/sessionLogin.jsp");
		rd.forward(request, response);
		
	}

}
