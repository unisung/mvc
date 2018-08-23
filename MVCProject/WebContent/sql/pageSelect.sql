select * from GONGJI;

select gongji_no,gongji_name,gongji_title,
       gongji_cont,gongji_pwd,gongji_hit,gongji_regdate
  from
(select rownum rn,a.* 
 from
(select * from gongji) a )
where rn between 11 and 20
;

select count(*) from gongji;