package com.member.model;

import java.util.List;

public interface MemberService {
 //회원 존재여부 확인
  int checkMemberId(String id) throws Exception;
  //우편번호 조회
  List searchZipcode(String dong) throws Exception;
  //회원정보 조회
  MemberBean findpwd(String pwd_id, String pwd_name) throws Exception;
  //id,password 체크
  int userCheck(String id,String pass) throws Exception;
  //회원정보 조회
  MemberBean getMember(String id) throws Exception;
  //회원정보 수정
  int updateMember(MemberBean bean) throws Exception;
  //회원정보 삭제
  int deleteMember(String id, String pass, String del_cont) throws Exception;
  
  
}
