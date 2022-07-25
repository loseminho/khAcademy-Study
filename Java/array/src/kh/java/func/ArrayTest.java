package kh.java.func;

import java.util.Scanner;
import java.util.Random;

public class ArrayTest {
	public void test1() {
		// 정수형 변수 5개를 선언한 후 1/2/3/4/5를 저장하고 출력
		int num0 = 1;
		int num1 = 2;
		int num2 = 3;
		int num3 = 4;
		int num4 = 5;
		System.out.println("변수를 이용한 값 출력");
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);

		// 정수형 배열 이용해서 5개 값 저장후 출력
		// 정수 5개를 저장 할 수 있는 배열 선언
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.println("배열을 이용한 값 출력");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		// 배열의 경우 반복문을 이용해서 출력 가능
		System.out.println("반복문을 이용한 배열 출력");
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
	}

	public void test2() {
		// 배열에 데이터 1,2,3,4,5 넣기
		// 1) 길이가 5인 배열 선언 후 인덱스 번호로 데이터 넣기
		int[] arr1 = new int[5];
		// 선언 후 기본값으로 배열 초기화
		for (int i = 0; i < 5; i++) {
			System.out.println(arr1[i]);
		}
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;

		for (int i = 0; i < 5; i++) {
			System.out.println(arr1[i]);
		}

		// 2) 배열 선언 동시에 값 대입
		int[] arr2 = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < 5; i++) {
			System.out.println(arr2[i]);
		}
	}

	public void test3() {
		// 배열에 "hi","Hello","bye"를 대입
		// 1) 길이가 3인 배열을 선언하여 인덱스를 이용해서 대입
		String[] arr1 = new String[3];
		arr1[0] = "hi";
		arr1[1] = "Hello";
		arr1[2] = "bye";
		for (int i = 0; i < 3; i++) {
			System.out.println(arr1[i]);
		}
		// 2) 배열 선언하면서 동시에 값 대입{}이용
		String[] arr2 = { "hi", "Hello", "bye" };
		for (int i = 0; i < 3; i++) {
			System.out.println(arr2[i]);
		}
	}

	public void test4() {
		// 길이가 4인 정수형 배열 선언
		// 스캐너를 이용해서 국어점수, 수학점수,영어 점수를
		// 입력 받아서 배열에 저장
		// 배열 마지막 공간에는 합계를 저장
		// 출력은 국어점수/수학점수/영어점수/합계/평균
		// 출력 예시 )
		// 국어 : 80 / 수학 : 50 / 영어 :50 / 합계 : 180 / 평균 : 60
		Scanner sc = new Scanner(System.in);
		int[] num = new int[4];
		String[] name = { "국어", "수학", "영어", "합계", "평균" };

		for (int i = 0; i < 3; i++) {
			System.out.printf("당신의 %s 점수는? : \n", name[i]);
			int num1 = sc.nextInt();
			num[i] = num1;
			num[3] += num1;
		}
		System.out.println("국어 : " + num[0] + " / 수학 : " + num[1] + " / 영어 : " + num[2] + " / 합계 : " + num[3]
				+ " / 평균 : " + (double) num[3] / 3);
	}

	public void test5() {
		// 길이 100인 정수형 배열 선언
		// 1~100까지값 순서대로 대입 후 출력
		int[] num = new int[100];
		for (int i = 0; i < 100; i++) {
			num[i] = i + 1;
			System.out.println(num[i]);
		}
	}

	public void test6() {
		// 길이가 5인 정수형 배열을 선언
		// 스캐너 + for문을 이용하여 정수 5개 입력 받은 후 입력 받은 정수 출력
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "번째 숫자를 입력하세요 : ");
			int num1 = sc.nextInt();
			arr[i] = num1;
		}
		// 배열 0번째 값과 배열 1번째 값을 비교하여
		// 0번째가 큰 경우 두 수의 자리를 변경
		for (int j = arr.length - 1; j > 1; j--) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++)
//		System.out.println("입력받은 정수는 "+arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+",");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + "\t");
			}
	}

	
	
	public void test7() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("===== 로또 프로그램 =====");
		int[] user = new int[6]; // 유저 최종 결과를 담을 6자리 공간
		int[] computer = new int[6]; // 컴퓨터 최종 결과를 담을 6자리 공간
		int count = 0;
		// 유저, 컴퓨터 번호 입력 받기
		for(int i = 0; i < user.length; i++) {
			System.out.println(i+1 + "번째 로또 번호 입력(1~45) : ");
			int pick = sc.nextInt();
			user[i] = pick;			
			if(user[i]<1 || user[i]>45) {
				System.out.println("잘못 입력하셨습니다. 1~45 사이 값을 입력 해주세요.");
				i--;
				}
			computer[i] = r.nextInt(45)+1; // 랜덤숫자 생성
			//랜덤 숫자 중복 제거
			for(int j = 0; j< i; j++) {
				if(computer[i] == computer[j]){
					i--;
				}
				if(user[i]== user[j]) {
					i--;
					System.out.println("이미 중복된 번호입니다. 다시 입력해주세요.");
				}
				if(computer[i] == user[j]) {
					count++;//유저와 컴퓨터가 일치하는 숫자를 세고 저장
				}
			}
		}
		// 번호 오름차순으로 순서 변경 (유저, 컴퓨터)
		for(int j = user.length-1; j > 1; j--){
			for(int i = 0; i < j; i++){
				if(user[i] > user[i + 1]){
					int tmp = user[i];
					user[i] = user[i + 1];
					user[i + 1] = tmp;
				}
				if(computer[i] > computer[i + 1]){
					int tmp = computer[i];
					computer[i] = computer[i + 1];
					computer[i + 1] = tmp;
				}
			}
		}
		//최종 결과 출력
		System.out.println("=====최종 결과 출력=====");
		System.out.println("사용자 번호");
		for(int i=0; i<user.length;i++) {
			System.out.print(user[i]+ "  ");
		}
		
		System.out.println("컴퓨터 번호");
		for(int i=0; i<computer.length;i++) {
			System.out.print(computer[i]+ "  ");
		}
		
		System.out.println("맞은 갯수 : "+count);
		if(count == 6) {
			System.out.println("축하합니다! 1등입니다.");
		}else if(count == 5) {
			System.out.println("축하합니다! 2등입니다.");
		}else if(count == 4) {
			System.out.println("축하합니다! 3등입니다.");
		}else if(count == 3) {
			System.out.println("축하합니다! 4등입니다.");
		}else {
			System.out.println("꽝!");//case로 진행해도 됨.
		}
	}
	public void motel() {
		Scanner sc = new Scanner(System.in);
		//정수배열 선언 길이 10
		int[] rooms = new int[10];
		//숫자 2가지만 사용한다면 boolean[] rooms를 하는게 더 좋긴 함.
		//배열의 각 인덱스가 방을 의미
		//0인 경우, 비어있는 방
		//1인 경우, 손님이 있는 방
		
		while(true) {
			System.out.println("모텔관리프로그램 v1.0");
			System.out.println("1.입실  2.퇴실  3.방보기  4.종료");
			System.out.print("선택 > ");
			int user = sc.nextInt();
			
			if(user==1) {
				System.out.println("몇번 방에 입실하겠습니까?");
				int user1 = sc.nextInt();
				if(rooms[user1-1]==1) {
					System.out.println(user1+"번 방에는 이미 손님이 있습니다.");
				}else {
					rooms[user1-1]=1;
					System.out.println(user1+"번 방에 입실하였습니다.");
				}
				
			}else if(user==2) {
				System.out.println("몇번 방에서 퇴실하겠습니까?");
				int user2 = sc.nextInt();
				if(rooms[user2-1]==1) {
					rooms[user2-1]=0;
					System.out.println(user2+"번 방에서 퇴실하였습니다.");
				}else {
					System.out.println(user2+"번 방은 현재 빈 방입니다.");
				}
				
			}else if(user==3) {
				for(int i=0;i<10;i++) {
					if(rooms[i]==0) {
						System.out.println((i+1)+"번 방이 현재 비어있습니다.");
					}else {
						System.out.println((i+1)+"번 방에는 현재 손님이 있습니다.");
					}
				}
			}else if(user==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("번호를 잘못 입력하였습니다.");
			}	
		}
	}
}
