set serveroutput on
declare
vemp emp%rowtype;
vdname varchar2(20):='';
begin
select * into vemp from emp where ename='홍길동';
if(vemp.deptno=10)then
vdname:='개발부';
elsif(vemp.deptno=20)then
vdname:='디자인부';
else
vdname:='영업부';
end if;
dbms_output.put_line('사원번호/사원이름/부서명');
dbms_output.put_line('==================>');
dbms_output.put_line(vemp.empno||'/'||vemp.ename||'/'||vdname);

end ;
/