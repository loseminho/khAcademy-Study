package kh.java.func;

public class Variable {
	public void var1() {
		// 변수를 선언하는 방법 : 자료형 변수명;
		// 1.논리형 변수를 선언
		boolean bool;
		// 2.문자형 변수를 선언
		char ch;
		// 3.정수형 변수 선언
		int num;
		// 4.실수형 변수 선언
		double dNum;

		// 변수에 데이터를 저장하는 방법 -> 대입연산자 사용 (=)
		// a = b; -> b라는 값을 a 변수에 대입
		num = 10;
		System.out.println(num);
		
		// 문자형변수에 A 대입 후 출력
		ch = 'A';
		System.out.println(ch);
		
		//논리형변수에 true 대입 후 출력
		bool = true;
		System.out.println(bool);
		
		//실수형변수에 3.14 대입 후 출력
		dNum = 3.14;
		System.out.println(dNum);
		
		System.out.println(num-dNum);
		
		long lNum;
		lNum = 1000l;
		float fNum;
		fNum = 3.14f;
	}
	public void var2() {
		double dNum1 = 3.14;
		System.out.println(dNum1);
		final double PI = 3.14;//변수 내 값 변경 불가(상수).
		System.out.println(PI);
	}
	public void var3() {
		String str1;
		str1 = "안녕하세요";
		System.out.println(str1);
		str1 = "안녕히가세요";
		System.out.println(str1);
	}
	public void var4() {
		int num = 2147483647;
		int result = num + 1;
		System.out.println(result);//오버플로우로 인해 -가 됨.
		long result2 = (long)num + 1;
		System.out.println(result2);		
	}
	public void print() {
		//변수3개 선언(이름-String, 나이-int, 주소-String)
		String name = "진민호";
		int age = 27;
		String add = "인천";
		System.out.println("제 이름은 "+name+"이고 나이는 "+ age +"살 사는 곳은 "+ add + "입니다.");
		System.out.print("제 이름은 "+ name + "이고 나이는 " + age + "살 사는 곳은 " + add + "입니다."+ "\n");
		System.out.printf("제 이름은 %s이고 나이는 %d살 사는 곳은 %s입니다.\n", name,age,add);
		System.out.printf("%.3f",3.14159212341234);//.3 -> 소수점 셋째 자리 까지만 출력
		
		//제이름은 "진민호"입니다.
		System.out.println("제이름은 \"진민호\"입니다.");
		System.out.println("안녕\t하세요.");
		System.out.println("안녕\n하세요.");
		System.out.println("중간에 엔터를 넣고 싶으면 \\n를 사용하세요.");	
	}
	public void test1() {
		int one = 100;
		long first2 = 999900000000L;
		float first3 = 486.520f;
		double first4 = 5697.890123;
		char first5 = 'A';
		String first6 = "Hello JAVA";
		boolean seven = true;
		
		System.out.println("1 : "+ one);
		System.out.println("2 : "+ first2);		
		System.out.println("3 : "+ first3);
		System.out.println("4 : "+ first4);
		System.out.println("5 : "+ first5);
		System.out.println("6 : "+ first6);
		System.out.println("7 : "+ seven);
	}
	public void test2() {
		String line = "---------------------------------------------------------------------";
		String title = "이름 \t 나이 \t 성별 \t 지역 \t 전화번호 \t \t 이메일";
		String minho = "진민호 \t 27 \t 남 \t 인천 \t 01032677800 \t wlsalsghzo@naver.com";
		String one = "신다혜 \t 31 \t 여 \t 서울 \t 01056060423 \t wlsalsghzo@naver.com";
		String two = "진민호 \t 27 \t 남 \t 인천 \t 01032677800 \t wlsalsghzo@naver.com";
		
		System.out.println();
		System.out.println(title);
		System.out.println(line+"\n"+minho);
		System.out.println(line+"\n"+one);
		System.out.println(line+"\n"+two);
	}
	
}
