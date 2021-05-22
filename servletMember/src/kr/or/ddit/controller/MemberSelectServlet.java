package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/MemberSelectServlet.do")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private IMemberService service = null;
	
    public MemberSelectServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		List<MemberVO> memList = service.selectMember();
		
		request.setAttribute("memList", memList);
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberSelect.jsp");
		
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
