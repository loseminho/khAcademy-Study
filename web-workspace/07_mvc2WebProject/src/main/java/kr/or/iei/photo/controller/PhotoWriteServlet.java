package kr.or.iei.photo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.photo.model.service.PhotoService;
import kr.or.iei.photo.model.vo.Photo;

/**
 * Servlet implementation class PhotoWriteServlet
 */
@WebServlet(name = "photoWrite", urlPatterns = { "/photoWrite.do" })
public class PhotoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값 추출
		//multpart/form-data(파일 업로드)형식이면 데이터를 한번 꺼낸 후 추출해야 함
		//->cos.jar 라이브러리를 사용해서 처리
		//2-1. 파일이 업로드 될 경로를 지정
		String root = getServletContext().getRealPath("/");// webapp 폴더의 절대 경로
		String saveDirectory = root+"upload/photo";
		
		//2-2. 파일 업로드 최대 용량 설정(일반적인 웹은 최대 용량 10MB)
		int maxSize = 10*1024*1024;
		
		//2-3. multipart/form-data 에서 데이터를 꺼내기 위한 객체
		//request -> MultipartRequest객체 변환(cos.jar)
		//매개변수 5개를 전달하면서 객체 생성
		//1)request,  2)파일 저장 경로,  3)파일 최대 크기,  4)인코딩 타입,  5)파일명 중복 처리 객체
		//MultipartRequest 객체가 생성 되는 시점에 파일이 업로드 완료
		//데이터 추출은 MultipartRequest에서 수행하게 됨
		//request에서 추출하면 모두 null 리턴하게 됨
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Photo p = new Photo();
		//데이터베이스에서 받아야 할 정보 (작성자, 제목, 내용, 경로)
		String photoTitle = mRequest.getParameter("photoTitle");
		String photoWriter = mRequest.getParameter("photoWriter");
		String photoContent = mRequest.getParameter("photoContent");
		String filepath = mRequest.getFilesystemName("imageFile");
		p.setFilepath(filepath);
		p.setPhotoContent(photoContent);
		p.setPhotoWriter(photoWriter);
		p.setPhotoTitle(photoTitle);
		
		//3. 비즈니스 로직
		PhotoService service = new PhotoService();
		int result = service.insertPhoto(p);
		
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "등록 완료");
			request.setAttribute("msg", "등록이 완료되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "등록 실패");
			request.setAttribute("msg", "등록이 실패하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/photoList.do");
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
