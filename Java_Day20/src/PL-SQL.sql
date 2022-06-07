select * from emp order by empno desc;
alter table emp add comm number(38);
update emp set comm=500 where empno=101;
insert  into emp values(11,'홍길동','인사과장',3000,300,10);
select  * from emp;
-- 트리거를 위한 emp01 테이블 생성
drop table emp01;
create table emp01(
   empno number(38) primary key,
   ename varchar2(50),
   job varchar2(50)
);

select * from emp01;
drop table sal01;
create table sal01(
salno number(38) primary key
,sal number(10,2)--급여
,empno number(38) references emp01(empno)
);
select * from sal01 order by salno asc;

create sequence sal01_salno_seq
start with 1
increment by 1
nocache;
select sal01_salno_seq.nextval from dual;
