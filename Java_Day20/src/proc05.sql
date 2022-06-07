set serveroutput on
create or replace procedure cursor_sample01

is
vdept dept71%rowtype;
cursor c01
is
select  * from dept71;
begin
dbms_output.put_line('부서번호/부서이름/위치');
dbms_output.put_line('==========================>');
open c01;
    Loop
    fetch c01 into vdept.deptno,vdept.dname,vdept.LOC;
    exit when c01%notfound;
    dbms_output.put_line(vdept.deptno||'/'||vdept.dname||'/'||vdept.LOC);
    end loop;
 close c01;
end;
/

execute cursor_sample01;