select sequence_name,increment_by from user_sequences;

create sequence dept_deptno_seq start with 1 increment by 1 nocache;
select dept_deptno_seq.nextval from dual;
select sysdate from dual;

create table emp_test(
empno number(38) primary key
,ename varchar2(50)
);
insert into emp_test values(dept_deptno_seq.nextval,'홍길동');
select * from emp_test order by empno;
create sequence dept_del_seq;

select sequence dept_del_seq;

drop sequence dept_del_seq;

create sequence dept_deptno_Seq2 start with 10 increment by 10 maxvalue 30;
select sequence_name,max_value,increment_by from user_sequences;
select dept_deptno_seq2.nextval from dual;
select dept_deptno_seq2.nextval from dual;
select dept_deptno_seq2.nextval from dual;
select dept_deptno_seq2.nextval from dual;

alter sequence dept_deptno_seq2 maxvalue 100;