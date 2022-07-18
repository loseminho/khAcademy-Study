package kh.java.func;
import java.util.Scanner;

public class MethodTest3 {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		System.out.println("정수를 입력하세요 : ");
		int num3 = sc.nextInt();
		System.out.println("정수를 입력하세요 : ");
		int num4 = sc.nextInt();
		add(num1,num2);
		add(num1,num2,num3,num4);
	}
	//add메소드 생성
	//매개변수로 정수를 받아서 합친 결과를 리턴하는 메소드
	public int add(int num1, int num2) {
		return (num1+num2);
	}
	public int add(int num1,int num2,int num3, int num4) {
		return (num1+num2+num3+num4);
	}
	
	
}
