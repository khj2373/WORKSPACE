--01.
CREATE TABLE TB_CATEGORY(
    NAME VARCHAR2(10),
    USE_YN CHAR(1) DEFAULT 'Y' CHECK(USE_YN IN ('Y', 'N'))
);

--02.
CREATE TABLE TB_CLASS_TYPE(
    NO VARCHAR2(5) PRIMARY KEY,
    NAME VARCHAR2(10)
);

--03.
ALTER TABLE TB_CATEGORY ADD PRIMARY KEY(NAME);

--04.
ALTER TABLE TB_CLASS_TYPE MODIFY NAME NOT NULL;

--05.
ALTER TABLE TB_CLASS_TYPE
MODIFY NO VARCHAR2(10)
MODIFY NAME VARCHAR2(20);

ALTER TABLE TB_CATEGORY
MODIFY NAME VARCHAR2(20);

--06.
ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NO TO CLASS_TYPE_NO;

ALTER TABLE TB_CLASS_TYPE
RENAME COLUMN NAME TO CLASS_TYPE_NAME;

ALTER TABLE TB_CATEGORY
RENAME COLUMN NAME TO CATEGORY_NAME;

--07.
ALTER TABLE TB_CATEGORY
RENAME CONSTRAINT SYS_C007031 TO PK_CATEGORY_NAME;

ALTER TABLE TB_CLASS_TYPE
RENAME CONSTRAINT SYS_C007030 TO PK_CLASS_TYPE_NAME;

--08.
INSERT INTO TB_CATEGORY VALUES ('공학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('자연과학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('의학', 'Y');
INSERT INTO TB_CATEGORY VALUES ('예체능', 'Y');
INSERT INTO TB_CATEGORY VALUES ('인문사회', 'Y');

--09.
ALTER TABLE TB_DEPARTMENT
ADD CONSTRAINT FK_DEPARTMENT_CATEGORY FOREIGN KEY(CATEGORY) REFERENCES TB_CATEGORY;

--10.
--GRANT CREATE VIEW TO HOMEWORK;
CREATE VIEW VW_학생일반정보
AS (SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
    FROM TB_STUDENT);
    
--11.
CREATE VIEW VW_지도면담
AS (SELECT STUDENT_NO, DEPARTMENT_NAME, PROFESSOR_NAME
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
    LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO))
ORDER BY DEPARTMENT_NAME;

--12.
CREATE VIEW VW_학과별학생수
AS (SELECT DEPARTMENT_NAME, COUNT(STUDENT_NO) AS "STUDENT_COUNT"
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
    GROUP BY DEPARTMENT_NAME);
    
--13.
UPDATE VW_학생일반정보
SET STUDENT_NAME = '김현준'
WHERE STUDENT_NO = 'A213046';

--14.
CREATE OR REPLACE VIEW VW_학생일반정보
AS (SELECT STUDENT_NO, STUDENT_NAME, STUDENT_ADDRESS
    FROM TB_STUDENT)
WITH READ ONLY;

CREATE OR REPLACE VIEW VW_지도면담
AS (SELECT STUDENT_NO, DEPARTMENT_NAME, PROFESSOR_NAME
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
    LEFT JOIN TB_PROFESSOR ON (COACH_PROFESSOR_NO = PROFESSOR_NO))
ORDER BY DEPARTMENT_NAME
WITH READ ONLY;

CREATE OR REPLACE VIEW VW_학과별학생수
AS (SELECT DEPARTMENT_NAME, COUNT(STUDENT_NO) AS "STUDENT_COUNT"
    FROM TB_STUDENT
    JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
    GROUP BY DEPARTMENT_NAME)
WITH READ ONLY;

--15. ?
SELECT TB_CLASS.CLASS_NO AS "과목번호", CLASS_NAME "과목이름", COUNT(TB_GRADE.CLASS_NO) AS "누적수강생수(명)"
FROM TB_CLASS
JOIN TB_GRADE ON (TB_CLASS.CLASS_NO = TB_GRADE.CLASS_NO)
GROUP BY TB_CLASS.CLASS_NO, CLASS_NAME, SUBSTR(TERM_NO, 1, 4)
ORDER BY COUNT(TB_GRADE.CLASS_NO) DESC;