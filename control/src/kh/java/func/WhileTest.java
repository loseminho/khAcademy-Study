package kh.java.func;
import java.util.Scanner;

public class WhileTest {
	public void test1() {
		int i=1;
		while(i<5) {
			i++;
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번 출력하시겠습니까? : ");
		int num = sc.nextInt();
		int i=1;
		while(i==num) {
			System.out.println("안녕하세요");
			i++;
		}
	}
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까?");
		int num = sc.nextInt();
		System.out.println(num+"단 입니다.");
		int i=1;
		
		while(i<10) {
			System.out.println(num+" * "+i+" = "+num*i);	
			i++;
		}	
	}

	public void test4() {
		Scanner sc = new Scanner(System.in);
		int i=1;
		int sum = 0;
		
		while(i<6) {
			System.out.println("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			sum += num;
			i++;
		}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		
		int i=0;
		int sum = 0;
		int a = num1;
		
		while(i<num2-num1+1) {
			sum += a;
			a++;
			i++;
		}
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+sum);
	}

	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 : ");
		int num1 = sc.nextInt();
		int i=0;
		int sum=0;
		
		while(i<=num1/2) {
			sum+=i*2;
			i++;
		}
		System.out.println("짝수들의 합은 : "+sum);
	}
	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		do {
			System.out.println("10을 입력하셨네요");
			num++;
		}while(num==10);
	}
	public void test8() {
		while(true) {
			System.out.println("반복");
		}
	}
	public void test9() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("안녕하세요");
			System.out.print("한번 더 출력할가요?(1.yes/2.no) : ");
			int select = sc.nextInt();
			if(select == 1) {
				System.out.println("OK!");
			}else if(select == 2){
				break;
			}
			System.out.println("반복문 마지막부분");
		}
		System.out.println("반복문 종료 시 실행되는 코드");
	}
	public void test10() {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("i : "+i);
			System.out.println("1/2/3 중 하나를 선택하세요 : ");
			int select = sc.nextInt();
			if(select == 1) {
				break;
			}else if(select == 2) {
				continue;
			}else {
				System.out.println("그 외 나머지");
			}
			System.out.println("반복문 마지막부분");
		}
		System.out.println("반복문 끝나면 출력되는 문구");
	}
}



