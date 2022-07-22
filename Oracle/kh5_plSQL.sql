/*
PL/SQL : Procedural Language extention to SQL
-오라클 자체에 내장되어 있는 절차적 언어
- SQL 단점을 보완하여 문장 내 변수정의, 조건처리, 반복처리 등을 지원

ㅁ유형
1. 익명블록
    - 이름이 없는 블록, 간단한 블록 수행 시 사용
2. 프로시저(리턴이 없는 메소드)
    - 지정된 특정 처리르 실행하는 서브프로그램
3. 함수(리턴이 있는 메소드)
    - 프로시저와 거의 동일

ㅁ문법구조
DECLARE(선택적 선언부)
    - 변수 또는 상수를 선언하는 부분
    - 변수를 사용하지 않는 경우 생략 가능
BEGIN(실행부)
    - 제어문, 반복문, 함수정의 등 로직을 기술
    - 반드시 작성
EXCEPTION(예외 처리부)
    - 예외 상황 발생시 해결하기 위한 구문 작성
    - 생략 가능
END;(블록 종료)
/(PL/SQL 실행 및 종료)

*/
--실습
SET SERVEROUTPUT ON;


BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/



















