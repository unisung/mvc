package com.gongji.model;

import java.util.ArrayList;
import java.util.List;
import com.db.DBManager;

public class GongjiDao extends DBManager implements GongjiService{
	private static GongjiDao instance;
	private GongjiDao() {}//외부에서 생성자 접근 막기

	public static GongjiDao getInstance() {
		if(instance==null) instance=new GongjiDao();
		return instance;
	}
	



	@Override
	public int getListCount() throws Exception {
		int count=0;
		sql="select count(*) from gongji";
	    pstmt = getConnection().prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs.next())
			count = rs.getInt(1);
		
		close(conn,pstmt,rs);		
		return count;
	}

	@Override
	public List<GongjiBean> getGongjiList(int page, int limit) throws Exception {
		sql = "select gongji_no,gongji_name,gongji_title, " + 
				"     gongji_cont,gongji_pwd,gongji_hit,gongji_regdate " + 
				" from" + 
				" (select rownum rn,a.* " + 
				"    from " + 
				" (select * from gongji) a ) " + 
				" where rn between ? and ? ";
		pstmt = getConnection().prepareStatement(sql);
		List<GongjiBean> list  = new ArrayList<>();
		
		int startrow = (page-1)*10+1;//해당 페이지의 시작번호
		int endrow = page*limit;//끝번호
		
		pstmt.setInt(1, startrow);
		pstmt.setInt(2,endrow);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int i=0;
			GongjiBean g = new GongjiBean();
			g.setGongji_no(rs.getInt(++i));
			g.setGongji_name(rs.getString(++i));
			g.setGongji_title(rs.getString(++i));
			g.setGongji_cont(rs.getString(++i));
			g.setGongji_pwd(rs.getString(++i));
			g.setGongji_hit(rs.getInt(++i));
			g.setGongji_regdate(rs.getString(++i));
			
			 list.add(g);
		}
		close(conn,pstmt,rs);
		return list;
	}

	@Override
	public void updateGongjigHit(int gongji_no) throws Exception {
        sql = "update gongji set gongji_hit=gongji_hit+1 where gongji_no=?";
        conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gongji_no);
        pstmt.executeUpdate();
        close(conn,pstmt);
	}
	
	@Override
	public GongjiBean getGongjiCont(int gongji_no) throws Exception {
		GongjiBean gongji = new GongjiBean();
		sql="select * from gongji where gongji_no=?";
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gongji_no);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int i=0;
			gongji.setGongji_no(rs.getInt(++i));
			gongji.setGongji_name(rs.getString(++i));
			gongji.setGongji_title(rs.getString(++i));
			gongji.setGongji_cont(rs.getString(++i));
			gongji.setGongji_pwd(rs.getString(++i));
			gongji.setGongji_hit(rs.getInt(++i));
			gongji.setGongji_regdate(rs.getString(++i));
		}
		close(conn,pstmt,rs);
		return gongji;
	}

}
