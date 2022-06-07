set serveroutput on

declare
  vempno number(10);
  vename varchar2(20); -- 2개의 변수 선언
  
begin

   vempno := 101; --사원번호 , := 이 PL-SQL문에서 대입연산자
   VENAME := '홍길동'; --PL-SQL문에서 문자열은 작은 따옴표로 처리
   
   DBMS_OUTPUT.PUT_LINE('사원번호   /  사원이름');
   dbms_output.put_line('======================>');
   DBMS_OUTPUT.PUT_LINE(vempno || ' / ' || vename);  -- 한줄 주석문 기호, ||는 PL-SQL문에서 문자열 연결 연산 기호
end;
/