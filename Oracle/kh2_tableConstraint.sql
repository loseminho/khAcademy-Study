--���̺� �������
-- CREATE TABLE ���̺��̸�(�÷��̸� �ڷ���(ũ��))

CREATE TABLE MEMBER(
    MEMBER_ID   VARCHAR2(20),
    MEMBER_PW   VARCHAR2(20),
    MEMBER_NAME VARCHAR2(21)
);
SELECT * FROM MEMBER;

--���̺� �÷� ���� ���� ���� �ڸ�Ʈ �ۼ� ��ɾ�
COMMENT ON COLUMN MEMBER.MEMBER_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN MEMBER.MEMBER_PW IS 'ȸ����й�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS 'ȸ���̸�';

--������ ������ ����
INSERT INTO MEMBER VALUES('user01','1234','����1');

--���������� �ϳ��� ���� ���̺� ����
CREATE TABLE USER_NOCONS(
    USER_NO     NUMBER,
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11)
);

INSERT INTO USER_NOCONS VALUES(1,'user01','1234','����1','����','01011111111');
SELECT * FROM USER_NOCONS;


--�������� NOT NULL ����.
CREATE TABLE USER_NOTNULL(
    USER_NO     NUMBER,
    USER_ID     VARCHAR2(30) NOT NULL,
    USER_PW     VARCHAR2(30) NOT NULL,
    USER_NAME   VARCHAR2(30) NOT NULL,
    GENDER      CHAR(6),
    PHONE       CHAR(11)
);

INSERT INTO USER_NOTNULL
VALUES(1, 'user01','1234','����1','����','01011111111');

--NULL�� �����س��� �÷� ���� NULL�� ���� ��, ���� �߻�
INSERT INTO USER_NOTNULL
VALUES(2, 'user02',NULL,'����1','����','01011111111');

--UNIQUE : �ش� �÷� ���� �ߺ��� ����
--�������� UNIQUE ����.
CREATE TABLE USER_UNIQUE(
    USER_NO     NUMBER UNIQUE NOT NULL,  --UNIQUE �÷� ���� ����
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11),
    UNIQUE(USER_ID)            --UNIQUE ���̺� ���� ����
);

SELECT * FROM USER_UNIQUE;
INSERT INTO USER_UNIQUE
VALUES(1,'user01','1111','����1','����','01011111111');

--UNIQUE�� �����س��� �÷� ���� �ߺ� ���� ���� ��, ���� �߻�
INSERT INTO USER_UNIQUE
VALUES(1,'user01','1111','����2','����','01022222222');

--UNIQUE���� NULL�� �����Ͱ� �ƴϱ⶧���� ���� �� �� ����.
INSERT INTO USER_UNIQUE
VALUES(3,NULL,'1111','����3','����','01033333333');

--UNIQUE �ٸ� ���� ���
CREATE TABLE USER_UNIQUE2(
    USER_NO     NUMBER,
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11),
    UNIQUE(USER_NO, USER_ID)        --���ÿ� �ߺ����� ���ö��� UNIQUE�� �ɸ�
);
SELECT * FROM USER_UNIQUE2;
INSERT INTO USER_UNIQUE2
VALUES(1,'user01','1234','����1','����','01011111111');
INSERT INTO USER_UNIQUE2
VALUES(1,'user02','1234','����2','����','01022222222');

--PRIMARY KEY ����
CREATE TABLE USER_PK1(
    USER_NO     NUMBER PRIMARY KEY, -- �÷� �������� PK ����
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11)
);
INSERT INTO USER_PK1
VALUES(1,'user01','1234','����1','����','01011111111');

CREATE TABLE USER_PK2(
    USER_NO     NUMBER,
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11),
    PRIMARY KEY(USER_NO)        --���̺� �������� PK ����
);

CREATE TABLE USER_PK3(
    USER_NO     NUMBER,
    USER_ID     VARCHAR2(20),
    USER_PW     VARCHAR2(20),
    USER_NAME   VARCHAR2(20),
    GENDER      CHAR(6),
    PHONE       CHAR(11),
    PRIMARY KEY(USER_NO,USER_ID)        --���̺� �������� PK ����
);

CREATE TABLE SHOP_MEMBER(
    USER_NO NUMBER PRIMARY KEY,
    USER_ID VARCHAR2(20) UNIQUE NOT NULL,
    USER_PW VARCHAR2(20) NOT NULL,
    USER_NAME VARCHAR2(20)
);

INSERT INTO SHOP_MEMBER
VALUES(1,'user01','1111','����1');
INSERT INTO SHOP_MEMBER
VALUES(2,'user02','2222','����2');
INSERT INTO SHOP_MEMBER
VALUES(3,'user03','3333','����3');
                       
SELECT * FROM SHOP_MEMBER;









