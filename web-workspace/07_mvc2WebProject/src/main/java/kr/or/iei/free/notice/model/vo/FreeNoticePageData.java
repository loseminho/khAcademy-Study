package kr.or.iei.free.notice.model.vo;

import java.util.ArrayList;

public class FreeNoticePageData {
	private ArrayList<FreeNotice> Flist;
	private String FreePageNavi;
	
	public FreeNoticePageData() {
		super();
	}

	public FreeNoticePageData(ArrayList<FreeNotice> flist, String freePageNavi) {
		super();
		Flist = flist;
		FreePageNavi = freePageNavi;
	}

	public ArrayList<FreeNotice> getFlist() {
		return Flist;
	}

	public void setFlist(ArrayList<FreeNotice> flist) {
		Flist = flist;
	}

	public String getFreePageNavi() {
		return FreePageNavi;
	}

	public void setFreePageNavi(String freePageNavi) {
		FreePageNavi = freePageNavi;
	}
	
}
