--테이블 합병을 위한 원본 테이블 생성
drop table emp;

create table emp(
   empno number(38) primary key--사원번호
   ,ename varchar2(100)--사원명
   ,job varchar2(50)--직종
   ,sal number(38)--급여
   ,deptno number(38)--부서번호
);

insert into emp values(101, '홍길동', '개발부' ,5000 ,10);
insert into emp values(102, '이순신', '개발부' ,5000 ,10);
insert into emp values(103, '강감찬', '디자인부' ,3000 ,20);

select * from emp order by empno asc;

drop table emp01;

--복제 테이블 생성
create table emp01 as select * from emp;

select * from emp01 order by empno desc;

drop table emp02;

create table emp02 as select *from emp where job='개발부';

select * from EMP02;

--모든 레코드 job 필드 레코드 값 변경
update emp02 set job='test';
insert into emp02 values(104, '신사임당', 'top' ,3000,30);

--테이블 병합=>merge
merge into emp01
using emp02
on(emp01.empno=emp02.empno)
when matched then
update set
   emp01.ename=emp02.ename,
   emp01.job=emp02.job,
   emp01.sal=emp02.sal,
   emp01.deptno=emp02.deptno
   
when not matched then--기존 레코드가 없는경우 insert
insert values(emp02.empno, emp02.ename, emp02.job, emp02.sal, emp02.deptno);