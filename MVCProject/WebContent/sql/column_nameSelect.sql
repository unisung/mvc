select * from member;

select 
   'private '||
   decode(data_type,'VARCHAR2','String','NUMBER','int','DATE','Date',data_Type)||' '||
   lower(column_name)||',' 
from cols 
where table_name='MEMBER';

select member_pass from member where member_id='hong';

select 
   'private '||
   decode(data_type,'VARCHAR2','String','NUMBER','int','DATE','Date',data_Type)||' '||
   lower(column_name)||',' 
from cols 
where table_name='BOARD';

select * from board;


select * 
  from board 
 where 1=1;