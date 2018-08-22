member.sql
drop table member purge;
-- 회원관리 테이블 작성
create table member(
member_id varchar(20) primary key
,member_pass varchar(20) not null
,member_name varchar(30) not null
,member_nickname varchar(100) not null
,member_zip1 varchar(3) not null
,member_zip2 varchar(3) not null
,member_addr1 varchar(100) not null
,member_addr2 varchar(100) not null
,member_profilename varchar(100)   /* 이진파일(이미지)*/
,member_regdate date               /* 등록날짜 */
,member_state int                  /* 가입 상태(1,2) */
,member_delcont varchar(1000)      /* 탈퇴 사유 */
,member_deldate date               /* 탈퇴 날짜 */
);
-- 테이블 구조
select * from MEMBER;
-- 레코드 삽입
insert into MEMBER(member_id,member_pass,member_name,
member_nickname,member_zip1,member_zip2,member_addr1,
member_addr2,member_profilename,member_regdate,member_state)
values('hong','1234','홍길동','의적','123','789',
'서울시 강남구 테헤란로', 'IT정보기술원','20150104.jpg',sysdate,1);
insert into MEMBER(member_id,member_pass,member_name,
member_nickname,member_zip1,member_zip2,member_addr1,
member_addr2,member_profilename,member_regdate,member_state)
values('leess','1234','이순신','총무공','123','789',
'서울시 강남구 테헤란로', 'IT정보기술원','20141204.jpg',sysdate,1); 

commit work;


