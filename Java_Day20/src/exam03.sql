set serveroutput on

declare
   /* 테이블 타입 정의 -> 배열로 선언되어 져서 인덱스 주소번호로 접근하여 값을 가져옴. */
   type ename_table_type is table of emp.ename%type index by binary_integer;
   type job_table_type is table of emp.job%type index by binary_integer; -- 2개의 ename_table_type, job_table_type 테이블 타입 정의
   
   --테이블 타입 변수 선언
   ename_table ename_table_type;
   job_table job_table_type; --ename_table, job_table 각 변수 정의
   
   i binary_integer := 0; --인덱스 주소번호 변수 선언과 초기화, :=은 대입연산자

begin
    --emp테이블로 부터 사원명과,직종을 가져와서 테이블 타입 배열변수에 각 저장
    for k in (select ename,job from emp) loop
        i := i+1; --1씩 증가
        ename_table(i) := k.ename; --사원명 저장
        job_table(i) := k.job; --직종 저장
    end loop; --반복문 끝
    
    DBMS_OUTPUT.PUT_LINE('사원이름   /    직종');
    DBMS_OUTPUT.PUT_LINE('=======================>');
    
    for j in 1..i loop
       DBMS_OUTPUT.PUT_LINE(ename_table(j)  ||  '   /  ' ||  job_table(j));
    end loop;
end;
/