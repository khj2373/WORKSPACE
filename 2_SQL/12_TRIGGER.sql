/*
<Ʈ����>
���� ������ ���̺��� INSERT, UPDATE, DELETE�� DML���� ���� ��������� ���� ��
(���̺��� �̺�Ʈ�� �߻����� ��)
�ڵ����� �Ź� ������ ������ �̸� �����ص� �� �ִ�.

EX)
ȸ��Ż��� ���� ȸ�� ���̺��� ������ DELETE�� �� ��ٷ� Ż���� ȸ���鸸 ���� �����ϴ� ���̺���
�ڵ����� INSERT ���Ѿ��Ѵ�
�Ű�Ƚ���� ���� ���� �Ѿ��� �� ���������� �ش� ȸ���� ��������Ʈ�� ó���ϰԲ�
������� ���� ���(INSERT)�� ������ �ش� ��ǰ�� ���� ��� ������ �Ź� ����(UPDATE)�ؾ��Ѵ�

*Ʈ���� ����
-SQL���� ����ñ⿡ ���� �з�
-BEFORE TRIGGER : ���� ������ ���̺��� �̺�Ʈ�� �߻��Ǳ� ���� Ʈ���� ����
-AFTER TRIGGER : ���� ������ ���̺��� �̺�Ʈ�� �߻��� �� Ʈ���� ����

-SQL���� ���� �������� �޴� �� �࿡ ���� ����
-����Ʈ���� : �̺�Ʈ�� �߻��� SQL���� ���� �� �ѹ��� Ʈ���� ����
-��Ʈ���� : �ش� SQL�� ������ ������ �Ź� Ʈ���� ����
        (FOR EACH ROW �ɼ��� ����ؾ���)
    > :OLD - BEFORE UPDATE(���� �� �ڷ�), BEFORE DELETE(���� �� �ڷ�)
    > :NEW - AFTER INSERT(�߰��� �ڷ�), AFTER UPDATE(���� �� �ڷ�)
    
Ʈ���� ���� ����
[ǥ����]
CREATE [OR REPLACE] TRIGGER Ʈ���Ÿ�
BEFORE | AFTER      INSERT | UPDATE | DELETE    ON ���̺���
[FOR EACH ROW]
[DECLARE ��������]
BEGIN
    ���೻��(���������� ���� �̺�Ʈ�� �߻����� �� ������ ����)
[EXCEPTION ����ó��]
END;
*/
--EMPLOYEE ���̺��� ���ο� ���� INSERT�� ������ �ڵ����� ��µǴ� Ʈ���� ����

SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('���Ի���� �ȳ��ϼ���.');
END;
/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES(SEQ_EID.NEXTVAL, '������', '123123-1231234', 'D7', 'J7', SYSDATE);

---------------------------------------------------------------------------
--��ǰ �԰� �� ��� �����ؼ�
--> �ʿ��� ���̺� �� ������

--1. ��ǰ�� ���� �����͸� ������ ���̺�(TB_PRODUCT)
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY, --��ǰ��ȣ
    PNAME VARCHAR2(30) NOT NULL, --��ǰ��
    BRAND VARCHAR2(30) NOT NULL, --�귣��
    PRICE NUMBER, --����
    STOCK NUMBER DEFAULT 0 --���
);

--��ǰ��ȣ �ߺ� �ȵǰԲ� �Ź� ���ο� ��ȣ�� �߻���Ű�� ������ ����
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5;

--���õ�����
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������24', '�Ｚ', 1500000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '������15', '����', 1300000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '�����', '������', 800000, 20);

COMMIT;

--2. ��ǰ ����� �� �̷� ���̺� ����(TB_PRODETAIL)
--� ��ǰ�� � ��¥�� ��� �԰� �Ǵ� ����� �Ǵ��� �����͸� ���
CREATE TABLE TB_PRODETAIL(
    DECODED NUMBER PRIMARY KEY, --�̷¹�ȣ
    PCODE NUMBER REFERENCES TB_PRODUCT, --��ǰ��ȣ
    PDATE DATE NOT NULL, --�������
    AMOUNT NUMBER NOT NULL, --����� ����
    STATUS CHAR(6) CHECK(STATUS IN('�԰�', '���')) --����(�԰�, ���)
);

CREATE SEQUENCE SEQ_DECODE;

--300�� ��ǰ�� ���� ��¥�� 10�� �԰�
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 300, SYSDATE, 10, '�԰�');

--300�� ��ǰ�� ����� 10����
UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 300;

COMMIT;

--TB_PRODETAIL ���̺��� INSERT�̺�Ʈ �߻���
--TB_PRODUCT ���̺��� �Ź� �ڵ����� ��������� UPDATE�ϰԲ� Ʈ���� �ۼ�

/*
-��ǰ�� �԰��� ��� -> �ش� ��ǰ�� ã�Ƽ� ��� ���� ���� UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK + �԰��� ����(INSERT�� �ڷ��� AMOUNT)
WHERE PCODE = �԰��� ��ǰ��ȣ(INSERT�� �ڷ��� PCODE);

-��ǰ�� ����� ��� -> �ش� ��ǰ�� ã�Ƽ� ������� ���� UPDATE
UPDATE TB_PRODUCT
SET STOCK = STOCK - �԰��� ����(INSERT�� �ڷ��� AMOUNT)
WHERE PCODE = �԰��� ��ǰ��ȣ(INSERT�� �ڷ��� PCODE);
*/

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = '�԰�')
        THEN UPDATE TB_PRODUCT
             SET STOCK = STOCK + :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
    
    IF(:NEW.STATUS = '���')
        THEN UPDATE TB_PRODUCT
             SET STOCK = STOCK - :NEW.AMOUNT
             WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

--310�� ��ǰ�� ���� ��¥�� ���
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 310, SYSDATE, 7, '���');

--300�� ��ǰ�� ���� ��¥�� 100�� �԰�
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 300, SYSDATE, 100, '�԰�');