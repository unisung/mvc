-- zipcode.sql
drop table zipcode purge;

create table zipcode(
no varchar(5) primary key  /* 레코드 번호 */
,ZIPCODE varchar(7)        /* 우편번호*/ 
,sido varchar(10)          /* 시도 */
,gugun varchar(20)         /* 구군 */
,dong varchar(50)          /* 동   */
,bunji varchar(50)         /* 번지 */
); 
select * from zipcode;
delete from ZIPCODE;


select count(*) from zipcode;

commit work;




