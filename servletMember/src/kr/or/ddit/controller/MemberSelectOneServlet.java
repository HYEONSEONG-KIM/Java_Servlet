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
import kr.or.ddit.vo.MemberVO;
import sun.security.util.Length;


@WebServlet("/MemberSelectOneServlet.do")
public class MemberSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IMemberService service = null;
    
    public MemberSelectOneServlet() {
    	service = MemberServiceImpl.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("memId");
		
		
		MemberVO memVo = service.selecetOne(id);
		request.setAttribute("selectOne", memVo);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", memVo.getMem_id());
		session.setAttribute("pass", memVo.getMem_pass());
		session.setAttribute("name", memVo.getMem_name());
		session.setAttribute("ph", memVo.getMem_ph());
		session.setAttribute("addr", memVo.getMem_addr());
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/selectOne.jsp");
		rd.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
