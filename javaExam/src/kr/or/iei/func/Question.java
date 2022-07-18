package kr.or.iei.func;
import java.util.Scanner;

public class Question {
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		int[] num= new int[5];
		int sum = 0;
		
		//5개의 수 각 배열에 입력 받기 + 총 합 정산
		for(int i=0; i<5; i++) {
			System.out.println((i+1)+"번째 숫자 입력 : ");
			int num1 = sc.nextInt();
			num[i] = num1;
			sum += num1;
			System.out.println(num[i]);
		}
		
		//이력 받은 num 데이터 버블 정렬(오름차순)
		for (int i=num.length - 1; i > 1; i--) {
			for (int j = 0; j < i; j++) {
				if (num[j] > num[j + 1]) {
					int tmp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = tmp;
				}
			}
		}
		
		//정렬 결과 출력 반복문
		System.out.print("정렬 결과 : ");
		for(int i=0; i<5; i++) {
			System.out.printf(num[i]+"\t");
		}
		//합 출력
		System.out.println("입력한 수의 총 합은 : "+sum);
	}
}
