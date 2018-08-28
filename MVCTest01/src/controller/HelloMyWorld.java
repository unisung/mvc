package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;


@WebServlet("/HelloMyWorld")
public class HelloMyWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private Map<String, Action> commandMap = new HashMap<>();
		@Override
		public void init(ServletConfig config) throws ServletException {
			System.out.println("init()메소드 실행시작");
			Properties pr = new Properties();
			FileInputStream f=null;
			try {
				  f=new FileInputStream(new File("C:\\jspWorkspace\\MVCTest01\\src\\controller\\hoggildong.properties"));
				  pr.load(f);//저장{키=값}
			}catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(f!=null)try {f.close();}catch(Exception e) {e.printStackTrace();}
			}
			
			Iterator<Object> keyiterator = pr.keySet().iterator();

			while(keyiterator.hasNext()) {
				String command=(String)keyiterator.next();
				String className=pr.getProperty(command);
			try {
				  Class commandClass = Class.forName(className);//클래정보
				  Action commandInstance = (Action)commandClass.newInstance();//instance
				  commandMap.put(command,commandInstance);
			}catch(Exception e) {System.out.println(e.getMessage());}
			}//while문 끝.
			System.out.println("init()메소드 실행 끝.");
		}
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//url로 입력된 경로 분석
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(request.getContextPath().length());
		//map에 저장된 instance를 읽어서 처리
         Action action = commandMap.get(command);
	
		//분기 작업
		String viewPage = action.execute(request, response);//상속:구현된 객체의 메소드가 실행
		 
		//페이지 이동
		RequestDispatcher dispatcher
		 = request.getRequestDispatcher(viewPage);
		
		//페이지 이동
				dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}



}
