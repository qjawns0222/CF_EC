create table dept60(
deptno number(38) primary key
,dname varchar2(50) not null
,LOC varchar2(50)
);
select * from dept60;

insert into dept60 values(10,'개발부','서울');
insert into dept60 values(10,'개발부','판교');

insert into dept60 values(20,null,'부산');

select constraint_name,constraint_type,table_name from user_constraints where table_name in('DEPT60');
create table emp103(
empno number(10) unique
,ename varchar2(30) not null
,job varchar2(30)
,deptno number(38)
);

insert into emp103 values(502,'홍길동','인사부',40);
insert into emp103 values(502,'이순신','영업부',30);

insert into emp103 values(null,'강감찬','관리부',50);
insert into emp103 values(null,'신사임당','개발부',60);

select * from emp103 order by empno asc;

create table emp105(
empno number(10) constraint emp105_ename_pk primary key
,ename varchar2(30) constraint emp105_ename_nn not null
,job varchar2(30)
,deptno number(38)
);

select table_name,constraint_name from user_constraints where table_name in('EMP105');

insert into emp105 values(101,'james','sales',10);
insert into emp105 values(101,'smith','manager',20);

create table dept71(
deptno number(38) constraint dept71_deptno_pk primary key
,dname varchar2(100) constraint dept71_dname_nn not null
,LOC varchar2(100)
);

insert into dept71 values(10,'관리부','서울');
insert into dept71 values(20,'영업부','부산');
insert into dept71 values(30,'개발부','판교');
select * from dept71 order by deptno asc;
create table emp71(
empno number(38) constraint emp71_empno_pk primary key
,ename varchar2(50) constraint emp71_ename_nn not null
,job varchar2(50)
,deptno number(38) constraint emp71_empno_fk references dept71(deptno)
);
select * from dept71;
insert into emp71 values(11,'홍길동','관리사원',10);
insert into emp71 values(12,'이순시','영업사원',20);

select * from emp71 order by empno asc;

insert into emp71 values(13,'강감찬','경리원',50);

select table_name,constraint_type,constraint_name,r_constraint_name from user_constraints where table_name in('DEPT71','EMP71');
select * from dept71 inner join emp71 on dept71.deptno=emp71.deptno;
select * from emp71;


create table depart71(
deptcode varchar2(10) constraint depart71_deptcode_pk primary key
,deptname varchar2(20) constraint depart71_deptname_nn not null
);

insert into depart71 values('a001','영어교육과');
insert into depart71 values('k001','컴퓨터공학과');

select * from depart71 order by deptcode;

create table student71(
sno number(38) constraint student71_sno_pk primary key
,sname varchar2(30) constraint student71_sname_nn not null
,gender varchar2(10) constraint student71_gender_nn not null
,addr varchar2(200)
,deptcode varchar(10) constraint student71_deptcode_fk references depart71(deptcode)
);

insert into student71 values(1,'홍길동','남','서울시','a001');
insert into student71 values(2,'이순신','남','부산시','k001');

select  sno,sname,gender,addr,d.deptcode,deptname from depart71 d,student71 s where d.deptcode=s.deptcode;

select table_name,constraint_type,constraint_name,r_constraint_name from user_constraints where table_name in('DEPART71','STUDENT71');

create table emp73(
empno number(38) constraint emp73_empno_pk primary key
,ename varchar2(50) constraint emp73_ename_nn not null
,sal number(38) constraint emp73_sal_ck check(sal between 500 and 5000)
,gender varchar2(10) constraint emp73_gender_ck check(gender in('M','F'))
);

insert into emp73 values(7501,'신사임당님',7000,'F');
insert into emp73 values(7502,'강감찬',5000,'K');

create table dept73(
deptno number(38) primary key
,dname varchar2(30)
,LOC varchar2(30) default '서울'
);
insert into dept73(deptno,dname) values(10,'관리부');
select * from dept73;

create table emp76(
empno number(38)
,ename varchar2(50) not null
,job varchar2(50)
,deptno number(38)
,primary key(empno)
,unique(job)
,foreign key(deptno) references dept71(deptno)
);
create table emp77(
empno number(38)
,ename varchar2(50) constraint emp77_ename_nn not null
,job varchar2(50)
,deptno number(38)
,constraint emp77_empno_pk primary key(empno)
,constraint emp77_job_uk unique(job)
,constraint emp77_deptno_fk foreign key(deptno) references dept71(deptno)
);
select table_name,constraint_type,constraint_name,r_constraint_name from user_constraints where table_name='EMP77';

create table member01(
id varchar2(20)
,name varchar2(30)
,addr varchar2(100)
,phone varchar2(30)
,constraint member01_idPhone_pk primary key(id,phone)
);

select owner,constraint_name,table_name,column_name from user_cons_columns where table_name='MEMBER01';

create table emp78(
empno number(20)
,ename varchar2(30)
,job varchar2(30)
,deptno number(38)
);
alter table emp78 add constraint emp78_empno_pk primary key(empno);

alter table emp78 add constraint emp78_deptno_fk foreign key(deptno) references dept71(deptno);

alter table emp78 modify ename constraint emp78_ename_nn not null;
select table_name,constraint_name,constraint_type,r_constraint_name from user_constraints where table_name='EMP78';

insert into emp78 values(11,'이순신','관리사원',10);
insert into emp78 values(12,'홍길동','영업사원',20);
insert into emp78 values(13,'강감찬','관리사원',10);

alter table emp78 drop constraint emp78_empno_pk;
select * from emp78;
alter table emp78 drop constraint emp78_ename_nn;
select constraint_name from user_constraints where table_name='EMP78';

create table dept91(
deptno number(38) constraint dept91_deptno_pk primary key
,dname varchar2(50)
,LOC varchar2(50)
);
insert into dept91 values(10,'경리부','서울');
insert into dept91 values(20,'영업부','부산');

select * from dept91 order by deptno;
alter table dept91 add primary key(deptno);
------------------------------------------
create table emp91(
empno number(38) constraint emp91_empno_pk primary key
,ename varchar2(50) constraint emp91_ename_nn not null
,job varchar2(30)
,deptno number(38) constraint emp91_deptno_fk references dept91(deptno)
);

insert into emp91 values(11,'홍길동','경리과장',10);
insert into emp91 values(12,'이순신','영업부장',20);

select * from emp91 order by empno asc;

delete from dept91 where deptno=10;

alter table emp91 disable constraint emp91_deptno_fk;
select constraint_name,status from user_constraints where table_name='EMP91';

delete from dept91 where deptno=10;
select * from dept91;

alter table emp91 enable constraint emp91_deptno_fk;

insert into dept91 values(10,'경리부','서울');

create table dept81(
deptno number(38) constraint dept81_deptno_pk primary key
,dname varchar2(50)
,LOC varchar2(50)
);

insert into dept81 values(101,'관리부','서울');
insert into dept81 values(102,'개발부','제주도');

create table emp81(
empno number(38) constraint emp81_empno_pk primary key
,ename varchar2(50) constraint emp81_ename_nn not null
,job varchar2(50)
,deptno number(38) constraint emp81_deptno_fk references dept81(deptno)
);
insert into emp81 values(7001,'이순신','관리사원',101);
insert into emp81 values(7002,'강감찬','java 개발자',102);
select * from emp81;
select table_name,constraint_name,constraint_type,r_constraint_name,status from user_constraints where table_name in('DEPT81','EMP81');

alter table dept81 disable primary key cascade;

alter table dept81 drop primary key;

alter table dept81 drop primary key cascade;
