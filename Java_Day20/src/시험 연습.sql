

//1번
create table boardT7(
b_no number(38) primary key , 
b_name varchar2(50), 
b_title  varchar2(200), 
b_cont varchar2(4000),
b_date date
);
//2번
sqlplus system/123456
create tablespace night13 datafile 'C:\app\ko022\product\21c\oradata\XE\night13.dbf' size 200M;

alter session set "_oracle_script"=true;
create user night13 identified by night13;
grant create session to night13;
conn night13/night13;
show user;

//3번
create table emp100(
empno number(38) primary key,
ename varchar2(40) not null,
sal number(38),
deptno number(38)
);
insert into emp100 values(1,'굴루루',2000,1);
insert into emp100 values(2,'굴롤',3000,2);
insert into emp100 values(3,'굴라라',1000,2);
insert into emp100 values(4,'굴리리',1500,1);
select * from emp100 where sal>=2000;





















