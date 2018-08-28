package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.ContentAction;
import action.DeleteAction;
import action.EditAction;
import action.ListAction;
import action.LoginAction;
import action.LoginFormAction;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 StringBuffer requestURL = request.getRequestURL();
	 String requestURI = request.getRequestURI();
	 String contextPath = request.getContextPath();
	 String command = requestURI.substring(contextPath.length());
	 //이동처리객체(forward/sendRedirect여부,이동페이지 설정)
	 ActionForward actionForward=null;
	 //ListAction(로직처리객체)
	 Action action=null;
	 
	 try {
		 //url로 넘어온 command분석, 해당 action으로 분기처리
		 if(command.equals("/list.ko")) {
			action = new ListAction();
			actionForward = action.execute(request, response);
			//actionForward = new ActionForward();//ActionForward객체의 참조변수 
		 }else if(command.equals("/edit.ko")) {
				action = new EditAction();
				actionForward = action.execute(request, response);
				//actionForward = new ActionForward();//ActionForward객체의 참조변수 
	     }else if(command.equals("/content.ko")) {
				action = new ContentAction();
				actionForward = action.execute(request, response);
				//actionForward = new ActionForward();//ActionForward객체의 참조변수 
		 }else if(command.equals("/delete.ko")) {
				action = new DeleteAction();
				actionForward = action.execute(request, response);
				//actionForward = new ActionForward();//ActionForward객체의 참조변수 
		 }else if(command.equals("/login.ko")) {
				action = new LoginFormAction();
				actionForward = action.execute(request, response);
				//actionForward = new ActionForward();//ActionForward객체의 참조변수 
	     }else if(command.equals("/loginOk.ko")) {
				action = new LoginAction();
				actionForward = action.execute(request, response);
				//actionForward = new ActionForward();//ActionForward객체의 참조변수 
		 }
		 
		 
		 
		 
		 
		 if(actionForward!=null) {
			 if(actionForward.isRedirect()==true) {//redirect
				 response.sendRedirect(actionForward.getPath());
			 }else if(actionForward.isRedirect()==false) {//forward
				 RequestDispatcher dispatcher
				 = request.getRequestDispatcher(actionForward.getPath());
				 dispatcher.forward(request, response);//forward(req,res) - dispatcher의 메소드
			 }
		 }
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
		
	}

}
