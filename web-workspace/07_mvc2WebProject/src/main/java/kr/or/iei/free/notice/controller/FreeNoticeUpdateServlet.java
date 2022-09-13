package kr.or.iei.free.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.free.notice.model.service.FreeNoticeService;
import kr.or.iei.free.notice.model.vo.FreeNotice;
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;

/**
 * Servlet implementation class FreeNoticeUpdateServlet
 */
@WebServlet(name = "freeNoticeUpdate", urlPatterns = { "/freeNoticeUpdate.do" })
public class FreeNoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeNoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값추출
		//2-1. 파일업로드 경로 설정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice";
		
		//2-2. 파일 최대 크기 지정
		int maxSize = 10*1024*1024;
		
		//2-3. request -> MultipartRequest 변환(파일 업로드 시점)
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		int noticeNo = Integer.parseInt(mRequest.getParameter("FreeNoticeNo"));
		String noticeTitle = mRequest.getParameter("FreeNoticeTitle");
		String noticeContent = mRequest.getParameter("FreeNoticeContent");
		
		//기존 파일이 지워졌으면 delete, 그외 모든 값은 stay로 들어옴
		String status = mRequest.getParameter("status");
		
		//새 첨부파일이 있으면 새 첨부파일 값, 없으면 null로 값이 들어감
		String filename = mRequest.getOriginalFileName("upfile");
		String filepath = mRequest.getFilesystemName("upfile");
		
		//기존 첨부 파일이 있었으면 기존 첨부 파일 값, 없었으면 null
		String oldFilename = mRequest.getParameter("oldFilename");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		if(oldFilename != null && status.equals("stay")) {
			filename = oldFilename;
			filepath = oldFilepath;
		}
		FreeNotice fn = new FreeNotice();
		fn.setFreeNoticeNo(noticeNo);
		fn.setFreeNoticeTitle(noticeTitle);
		fn.setFreeNoticeContent(noticeContent);
		fn.setFreeFilename(filename);
		fn.setFreeFilepath(filepath);
		
		//3. 비즈니스 로직
		FreeNoticeService fservice = new FreeNoticeService();
		int result = fservice.updateNotice(fn);
		
		//4. 값 추출
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "변경완료");
			request.setAttribute("msg", "공지사항이 수정되었습니다");
			request.setAttribute("icon", "success");
			if(status.equals("delete")) {
				File delFile = new File(saveDirectory+"/"+oldFilepath);
				delFile.delete();
			}
		}else {
			request.setAttribute("title", "변경실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/freeNoticeView.do?FreeNoticeNo="+noticeNo);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
