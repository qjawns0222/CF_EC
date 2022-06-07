create table dept81_copy as select * from dept81;
select * from dept81_copy;
create table emp_copy(
empno number(38) primary key
,ename varchar2(20) not null
,job varchar2(20)
,sal number(38)
,comm number(38)
,deptno number(38)
);

insert into emp_copy values(201,'홍길동','관리사원',100,10,101);
insert into emp_copy values(202,'이순신','개발 사원',200,20,102);

select * from emp_copy;

create view em_view30 as select empno,ename,deptno from emp_copy where deptno=101;
select * from em_view30;

insert into em_view30 values(203,'신사임당님',102);
select * from emp_copy order by empno asc;

create table dept86(
deptno number(38) constraint dept86_deptno_pk primary key
,dname varchar2(50) constraint dept86_dname_nn not null
,LOC varchar2(50)
);

insert into dept86 values(10,'영업부','서울');

insert into dept86 values(20,'개발부','인천송도');

select * from dept86;
drop table emp86;
create table emp86(
empno number(38) constraint emp86_empno_pk primary key
,ename varchar2(30) constraint emp86_ename_nn not null
,SAL int
,job varchar(50)
,comm int
,deptno constraint emp86_deptno_fk references dept86(deptno)
);

insert into emp86 values(101,'이순신',3000,'영업사원',300,10);
insert into emp86 values(102,'강감찬',6000,'영업과장',600,10);
insert into emp86 values(103,'신사임당',6000,'인사과장',0,20);

select empno,ename,job,sal,comm,d.deptno,dname from dept86 d, emp86 e
where d.deptno=e.deptno and e.deptno=10 order by empno asc;

create view join_view
as
select empno,ename,job,sal,comm,d.deptno,dname from dept86 d, emp86 e
where d.deptno=e.deptno and e.deptno=10 order by empno asc;
select * from join_view;

create view del_view as select empno,ename from emp86;
select * from del_view;
drop view del_view;
select view_name from user_views;

create view re_view as select empno,ename from emp86;

select * from re_view;

create or replace view re_view as select empno,ename,sal from emp86;
select * from re_view;

create or replace force view for_view as select empno,ename from abc;
select view_name from user_views;

select * from emp86;

create or replace view view_check as select empno,ename,deptno from emp86 where deptno=20 with check option;

update view_check set deptno=10 where empno=103;

create or replace view only_view as select empno,ename,sal,comm,deptno from emp86 where deptno=20 with read only;

select * from only_view;
update only_view set comm=600 where empno=103;

create table emp92(
empno number(38) primary key
,ename varchar2(50)
,sal number(38)
);

insert into emp92 values(1,'홍길동',1000);

insert into emp92 values(2,'이순신',2000);

insert into emp92 values(3,'강감찬',3000);

select rownum,empno,ename,sal from emp92 order by empno desc;

create or replace view row_view as select empno,ename,sal from emp92 order by empno desc;
delete from emp92 where empno=2;

select rownum,empno,ename,sal from row_view;

select rownum,empno,ename,sal from row_view where rownum<=1;
select rownum,empno,ename,sal 
   from (select empno,ename,sal from emp92 order by empno desc)
where rownum <= 1;