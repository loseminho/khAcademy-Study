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

--PL/SQL을 시작 전 작동시켜줘야함
SET SERVEROUTPUT ON;


BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/

DECLARE
    ID NUMBER;
    NAME VARCHAR2(20);
    
BEGIN
    SELECT EMP_ID, EMP_NAME
    INTO ID, NAME    
    FROM EMPLOYEE
    WHERE EMP_NAME='선동일';
    DBMS_OUTPUT.PUT_LINE('사번 : '||ID);
    DBMS_OUTPUT.PUT_LINE('이름 : '||NAME);
END;
/

DECLARE
    NAME    VARCHAR2(20);
    D_CODE  VARCHAR2(20);
    J_CODE  VARCHAR2(20);
    
BEGIN
    SELECT EMP_NAME, DEPT_CODE, JOB_CODE
    INTO NAME,D_CODE,J_CODE
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드 : '||D_CODE);    
    DBMS_OUTPUT.PUT_LINE('직급코드 : '||J_CODE);  
    
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
END;
/

--사원번호 입력시 이름, 부서명, 직급명이 출력 되도록 익명블록작성

DECLARE
    NAME    VARCHAR2(20);
    D_NAME  VARCHAR2(20);
    J_NAME  VARCHAR2(20);
BEGIN
    SELECT EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO NAME,D_NAME,J_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
    JOIN JOB USING (JOB_CODE)
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||NAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : '||D_NAME);    
    DBMS_OUTPUT.PUT_LINE('직급명 : '||J_NAME);  
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
END;
/

/*
PL/SQL의 변수 선언 및 대입
변수이름    [CONSTANT]  자료형 [:= 초기값];
DECLARE
    NO  CONSTANT    NUM := 10; --상수인경우 변수 선언시 반드시 초기화 해주어야함.
    NAME    VARCHAR2(20);
    TEST    VARCHAR2(30) := 'TEST문구';

*/
--상수는 중간에 값 변경 불가.
DECLARE
    NAME    VARCHAR2(20) := '진민호';
    NUM     NUMBER;
    NUM1    CONSTANT NUMBER := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE(NAME); 
    NAME := '변경이름';
    DBMS_OUTPUT.PUT_LINE(NAME);
END;
/

--동일한 자료형 선언하기
/*
DECLARE
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    D_NAME  DEPARTMENT.DEPT_TITLE%TYPE;
    J_NAME  JOB.JOB_NAME%TYPE;
BEGIN
    SELECT EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO NAME,D_NAME,J_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    LEFT JOIN JOB USING(JOB_CODE)
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE(NAME);
    DBMS_OUTPUT.PUT_LINE(D_NAME);
    DBMS_OUTPUT.PUT_LINE(J_NAME);
END;
/
*/
--변수 테이블%ROWTYPE : 변수에 테이블의 모든 데이터 타입을 저장
SELECT * FROM EMPLOYEE;

DECLARE
    MYROW   EMPLOYEE%ROWTYPE;
BEGIN
    SELECT EMP_NAME, EMP_NO, EMAIL, DEPT_CODE, SALARY
    INTO MYROW.EMP_NAME,
    MYROW.EMP_NO,
    MYROW.EMAIL,
    MYROW.DEPT_CODE,
    MYROW.SALARY
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||MYROW.EMP_NAME );
    DBMS_OUTPUT.PUT_LINE('주민번호 : '||MYROW.EMP_NO );
    DBMS_OUTPUT.PUT_LINE('이메일 : '||MYROW.EMAIL );
    DBMS_OUTPUT.PUT_LINE('부서코드 : '||MYROW.DEPT_CODE );
    DBMS_OUTPUT.PUT_LINE('급여 : '||MYROW.SALARY );
END;
/

--사번 입력 시 이름, 부서명, 직급명, 급여, 이메일 출력
--RECORD ( 순서에 맞으면 하나하나 지명 안하고 RECORD 변수만 호출해주면 사용 가능)
-- 사번 입력 시 이름, 부서명, 직급명, 급여, 이메일 출력
DECLARE
    TYPE MY_RECORD IS RECORD( -- MY_RECORD 라는 자료형 선언
        NAME    EMPLOYEE.EMP_NAME%TYPE,
        D_NAME  DEPARTMENT.DEPT_TITLE%TYPE,
        J_NAME  JOB.JOB_NAME%TYPE,
        SAL     EMPLOYEE.SALARY%TYPE,
        EMAIL   EMPLOYEE.EMAIL%TYPE
    );
    MYRECORD MY_RECORD; -- 변수선언
BEGIN
    SELECT EMP_NAME,DEPT_TITLE,JOB_NAME,SALARY,EMAIL -- 순서와 갯수를 맞춰서
    INTO MYRECORD.NAME,MYRECORD.D_NAME,MYRECORD.J_NAME,MYRECORD.SAL,MYRECORD.EMAIL
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE =DEPT_ID)
    LEFT JOIN JOB USING (JOB_CODE)
    WHERE EMP_ID = '&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '|| MYRECORD.NAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : '|| MYRECORD.D_NAME);
    DBMS_OUTPUT.PUT_LINE('직급명 : '|| MYRECORD.J_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '|| MYRECORD.SAL);
    DBMS_OUTPUT.PUT_LINE('이메일 : '|| MYRECORD.EMAIL);
END;
/
/*
실습문제 1 -
사번, 사원명, 직급코드, 급여를 담을 수 있는 참조 변수를 통해
송중기 사원의 사번, 사원명, 직급코드, 급여를 익명블럭을 통해 스크립트 출력
실습문제 2 -
사번, 사원명, 부서명, 직급명을 담을 수 있는 참조변수를 통해서
사원명을 검색하여 해당 사원의 사번, 사원명, 부서명, 직급명을
익명 블럭을 통해 스크립트 출력하시오
실습문제 3 - 
사원번호를 입력하여 해당 사원을 찾아
사원명, 주민번호, 입사일, 부서명을
익명블럭을 통해 스크립트 출력하시오.
*/
--실습 1번
DECLARE
    ID      EMPLOYEE.EMP_ID%TYPE;
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    D_NAME  EMPLOYEE.JOB_CODE%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
    INTO ID, NAME, D_NAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('사번 : '||ID);
    DBMS_OUTPUT.PUT_LINE('사원명 : '||NAME);
    DBMS_OUTPUT.PUT_LINE('직급코드 : '||D_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
END;
/
--실습 2번
DECLARE
    TYPE MY_RECORD IS RECORD(
        ID      EMPLOYEE.EMP_ID%TYPE,
        NAME    EMPLOYEE.EMP_NAME%TYPE,
        D_NAME  DEPARTMENT.DEPT_TITLE%TYPE,
        J_NAME  JOB.JOB_NAME%TYPE
    );
    MYRECORD MY_RECORD;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO MYRECORD
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
    LEFT JOIN JOB USING (JOB_CODE)
    WHERE EMP_NAME='&사원명';
    DBMS_OUTPUT.PUT_LINE('사번 : '||MYRECORD.ID);
    DBMS_OUTPUT.PUT_LINE('사원명 : '||MYRECORD.NAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : '||MYRECORD.D_NAME);
    DBMS_OUTPUT.PUT_LINE('직급명 : '||MYRECORD.J_NAME);
END;
/
DECLARE
    MYROW   EMPLOYEE%ROWTYPE;
    MYROW_D DEPARTMENT%ROWTYPE;
BEGIN
    SELECT EMP_NAME, EMP_NO, HIRE_DATE, DEPT_TITLE
    INTO MYROW.EMP_NAME,
        MYROW.EMP_NO,
        MYROW.HIRE_DATE,
        MYROW_D.DEPT_TITLE
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('사번 : '||MYROW.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('사원명 : '||MYROW.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('직급코드 : '||MYROW.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('급여 : '||MYROW_D.DEPT_TITLE);
END;
/


/*
PL/SQL 선택문
*/
-- 사원번호 가지고 이름, 급여, 보너스율 출력
-- 보너스를 받지 않으면 '보너스가 없습니다.' 출력
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    BO      EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY, NVL(BONUS,0)
    INTO E_NAME,SAL,BO
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
    IF(BO = 0)
    THEN DBMS_OUTPUT.PUT_LINE('보너스가 없습니다.');
    ELSE DBMS_OUTPUT.PUT_LINE('보너스 : '||(BO*100)||'%');
    END IF;
END;
/

--사번을 입력 받은 후 급여에 따라서 등급을 나눔
-- 이름, 급여, 급여등급(0~99 :F, 100~199 :E, 200~299 : D,....)
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY
    INTO E_NAME,SAL
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
    IF(0<=SAL AND SAL<1000000)
    THEN DBMS_OUTPUT. PUT_LINE('등급 : F');
    ELSIF(1000000<=SAL AND SAL<2000000)
    THEN DBMS_OUTPUT.PUT_LINE('등급 : D');
    ELSIF(2000000<=SAL AND SAL<3000000)
    THEN DBMS_OUTPUT.PUT_LINE('등급 : E');
    ELSIF(3000000<=SAL AND SAL<4000000)
    THEN DBMS_OUTPUT.PUT_LINE('등급 : C'); 
    ELSIF(4000000<=SAL AND SAL<5000000)
    THEN DBMS_OUTPUT.PUT_LINE('등급 : B');
    ELSE DBMS_OUTPUT.PUT_LINE('등급 : A');
    END IF;
END;
/
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    SAL_GRADE CHAR(1);
BEGIN
    SELECT EMP_NAME, SALARY
    INTO E_NAME,SAL
    FROM EMPLOYEE
    WHERE EMP_ID = '&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
    SAL :=  SAL/10000;
    IF(0<=SAL AND SAL<100) THEN SAL_GRADE := 'F';
    ELSIF (100<=SAL AND SAL<200) THEN SAL_GRADE := 'E';
    ELSIF (200<=SAL AND SAL<300) THEN SAL_GRADE := 'D';
    ELSIF (300<=SAL AND SAL<400) THEN SAL_GRADE := 'C';
    ELSIF (400<=SAL AND SAL<500) THEN SAL_GRADE := 'B';
    ELSE SAL_GRADE := 'A';
    END IF;
    DBMS_OUTPUT.PUT_LINE('등급 : '||SAL_GRADE);
END;
/
/*
실습문제 1
사원번호를 입력받아서 사원의 사번,이름,급여,보너스율을 출력.
직급이 대표인 경우, '저희회사 대표님이십니다.'를 출력.
*/
DECLARE
    MYROW   EMPLOYEE%ROWTYPE;
BEGIN
    SELECT EMP_ID,EMP_NAME,SALARY,BONUS
    INTO MYROW.EMP_ID,MYROW.EMP_NAME,MYROW.SALARY,MYROW.BONUS
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    IF(MYROW.EMP_ID=200)
    THEN DBMS_OUTPUT.PUT_LINE('저희 회사 대표님이십니다');
    ELSE 
    DBMS_OUTPUT.PUT_LINE('사번 : '||MYROW.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : '||MYROW.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||MYROW.SALARY);
    DBMS_OUTPUT.PUT_LINE('보너스율 : '||(MYROW.BONUS*100)||'%');
    END IF;
END;
/
-- %TYPE으로 다시
DECLARE
    E_ID        EMPLOYEE.EMP_ID%TYPE;
    E_NAME      EMPLOYEE.EMP_NAME%TYPE;
    SAL         EMPLOYEE.SALARY%TYPE;
    BO          EMPLOYEE.BONUS%TYPE;
    J_NAME      JOB.JOB_NAME%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY,NVL(BONUS,0)*100,JOB_NAME
    INTO E_ID, E_NAME, SAL, BO, J_NAME
    FROM EMPLOYEE
    JOIN JOB USING(JOB_CODE)
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('사번 : '||E_ID);
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
    DBMS_OUTPUT.PUT_LINE('보너스율 : '||BO||'%');
    IF(J_NAME='대표')
    THEN DBMS_OUTPUT.PUT_LINE('대표입니다.');
    END IF;
END;
/
/*
실습문제 2
해당 사원 번호를 입력받아 해당 사원이 소속된 부서에서 
가장 높은 급여를 받고 있는 사원을 출력하여라
출력 값은 검색된 사원명, 검색된 사원 부서,  소속부서에서 가장 높은 급여를 받은 사원명 및 급여,부서 정보를 출력 하여라.
ex) 
사원번호 '207'번을 입력시

### 검색된 사원 정보 ###
검색된 사원명 : 하이유
소속된 부서명 : 해외영업1부
-------------------------------
### 해외영업1부에서 급여가 가장 높은 사원 정보 ###
사원명 : 대북혼
급여 : 3760000 원
소속된 부서 : 해외영업1부
*/
SELECT * FROM EMPLOYEE;
SELECT EMP_NAME FROM EMPLOYEE WHERE SALARY=9000000;
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    D_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    TOPNAME VARCHAR(40);
    TOPSALARY NUMBER;
BEGIN
    SELECT EMP_NAME,
    DEPT_TITLE,
    SALARY,
    (SELECT MAX(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=DEPT_ID) AS TOPSALARY,
    (SELECT EMP_NAME FROM EMPLOYEE WHERE SALARY=(SELECT MAX(SALARY) FROM EMPLOYEE WHERE DEPT_CODE=DEPT_ID))AS TOPMAN
    INTO E_NAME, D_TITLE, SAL,TOPSALARY, TOPNAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)
    WHERE EMP_ID='&사원번호';
    DBMS_OUTPUT.PUT_LINE('### 검색된 사원 정보 ###');
    DBMS_OUTPUT.PUT_LINE('사원이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('부서명 : '||D_TITLE);
    DBMS_OUTPUT.PUT_LINE('--------------------------');
    IF(D_TITLE IS NOT NULL)
    THEN
    DBMS_OUTPUT.PUT_LINE('###'||D_TITLE||'에서 급여가 가장 높은 사원 정보 ###');
    DBMS_OUTPUT.PUT_LINE('사원명 : '||TOPNAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||TOPSALARY);
    ELSE
    DBMS_OUTPUT.PUT_LINE('부서에 들어있지 않습니다.');
    END IF;
END;
/
--MAX_SAL EMPLOYEE.SALART%TYPE;
-- SELECT MAX(SALARY)FROM EMPLOYEE JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID) WHERE DEPT_TITLE = D_NAME;
-- SELECT EMP_NAME INTO MAX_E_NAME FROM EMPLOYEE WHERE SALARY = MAXSAL;

SELECT * FROM EMPLOYEE;

DECLARE
    SEARCH_NAME     EMPLOYEE.EMP_NAME%TYPE;
    DEPT_NAME       DEPARTMENT.DEPT_TITLE%TYPE;
    MAX_SAL         EMPLOYEE.SALARY%TYPE;
    MAX_NAME        EMPLOYEE.EMP_NAME%TYPE;
BEGIN
    SELECT EMP_NAME, DEPT_TITLE
    INTO SEARCH_NAME, DEPT_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = '&사번';
    
    IF(DEPT_NAME IS NOT NULL)
    THEN
        SELECT MAX(SALARY)
        INTO MAX_SAL
        FROM EMPLOYEE
        LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
        WHERE DEPT_TITLE = DEPT_NAME; -- 변수에 있는 값과 부서 이름 비교
    ELSE -- 부서코드가 NULL인 경우
        SELECT MAX(SALARY)
        INTO MAX_SAL
        FROM EMPLOYEE
        WHERE DEPT_CODE IS NULL;
        DEPT_NAME := '부서없음';
    END IF;
    
    SELECT EMP_NAME
    INTO MAX_NAME
    FROM EMPLOYEE
    WHERE SALARY = MAX_SAL; -- 변수에 있는 값과 급여 비교
    
    DBMS_OUTPUT.PUT_LINE('=== 검색한 사원 정보 ===');
    DBMS_OUTPUT.PUT_LINE('검색한 사원명 : '||SEARCH_NAME);
    DBMS_OUTPUT.PUT_LINE('소속된 부서명 : '||DEPT_NAME);
    DBMS_OUTPUT.PUT_LINE('-------------------------------------');
    DBMS_OUTPUT.PUT_LINE('==='||DEPT_NAME||'에서 급여가 가장 높은 사원 정보'||'===');
    DBMS_OUTPUT.PUT_LINE('사원명 : '||MAX_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||MAX_SAL);
    DBMS_OUTPUT.PUT_LINE('소속된 부서명 : '||DEPT_NAME);
END;
/

/*
ㅁ반복문 
BASIC LOOP : 조건없이 무한 반복
*/
DECLARE
    NUM NUMBER :=1;
BEGIN
    LOOP        --반복 시작
        DBMS_OUTPUT.PUT_LINE(NUM);
        NUM :=NUM+1;
        IF(NUM>5)
        THEN EXIT;
        END IF;
    END LOOP;  --반복 끝
END;
/

-- FOR LOOP : 반복 횟수를 지정해서 반복,
DECLARE
BEGIN
    --IN 이 아닌 REVERSE 사용 시 가장 끝 값부터 앞까지 루프
    FOR NUM IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
END;
/

-- WHILE LOOP : 조건식이 TRUE인 동안 반복하는 반복문
-- 단, 처음에 조건식이 FALSE인경우 한번도 실행 하지 않을 수 있음
DECLARE
    NUM     NUMBER := 1;
BEGIN
    WHILE (NUM<=5) LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
        NUM := NUM + 1;
    END LOOP;
END;
/

--전직원 이름 및 급여 LOOP로 출력해보기
DECLARE
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    FOR NUM IN 0..22 LOOP
        SELECT EMP_NAME, SALARY
        INTO NAME, SAL
        FROM EMPLOYEE
        WHERE EMP_ID=200+NUM;
        DBMS_OUTPUT.PUT_LINE('이름 : '|| NAME);
        DBMS_OUTPUT.PUT_LINE('급여 : '|| SAL);
    END LOOP;
END;
/

CREATE TABLE LOOP_TEST(
    EMP_NAME    VARCHAR2(20),
    DEPT_TITLE  VARCHAR2(30),
    JOB_NAME    VARCHAR2(30),
    SALARY      NUMBER
);
-- PL/SQL 반복문을 활용하여 데이터 입력
-- JOIN이나 SUBQUERY 사용 안함
-- 부서코드 없는 직원은 '부서없음'으로 부서명 입력.
-- 1. 사번을 이용해서 EMPLOYEE 테이블에서 필요한 정보 조회
-- 2. 1번의 조회 결과를 이용해서 DEPARTMENT, JOB에서 추가 정보 조회
-- 3. 1,2번의 조회 결과를 이용하여  FCV문 작성
-- 4. 모든 INSERT가 종료되면 COMMIT;
DECLARE
    EMP     EMPLOYEE%ROWTYPE;
    D_NAME  DEPARTMENT.DEPT_TITLE%TYPE;
    J_NAME  JOB.JOB_NAME%TYPE;
BEGIN  
    FOR NUM IN 0..22 LOOP
        SELECT EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
        INTO EMP.EMP_NAME, EMP.DEPT_CODE, EMP.JOB_CODE, EMP.SALARY
        FROM EMPLOYEE
        WHERE EMP_ID =200+NUM;
        
        IF(EMP.DEPT_CODE IS NULL)
        THEN
            D_NAME := '부서없음';
        ELSE
            SELECT DEPT_TITLE
            INTO D_NAME
            FROM DEPARTMENT
            WHERE DEPT_ID = EMP.DEPT_CODE;
        END IF;
        
        SELECT JOB_NAME
        INTO J_NAME
        FROM JOB
        WHERE JOB_CODE = EMP.JOB_CODE;
        
        INSERT INTO LOOP_TEST 
        VALUES(EMP.EMP_NAME, D_NAME, J_NAME, EMP.SALARY);
    END LOOP;
    COMMIT;
END;
/



DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    BO      EMPLOYEE.BONUS%TYPE;
BEGIN 
    SELECT EMP_NAME, SALARY, 100*NVL(BONUS, 0)
    INTO E_NAME,SAL, BO
    FROM EMPLOYEE
    WHERE EMP_ID='&사번';
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
    DBMS_OUTPUT.PUT_LINE('보너스 : '||BO||'%');
    
EXCEPTION
/*
    WHEN 예외이름1 THEN 처리할 문장1;
    WHEN 예외이름2 THEN 처리할 문장2;
*/
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('직원 정보를 조회할 수 없습니다.');
END;
/
--------------------------------------------------------
/*
PROCEDURE(프로시저)
->  일련의 작업 절차를 정리해서 저장해 둔 것
->  여러 SQL문을 묶어서 미리 정의하고 하나의 요청으로 실행
->  자주 사용되는 복잡한 작업들을 만들어두고 간단하게 사용이 가능
->  (자바에서)return void인 자바 메소드와 비슷

프로시저 만드는  방법
CREATE [OR REPLACE] 
PROCEDURE 프로시저이름(매개변수1 [변수타입] 자료형, 매개변수2 자료형,..)
IS
    지역변수 선언 영역
BEGIN
    실행 문장
END;
/
--프로시저 매개변수
1. 만약에 매개변수가 없으면 프로시저 이름까지만 작성하고 IS 구문으로 넘어감
    ex)
    CREATE PROCEDURE  프로시저이름
    IS
2. 매개변수의 자료형 입력 시 길이는 작성하지 않음(길이 작성 시 에러발생)
    ex)
    CREATE PROCEDURE 프로시저 이름(STR VARCHAR2) -> 길이 작성X
    IS
3. 변수타입 키워드 [IN|OUT|INOUT]
    -> IN : 데이터를 전달 받을때 사용
    -> OUT : 결과를 받아갈 때 사용
    -> INOUT : IN, OUT 두가지 목적으로 모두 사용 가능(실제로 거의 안씀)
*/

--매개변수가 없는 프로시저 생성
CREATE OR REPLACE PROCEDURE TEST_PRO_1
IS
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY
    INTO NAME,SAL
    FROM EMPLOYEE
    WHERE EMP_ID=200;
    DBMS_OUTPUT.PUT_LINE('이름 : '||NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
END;
/
--프로시저 사용
EXECUTE TEST_PRO_1;
EXEC TEST_PRO_1;

--매개변수가 있는 프로시저 생성
CREATE OR REPLACE PROCEDURE TEST_PRO_2(E_NAME VARCHAR2)
IS
    D_CODE EMPLOYEE.DEPT_CODE%TYPE;
    J_CODE EMPLOYEE.JOB_CODE%TYPE;
    SAL    EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT DEPT_CODE, JOB_CODE, SALARY
    INTO D_CODE, J_CODE, SAL
    FROM EMPLOYEE
    WHERE EMP_NAME =E_NAME;
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('부서코드 : '||D_CODE);
    DBMS_OUTPUT.PUT_LINE('직급코드 : '||J_CODE);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL);
END;
/
--프로시저 사용
EXEC TEST_PRO_2('하동운');


CREATE OR REPLACE PROCEDURE
TEST_PRO_3(E_NAME1 IN VARCHAR2, E_NAME2 IN EMPLOYEE.EMP_NAME%TYPE)
IS
    SAL1    EMPLOYEE.SALARY%TYPE;
    SAL2    EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT SALARY
    INTO SAL1
    FROM EMPLOYEE WHERE EMP_NAME=E_NAME1;
    SELECT SALARY
    INTO SAL2
    FROM EMPLOYEE WHERE EMP_NAME=E_NAME2;
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME1);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL1);
    DBMS_OUTPUT.PUT_LINE('이름 : '||E_NAME2);
    DBMS_OUTPUT.PUT_LINE('급여 : '||SAL2);
END;
/
EXEC TEST_PRO_3('선동일','하이유');

-- OUT 변수
CREATE OR REPLACE PROCEDURE TEST_PRO_4(
    E_NAME IN VARCHAR2,
    D_NAME OUT VARCHAR2
)
IS
    D_CODE  EMPLOYEE.DEPT_CODE%TYPE;
BEGIN
    SELECT DEPT_CODE
    INTO D_CODE
    FROM EMPLOYEE WHERE EMP_NAME = E_NAME;
    
    SELECT DEPT_TITLE
    INTO D_NAME
    FROM DEPARTMENT WHERE DEPT_ID=D_CODE;
END;
/

DROP PROCEDURE TEST_PRO_4;

DECLARE
    D_TITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    --PL/SQL 내부에서 프로시저 사용시 EXEC키워드를 사용하지 않음
    TEST_PRO_4('하이유',D_TITLE);
    DBMS_OUTPUT.PUT_LINE(D_TITLE);
END;
/


CREATE TABLE EMP_PRO_TEST
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, SALARY
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
LEFT JOIN JOB USING (JOB_CODE)
ORDER BY 1;
SELECT * FROM EMP_PRO_TEST;
-- 1. 프로시저 생성
-- >매개변수로 사번을 받아서 해당 직원을 EMP_PRO_TEST테이블에서 삭제 한 뒤
-- >COMMIT;
CREATE OR REPLACE PROCEDURE EMP_PRO_TEST_DELETE(E_ID IN VARCHAR2)
IS
BEGIN
    DELETE FROM EMP_PRO_TEST
    WHERE EMP_ID=E_ID;
    COMMIT;
END;
/
EXEC EMP_PRO_TEST_DELETE('205');



/*
1. 신규 테이블 생성 (테이블명 DEL_EMP)
    > 사번, 이름, 부서명, 직급명, 퇴사일 저장할 컬럼 존재
2. DEL_EMP_PRO2 프로시저 생성
    > 매개변수로 사번을 받음
    > 매개변수로 받은 사원정보를 EMP_PRO_TEST테이블에서 삭제
    > EMP_PRO_TEST 테이블 삭제 전에 필요한 정보를 조회해서
    > DEL_EMP에 INSERT 한 후 삭제( 퇴사일은 SYSDATE로 입력)
    > 작업이 잘 되면, COMMIT.
*/
SELECT * FROM EMP_PRO_TEST;
CREATE TABLE DEL_EMP(
    DEL_E_ID        VARCHAR2(10),
    DEL_E_NAME      VARCHAR2(20),
    DEL_D_TITLE     VARCHAR2(20),
    DEL_J_NAME      VARCHAR2(20),
    DEL_END_DATE    DATE
);

CREATE OR REPLACE PROCEDURE DEL_EMP_PRO2(E_ID IN VARCHAR2)
IS
    EMP EMP_PRO_TEST%ROWTYPE;
BEGIN
    SELECT EMP_NAME, DEPT_TITLE, JOB_NAME
    INTO EMP.EMP_NAME,
    EMP.DEPT_TITLE,
    EMP.JOB_NAME
    FROM EMP_PRO_TEST
    WHERE EMP_ID = E_ID;
    INSERT INTO DEL_EMP VALUES
    (E_ID,
    EMP.EMP_NAME,
    EMP.DEPT_TITLE,
    EMP.JOB_NAME,
    SYSDATE);
    DELETE FROM EMP_PRO_TEST
    WHERE EMP_ID = E_ID;
    COMMIT;
END;
/

SELECT * FROM EMP_PRO_TEST;
SELECT * FROM DEL_EMP;
EXEC DEL_EMP_PRO2('207');

/*
FUNCTION : 프로시저와 거의 유사
> 리턴이 반드시 존재
> IN|OUT 타입 변수 사용 X

함수 작성 방법
CREATE [OR REPLACE] FUNCTION 함수이름(매개변수1 자료형, 매개변수2 자료형..)
RETURN 리턴자료형
IS
BEGIN
END;
/
*/
-- 부서코드를 받아서 해당하는 부서명을 조회하는 함수 생성
CREATE OR REPLACE FUNCTION GET_DEPT(D_CODE VARCHAR2)
RETURN DEPARTMENT.DEPT_TITLE%TYPE
IS
    D_NAME DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT DEPT_TITLE
    INTO D_NAME
    FROM DEPARTMENT
    WHERE DEPT_ID = D_CODE;
    RETURN D_NAME;
END;
/

SELECT GET_DEPT('D9') FROM DUAL;
--JOIN을 사용하지 않아도 조회 가능.
SELECT EMP_NAME, DEPT_CODE, GET_DEPT(DEPT_CODE) FROM EMPLOYEE;

-- 급여랑 보너스를 매개변수로 받아서 연봉을 계산해서 리턴
CREATE OR REPLACE FUNCTION GET_YEAR_SAL(
    SAL NUMBER,
    BO  NUMBER
)
RETURN NUMBER
IS
    YEAR_SAL    NUMBER;
BEGIN
    YEAR_SAL := (SAL+SAL*BO)*12;
    RETURN YEAR_SAL;
END;
/
SELECT GET_YEAR_SAL(50000000,0.1) FROM DUAL;
SELECT EMP_NAME, SALARY, GET_YEAR_SAL(SALARY,NVL(BONUS,0)) FROM EMPLOYEE;

--매개변수로 사번 받아서 해당 사원 연봉을 리턴하는 함수.
CREATE OR REPLACE FUNCTION GET_YEAR_SAL2(
    E_ID    NUMBER
)
RETURN NUMBER
IS
    SAL EMPLOYEE.SALARY%TYPE;
    BO  EMPLOYEE.BONUS%TYPE;
    YEAR_SAL NUMBER;
BEGIN
    SELECT SALARY, NVL(BONUS, 0)
    INTO SAL,BO
    FROM EMPLOYEE WHERE EMP_ID=E_ID;
    YEAR_SAL := (SAL+SAL*BO)*12;
    RETURN YEAR_SAL;
END;
/
SELECT EMP_NAME, GET_YEAR_SAL2(EMP_ID) FROM EMPLOYEE;

/*
TRIGGER : 미리 정해놓은 조건을 만족하거나 수행되면 자동적으로 수행되는 행동
    > 특정 테이블이나 뷰에 INSERT,UPDATE,DELETE의 의해
    > 입력, 수정, 삭제가 되는 경우 자동으로 실행
*/
-- 회원 정보를 저장하는 테이블
CREATE TABLE M_TBL(
    MEMBER_ID   VARCHAR2(20) PRIMARY KEY,   --아이디
    MEMBER_PW   VARCHAR2(30) NOT NULL,      --비밀번호
    MEMBER_NAME VARCHAR2(20) NOT NULL,      --이름
    ENROLL_DATE DATE                        --가입일
);
-- M_TBL에 정보가 변경되면 변경이력을 저장하는 테이블(비밀번호)
CREATE TABLE M_LOG(
    MEMBER_ID   VARCHAR2(20)    REFERENCES M_TBL ON DELETE CASCADE,
    CHANGE_CONTENT VARCHAR2(100), --비밀번호 변경내역
    CHANGE_DATE DATE              --변경 날짜
);
-- M_TBL에서 회원이 탈퇴 시 탈퇴 이력을 저장하는 테이블
CREATE TABLE DEL_M_TBL(
    --외래키를 걸어선 안됨.(다른 테이블에서 정보가 삭제되도 남아야야함)
    MEMBER_ID   VARCHAR2(20)    PRIMARY KEY,
    MEMBER_NAME VARCHAR2(20),
    ENROLL_DATE DATE,
    OUT_DATE    DATE
);
/*
FOR EACH ROW가 있는 경우엔,
업데이트문 동작 -> 5개의 행이 수정된 경우, 트리거가 5회 동작
FOR EACH ROW가 없는 경우엔,
업데이트문 동작 -> 5개의 행이 수정된 경우에도 트리거가 1회 동작

ㅁ트리거 작성 틀
CREATE [OR REPLACE] TRIGGER 트리거이름
동작시점    동작DML   (AFTER INSERT)
ON 대상 테이블
[FOR EACH ROW] -- 트리거 종류 구분(변경된 행의 수 만큼 트리거 동작)
BEGIN
    --실행 코드  영역
END;
/
바인드변수(FOR EACH ROW를 사용할 때만 사용가능한 변수)
:NEW    - SQL문으로 새로 입력된 데이터
:OLD    - SQL문으로 변경되기 전 데이터
:NEW.컬럼명
:OLD.컬럼명
*/
-- M_TBL에 회원이 INSERT되면 '회원이 추가되었습니다.'메세지 출력하는 트리거 생성
CREATE OR REPLACE TRIGGER M_TBL_INSERT_TRG
AFTER INSERT
ON M_TBL
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.MEMBER_NAME||'회원이 추가되었습니다.');
END;
/
INSERT INTO M_TBL VALUES('user01','1111','유저1',SYSDATE-1);
COMMIT;
INSERT INTO M_TBL VALUES('user02','2222','유저2',SYSDATE-1);
COMMIT;
INSERT INTO M_TBL VALUES('user03','3333','유저3',SYSDATE-1);

-- M_TBL에서 비밀번호를 변경하면 변경이력을 M_LOG TBL에 INSERT
CREATE OR REPLACE TRIGGER M_TBL_PW_TRG
AFTER UPDATE
ON M_TBL
FOR EACH ROW
BEGIN
    INSERT INTO M_LOG 
    VALUES(:OLD.MEMBER_ID, :OLD.MEMBER_PW||'-->'||:NEW.MEMBER_PW, SYSDATE);
END;
/
SELECT * FROM M_TBL;
UPDATE M_TBL SET MEMBER_PW='1234' WHERE MEMBER_ID='user01';
SELECT * FROM M_LOG;

-- M_TBL에서 데이터 삭제 시 DEL_M_TBL에 데이터를 INSERT하는 트리거
CREATE OR REPLACE TRIGGER M_TBL_DEL_TRG
AFTER DELETE
ON M_TBL
FOR EACH ROW
BEGIN
    INSERT INTO DEL_M_TBL
    VALUES(:OLD.MEMBER_ID,:OLD.MEMBER_NAME,:OLD.ENROLL_DATE,SYSDATE);
END;
/
SELECT * FROM M_TBL;
DELETE FROM M_ TBL WHERE MEMBER_ID='user03';
SELECT * FROM DEL_M_TBL;
COMMIT;

CREATE TABLE PRODUCT(
    PCODE   NUMBER          PRIMARY KEY,    -- 상품코드
    PNAME   VARCHAR2(50)    NOT NULL,       -- 상품이름
    PRICE   NUMBER,                         -- 가격
    STOCK   NUMBER                          -- 재고
);
CREATE TABLE PRO_DETAIL(
    DCODE   NUMBER      PRIMARY KEY,                --입/출고 번호
    PCODE   NUMBER  REFERENCES PRODUCT,             --상품코드
    D_DATE  DATE,                                   --입/출고 날짜
    AMOUNT  NUMBER,                                 --입/출고 수량
    STATUS  CHAR(6) CHECK(STATUS IN ('입고','출고'))  --구분
);
INSERT INTO PRODUCT
VALUES(PCODE_SEQ.NEXTVAL,'마사지볼','10000',20);
INSERT INTO PRODUCT
VALUES(PCODE_SEQ.NEXTVAL,'핸드크림',15000,10);
CREATE SEQUENCE PCODE_SEQ;
CREATE SEQUENCE DCODE_SEQ;
SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;
COMMIT;
INSERT INTO PRO_DETAIL
VALUES(DCODE_SEQ.NEXTVAL,2,SYSDATE,10,'입고');
INSERT INTO PRO_DETAIL
VALUES(DCODE_SEQ.NEXTVAL,1,SYSDATE,5,'출고');


CREATE OR REPLACE TRIGGER PRO_TRG
AFTER INSERT
ON PRO_DETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = '입고')
    THEN 
        UPDATE PRODUCT SET STOCK = STOCK + :NEW.AMOUNT WHERE PCODE=:NEW.PCODE;
    ELSE
        UPDATE PRODUCT SET STOCK = STOCK - :NEW.AMOUNT WHERE PCODE=:NEW.PCODE;
    END IF;
END;
/
COMMIT;























































