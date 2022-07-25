package kh.java.func;
import java.util.Scanner;

public class SwitchTest {
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~3사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		switch(num) {
		case 1 : 
			System.out.println("1을 입력하셨습니다.");
			break;
		case 2 : 
			System.out.println("2을 입력하셨습니다.");
			break;
		case 3 : 
			System.out.println("3을 입력하셨습니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			break;	
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str = sc.next();
		switch(str) {
		case "aa":
			System.out.println("aaaaaaaa");
			break;
		case "bb":
			System.out.println("bbbbbbbbbb");
			break;
		}
	}
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("일수를 알고싶은 달을 입력하세요 : ");
		int mon = sc.nextInt();
		
		switch(mon) {
		case 1:
		case 3:	
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(mon+"월달은 31일까지 있습니다.");
			break;			
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(mon+"월달은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(mon+"월달은 28일까지 있습니다.");
			break;			

		default :
			System.out.println("잘못 입력 하셨습니다.");			
		}
		
	}
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("장학금 지불 시스템입니다.");
		System.out.println("학점을 입력하세요(A,B,C,D,F) : ");
		String num = sc.next();		
		
		switch (num) {
		case "A":
			System.out.println("수고하셨습니다. 장학금을 100%지급해드리겠습니다.");
			break;
		case "B":
			System.out.println("아쉽군요 장학금을 50%지급해드리겠습니다.");
			break;			
		case "C":
			System.out.println("장학금을 바라시면 좀 더 열심히 해주세요.");
			break;
		case "D":
			System.out.println("크흠...............");
			break;		
		case "F":
			System.out.println("학사 경고입니다!!");
			break;
		default :
			System.out.println("잘못 입력 하셨습니다.");
		}
	}
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 계산기 프로그램 ====");
		System.out.println("연산자를 입력하세요(+,-,*,/) : ");
		String per = sc.next();				
		System.out.println("첫번째 정수를 입력 하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력 하세요 : ");
		int num2 = sc.nextInt();	
		
		switch (per) {
		case "+":
			System.out.println(num1+"+"+num2+"="+(num1+num2));
			break;
		case "-":
			System.out.println(num1+"-"+num2+"="+(num1-num2));
			break;
		case "*":
			System.out.println(num1+"*"+num2+"="+(num1*num2));
			break;
		case "/":
			System.out.println(num1+"/"+num2+"="+(num1/num2));
			break;
		default :
			System.out.println("잘못 입력 하셨습니다.");			
		}
	}
	
	
	
}

