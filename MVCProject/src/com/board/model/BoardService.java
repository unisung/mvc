package com.board.model;

import java.util.List;

public interface BoardService {
	//게시글 리스트
  List<BoardBean> getBoardList() throws Exception;
  //게시글 추가
  int insertBoard(BoardBean board) throws Exception;
  //조회수 증가
  void boardHit(int no) throws Exception;
  //내용보기
  BoardBean getCont(int no) throws Exception;
  //수정
  int boardEdit(BoardBean board) throws Exception;
  //삭제
  int deleteBoard(int no) throws Exception;
  //검색결과
  List<BoardBean> findBoard(String find_name,String find_field) throws Exception;
  

}
