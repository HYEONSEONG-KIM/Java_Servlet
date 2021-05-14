package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		double result = 0;
		String op = request.getParameter("op");
		
		switch(op) {
			case "+" : result = num1 + num2;
				break;
			case "-" : result = num1 - num2;
				break;
			case "*" : result = num1 * num2;
				break;
			case "/" : result = (double)num1 / num2;
				break;
			case "%" : result = num1 % num2;
				break;
		}
		
		out.println("<html><head><meta charset = 'utf-8'");
		out.println("<title>Request객체 연습2</title></head>");
		out.println("<h2>getParameter방식</h2>");
		
		out.println("<p>" + num1 + op + num2 + " = " + result + "</p>");
		
		
		Map<String, String[]> operation = request.getParameterMap();
		int num01 = Integer.parseInt(operation.get("num1")[0]);
		int num02 = Integer.parseInt(operation.get("num2")[0]);
		String op2 = operation.get("op")[0];
		
		switch(op2) {
		case "+" : result = num01 + num02;
			break;
		case "-" : result = num01 - num02;
			break;
		case "*" : result = num01 * num02;
			break;
		case "/" : result = (double)num01 / num02;
			break;
		case "%" : result = num01 % num02;
			break;
	}
		out.println("<h2>getParameterMap방식</h2>");
		out.println("<p>" + num01 + op + num02 + " = " + result + "</p>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
