package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번 째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번 째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("========= 결과 ========");
		int sum = num1+num2;
		int min = num1-num2;
		int mul = num1*num2;
		int div = num1/num2;
		int per = num1%num2;
		
		System.out.println("더하기 결과 : "+ sum);
		System.out.println("빼기 결과 : "+ min);
		System.out.println("곱하기 결과 : "+ mul);
		System.out.println("나누기 몫 : "+ div);
		System.out.println("나누기 나머지 : "+ per);
		
	}
	
	public void exam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("가로 길이 입력 : ");
		double num1 = sc.nextDouble();
		System.out.println("세로 길이 입력 : ");
		double num2 = sc.nextDouble();
		System.out.println("========= 결과 ========");
		double area = num1*num2;
		double peri = 2*(num1+num2);
		System.out.println("면적 : "+ area);
		System.out.println("둘레 : "+ peri);
		
	}
	
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("영어단어 입력 : ");
		String pull = sc.nextLine();
		char ch1 = pull.charAt(0);
		char ch2 = pull.charAt(1);
		char ch3 = pull.charAt(2);
		
		
		System.out.println("첫번째 문자 : "+ch1);
		System.out.println("두번째 문자 : "+ch2);
		System.out.println("세번째 문자 : "+ch3);
	}
}
