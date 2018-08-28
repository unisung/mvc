package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class FrontController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Map<Object,Object>
	Map<String,Action> commandmap = new HashMap<>();
    Properties props = new Properties();
    
	public void init(ServletConfig config) throws ServletException {
		try {
		   props.load(new FileInputStream(new File("C:\\jspWorkspace\\MVCTest02\\WebContent\\resources\\command.properties")));
		   ///list.action,/edit.action,/content.action,/delete.action,/login.action,/loginOk.action
		   Iterator<Object> keys = props.keySet().iterator();//
		   while(keys.hasNext()) {
			String command = (String)keys.next();
			String className = props.getProperty(command);//action.ListAction
			
			 Class commandClass = Class.forName(className);//해당클래스 로딩(클래스로더)
			 Action action = (Action)commandClass.newInstance();// ListAction action = new ListAction();
			 commandmap.put(command, action);
		   } 
		}catch(Exception e) {e.printStackTrace();}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 
		StringBuffer requestURL = request.getRequestURL();
		 String requestURI = request.getRequestURI();
		 String contextPath = request.getContextPath();
		 String command=requestURI.substring(contextPath.length());
		 System.out.println("servie_command="+command);
		 try {
			 
		    Action action = commandmap.get(command);
		    String idongPage = action.execute(request, response);
		    
		    System.out.println("이동페이지:"+idongPage);
		    
		    //이동처리
		    RequestDispatcher rd
		     = request.getRequestDispatcher("./pageView/"+idongPage+".jsp");
		    rd.forward(request, response);
		    
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}

}
