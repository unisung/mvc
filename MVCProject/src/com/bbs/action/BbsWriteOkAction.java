package com.bbs.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.model.BbsBean;
import com.bbs.model.BbsDao;
import com.controller.action.Action;
import com.controller.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;

public class BbsWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BbsBean bbs = new BbsBean();
		
		String saveFolder="C:\\Users\\Administrator\\mvcgit\\MVCProject\\WebContent\\upload";
		int fileSize=5*1024*1024;//5*1kb*1kb =5Mb
		MultipartRequest multi=null;
		multi= new MultipartRequest(request, 
									saveFolder, 
									fileSize,
									"UTF-8"); 
		String bbs_name = multi.getParameter("bbs_name");
		String bbs_pass = multi.getParameter("bbs_pass");
		String bbs_subject = multi.getParameter("bbs_subject");
		String bbs_content = multi.getParameter("bbs_content");
		
		File upFile = multi.getFile("bbs_file");
		
		if(upFile!=null) {
			Calendar c= Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			int date = c.get(Calendar.DATE);
			
			String homedir = saveFolder+"/"+year+"-"+month+"-"+date;
			File path1 = new File(homedir);
			if(!path1.exists()) {//해당 디렉토리가 존재하지 않으면
				path1.mkdirs();//생성
			}
			Random r = new Random();
			int random = r.nextInt(100000000); 
			//파일 확장자 구하기 test1.txt
			int index = upFile.getName().lastIndexOf(".");
			String fileExtension
			   = upFile.getName().substring(index+1);//"."이후의 txt
			
			String refileName
			 = "bbs"+year+month+date+random+"."+fileExtension;
			//파일명 수정
			upFile.renameTo(new File(homedir+"/"+refileName));
			
			String fileDbName
			   = "/"+year+"-"+month+"-"+date+"/"+refileName;
			
			bbs.setBbs_file(fileDbName);		
	 }
		bbs.setBbs_name(bbs_name);
		bbs.setBbs_pass(bbs_pass);
		bbs.setBbs_subject(bbs_subject);
		bbs.setBbs_content(bbs_content);
		
		System.out.println(bbs.getBbs_name());
		System.out.println(bbs.getBbs_file());
		
		
		
		BbsDao dao = BbsDao.getInstance();
		int result = dao.insertBbs(bbs);
		
		
	    ActionForward forward = new ActionForward();	
		PrintWriter out = response.getWriter();
		if(result>0) {
			forward.setRedirect(true);
			forward.setPath("bbs_list.do");//자료실 목록보기
		}else {
			out.print("<script>");
			out.print("alert('게시물 저장에 실패하였습니다.);");
			out.print("history.back();");
			out.print("</script>");
		}
        //forward객체 리턴
		return forward;
	}

}
