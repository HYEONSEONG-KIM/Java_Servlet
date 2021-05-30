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


@WebServlet("/MemberUpdateServlet.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IMemberService service = null; 
    
    public MemberUpdateServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_id(request.getParameter("mem_id"));
		memVo.setMem_pass(request.getParameter("mem_pass"));
		memVo.setMem_name(request.getParameter("mem_name"));
		memVo.setMem_ph(request.getParameter("mem_ph"));
		memVo.setMem_addr(request.getParameter("mem_addr"));
		
		
		int result = service.updateMember(memVo);
	
		request.setAttribute("upresult", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/memberSelect.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
