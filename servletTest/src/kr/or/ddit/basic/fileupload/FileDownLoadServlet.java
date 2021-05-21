package kr.or.ddit.basic.fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/file/FileDownLoad.do")
public class FileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uploadPath = "c:/uploadFiles";
		
		String fileName = request.getParameter("fileName");
		
		String filePath = uploadPath + File.separator + fileName;
		
		File file = new File(filePath);
		
		OutputStream out = null;
		FileInputStream fin = null;
		
		if(file.exists()) {
			// Download를 위한 Content-Type 설정
			response.setContentType("application/octet-stream; chatset=utf-8");
			
			// Response객체의 Header에 Content-Disposition 속성을 설정
			String headerKey = "Content-Disposition";
			//String headerValue = "attachment; filename=\"" + file.getName() + "\"";
			String downFilename = getDisposition(file.getName(), getBrowser(request));
			String headerValue = "attachment; filename=\"" + downFilename + "\"";
			System.out.println(headerValue +", "+file.getName()+", "+downFilename);
			response.setHeader(headerKey, headerValue);
			
			try {
				// 출력용 스트립 객체 생성 => Response객체를 이용해서 구함
				out = response.getOutputStream();
				
				// 파일 입력용 스트립 객체 생성
				fin = new FileInputStream(file);
				byte[] temp = new byte[8192];
				int len = 0;
				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트립으로 출력
				while((len = fin.read(temp)) > 0) {
					out.write(temp, 0 , len);
				}
				out.flush();
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			}finally {
				if(fin != null) fin.close();
				if(out != null) out.close();
			}
		}else {	// 파일이 없을 경우
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fileName + " 파일이 존재하지 않습니다</h3>");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 사용자의 웹브라우저 종류를 반환하는 메서드
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if(header.indexOf("MSIE") > -1) {
			return "MISE";
		}else if(header.indexOf("Chrome") > -1) {
			return "Chrome";
		}else if(header.indexOf("Opera") > -1) {
			return "Opera";
		}else if(header.indexOf("Trident/7.0") > -1) { // IE 11버전 이상
			return "MSIE";
		}
		return "Firefox";
	}
	
	
	// 브라우저별로 한글 파일이름을 변환해서 반환하는 메서드
	private String getDisposition(String filename, String browser) {
		String encodedFilename = null;
		
		try {
			if(browser.equals("MSIE")) {
				encodedFilename = URLEncoder.encode(filename, "utf-8").replaceAll("\\", "%20");
			}else if(browser.equals("Firefox")) {
				encodedFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";
			}else if(browser.equals("Opera")) {
				encodedFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";
			}else if(browser.equals("Chrome")) {
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < filename.length(); i++) {
					char c = filename.charAt(i);
					if(c > '~') {
						sb.append(URLEncoder.encode("" + c, "utf-8"));
					}else {
						sb.append(c);
					}
				}
				encodedFilename = sb.toString();
			}else {
				throw new RuntimeException("지원되지 않는 브라우저 입니다");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return encodedFilename;
	}
	
	
	
}








