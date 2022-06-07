set serverout on

declare
   --%type을 사용하면 테이블 생성시 정의한 컬럼 자료형 타입으로 자동 설정
   vempno emp.empno%type; --vempno 매개변수는 emp테이블의 empno컬럼 타입으로 설정
   vename emp.ename%type;
begin

    DBMS_OUTPUT.PUT_LINE('사번      /    사원이름');
    DBMS_OUTPUT.PUT_LINE('=============================>');
    
    select empno,ename into vempno,vename from emp where ename='홍길동'; --홍길동 사원의 사원번호와 이름을 검색해서 각 매개변수인
    --vempno,vename변수에 저장
    
    DBMS_OUTPUT.PUT_LINE(vempno  ||  '  /   '  ||  vename);
end;
/