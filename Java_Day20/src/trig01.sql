create or replace trigger trt_01

after insert on emp01

begin
dbms_output.put_line('welcome');
end;
/