/* SELECT * FROM ALL_USERS; */

/*
���� ���� ��� 
CREATE USER �����̸� IDENTIFIED BY ��й�ȣ;
GRANT ���� TO ������;
*/

CREATE USER MYBATIS IDENTIFIED BY MYBATIS;

--KH������ �ּ����� ������ �ο�(����, �����Ͱ���)
GRANT CONNECT, RESOURCE TO MYBATIS;
