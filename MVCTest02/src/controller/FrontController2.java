package controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ContentAction;
import action.DeleteAction;
import action.EditAction;
import action.ListAction;
//propterty객체 저장 후 처리 - 외부파일 없이 처리
//서블릿을 상속받은 클래스로 컨트롤러를 작성
public class FrontController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Properties props = new Properties();
	@Override
	public void init() throws ServletException {
		System.out.println("init()시작");
		props.setProperty("/list.do", "action.ListAction");
		props.setProperty("/edit.do", "action.EditAction");
		props.setProperty("/content.do", "action.ContentAction");
		props.setProperty("/delete.do", "action.DeleteAction");
		System.out.println("init()끝");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		
		String idongPage = "";
		//viewResolver
		String prefix="./pageView/";//
		String postfix=".jsp";//
		
        String className = props.getProperty(command);
        System.out.println(className);
		
		try {
			Class actionClass = Class.forName(className);
			Action action = (Action)actionClass.newInstance();
			//execute()메소드의 다형성
		   idongPage = action.execute(request, response);	
	
		
		 idongPage = prefix + idongPage +postfix;
		 System.out.println("idongPage="+idongPage);
		 
		//이동처리
		RequestDispatcher dispatecher
		 = request.getRequestDispatcher(idongPage);
		dispatecher.forward(request, response);
		
		}catch(Exception e) {e.printStackTrace();}
	}

}







