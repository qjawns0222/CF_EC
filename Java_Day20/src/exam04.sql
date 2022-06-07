set serveroutput on
declare
type emp_record_type is record(
v_empno emp.empno%type,
v_ename emp.ename%type,
v_job emp.job%type,
v_deptno emp.deptno%type
);
emp_record emp_record_type;

begin
	select empno,ename,job,deptno into emp_record from emp where ename='강감찬';
	DBMS_OUTPUT.PUT_LINE('사원번호:'||emp_record.v_empno);
	DBMS_OUTPUT.PUT_LINE('사원이름:'||emp_record.v_ename);
	DBMS_OUTPUT.PUT_LINE('직종:'||emp_record.v_job);
	DBMS_OUTPUT.PUT_LINE('부서번호:'||emp_record.v_deptno);
end;
/