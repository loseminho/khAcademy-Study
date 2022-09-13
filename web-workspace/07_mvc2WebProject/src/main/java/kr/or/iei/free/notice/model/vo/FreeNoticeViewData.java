package kr.or.iei.free.notice.model.vo;

import java.util.ArrayList;


public class FreeNoticeViewData {
	   private FreeNotice fn;
	   private ArrayList<FreeNoticeComment> fCommentList;
	   private ArrayList<FreeNoticeComment> fReCommentList;
	public FreeNoticeViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FreeNoticeViewData(FreeNotice fn, ArrayList<FreeNoticeComment> fCommentList,
			ArrayList<FreeNoticeComment> fReCommentList) {
		super();
		this.fn = fn;
		this.fCommentList = fCommentList;
		this.fReCommentList = fReCommentList;
	}
	public FreeNotice getFn() {
		return fn;
	}
	public void setFn(FreeNotice fn) {
		this.fn = fn;
	}
	public ArrayList<FreeNoticeComment> getfCommentList() {
		return fCommentList;
	}
	public void setfCommentList(ArrayList<FreeNoticeComment> fCommentList) {
		this.fCommentList = fCommentList;
	}
	public ArrayList<FreeNoticeComment> getfReCommentList() {
		return fReCommentList;
	}
	public void setfReCommentList(ArrayList<FreeNoticeComment> fReCommentList) {
		this.fReCommentList = fReCommentList;
	}
	   
}
