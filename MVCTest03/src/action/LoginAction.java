package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			               HttpServletResponse response) throws Exception {
	
		//id와 패스워드파라미터 받기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("id="+id);
		System.out.println("password="+password);
		String page="";
		MemberDao dao = MemberDao.getInstance();
		//id와 password를 입력받아서 결과 값을 처리
		int result = dao.userCheck(id,password);
		
		//db에서 id,패스워드 읽어서 비교하기
		//경로 설정
		   ActionForward forward = new ActionForward(); 
		   
		if(result==1) {
				System.out.println(1);
				 request.setAttribute("gildong", "로그인 성공");
				 forward.setRedirect(false);
				page = "./pageView/list.jsp";
		}else{
			System.out.println(3);
			 forward.setRedirect(true);
			page = "login.ko";
		}
		
		
		//경로 설정
		  // ActionForward forward = new ActionForward(); 
		  // forward.setRedirect(false);//값이 false일때 forward,true일때 sendRedirect
		   forward.setPath(page);//이동할 경로 설정
			
		return forward;
	}

}
