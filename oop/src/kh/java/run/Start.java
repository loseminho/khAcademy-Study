package kh.java.run;
import kh.java.func.Cafe;
import kh.java.func.MethodTest;
import kh.java.func.MethodTest3;
import kh.java.func.TV;
import kh.java.func.Cafe;
import kh.java.func.yaNolja;

public class Start {

	public static void main(String[] args) {
		//객체생성하는 방법
		//1) 패키지가 다른경우 import
		//2) new 클래스명();
		// => 클래스 형태대로 메모리에 데이터 생성 후 주소 리턴
		// => 주소를 TV형태의 변수에 저장
		yaNolja yn = new yaNolja();
		yn.start();
	}

}
