package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/MemberInsrtServlet.do")
public class MemberInsrtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private IMemberService service= null;
	
    public MemberInsrtServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String result = null;
		
		MemberVO memvo = new MemberVO();
		memvo.setMem_id(request.getParameter("mem_id"));
		memvo.setMem_name(request.getParameter("mem_name"));
		memvo.setMem_pass(request.getParameter("mem_pass"));
		memvo.setMem_ph(request.getParameter("mem_ph"));
		memvo.setMem_addr(request.getParameter("mem_addr"));
		
		result = service.insertMember(memvo);
		
		if(result == null) {
			result = "no";
		}else {
			result = "ok";
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/member/insertMember.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
