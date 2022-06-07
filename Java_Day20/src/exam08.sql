set serveroutput on 
declare
i number(38):=1;
begin
	loop
	dbms_output.put_line(i);
	i:=i+1;
	if i>5 then
	exit;
	end if;
	end loop;
end;
/