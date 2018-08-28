package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.HelloAction;


@WebServlet("/MyController")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HelloAction action = new HelloAction();
		
	try {
		  //action클래스의 인스턴스에 작업을 하도록 분기 처리
		  //이동할 페이지 
			 String viewPage = action.execute(request, response);
		
		
		RequestDispatcher dispatcher
		 = request.getRequestDispatcher(viewPage);//이동할 페이지 처리
		
		//페이지 이동
		dispatcher.forward(request, response);
		
		}catch(Exception e) {}
	}

}
