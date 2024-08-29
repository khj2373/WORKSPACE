--1.
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2
                     FROM EMPLOYEE);
                     
--2.
SELECT EMP_ID, EMP_NAME,
        EXTRACT(YEAR FROM SYSDATE) - 
        CASE
            WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
                2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
            ELSE
                1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
        END + 1 AS "³ªÀÌ",
        DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) -
    CASE
        WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
            2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
        ELSE
            1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
    END + 1 = (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) -
                            CASE
                                WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
                                    2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
                                ELSE
                                    1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
                            END + 1)
                FROM EMPLOYEE);

