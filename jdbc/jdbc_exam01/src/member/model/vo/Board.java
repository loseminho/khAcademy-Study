package member.model.vo;

import java.util.Date;

public class Board {
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private int boardWriter;
    private String memberName;
    private int readConut;
    private Date writeDate;
    public Board() {
        super();
    }

    public Board(int boardNo, String boardTitle, String boardContent, int boardWriter, int readConut, Date writeDate) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
        this.readConut = readConut;
        this.writeDate = writeDate;
    }
    public Board(int boardNo, String boardTitle, String boardContent, String memberName, int readConut, Date writeDate) {
        this.boardNo = boardNo;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.memberName = memberName;
        this.readConut = readConut;
        this.writeDate = writeDate;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }


    public int getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(int boardWriter) {
        this.boardWriter = boardWriter;
    }

    public int getReadConut() {
        return readConut;
    }

    public void setReadConut(int readConut) {
        this.readConut = readConut;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }
}
