-- bbs.sql
drop table bbs purge;

create table bbs(
bbs_num int primary key
,bbs_name varchar(20) not null
,bbs_pass varchar(20) not null
,bbs_subject varchar(100) not null
,bbs_content varchar(1000) not null
,bbs_file varchar(100)
,bbs_re_ref int    /* 답변글(그룹번호) */
,bbs_re_lev int    /* 답변글(깊이번호) */
,bbs_re_seq int    /* 답변글(순서번호) */
,bbs_readcount int /* 조회수 */
,bbs_date date     /* 글 등록 날짜 */
);

select * from bbs;
commit work;

/*
 * 답변글 관련 컬럼 
 * 
 *  bbs_num   bbs_subject     bbs_re_ref     bbs_re_lev    bbs_re_seq
 *     2        강의자료          2              0              0
 *              re:강의자료       2              1              1
 *     1        수업자료          1              0              0 
 *               ->re:수업자료    1              1              1
 *               ->re:수업자료    1              1              2(1+1)
 *               ->re:re:수업자료 1              2              3(2+1)
 * 
 *   order by bbs_re_ref desc, bbs_re_seq asc;
 */









