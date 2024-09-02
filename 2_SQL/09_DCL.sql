/*
<DCL : ������ ���>

������ �ý��� ���� �Ǵ� ��ü���ٱ����� �ο��ϰų� ȸ���ϴ� ����

> �ý��� ���� : DB�� �����ϴ� ����, ��ü�� ������ �� �ִ� ����
> ��ü ���� ���� : Ư�� ��ü���� ������ �� �ִ� ����

CREATE USER ������ IDENTIFIED BY ��й�ȣ; --> ��й�ȣ�� ��ҹ��ڸ� ������
GRANT ����(CONNECT, RESOURCE) TO ����
*/

SELECT *
FROM ROLE_SYS_PRIVS;

/*
<TCL : Ʈ����� ���>
-�����ͺ��̽��� ������ �������
-�������� �������<DML>���� �ϳ��� Ʈ����ǿ� ��� ó��
DML�� �Ѱ��� ������ �� Ʈ������� �������� �ʴ´ٸ� Ʈ������� ���� ����
    Ʈ������� �����Ѵٸ� �ش� Ʈ����ǿ� ��� ó��
COMMIT�ϱ� �������� ������׵��� �ϳ��� Ʈ����ǿ� ��´�
-Ʈ������� ����� �Ǵ� SQL : INSERT, UPDATE, DELETE

COMMIT(Ʈ����� ���� ó�� �� Ȯ��)
ROLLBACK(Ʈ����ǿ� �ִ� �۾��� ���)
SAVEPOINT(�ӽ�����)

-COMMIT : �� Ʈ����ǿ� ����ִ� ������׵��� ���� DB�� �ݿ���Ű�ڴٴ� �ǹ�
-ROLLBACK : �� Ʈ����ǿ� ����ִ� ������׵��� ����(���)�� �� ������ COMMIT �������� ���ư�
-SAVEPOINT ����Ʈ�� : ���� ������ �ش� ����Ʈ������ �ӽ����� ���ְڴ�
*/

DROP TABLE EMP_01;

CREATE TABLE EMP_01
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
        FROM EMPLOYEE
        JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));
        
SELECT * FROM EMP_01;

--����� 200, 201���� ��� ����
DELETE FROM EMP_01
WHERE EMP_ID = 200 OR EMP_ID =201;

ROLLBACK;

--------------------------------------------------------------
--����� 200, 201���� ��� ����
DELETE FROM EMP_01
WHERE EMP_ID = 200 OR EMP_ID =201;

COMMIT;
ROLLBACK;

--------------------------------------------------------------------------
DELETE FROM EMP_01
WHERE EMP_ID IN (217, 216, 216);

SELECT * FROM EMP_01;

SAVEPOINT SP;

INSERT INTO EMP_01
VALUES(810, '�踻��', '���������');

DELETE FROM EMP_01
WHERE EMP_ID = 210;

ROLLBACK TO SP;

COMMIT;
----------------------------------------------------------
DELETE FROM EMP_01
WHERE EMP_ID = 210;

--DDL�� ����
DROP TABLE TEST;
CREATE TABLE TEST(
    TID NUMBER
);

ROLLBACK;

SELECT * FROM EMP_01;
--DDL��(CREATE, ALTER, DROP)�� �����ϴ� ���� ���� Ʈ����ǿ� �ִ� ������׵���
--������ COMMIT�� �ȴ�. (���� DB�� �ݿ� �ȴ�)
--��, DDL�� ������ ������׵��� �ִٸ� ��Ȯ�ϰ� �Ƚ��ϰ� ����