--CREATE 실습
/*
1. 새로운 계정 생성(관리자 계정에서 진행)
- 계정이름 : ddlexam
- 비밀번호 : 1111
-> 계정생성 후 권한부여
2. 새로 생성된 계정에서 다음 조건에 만족하는 TABLE들을 생성하시오
첫번째 테이블 명 : EXPERT_TBL
컬럼명
MEMBER_CODE(number) - 기본키					-- 회원전용코드
MEMBER_ID (varchar2(20) ) - 중복금지			-- 회원 아이디
MEMBER_PWD (varchar2(20)) - NULL 값 허용금지	-- 회원 비밀번호
MEMBER_NAME(varchar2(10)) - NULL값 허용 금지	-- 회원 이름
MEMBER_ADDR (varchar2(50)) - NULL값 허용금지	-- 회원 거주지
GENDER (char(3)) - '남' 혹은 '여'로만 입력 가능		-- 성별
PHONE(char(13))
두번째 테이블 명 : COMPANY_TBL
컬럼명
MEMBER_CODE(number) - 외래키(EXPERT_TBL의 기본키 참조)	-- 회원전용코드
SKILL(varchar2(50)) 					-- 회원 능력
-> 회원이 삭제되는 경우 COMPANY_TBL의 삭제회원 연관정보는 모두 삭제되게 만드세요.
데이터를 입력 및 삭제 해서 정상적으로 동작하는지 확인해보세요
※ 테이블 생성 이후 수정사항발생하여 다시만들어야 하는 경우
DROP TABLE 테이블명;
-> 테이블 삭제 후 재생성(삭제하지 않고 다시 생성하는경우 에러가 발생)?
*/
CREATE TABLE EXPERT_TBL(
MEMBER_CODE     number PRIMARY KEY,		             -- 회원전용코드
MEMBER_ID       varchar2(20) UNIQUE,                 -- 회원 아이디
MEMBER_PWD      varchar2(20) NOT NULL,               -- 회원 비밀번호
MEMBER_NAME     varchar2(10) NOT NULL,	             -- 회원 이름
MEMBER_ADDR     varchar2(50) NOT NULL,               -- 회원 거주지
GENDER          char(3) CHECK(GENDER IN('남','여')),  --성별
PHON            char(13)
);
INSERT INTO EXPERT_TBL
VALUES (1,'USER1','1234','진민호','삼산동','남','01032677800');
INSERT INTO EXPERT_TBL
VALUES (2,'USER2','1234','이민호','육산동','여','01022222222');
DELETE FROM EXPERT_TBL WHERE MEMBER_CODE = 2;

SELECT * FROM EXPERT_TBL;

CREATE TABLE COMPANY_TBL(
MEMBER_CODE     number REFERENCES EXPERT_TBL(MEMBER_CODE) ON DELETE CASCADE,
--회원 전용 코드
SKILL           varchar2(50)
-- 회원 능력
);
INSERT INTO COMPANY_TBL VALUES (1,'불쏘기');
INSERT INTO COMPANY_TBL VALUES (2,'잠들기');
INSERT INTO COMPANY_TBL VALUES (2,'깨기');

SELECT * FROM COMPANY_TBL;





