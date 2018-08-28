package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ContentAction;
import action.DeleteAction;
import action.EditAction;
import action.ListAction;

//서블릿을 상속받은 클래스로 컨트롤러를 작성
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer requestURL = request.getRequestURL();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		System.out.println(requestURL);
		System.out.println(requestURI);
		System.out.println(contextPath);
		System.out.println(command);
		
		String idongPage = "";
		//viewResolver
		String prefix="./pageView/";//
		String postfix=".jsp";//
		
		try {
		if(command.equals("/list.ko")) {
		   ListAction action = new ListAction();	
		   idongPage = action.execute(request, response);	
		}else if(command.equals("/edit.ko")) {
		   EditAction action = new EditAction();	
		   idongPage = action.execute(request, response);
		}else if(command.equals("/content.ko")) {
		   ContentAction action = new ContentAction();
		   idongPage = action.execute(request, response);
		}else if(command.equals("/delete.ko")) {
		  DeleteAction action = new DeleteAction();
		  idongPage = action.execute(request, response);
		}
		
		 idongPage = prefix + idongPage +postfix;
		 System.out.println("idongPage="+idongPage);
		 
		//이동처리
		RequestDispatcher dispatecher
		 = request.getRequestDispatcher(idongPage);
		dispatecher.forward(request, response);
		
		}catch(Exception e) {e.printStackTrace();}
	}

}







