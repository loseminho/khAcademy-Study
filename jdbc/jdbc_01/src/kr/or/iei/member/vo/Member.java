package kr.or.iei.member.vo;

import java.sql.Date;

public class Member {
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberAddr;
    private String memberPhone;
    private int memberAge;
    private char memberGender;
    private Date enrollDate;
    public Member(String memberId, String memberPw, String memberName, String memberAddr, String memberPhone, int memberAge, char memberGender, Date enrollDate) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
        this.memberAddr = memberAddr;
        this.memberPhone = memberPhone;
        this.memberAge = memberAge;
        this.memberGender = memberGender;
        this.enrollDate = enrollDate;
    }

    public Member() {
        super();
    }

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPw() {
        return memberPw;
    }
    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberAddr() {
        return memberAddr;
    }
    public void setMemberAddr(String memberAddr) {
        this.memberAddr = memberAddr;
    }
    public String getMemberPhone() {
        return memberPhone;
    }
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    public int getMemberAge() {
        return memberAge;
    }
    public void setMemberAge(int memberAge) {
        this.memberAge = memberAge;
    }
    public char getMemberGender() {
        return memberGender;
    }
    public void setMemberGender(char memberGender) {
        this.memberGender = memberGender;
    }
    public Date getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

}
