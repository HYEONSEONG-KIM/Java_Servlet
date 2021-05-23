package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/MemberDeleteServlet.do")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IMemberService service = null;
   
    public MemberDeleteServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		String memId= (String) session.getAttribute("id");
		
		int result = service.deleteMember(memId);
		
		request.setAttribute("delresult", result);
		
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberSelect.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
