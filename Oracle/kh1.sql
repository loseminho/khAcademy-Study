SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;

SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID);