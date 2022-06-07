set serveroutput on

declare
    vemp emp%rowtype;
    annsal number(7,2);

begin
select * into vemp from emp where ename='홍길동';
if(vemp.comm is null)then
annsal :=vemp.sal*12;
else
annsal:=vemp.sal*12+vemp.comm;
end if;
DBMS_OUTPUT.PUT_LINE('사번/사원이름/연봉');
DBMS_OUTPUT.PUT_LINE('========================>');
DBMS_OUTPUT.PUT_LINE(vemp.empno||'/'||vemp.ename||'/'||annsal);
end;
/