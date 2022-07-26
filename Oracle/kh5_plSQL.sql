/*
PL/SQL : Procedural Language extention to SQL
-����Ŭ ��ü�� ����Ǿ� �ִ� ������ ���
- SQL ������ �����Ͽ� ���� �� ��������, ����ó��, �ݺ�ó�� ���� ����

������
1. �͸���
    - �̸��� ���� ���, ������ ��� ���� �� ���
2. ���ν���(������ ���� �޼ҵ�)
    - ������ Ư�� ó���� �����ϴ� �������α׷�
3. �Լ�(������ �ִ� �޼ҵ�)
    - ���ν����� ���� ����

����������
DECLARE(������ �����)
    - ���� �Ǵ� ����� �����ϴ� �κ�
    - ������ ������� �ʴ� ��� ���� ����
BEGIN(�����)
    - ���, �ݺ���, �Լ����� �� ������ ���
    - �ݵ�� �ۼ�
EXCEPTION(���� ó����)
    - ���� ��Ȳ �߻��� �ذ��ϱ� ���� ���� �ۼ�
    - ���� ����
END;(��� ����)
/(PL/SQL ���� �� ����)

*/

--PL/SQL�� ���� �� �۵����������
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
    WHERE EMP_NAME='������';
    DBMS_OUTPUT.PUT_LINE('��� : '||ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��ڵ� : '||D_CODE);    
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||J_CODE);  
    
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');
END;
/

--�����ȣ �Է½� �̸�, �μ���, ���޸��� ��� �ǵ��� �͸����ۼ�

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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��� : '||D_NAME);    
    DBMS_OUTPUT.PUT_LINE('���޸� : '||J_NAME);  
EXCEPTION
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');
END;
/

/*
PL/SQL�� ���� ���� �� ����
�����̸�    [CONSTANT]  �ڷ��� [:= �ʱⰪ];
DECLARE
    NO  CONSTANT    NUM := 10; --����ΰ�� ���� ����� �ݵ�� �ʱ�ȭ ���־����.
    NAME    VARCHAR2(20);
    TEST    VARCHAR2(30) := 'TEST����';

*/
--����� �߰��� �� ���� �Ұ�.
DECLARE
    NAME    VARCHAR2(20) := '����ȣ';
    NUM     NUMBER;
    NUM1    CONSTANT NUMBER := 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE(NAME); 
    NAME := '�����̸�';
    DBMS_OUTPUT.PUT_LINE(NAME);
END;
/

--������ �ڷ��� �����ϱ�
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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE(NAME);
    DBMS_OUTPUT.PUT_LINE(D_NAME);
    DBMS_OUTPUT.PUT_LINE(J_NAME);
END;
/
*/
--���� ���̺�%ROWTYPE : ������ ���̺��� ��� ������ Ÿ���� ����
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
    WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||MYROW.EMP_NAME );
    DBMS_OUTPUT.PUT_LINE('�ֹι�ȣ : '||MYROW.EMP_NO );
    DBMS_OUTPUT.PUT_LINE('�̸��� : '||MYROW.EMAIL );
    DBMS_OUTPUT.PUT_LINE('�μ��ڵ� : '||MYROW.DEPT_CODE );
    DBMS_OUTPUT.PUT_LINE('�޿� : '||MYROW.SALARY );
END;
/

--��� �Է� �� �̸�, �μ���, ���޸�, �޿�, �̸��� ���
--RECORD ( ������ ������ �ϳ��ϳ� ���� ���ϰ� RECORD ������ ȣ�����ָ� ��� ����)
-- ��� �Է� �� �̸�, �μ���, ���޸�, �޿�, �̸��� ���
DECLARE
    TYPE MY_RECORD IS RECORD( -- MY_RECORD ��� �ڷ��� ����
        NAME    EMPLOYEE.EMP_NAME%TYPE,
        D_NAME  DEPARTMENT.DEPT_TITLE%TYPE,
        J_NAME  JOB.JOB_NAME%TYPE,
        SAL     EMPLOYEE.SALARY%TYPE,
        EMAIL   EMPLOYEE.EMAIL%TYPE
    );
    MYRECORD MY_RECORD; -- ��������
BEGIN
    SELECT EMP_NAME,DEPT_TITLE,JOB_NAME,SALARY,EMAIL -- ������ ������ ���缭
    INTO MYRECORD.NAME,MYRECORD.D_NAME,MYRECORD.J_NAME,MYRECORD.SAL,MYRECORD.EMAIL
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE =DEPT_ID)
    LEFT JOIN JOB USING (JOB_CODE)
    WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '|| MYRECORD.NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��� : '|| MYRECORD.D_NAME);
    DBMS_OUTPUT.PUT_LINE('���޸� : '|| MYRECORD.J_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '|| MYRECORD.SAL);
    DBMS_OUTPUT.PUT_LINE('�̸��� : '|| MYRECORD.EMAIL);
END;
/
/*
�ǽ����� 1 -
���, �����, �����ڵ�, �޿��� ���� �� �ִ� ���� ������ ����
���߱� ����� ���, �����, �����ڵ�, �޿��� �͸���� ���� ��ũ��Ʈ ���
�ǽ����� 2 -
���, �����, �μ���, ���޸��� ���� �� �ִ� ���������� ���ؼ�
������� �˻��Ͽ� �ش� ����� ���, �����, �μ���, ���޸���
�͸� ���� ���� ��ũ��Ʈ ����Ͻÿ�
�ǽ����� 3 - 
�����ȣ�� �Է��Ͽ� �ش� ����� ã��
�����, �ֹι�ȣ, �Ի���, �μ�����
�͸���� ���� ��ũ��Ʈ ����Ͻÿ�.
*/
--�ǽ� 1��
DECLARE
    ID      EMPLOYEE.EMP_ID%TYPE;
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    D_NAME  EMPLOYEE.JOB_CODE%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
    INTO ID, NAME, D_NAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('��� : '||ID);
    DBMS_OUTPUT.PUT_LINE('����� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||D_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
END;
/
--�ǽ� 2��
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
    WHERE EMP_NAME='&�����';
    DBMS_OUTPUT.PUT_LINE('��� : '||MYRECORD.ID);
    DBMS_OUTPUT.PUT_LINE('����� : '||MYRECORD.NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��� : '||MYRECORD.D_NAME);
    DBMS_OUTPUT.PUT_LINE('���޸� : '||MYRECORD.J_NAME);
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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('��� : '||MYROW.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('����� : '||MYROW.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||MYROW.DEPT_CODE);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||MYROW_D.DEPT_TITLE);
END;
/


/*
PL/SQL ���ù�
*/
-- �����ȣ ������ �̸�, �޿�, ���ʽ��� ���
-- ���ʽ��� ���� ������ '���ʽ��� �����ϴ�.' ���
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
    BO      EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY, NVL(BONUS,0)
    INTO E_NAME,SAL,BO
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    IF(BO = 0)
    THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� �����ϴ�.');
    ELSE DBMS_OUTPUT.PUT_LINE('���ʽ� : '||(BO*100)||'%');
    END IF;
END;
/

--����� �Է� ���� �� �޿��� ���� ����� ����
-- �̸�, �޿�, �޿����(0~99 :F, 100~199 :E, 200~299 : D,....)
DECLARE
    E_NAME  EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY
    INTO E_NAME,SAL
    FROM EMPLOYEE
    WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    IF(0<=SAL AND SAL<1000000)
    THEN DBMS_OUTPUT. PUT_LINE('��� : F');
    ELSIF(1000000<=SAL AND SAL<2000000)
    THEN DBMS_OUTPUT.PUT_LINE('��� : D');
    ELSIF(2000000<=SAL AND SAL<3000000)
    THEN DBMS_OUTPUT.PUT_LINE('��� : E');
    ELSIF(3000000<=SAL AND SAL<4000000)
    THEN DBMS_OUTPUT.PUT_LINE('��� : C'); 
    ELSIF(4000000<=SAL AND SAL<5000000)
    THEN DBMS_OUTPUT.PUT_LINE('��� : B');
    ELSE DBMS_OUTPUT.PUT_LINE('��� : A');
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
    WHERE EMP_ID = '&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    SAL :=  SAL/10000;
    IF(0<=SAL AND SAL<100) THEN SAL_GRADE := 'F';
    ELSIF (100<=SAL AND SAL<200) THEN SAL_GRADE := 'E';
    ELSIF (200<=SAL AND SAL<300) THEN SAL_GRADE := 'D';
    ELSIF (300<=SAL AND SAL<400) THEN SAL_GRADE := 'C';
    ELSIF (400<=SAL AND SAL<500) THEN SAL_GRADE := 'B';
    ELSE SAL_GRADE := 'A';
    END IF;
    DBMS_OUTPUT.PUT_LINE('��� : '||SAL_GRADE);
END;
/
/*
�ǽ����� 1
�����ȣ�� �Է¹޾Ƽ� ����� ���,�̸�,�޿�,���ʽ����� ���.
������ ��ǥ�� ���, '����ȸ�� ��ǥ���̽ʴϴ�.'�� ���.
*/
DECLARE
    MYROW   EMPLOYEE%ROWTYPE;
BEGIN
    SELECT EMP_ID,EMP_NAME,SALARY,BONUS
    INTO MYROW.EMP_ID,MYROW.EMP_NAME,MYROW.SALARY,MYROW.BONUS
    FROM EMPLOYEE
    WHERE EMP_ID='&���';
    IF(MYROW.EMP_ID=200)
    THEN DBMS_OUTPUT.PUT_LINE('���� ȸ�� ��ǥ���̽ʴϴ�');
    ELSE 
    DBMS_OUTPUT.PUT_LINE('��� : '||MYROW.EMP_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||MYROW.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||MYROW.SALARY);
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : '||(MYROW.BONUS*100)||'%');
    END IF;
END;
/
-- %TYPE���� �ٽ�
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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('��� : '||E_ID);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    DBMS_OUTPUT.PUT_LINE('���ʽ��� : '||BO||'%');
    IF(J_NAME='��ǥ')
    THEN DBMS_OUTPUT.PUT_LINE('��ǥ�Դϴ�.');
    END IF;
END;
/
/*
�ǽ����� 2
�ش� ��� ��ȣ�� �Է¹޾� �ش� ����� �Ҽӵ� �μ����� 
���� ���� �޿��� �ް� �ִ� ����� ����Ͽ���
��� ���� �˻��� �����, �˻��� ��� �μ�,  �ҼӺμ����� ���� ���� �޿��� ���� ����� �� �޿�,�μ� ������ ��� �Ͽ���.
ex) 
�����ȣ '207'���� �Է½�

### �˻��� ��� ���� ###
�˻��� ����� : ������
�Ҽӵ� �μ��� : �ؿܿ���1��
-------------------------------
### �ؿܿ���1�ο��� �޿��� ���� ���� ��� ���� ###
����� : ���ȥ
�޿� : 3760000 ��
�Ҽӵ� �μ� : �ؿܿ���1��
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
    WHERE EMP_ID='&�����ȣ';
    DBMS_OUTPUT.PUT_LINE('### �˻��� ��� ���� ###');
    DBMS_OUTPUT.PUT_LINE('����̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��� : '||D_TITLE);
    DBMS_OUTPUT.PUT_LINE('--------------------------');
    IF(D_TITLE IS NOT NULL)
    THEN
    DBMS_OUTPUT.PUT_LINE('###'||D_TITLE||'���� �޿��� ���� ���� ��� ���� ###');
    DBMS_OUTPUT.PUT_LINE('����� : '||TOPNAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||TOPSALARY);
    ELSE
    DBMS_OUTPUT.PUT_LINE('�μ��� ������� �ʽ��ϴ�.');
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
    WHERE EMP_ID = '&���';
    
    IF(DEPT_NAME IS NOT NULL)
    THEN
        SELECT MAX(SALARY)
        INTO MAX_SAL
        FROM EMPLOYEE
        LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
        WHERE DEPT_TITLE = DEPT_NAME; -- ������ �ִ� ���� �μ� �̸� ��
    ELSE -- �μ��ڵ尡 NULL�� ���
        SELECT MAX(SALARY)
        INTO MAX_SAL
        FROM EMPLOYEE
        WHERE DEPT_CODE IS NULL;
        DEPT_NAME := '�μ�����';
    END IF;
    
    SELECT EMP_NAME
    INTO MAX_NAME
    FROM EMPLOYEE
    WHERE SALARY = MAX_SAL; -- ������ �ִ� ���� �޿� ��
    
    DBMS_OUTPUT.PUT_LINE('=== �˻��� ��� ���� ===');
    DBMS_OUTPUT.PUT_LINE('�˻��� ����� : '||SEARCH_NAME);
    DBMS_OUTPUT.PUT_LINE('�Ҽӵ� �μ��� : '||DEPT_NAME);
    DBMS_OUTPUT.PUT_LINE('-------------------------------------');
    DBMS_OUTPUT.PUT_LINE('==='||DEPT_NAME||'���� �޿��� ���� ���� ��� ����'||'===');
    DBMS_OUTPUT.PUT_LINE('����� : '||MAX_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||MAX_SAL);
    DBMS_OUTPUT.PUT_LINE('�Ҽӵ� �μ��� : '||DEPT_NAME);
END;
/

/*
���ݺ��� 
BASIC LOOP : ���Ǿ��� ���� �ݺ�
*/
DECLARE
    NUM NUMBER :=1;
BEGIN
    LOOP        --�ݺ� ����
        DBMS_OUTPUT.PUT_LINE(NUM);
        NUM :=NUM+1;
        IF(NUM>5)
        THEN EXIT;
        END IF;
    END LOOP;  --�ݺ� ��
END;
/

-- FOR LOOP : �ݺ� Ƚ���� �����ؼ� �ݺ�,
DECLARE
BEGIN
    --IN �� �ƴ� REVERSE ��� �� ���� �� ������ �ձ��� ����
    FOR NUM IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
    END LOOP;
END;
/

-- WHILE LOOP : ���ǽ��� TRUE�� ���� �ݺ��ϴ� �ݺ���
-- ��, ó���� ���ǽ��� FALSE�ΰ�� �ѹ��� ���� ���� ���� �� ����
DECLARE
    NUM     NUMBER := 1;
BEGIN
    WHILE (NUM<=5) LOOP
        DBMS_OUTPUT.PUT_LINE(NUM);
        NUM := NUM + 1;
    END LOOP;
END;
/

--������ �̸� �� �޿� LOOP�� ����غ���
DECLARE
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    FOR NUM IN 0..22 LOOP
        SELECT EMP_NAME, SALARY
        INTO NAME, SAL
        FROM EMPLOYEE
        WHERE EMP_ID=200+NUM;
        DBMS_OUTPUT.PUT_LINE('�̸� : '|| NAME);
        DBMS_OUTPUT.PUT_LINE('�޿� : '|| SAL);
    END LOOP;
END;
/

CREATE TABLE LOOP_TEST(
    EMP_NAME    VARCHAR2(20),
    DEPT_TITLE  VARCHAR2(30),
    JOB_NAME    VARCHAR2(30),
    SALARY      NUMBER
);
-- PL/SQL �ݺ����� Ȱ���Ͽ� ������ �Է�
-- JOIN�̳� SUBQUERY ��� ����
-- �μ��ڵ� ���� ������ '�μ�����'���� �μ��� �Է�.
-- 1. ����� �̿��ؼ� EMPLOYEE ���̺��� �ʿ��� ���� ��ȸ
-- 2. 1���� ��ȸ ����� �̿��ؼ� DEPARTMENT, JOB���� �߰� ���� ��ȸ
-- 3. 1,2���� ��ȸ ����� �̿��Ͽ�  FCV�� �ۼ�
-- 4. ��� INSERT�� ����Ǹ� COMMIT;
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
            D_NAME := '�μ�����';
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
    WHERE EMP_ID='&���';
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
    DBMS_OUTPUT.PUT_LINE('���ʽ� : '||BO||'%');
    
EXCEPTION
/*
    WHEN �����̸�1 THEN ó���� ����1;
    WHEN �����̸�2 THEN ó���� ����2;
*/
    WHEN NO_DATA_FOUND
    THEN DBMS_OUTPUT.PUT_LINE('���� ������ ��ȸ�� �� �����ϴ�.');
END;
/
--------------------------------------------------------
/*
PROCEDURE(���ν���)
->  �Ϸ��� �۾� ������ �����ؼ� ������ �� ��
->  ���� SQL���� ��� �̸� �����ϰ� �ϳ��� ��û���� ����
->  ���� ���Ǵ� ������ �۾����� �����ΰ� �����ϰ� ����� ����
->  (�ڹٿ���)return void�� �ڹ� �޼ҵ�� ���

���ν��� �����  ���
CREATE [OR REPLACE] 
PROCEDURE ���ν����̸�(�Ű�����1 [����Ÿ��] �ڷ���, �Ű�����2 �ڷ���,..)
IS
    �������� ���� ����
BEGIN
    ���� ����
END;
/
--���ν��� �Ű�����
1. ���࿡ �Ű������� ������ ���ν��� �̸������� �ۼ��ϰ� IS �������� �Ѿ
    ex)
    CREATE PROCEDURE  ���ν����̸�
    IS
2. �Ű������� �ڷ��� �Է� �� ���̴� �ۼ����� ����(���� �ۼ� �� �����߻�)
    ex)
    CREATE PROCEDURE ���ν��� �̸�(STR VARCHAR2) -> ���� �ۼ�X
    IS
3. ����Ÿ�� Ű���� [IN|OUT|INOUT]
    -> IN : �����͸� ���� ������ ���
    -> OUT : ����� �޾ư� �� ���
    -> INOUT : IN, OUT �ΰ��� �������� ��� ��� ����(������ ���� �Ⱦ�)
*/

--�Ű������� ���� ���ν��� ����
CREATE OR REPLACE PROCEDURE TEST_PRO_1
IS
    NAME    EMPLOYEE.EMP_NAME%TYPE;
    SAL     EMPLOYEE.SALARY%TYPE;
BEGIN
    SELECT EMP_NAME, SALARY
    INTO NAME,SAL
    FROM EMPLOYEE
    WHERE EMP_ID=200;
    DBMS_OUTPUT.PUT_LINE('�̸� : '||NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
END;
/
--���ν��� ���
EXECUTE TEST_PRO_1;
EXEC TEST_PRO_1;

--�Ű������� �ִ� ���ν��� ����
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
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME);
    DBMS_OUTPUT.PUT_LINE('�μ��ڵ� : '||D_CODE);
    DBMS_OUTPUT.PUT_LINE('�����ڵ� : '||J_CODE);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL);
END;
/
--���ν��� ���
EXEC TEST_PRO_2('�ϵ���');


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
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME1);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL1);
    DBMS_OUTPUT.PUT_LINE('�̸� : '||E_NAME2);
    DBMS_OUTPUT.PUT_LINE('�޿� : '||SAL2);
END;
/
EXEC TEST_PRO_3('������','������');

-- OUT ����
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
    --PL/SQL ���ο��� ���ν��� ���� EXECŰ���带 ������� ����
    TEST_PRO_4('������',D_TITLE);
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
-- 1. ���ν��� ����
-- >�Ű������� ����� �޾Ƽ� �ش� ������ EMP_PRO_TEST���̺��� ���� �� ��
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
1. �ű� ���̺� ���� (���̺�� DEL_EMP)
    > ���, �̸�, �μ���, ���޸�, ����� ������ �÷� ����
2. DEL_EMP_PRO2 ���ν��� ����
    > �Ű������� ����� ����
    > �Ű������� ���� ��������� EMP_PRO_TEST���̺��� ����
    > EMP_PRO_TEST ���̺� ���� ���� �ʿ��� ������ ��ȸ�ؼ�
    > DEL_EMP�� INSERT �� �� ����( ������� SYSDATE�� �Է�)
    > �۾��� �� �Ǹ�, COMMIT.
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
FUNCTION : ���ν����� ���� ����
> ������ �ݵ�� ����
> IN|OUT Ÿ�� ���� ��� X

�Լ� �ۼ� ���
CREATE [OR REPLACE] FUNCTION �Լ��̸�(�Ű�����1 �ڷ���, �Ű�����2 �ڷ���..)
RETURN �����ڷ���
IS
BEGIN
END;
/
*/
-- �μ��ڵ带 �޾Ƽ� �ش��ϴ� �μ����� ��ȸ�ϴ� �Լ� ����
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
--JOIN�� ������� �ʾƵ� ��ȸ ����.
SELECT EMP_NAME, DEPT_CODE, GET_DEPT(DEPT_CODE) FROM EMPLOYEE;

-- �޿��� ���ʽ��� �Ű������� �޾Ƽ� ������ ����ؼ� ����
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

--�Ű������� ��� �޾Ƽ� �ش� ��� ������ �����ϴ� �Լ�.
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
TRIGGER : �̸� ���س��� ������ �����ϰų� ����Ǹ� �ڵ������� ����Ǵ� �ൿ
    > Ư�� ���̺��̳� �信 INSERT,UPDATE,DELETE�� ����
    > �Է�, ����, ������ �Ǵ� ��� �ڵ����� ����
*/
-- ȸ�� ������ �����ϴ� ���̺�
CREATE TABLE M_TBL(
    MEMBER_ID   VARCHAR2(20) PRIMARY KEY,   --���̵�
    MEMBER_PW   VARCHAR2(30) NOT NULL,      --��й�ȣ
    MEMBER_NAME VARCHAR2(20) NOT NULL,      --�̸�
    ENROLL_DATE DATE                        --������
);
-- M_TBL�� ������ ����Ǹ� �����̷��� �����ϴ� ���̺�(��й�ȣ)
CREATE TABLE M_LOG(
    MEMBER_ID   VARCHAR2(20)    REFERENCES M_TBL ON DELETE CASCADE,
    CHANGE_CONTENT VARCHAR2(100), --��й�ȣ ���泻��
    CHANGE_DATE DATE              --���� ��¥
);
-- M_TBL���� ȸ���� Ż�� �� Ż�� �̷��� �����ϴ� ���̺�
CREATE TABLE DEL_M_TBL(
    --�ܷ�Ű�� �ɾ �ȵ�.(�ٸ� ���̺��� ������ �����ǵ� ���ƾ߾���)
    MEMBER_ID   VARCHAR2(20)    PRIMARY KEY,
    MEMBER_NAME VARCHAR2(20),
    ENROLL_DATE DATE,
    OUT_DATE    DATE
);
/*
FOR EACH ROW�� �ִ� ��쿣,
������Ʈ�� ���� -> 5���� ���� ������ ���, Ʈ���Ű� 5ȸ ����
FOR EACH ROW�� ���� ��쿣,
������Ʈ�� ���� -> 5���� ���� ������ ��쿡�� Ʈ���Ű� 1ȸ ����

��Ʈ���� �ۼ� Ʋ
CREATE [OR REPLACE] TRIGGER Ʈ�����̸�
���۽���    ����DML   (AFTER INSERT)
ON ��� ���̺�
[FOR EACH ROW] -- Ʈ���� ���� ����(����� ���� �� ��ŭ Ʈ���� ����)
BEGIN
    --���� �ڵ�  ����
END;
/
���ε庯��(FOR EACH ROW�� ����� ���� ��밡���� ����)
:NEW    - SQL������ ���� �Էµ� ������
:OLD    - SQL������ ����Ǳ� �� ������
:NEW.�÷���
:OLD.�÷���
*/
-- M_TBL�� ȸ���� INSERT�Ǹ� 'ȸ���� �߰��Ǿ����ϴ�.'�޼��� ����ϴ� Ʈ���� ����
CREATE OR REPLACE TRIGGER M_TBL_INSERT_TRG
AFTER INSERT
ON M_TBL
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.MEMBER_NAME||'ȸ���� �߰��Ǿ����ϴ�.');
END;
/
INSERT INTO M_TBL VALUES('user01','1111','����1',SYSDATE-1);
COMMIT;
INSERT INTO M_TBL VALUES('user02','2222','����2',SYSDATE-1);
COMMIT;
INSERT INTO M_TBL VALUES('user03','3333','����3',SYSDATE-1);

-- M_TBL���� ��й�ȣ�� �����ϸ� �����̷��� M_LOG TBL�� INSERT
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

-- M_TBL���� ������ ���� �� DEL_M_TBL�� �����͸� INSERT�ϴ� Ʈ����
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
    PCODE   NUMBER          PRIMARY KEY,    -- ��ǰ�ڵ�
    PNAME   VARCHAR2(50)    NOT NULL,       -- ��ǰ�̸�
    PRICE   NUMBER,                         -- ����
    STOCK   NUMBER                          -- ���
);
CREATE TABLE PRO_DETAIL(
    DCODE   NUMBER      PRIMARY KEY,                --��/��� ��ȣ
    PCODE   NUMBER  REFERENCES PRODUCT,             --��ǰ�ڵ�
    D_DATE  DATE,                                   --��/��� ��¥
    AMOUNT  NUMBER,                                 --��/��� ����
    STATUS  CHAR(6) CHECK(STATUS IN ('�԰�','���'))  --����
);
INSERT INTO PRODUCT
VALUES(PCODE_SEQ.NEXTVAL,'��������','10000',20);
INSERT INTO PRODUCT
VALUES(PCODE_SEQ.NEXTVAL,'�ڵ�ũ��',15000,10);
CREATE SEQUENCE PCODE_SEQ;
CREATE SEQUENCE DCODE_SEQ;
SELECT * FROM PRODUCT;
SELECT * FROM PRO_DETAIL;
COMMIT;
INSERT INTO PRO_DETAIL
VALUES(DCODE_SEQ.NEXTVAL,2,SYSDATE,10,'�԰�');
INSERT INTO PRO_DETAIL
VALUES(DCODE_SEQ.NEXTVAL,1,SYSDATE,5,'���');


CREATE OR REPLACE TRIGGER PRO_TRG
AFTER INSERT
ON PRO_DETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = '�԰�')
    THEN 
        UPDATE PRODUCT SET STOCK = STOCK + :NEW.AMOUNT WHERE PCODE=:NEW.PCODE;
    ELSE
        UPDATE PRODUCT SET STOCK = STOCK - :NEW.AMOUNT WHERE PCODE=:NEW.PCODE;
    END IF;
END;
/
COMMIT;

























































