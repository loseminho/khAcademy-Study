package kh.java.func;
import java.util.Scanner;

public class ForTest {
	public void test1() {
		for(int i=1;i<=5;i++) {
			System.out.println("안녕하세요.");
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번 출력 하시겠습니까? ");
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			System.out.println("안녕하세요.");
		}
	}
	
	public void test3() {
		System.out.println("2단 입니다.");
		for(int i=1;i<=9;i++) {
			System.out.println("2 * "+i+"= "+(i*2));
		}
	}
	
	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇단을 출력 하시겠습니까?");
		int num = sc.nextInt();
		System.out.println(num+"단 입니다.");
		for(int i=1;i<=9;i++) {
			System.out.println(num+" * "+i+" = "+(i*num));
		}
	}
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++) {
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			sum += num;
		}
		System.out.println("입력한 5개의 정수의 합 : "+sum);
	}
	
	public void test6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();
		int sum = 0;
		int j = num2-num1;
		
		for(int i=0;i<=j;i++) {
			sum += num1;
			num1++;
		}
		System.out.println(num1+" ~ "+num2+"의 정수의 합 : "+sum);
	}
	
	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i=0;i<=num;i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		System.out.println("짝수들의 합은 : "+sum);
	}
	
	public void test8() {
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++){
				System.out.println(i+ " , "+j);
			}
		}
	}

	public void test9() {
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++){
				//System.out.print(i+ " *"+j+" = "+i*j+"  ");
				System.out.printf("%d*%d =%d  ",j,i,i*j);
			}
			System.out.println();
		}
	}	
	
	
	
	
}
