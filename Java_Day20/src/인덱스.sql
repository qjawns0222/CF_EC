create table emp201(
empno number(38) primary key
,ename varchar2(100)
,sal number(38)
);

insert into emp201 values(11,'홍길동',100);
insert into emp201 values(12,'이순신',200);
insert into emp201 values(13,'강감찬',300);

select * from emp201 order by empno asc;

create table emp202 as select * from emp201  where  10=0;
select table_name,column_name,index_name from user_ind_columns where table_name in('EMP201','EMP202');
insert into emp202 select * from emp201;
select * from emp202;

create index idx_emp202_ename on emp202(ename);
create index idx_emp202_empno on emp202(empno);

drop index idx_emp202_ename;
create table emp203 as select * from emp202  where  10=0;

select * from emp203 order by empno;
insert into emp203 values(10,'신사임당',1000);
insert into emp203 values(20,'이순신',2000);
insert into emp203 values(30,'신사임당',3000);

create unique index idx_emp203_empno on emp203(empno);

create unique index idx_emp203_ename on emp203(ename);

