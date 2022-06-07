create or replace package exam_pack -- exam_pack 패키지 정의
is
   function cal_bonus(vempno in emp.empno%type)  --함수명과 사원번호 인자값을 전달받을 변수 정의
    return number; --함수 호출후 반환 타입 정의
    
    procedure cursor_sample01; --저장 프로시저명 정의
end;
/

create or replace package body exam_pack -- exam_pack 패키지 몸체 문장 정의
is 
 function cal_bonus(vempno in emp.empno%type)
 return number
 
 is 
   vsal number(7,2); -- 급여을 저장할 실수 타입 변수 정의
   
 begin
   select sal into vsal from emp where empno=vempno;
   
   return (vsal*50);  --급여*50 한 값을 반환
 end;
 
 procedure cursor_sample01
 is
   vdept dept71%rowtype; --로우 타입 변수 정의(한행의 레코드 값을 저장)
   
   cursor c01 --커서 정의
   is
   select * from dept71; --테이블로 부터 레코드를 읽어서 커서에 저장
   
   begin
      DBMS_OUTPUT.PUT_LINE('deptno  / dname  / LOC');
      DBMS_OUTPUT.PUT_LINE('=========================>');
      
      open c01; --커서 열기
       LOOP --반복문 시작
         fetch c01 into vdept.deptno, vdept.dname, vdept.LOC; --커서로 부터 읽어온 것을 저장시킴
         
         exit when c01%NOTFOUND; --커서로 부터 더 이상 읽어올 값이 없다면 반복문 종료
         
         DBMS_OUTPUT.PUT_LINE(vdept.deptno  || ' /  '  || vdept.dname ||'  /  ' || vdept.LOC);
       
       END LOOP;  --반복문 종료
       CLOSE c01; --커서 닫기
 
 end;
 END;
 /
 