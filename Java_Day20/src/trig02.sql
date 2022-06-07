create or replace trigger trt02
after insert on emp01
for each row
begin 
insert into sal01 values(sal01_salno_seq.nextval,5000000,:new.empno);
end;
/