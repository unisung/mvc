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

public class BbsEditOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BbsBean bbsbean = new BbsBean();
		BbsDao  bbsDao = BbsDao.getInstance();
		ActionForward forward = new ActionForward();
		
		//이진파일 업로드 폴더 경로
		String saveFolder ="C:\\Users\\Administrator\\mvcgit\\MVCProject\\WebContent\\upload";
		//이진파일 업로드 최대크기 지정
		int fileSize = 5*1024*1024;
		//업로드 객체
		MultipartRequest multi=null;
		multi = new MultipartRequest(request, saveFolder,fileSize,"UTF-8");
		
		int bbs_num=Integer.parseInt(multi.getParameter("num"));
		int page = Integer.parseInt(multi.getParameter("page"));
		
		System.out.println("bbs_num="+bbs_num);
		System.out.println("page="+page);
		
		String bbs_name=multi.getParameter("bbs_name");
		String bbs_pass=multi.getParameter("bbs_pass");
		String bbs_subject=multi.getParameter("bbs_subject");
		String bbs_content=multi.getParameter("bbs_content");
		
		bbsbean = bbsDao.getCont(bbs_num);
		PrintWriter out = response.getWriter();
		
		if(!bbsbean.getBbs_pass().equals(bbs_pass)) {
			out.print("<script>");
			out.print("alert('비번이 올바르지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");
		}else {
			File upFile = multi.getFile("bbs_file");
			if(upFile!=null) {
				String fileName = upFile.getName();
				File DelFile = new File(saveFolder+bbsbean.getBbs_file());
				//수정시 새로운파일 선택하면 기존 파일 삭제
				if(DelFile.exists()) {
					DelFile.delete();
				}
				//저장할 파일 이름 설정
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month=c.get(Calendar.MONTH)+1;
				int date = c.get(Calendar.DATE);
				
				String homedir = saveFolder+"/"+year+"-"+month+"-"+date;
				File path1 = new File(homedir);
				
				if(!path1.exists())//저장할 폴더가 존재하지 않으면 
					path1.mkdir();//새로 생성
				
				Random r = new Random();
				int random = r.nextInt(100000000);
				
				//파일 확장자 구하기
				int index = fileName.lastIndexOf(".");
				String fileExtension =
						fileName.substring(index+1);
				
			    //새파일 저장
				String refileName 
				    = "bbs"+year+month+date+random+"."+fileExtension;
				String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;
				
				System.out.println("edit_fileDbName="+fileDBName);
				
				upFile.renameTo(new File(homedir+"/"+refileName));
				//새로운 이름으로 db에 저장
				bbsbean.setBbs_file(fileDBName);
			}//새로우 파일이 넘어오면 처리 하는 부분 끝.
			//
			bbsbean.setBbs_name(bbs_name);
			bbsbean.setBbs_subject(bbs_subject);
			bbsbean.setBbs_content(bbs_content);
			bbsbean.setBbs_num(bbs_num);
			
			//db에 update처리
			bbsDao.bbsEdit(bbsbean);
			
			forward.setRedirect(true);
			forward.setPath("bbs_cont.do?num="+bbs_num+"&page="+page+"&state=cont");
			
			return forward;
		}
		
		return null;
	}

}
