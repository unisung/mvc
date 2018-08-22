package com.controller.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//현재페이지로 넘어오는 요청객체의 문자셋 설정
		response.setContentType("text/html;charset=utf-8");//보내는 페이지의 문자셋 설정
		
		//Uri command경로 읽어 들이기
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println("RequestURI="+RequestURI);
		System.out.println("contextPath="+contextPath);
		System.out.println("command="+command);
		
		//service객체 선언
		Action action=null;
		ActionForward forward=null;
		
		System.out.println("RequestURI="+RequestURI);
		System.out.println("contextPath="+contextPath);
		System.out.println("command="+command);
		//command 프로퍼티 파일 읽어 들이기
		Properties prop=new Properties();
		FileInputStream fis = 
new FileInputStream("C:\\jspWorkspace\\MVCProject\\src\\com\\controller\\action\\command.properties");
		prop.load(fis);
		fis.close();
		String value = prop.getProperty(command).trim();
		
		 System.out.println("value="+value);
		 
		if(value.substring(0, 7).equals("execute")) {
			try {
					StringTokenizer st = new StringTokenizer(value, "|");
					String url_1=st.nextToken();
					String url_2=st.nextToken();
					System.out.println("url_1="+url_1);
					System.out.println("url_2="+url_2);
					Class url=Class.forName(url_2);
					action = (Action)url.newInstance();//인터페이스 타입 변환
					//생성된 action인스턴스의 execute()메소드 실행
				     forward=action.execute(request, response);	
		}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			forward=new ActionForward();
			forward.setRedirect(false);//forward
			forward.setPath(value);//command경로
			System.out.println("value="+value);
		}
		//command 처리
		//뷰로 이동 처리 부분
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				System.out.println("forward.getPath()="+forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
