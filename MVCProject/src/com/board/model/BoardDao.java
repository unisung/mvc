package com.board.model;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDao implements BoardService{
	private static BoardDao instance;
	private static SqlSession session;
	static {
		try {
			  Reader reader = 
				     Resources.getResourceAsReader("config/configuration.xml");
			  SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader);
			  session = sf.openSession(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private BoardDao() {}
	public static BoardDao getInstance() {
		if(instance==null) instance=new BoardDao();
		return instance;
	}
	@Override
	public List<BoardBean> getBoardList() {
		return session.selectList("selectBoardList");
	}
	@Override
	public int insertBoard(BoardBean board) {
		return session.insert("insertBoard", board);
	}
	@Override
	public void boardHit(int no) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public BoardBean getCont(int no) {
		return session.selectOne("selectBoard",no);
	}
	@Override
	public int boardEdit(BoardBean board) {
		return session.update("boardUpdate", board);		
	}
	@Override
	public int deleteBoard(int no) {
		return session.delete("deleteBoard", no);
	}
	@Override
	public List<BoardBean> findBoard(String find_name, String find_field) {
		BoardBean board = new BoardBean();
		board.setFind_name(find_name);
		board.setFind_field(find_field);
		
		System.out.println("find_name="+board.getFind_name());
		System.out.println("find_field="+board.getFind_field());
		
		return session.selectList("selectBoardFindList", board);
	}
	

}
