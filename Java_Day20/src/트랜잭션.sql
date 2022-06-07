create table dept51(
deptno number(38) primary key
,dname varchar2(50)
)
insert into dept51 values(101,'영업부');
insert into dept51 values(102,'인사부');

select * from dept51 order by deptno asc;
create table dept52 as select * from dept51;
select * from dept52 order by deptno asc;

create table dept53 as select * from dept52;

select * from dept53;

insert into dept53 values(101,'영업부');
insert into dept53 values(102,'인사부');
insert into dept53 values(103,'관리부');
insert into dept53 values(104,'경리부');

create table dept55 as select * from dept;

select * from dept55 order by deptno;

create table dept56 as select * from dept;

select * from dept56 order by deptno;

drop table dept56;