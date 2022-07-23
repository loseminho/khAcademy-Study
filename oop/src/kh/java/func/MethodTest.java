package kh.java.func;
import kh.java.func2.MethodTest2;
import java.util.Scanner;

public class MethodTest {
	public void test6() {
		int num= 100;
		System.out.println("num : "+ num);
		test7(num);//매개변수로 기본형 데이터를 전송 시 '값'을 복사.
		System.out.println("num : "+ num);
		int[] arr = {1,2,3,4,5};
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
			System.out.println();
			//참조형데이터를 매개변수로 전달하면
			// '주소값'이 전달 -> 얕은복사가 됨.
			test8(arr);
			System.out.println(arr[2]);
			test9(arr[2]);
			System.out.println(arr[2]);
		}
	}
	public void test7(int num) {
		num += 100;
		System.out.println("test7 : "+num);
	}
	public void test8(int[] arr) {
		arr[2] = 100;
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void test9(int num) {
		num += 300;
	}
	
	
	
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		//입력 받은 두 수의 합을 출력
		int sum = add(num1, num2);
		System.out.println("입력받은 두 수의 합은 : "+sum);
		//입력받은 두 수의 나누기 결과를 받아오는 메소드 생성
		//나누기 결과는 실수타입으로 메소드이름 -> div
		double div = div(num1, num2);
		System.out.println("입력 받은 두 수를 나누면 : "+ div);
		div(num1,num2);
	}
	public int add(int num1, int num2) {
		System.out.println("num1 : "+ num1);
		System.out.println("num2 : "+ num2);
		int sum = num1+num2;
		return sum;
	}
	public double div(int num1,int num2) {
		double div = (double)num1/num2;
		return div;
	}

	public void test1() {
		MethodTest2 mt2 = new MethodTest2();
		mt2.test3();
		test2();
		System.out.println("test1 메소드 입니다.");
		int num = test4();
		System.out.println(num);
		test2();
	}
	private void test2() {
		System.out.println("test2 메소드 입니다.");
	}
	
	public int test4() {
		return 100;
	}
}
