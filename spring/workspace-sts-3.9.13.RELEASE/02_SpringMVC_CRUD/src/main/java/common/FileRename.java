package common;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class FileRename {
	public String fileRename(String path, String filename) {
		// 파일 명 중에서 마지막 . 앞 까지 추출
		String onlyFilename = filename.substring(0,filename.lastIndexOf("."));// ex) test
		String extention = filename.substring(filename.lastIndexOf("."));// ex) .txt
		//실제 업로드할 파일 명
		String filepath = null;
		//파일 명이 중복되는 경우 뒤에 붙일 숫자
		int count = 0;
		while(true) {
			if(count==0) {
				//파일 이름 체크 반복 첫번째
				filepath = onlyFilename+extention;// test.txt
			}else {
				//중복 되는 경우, _숫자를 붙임
				filepath = onlyFilename+"_"+count+extention;
			}
			File checkFile = new File(path+filepath);
			if(!checkFile.exists()) {
				//중복 되는 파일 명이 없는 경우에 반복문 나감
				break;
			}
			count++;
		}
		return filepath;
	}
	
}
