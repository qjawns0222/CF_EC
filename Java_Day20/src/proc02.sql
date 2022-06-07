create or replace procedure DEL_ENAME(vename emp.ename%type)
is
begin
delete from emp where ename=vename;
end;
/