/* SELECT * FROM ALL_USERS; */

/*
���� ���� ��� 
CREATE USER �����̸� IDENTIFIED BY ��й�ȣ;
GRANT ���� TO ������;
*/

CREATE USER spring IDENTIFIED BY spring;

--KH������ �ּ����� ������ �ο�(����, �����Ͱ���)
GRANT CONNECT, RESOURCE TO spring;
