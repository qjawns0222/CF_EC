create or replace trigger trt03
after delete on emp01
for each row
begin 
delete from sal01 where empno= :old.empno;
end;
/