create table tbl_guest(
g_no number(38) primary key
,g_name varchar2(50) not null
,g_title varchar2(200) not null
,g_cont varchar2(4000) not null
,g_date date
);

select * from tbl_guest order by g_no desc;

create sequence g_no_seq
start with 1
increment by 1
nocache;
select g_no_seq.nextval from dual;