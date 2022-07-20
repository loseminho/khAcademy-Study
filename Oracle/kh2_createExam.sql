--CREATE �ǽ�
/*
1. ���ο� ���� ����(������ �������� ����)
- �����̸� : ddlexam
- ��й�ȣ : 1111
-> �������� �� ���Ѻο�
2. ���� ������ �������� ���� ���ǿ� �����ϴ� TABLE���� �����Ͻÿ�
ù��° ���̺� �� : EXPERT_TBL
�÷���
MEMBER_CODE(number) - �⺻Ű					-- ȸ�������ڵ�
MEMBER_ID (varchar2(20) ) - �ߺ�����			-- ȸ�� ���̵�
MEMBER_PWD (varchar2(20)) - NULL �� ������	-- ȸ�� ��й�ȣ
MEMBER_NAME(varchar2(10)) - NULL�� ��� ����	-- ȸ�� �̸�
MEMBER_ADDR (varchar2(50)) - NULL�� ������	-- ȸ�� ������
GENDER (char(3)) - '��' Ȥ�� '��'�θ� �Է� ����		-- ����
PHONE(char(13))
�ι�° ���̺� �� : COMPANY_TBL
�÷���
MEMBER_CODE(number) - �ܷ�Ű(EXPERT_TBL�� �⺻Ű ����)	-- ȸ�������ڵ�
SKILL(varchar2(50)) 					-- ȸ�� �ɷ�
-> ȸ���� �����Ǵ� ��� COMPANY_TBL�� ����ȸ�� ���������� ��� �����ǰ� ���弼��.
�����͸� �Է� �� ���� �ؼ� ���������� �����ϴ��� Ȯ���غ�����
�� ���̺� ���� ���� �������׹߻��Ͽ� �ٽø����� �ϴ� ���
DROP TABLE ���̺��;
-> ���̺� ���� �� �����(�������� �ʰ� �ٽ� �����ϴ°�� ������ �߻�)?
*/
CREATE TABLE EXPERT_TBL(
MEMBER_CODE     number PRIMARY KEY,		             -- ȸ�������ڵ�
MEMBER_ID       varchar2(20) UNIQUE,                 -- ȸ�� ���̵�
MEMBER_PWD      varchar2(20) NOT NULL,               -- ȸ�� ��й�ȣ
MEMBER_NAME     varchar2(10) NOT NULL,	             -- ȸ�� �̸�
MEMBER_ADDR     varchar2(50) NOT NULL,               -- ȸ�� ������
GENDER          char(3) CHECK(GENDER IN('��','��')),  --����
PHON            char(13)
);
INSERT INTO EXPERT_TBL
VALUES (1,'USER1','1234','����ȣ','��굿','��','01032677800');
INSERT INTO EXPERT_TBL
VALUES (2,'USER2','1234','�̹�ȣ','���굿','��','01022222222');
DELETE FROM EXPERT_TBL WHERE MEMBER_CODE = 2;

SELECT * FROM EXPERT_TBL;

CREATE TABLE COMPANY_TBL(
MEMBER_CODE     number REFERENCES EXPERT_TBL(MEMBER_CODE) ON DELETE CASCADE,
--ȸ�� ���� �ڵ�
SKILL           varchar2(50)
-- ȸ�� �ɷ�
);
INSERT INTO COMPANY_TBL VALUES (1,'�ҽ��');
INSERT INTO COMPANY_TBL VALUES (2,'����');
INSERT INTO COMPANY_TBL VALUES (2,'����');

SELECT * FROM COMPANY_TBL;





