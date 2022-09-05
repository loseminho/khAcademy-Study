package kr.or.iei.free.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.free.notice.model.dao.FreeNoticeDao;
import kr.or.iei.free.notice.model.vo.FreeNotice;
import kr.or.iei.free.notice.model.vo.FreeNoticePageData;

public class FreeNoticeService {
	private FreeNoticeDao fdao;

	public FreeNoticeService() {
		super();
		fdao = new FreeNoticeDao();
	}

	public FreeNoticePageData selectFreeNoticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		// 한 페이지 당 게시물 수
		int numPerPage = 10;
		// 요청 페이지 끝 번호 
		int end = numPerPage * reqPage;
		// 요청 페이지 시작 번호
		int start = end - numPerPage + 1;
		//해당하는 데이터를 ArrayList 형태로 읽어와서 flist에 담음
		ArrayList<FreeNotice> flist = fdao.selectNoticeList(conn, start, end);
		
		//전체페이지 수 계산하기 위해서는 전체 게시물 수 조회를 해야함
		int totalCount = fdao.selectNoticeCount(conn);
		
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			//만약 페이지가 딱 꽉차서 떨어지는 상황인 경우,
			//ex) 9(총페이지) = 90(게시물)/10(페이지당게시물수)
			totalPage = totalCount/numPerPage;
		}else {
			//딱 떨어지지 않는경우, 나머지를 담을 페이지가 하나 더 있어야 함.
			//ex) 9(총페이지) = 85(게시물)/10(페이지당게시물수) +1(여분페이지)
			totalPage = totalCount/numPerPage + 1;
		}
		
		//페이지에 보여줄 페이지 네비게이션 크기
		int pageNaviSize = 5;
		//시작번호 선언
		int PageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		String pageNavi = "<ul class='pagination circle-style'>";
		
		if(PageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+(PageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(PageNo == reqPage) {
				//내가 요청한 페이지(현재 위치한 페이지)
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeList.do?reqPage="+PageNo+"'>";
				pageNavi += PageNo;
				pageNavi += "</a></li>";
			}else {
				//아닌 경우(위치해있지 않은 페이지)
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+PageNo+"'>";
				pageNavi += PageNo;
				pageNavi += "</a></li>";
			}
			PageNo++;
			if(PageNo > totalPage) {
				break;
			}
		}
		if(PageNo<=totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+PageNo+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		FreeNoticePageData fnpd = new FreeNoticePageData(flist, pageNavi);
		JDBCTemplate.close(conn);
		return fnpd;
	}
	
	
}
