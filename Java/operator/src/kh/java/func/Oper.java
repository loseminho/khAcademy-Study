package kh.java.func;
import java.util.Scanner;

public class Oper {
	public void test1() {
		//복합대입연산자(+=,-=,*=,/=,%=)
		int num = 10;
		//증감연산자
		num++;//num 값을 1 증가
		System.out.println("num : "+ num);
		++num;
		System.out.println("num : "+ num);
		num--;
		System.out.println("num : "+ num);
		--num;
		System.out.println("num : "+ num);
		//증감연산자의 연산 순서
		int num1 = 10;
		
		//변수++ : 후위연산(증감연산자가 변수 뒤에 위치할때)
		//인접 연산을 먼저 수행 후 자기 자신을 증/감
		//++변수 : 전위연산
		int num2 = (num1++)+2;
		System.out.println("num1 : "+ num1);
		System.out.println("num2 : "+ num2);

		int a = 10;
		int b = 10;
		int c;
		c = (a++)+(++b)+a;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("num1<num2 : "+(num1<num2));
		System.out.println("num1>num2 : "+(num1>num2));
		System.out.println("num1<=num2 : "+(num1<=num2));
		System.out.println("num1>=num2 : "+(num1>=num2));
		System.out.println("num1==num2 : "+(num1==num2));
		System.out.println("num1!=num2 : "+(num1!=num2));
		
	}
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("세번째 수 입력 : ");
		int num3 = sc.nextInt();
		
		System.out.println("네번째 수 입력 : ");
		int num4 = sc.nextInt();
		
		boolean result1 = num1<num2;
		boolean result2 = num3<num4;
		
		System.out.println("result 1 : "+result1);
		System.out.println("result 2 : "+result2);
		System.out.println("result 1 && result2 : "+(result1&&result2));
		System.out.println("result 1 || result2 : "+(result1||result2));
		System.out.println("!result 1 : "+ !result1);

	}
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력 : ");
		int num2 = sc. nextInt();
		int result = num1<num2?num1:num2;
		System.out.println("result : "+result);
	}
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		String a = "성인입니다. 어서오세요.";
		String c = "미성년자는 입장불가입니다.";
		
		String ans = (age>20)?a:c;
		System.out.println(ans);
		
	}
	
}
