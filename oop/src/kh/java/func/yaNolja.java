package kh.java.func;

import java.util.Scanner;

public class yaNolja {
	Scanner sc = new Scanner(System.in);
	String map;
	String kind;
	String room;
	int time;
	String house;
	String name;
	
	public void start(){
		opening();
		while(true) {
			System.out.println("===== 야 놀 쟈 =====");
			System.out.println("1. 예약하기");
			System.out.println("2. 최근 예약내역 확인");
			System.out.println("3. 예약 취소");
			System.out.println("4. 어플 종료");
			System.out.println("입력 > ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				order();
				break;
			case 2:
				myOrder();
				break;
			case 3:
				cancel();
				break;
			case 4:
				System.out.println("프로그램이 종료 됩니다.");
				return;
			}
		}
	}
	
	
	public void order() {
		System.out.println("┌────지역선택──────┐");
		System.out.println(" 서울 경기 인천 강원 ");
		System.out.println(" 충청 경상 전라 제주 ");
		System.out.println("└───────────────┘");
		System.out.println("  지역을 선택하세요 : ");
		sc.nextLine();
		map = sc.nextLine();
		System.out.println();
		
		System.out.println("┌─숙소의 형태를 고르세요┐");
		System.out.println("   호텔  모텔   펜션   ");
		System.out.println("└────────────────┘");
		System.out.println("  입력하기  : ");
		kind = sc.nextLine();

		System.out.println();
		
		System.out.println("┌─숙소의 형태를 고르세요┐");
		System.out.println("   숙박     대실   ");
		System.out.println("└────────────────┘");
		System.out.println("  입력하기  : ");
		room = sc.nextLine();
		System.out.println();
		
		System.out.println("┌─희망하시는 입실 시간─┐");
		System.out.println("  ex) 오후1시 = 13   ");
		System.out.println("└────────────────┘");
		System.out.println("  입력하기[1~24] : ");
		time = sc.nextInt();
		System.out.println();		
		
		System.out.println("┌─현재 가능한 숙소 종류입니다.─┐");
		System.out.println("  1. xx숙소 : 13:00   ");
		System.out.println("  2. zz모텔 : 11:30   ");
		System.out.println("  3. yy빌  : 15:00   ");
		System.out.println("  4. pp빌  : 15:00   ");
		System.out.println("└──────────────────────┘");
		System.out.println("  입력하기[1~4] : ");
		int selectHouse = sc.nextInt();
		if(selectHouse==1) {
			house = "xx숙소";
		}else if(selectHouse==2) {
			house = "zz모텔";
		}else if(selectHouse==3) {
			house = "yy빌";
		}else if(selectHouse==4) {
			house = "pp빌";
		}
		
		System.out.println("예약자 성함 : ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("예약이 완료되었습니다.");
	}
	
	public void myOrder() {	
		System.out.println("===== 최근 주문 내역 =====");
		System.out.println("예약하신 지역 : "+map);
		System.out.println("숙소 형태    : "+kind);
		System.out.println("숙소 형태    : "+room);
		System.out.println("입실 시간    : "+time+"시");
		System.out.println("예약한 숙소명 : "+house);
		System.out.println("예약자 성함  : "+name);
		System.out.println("입니다.");
		
	}
	
	
	public void cancel() {
		System.out.println("예약 취소를 선택하셨습니다.");
		System.out.println("예약을 취소 해드릴까요?[y/n] : ");
		char userCancel = sc.next().charAt(0);
		if(userCancel=='y') {
			map = "현재 예약이 취소 되었습니다.";
			kind = "현재 예약이 취소 되었습니다.";
			room = "현재 예약이 취소 되었습니다.";
			time = 0;
			house = "현재 예약이 취소 되었습니다.";
		}else if(userCancel=='n'){
			System.out.println("이전 화면으로 돌아갑니다.");
		}else {
			System.out.println("잘못 입력 하셨습니다.");
			return;
		}
	}
	
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void opening() {
		System.out.println("		. ⠀⠀⣀⣴⣾⣿⣷⣦⣀⠀⠀⠀⠀⣀⣴⣾⣿⣿⣷⣦⣀ㅇㅑ");
		System.out.println("		⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣧  ");
		delay(500);
		System.out.println("		⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷노");
		System.out.println("		⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ㄹ");
		System.out.println("		⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿");
		delay(500);
		System.out.println("		⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟ㅈㅏ");
		System.out.println("		⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋ ");
		System.out.println("		 ⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟");
		System.out.println("		 ⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋");
		delay(500);
		System.out.println("		 ⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⠋");
		System.out.println("		⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⠟");
		System.out.println("		⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⡿⠋⠀");
	}
}
