CREATE TABLE EXAM_MEMBER(
    MEMBER_NO       NUMBER          PRIMARY KEY,
    MEMBER_ID       VARCHAR2(20)    UNIQUE NOT NULL,
    MEMBER_PW       VARCHAR2(30)    NOT NULL,
    MEMBER_NAME     VARCHAR2(20)    NOT NULL,
    MEMBER_PHONE    CHAR(11)
);
CREATE TABLE EXAM_BOARD(
    BOARD_NO        NUMBER          PRIMARY KEY,
    BOARD_TITLE      VARCHAR2(100)   NOT NULL,
    BOARD_CONTENT   VARCHAR2(2000)  NOT NULL,
    BOARD_WRITER    NUMBER REFERENCES EXAM_MEMBER(MEMBER_NO) ON DELETE SET NULL, 
    READ_COUNT      NUMBER,
    WRITE_DATE      DATE
);
CREATE SEQUENCE SEQ_EXAM_MEMBER
START WITH 1
INCREMENT BY 1
MAXVALUE 1000000
NOCYCLE
NOCACHE;
CREATE SEQUENCE SEQ_EXAM_BOARD
START WITH 1
INCREMENT BY 1
MAXVALUE 1000000
NOCYCLE
NOCACHE;

drop SEQUENCE SEQ_EXAM_BOARD;

delete from exam_board where board_writer=2;

SELECT * FROM EXAM_MEMBER;
SELECT * FROM EXAM_BOARD;

SELECT BOARD_TITLE, (SELECT MEMBER_NAME
FROM EXAM_MEMBER
JOIN EXAM_BOARD ON (MEMBER_NO = BOARD_WRITER)) FROM EXAM_BOARD;


SELECT BOARD_NO,BOARD_TITLE,BOARD_CONTENT, MEMBER_NAME,READ_COUNT,WRITE_DATE
FROM EXAM_BOARD
JOIN EXAM_MEMBER ON (BOARD_WRITER = MEMBER_NO);
commit;



