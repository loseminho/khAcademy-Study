package kr.or.iei.free.notice.model.vo;

public class FreeNotice {
	private int FreeNoticeNo;
	private String FreeNoticeTitle;
	private String FreeNoticeWriter;
	private String FreeNoticeContent;
	private int FreeReadCount;
	private String FreeRegDate;
	private String FreeFilename;
	private String FreeFilepath;
	
	public FreeNotice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FreeNotice(int freeNoticeNo, String freeNoticeTitle, String freeNoticeWriter, String freeNoticeContent,
			int freeReadCount, String freeRegDate, String freeFilename, String freeFilepath) {
		super();
		FreeNoticeNo = freeNoticeNo;
		FreeNoticeTitle = freeNoticeTitle;
		FreeNoticeWriter = freeNoticeWriter;
		FreeNoticeContent = freeNoticeContent;
		FreeReadCount = freeReadCount;
		FreeRegDate = freeRegDate;
		FreeFilename = freeFilename;
		FreeFilepath = freeFilepath;
	}

	public int getFreeNoticeNo() {
		return FreeNoticeNo;
	}

	public void setFreeNoticeNo(int freeNoticeNo) {
		FreeNoticeNo = freeNoticeNo;
	}

	public String getFreeNoticeTitle() {
		return FreeNoticeTitle;
	}

	public void setFreeNoticeTitle(String freeNoticeTitle) {
		FreeNoticeTitle = freeNoticeTitle;
	}

	public String getFreeNoticeWriter() {
		return FreeNoticeWriter;
	}

	public void setFreeNoticeWriter(String freeNoticeWriter) {
		FreeNoticeWriter = freeNoticeWriter;
	}

	public String getFreeNoticeContentBr() {
		return FreeNoticeContent.replaceAll("\r\n", "<br>");
	}
	
	public String getFreeNoticeContent() {
		return FreeNoticeContent;
	}

	public void setFreeNoticeContent(String freeNoticeContent) {
		FreeNoticeContent = freeNoticeContent;
	}

	public int getFreeReadCount() {
		return FreeReadCount;
	}

	public void setFreeReadCount(int freeReadCount) {
		FreeReadCount = freeReadCount;
	}

	public String getFreeRegDate() {
		return FreeRegDate;
	}

	public void setFreeRegDate(String freeRegDate) {
		FreeRegDate = freeRegDate;
	}

	public String getFreeFilename() {
		return FreeFilename;
	}

	public void setFreeFilename(String freeFilename) {
		FreeFilename = freeFilename;
	}

	public String getFreeFilepath() {
		return FreeFilepath;
	}

	public void setFreeFilepath(String freeFilepath) {
		FreeFilepath = freeFilepath;
	}
	
	
}
