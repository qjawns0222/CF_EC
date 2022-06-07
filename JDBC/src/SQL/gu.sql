create or replace procedure sel_gu
(
vno in tbl_guest.g_no%type,
vname out tbl_guest.g_name%type,
vtitle out tbl_guest.g_title%type,
vcont out tbl_guest.g_cont%type
)

is 
begin
    select g_name,g_title,g_cont into vname,vtitle,vcont from tbl_guest where g_no=vno;

end;
/