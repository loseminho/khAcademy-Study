package kh.java.func;
import java.util.Scanner;

public class Scan {
	public void scan1() {
		//키보드로 값을 입력 받는 방법
		//1) import java.util.Scanner;
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하시오 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하시오 : ");
		int num2 = sc.nextInt();
		int sum1 = num1+num2;
		System.out.println("입력한 두 수의 합은 "+sum1+"이다.");

		/*System.out.println("실수를 입력 하세요 : ");
		double dNum = sc.nextDouble();
		float fNum = sc.nextFloat();*/
		
		//문자열 입력받는 방법
		//1) sc.next() : 띄어쓰기를 처리할 수 없어서 띄어쓰기 전까지만 처리 가능
		System.out.print("첫번째 문자열을 입력하세요 : ");
		String str1 = sc.next();
		System.out.println(str1);
		//2) sc.nextLine() : 띄어쓰기를 포함한 문자열 입력.
		System.out.print("두번째 문자열을 입력하세요 : ");
		sc.nextLine();//버퍼에 남아있는 엔터를 제거하는 용도
		String str2 = sc.nextLine();// 만약 문장 첫번째에 위치할 경우엔 바로 사용이 가능함.
		System.out.println(str2);
		
		//문자 입력 받기
		System.out.println("문자를 입력하세요 : ");
		char ch = sc.next().charAt(0);//문자열로 입력 받은 후 첫번째 글자만 추출
		System.out.println(ch);
	}
	public void scanExample1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신의 이름은? : ");
		String name = sc.next();
		
		System.out.println("당신의 나이는? : ");
		int age = sc.nextInt();
		
		System.out.println("당신의 주소는? : ");
		sc.nextLine();		
		String add = sc.nextLine();
		
		System.out.println("당신의 키는? : ");
		double height = sc.nextDouble();
		int b = (int)Math.round(height);// round() 메소드 사용 int 변환
		/*int c = height.intValue(); // intValue() 메소드 사용 Double int 변환*/
		
		System.out.println("당신의 몸무게는? : ");
		Double weight = sc.nextDouble();
		
		
		System.out.println("당신의 성별은? : ");
		char gender = sc.next().charAt(0);
		System.out.println("ㅁ입력한 값의 결과입니다ㅁ");
		System.out.println("당신의 이름 : "+name);
		System.out.println("당신의 나이 : "+age);
		System.out.println("당신의 주소 : "+add);
		System.out.println("당신의 키 : "+(int)height);
		System.out.println("당신의 몸무게 : "+weight);		
		System.out.println("당신의 성별 : "+gender);
		System.out.println("입니다.");
	}
	public void scanExample2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 입력 : ");
		int meth = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = sc.nextInt();
		int sum = (kor+meth+eng);// 합계
		double ever = (kor+meth+eng)/3.0;// 평균

		System.out.println("당신 성적의 총 합은 "+sum+"이고 평균은 "+ever+" 입니다!");
	}
	
}
