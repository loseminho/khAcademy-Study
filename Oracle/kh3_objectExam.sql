/*
계정 생성 : khtest
권한 부여 : connect,resource

테이블 2개 생성
회원테이블(MEMBER), 게시판테이블(BOARD)

## 회원테이블 ##
MEMBER_NO(NUMBER)		-- 회원 고유 순번 (자동 증가), PRIMARY KEY
MEMBER_USERID (VARCHAR2(20))	-- 회원 아이디			UNIQUE, NOT NULL
MEMBER_USERPWD (CHAR(20))	-- 회원 비밀번호		NOT NULL
MEMBER_NICKNAME (VARCHAR2(20))	-- 회원 닉네임			UNIQUE, NOT NULL
MEMBER_GENDER (VARCHAR2(3))	-- 회원 성별('남' 혹은 '여')	NOT NULL
MEMBER_EMAIL (VARCHAR2(30))	-- 회원 이메일			NOT NULL



-> 회원 고유 번호는 1000번 부터 시작하여 1씩 증가 해야함
-> MAX 번호는 1000000 번 까지
-> 성별은 '남' 또는 '여' 만 데이터 삽입이 가능 해야함 


## 게시판 테이블 ##
BOARD_NO (NUMBER)		-- 글 번호(자동 증가)	, PRIMARY KEY
BOARD_TITLE (VARCHAR2(20))	-- 글 제목		NOT NULL
BOARD_CONTENT (VARCHAR2(200))	-- 글 내용		NOT NULL
BOARD_WRITEDATE (DATE)		-- 글 작성시간		NOT NULL
BOARD_NICKNAME (VARCHAR2(20))	-- 글 작성자(닉네임)	NOT NULL 및 FOREIGN KEY

-> 글 번호는 1번부터 시작하여 1씩 증가 해야함
-> MAX 번호는 500000번 까지
-> BOARD_NICKNAME은 MEMBER 테이블의 회원 닉네임을 사용하여 외래키로 지정
	(MEMBER 테이블에 존재하지 않는 사용자가 글을 작성할 순 없음)
	(MEMBER 테이터 삭제 시 참조데이터 NULL로 변경)


## 추가적인 OBJECT 생성하기 ##

1. 위에 사항을 확인하고 필요한 SEQUENCE 객체 만들기 
2. 회원번호 , 회원닉네임, 회원 이메일, 회원 작성글 제목 을
볼 수 있는 VIEW 만들기
3. MEMBER와 BOARD 테이블을 'M' 과 'B' 로도 검색 할 수 있게 만들기(비공개동의어로 생성)
ex)	SELECT * FROM M; -- MEMBER 테이블 정보가 보여야 함
*/



CREATE TABLE MEMBER(
    MEMBER_NO           NUMBER	    PRIMARY KEY,
    MEMBER_USERID       VARCHAR2(20)	UNIQUE NOT NULL,
    MEMBER_USERPWD      CHAR(20) NOT NULL,
    MEMBER_NICKNAME     VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_GENDER       VARCHAR2(3) CHECK(MEMBER_GENDER IN('남','여')) NOT NULL,
    MEMBER_EMAIL        VARCHAR2(30) NOT NULL
);
CREATE SEQUENCE SEQ_MEMBER_NO
START WITH 1000
INCREMENT BY 1
MAXVALUE 1000000
NOCYCLE
NOCACHE;
SELECT * FROM MEMBER;
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,'USER01','1111','NICK01','남','EMAIL01');
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,'USER02','2222','NICK02','남','EMAIL02');
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,'USER03','3333','NICK03','남','EMAIL03');
INSERT INTO MEMBER VALUES(SEQ_MEMBER_NO.NEXTVAL,'USER04','4444','NICK04','남','EMAIL04');

CREATE TABLE BOARD(
    BOARD_NO         NUMBER PRIMARY KEY,
    BOARD_TITLE      VARCHAR2(20) NOT NULL,
    BOARD_CONTENT    VARCHAR2(200) NOT NULL,
    BOARD_WRITEDATE  DATE NOT NULL,
    BOARD_NICKNAME   VARCHAR2(20) REFERENCES MEMBER(MEMBER_NICKNAME)ON DELETE SET NULL NOT NULL
);
CREATE SEQUENCE SEQ_BOARD_NO
START WITH 1
INCREMENT BY 1
MAXVALUE 500000
NOCYCLE
NOCACHE;
INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,'TITLE01','CONTENT01',SYSDATE,'NICK01');
INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,'TITLE02','CONTENT02',SYSDATE,'NICK02');
INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,'TITLE03','CONTENT03',SYSDATE,'NICK03');
INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,'TITLE04','CONTENT04',SYSDATE,'NICK04');
SELECT * FROM BOARD;

CREATE VIEW VIEW_MEMBERS
AS
SELECT MEMBER_NO, MEMBER_NICKNAME, MEMBER_EMAIL, BOARD_TITLE
FROM M
JOIN B ON(MEMBER_NICKNAME = BOARD_NICKNAME);
DROP VIEW VIEW_MEMBERS;

CREATE SYNONYM M FOR MEMBER;
CREATE SYNONYM B FOR BOARD;

SELECT * FROM M;
SELECT * FROM B;
SELECT * FROM VIEW_MEMBERS;

SELECT UC.CONSTRAINT_NAME, -- 제약조건 이름
UC.CONSTRAINT_TYPE, -- 제약조건 타입
UC.TABLE_NAME, -- 테이블이름
UCC.COLUMN_NAME, -- 컬럼이름
UC.SEARCH_CONDITION -- 제약조건 설명
FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC ON (UC.CONSTRAINT_NAME = UCC.CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'BOARD';

-- 설정 값에서 NOT NULL 값만 NULL로 설정 변경해주어도 됨.
-- 혹은 제약조건을 비활성화를 한 후 진행.











