package kh.java.func;
import java.util.Scanner;


public class Cafe {
	int kind;
	boolean temp;	//t:아이스, f:핫
	boolean size;	//t:tall, f:grande
	int shot;		//샷 숫자
	boolean money;	//t:card, f:현금
	boolean inOut;	//t:매장,  f:테이크아웃
	int amount;		//구매 수량
	Scanner sc = new Scanner(System.in);
	
	
	public void start() {
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. 메뉴판 보기");
			System.out.println("2. 주문하기");
			System.out.println("3. 주문내역확인");
			System.out.println("4. 종료하기.");
			System.out.println("선택 > ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				showMenu();
				break;
			case 2:
				order();
				break;
			case 3:
				showLastOrder();
				break;
			case 4:
				System.out.println("프로그램이 종료 됩니다.");
				return;				
			}
		}	
	}
	public void showLastOrder() {
		System.out.println("===== 최근 주문 내역 =====");
		if(kind==1) {
			System.out.println("음료 종류 : 아메리카노");
		}else if(kind==2) {
			System.out.println("음료 종류 : 카페라떼");
		}else if(kind==3) {
			System.out.println("음료 종류 : 카페모카");
		}else if(kind==4) {
			System.out.println("음료 종류 : 아이스티");
		}else if(kind==5) {
			System.out.println("음료 종류 : 카모마일");
		}else {
			System.out.println("아직 음료를 주문하지 않았습니다.");
			return;
		}
		
		if(temp) {
			System.out.println("온도 : ICE");
		}else {
			System.out.println("온도 : HOT");
		}
		
		if(size) {
			System.out.println("음료 사이즈 : Tall");
		}else {
			System.out.println("음료 사이즈 : Grande");
		}
		System.out.println("샷 추가 횟수 : "+shot);
		
		if(money) {
			System.out.println("결제 수단 : 현금");
		}else {
			System.out.println("결제 수단 : 카드");
		}
		
		if(inOut) {
			System.out.println("매장에서 드시기 고르셨습니다.");
		}else {
			System.out.println("테이크아웃을 고르셨습니다.");
		}
		
		System.out.println("주문하신 음료의 수량은 : "+amount);
	}
	
	//주문하기 메소드
	public void order() {
		showMenu();
		System.out.println("음료를 선택하세요 : ");
		kind = sc.nextInt();
		System.out.println("온도선택[1.ICE /2.HOT] : ");
		int tempSel = sc.nextInt();
		if(tempSel== 1) {
			temp = true;
		}else {
			temp = false;
		}
		System.out.println("사이즈 선택[1.tall /2.grande] : ");
		int sizeSel = sc.nextInt();
		if(sizeSel== 1) {
			size = true;
		}else {
			size = false;
		}
		if(kind != 5) {
			System.out.println("샷 추가 몇번 하시겠습니까: ");
			shot = sc.nextInt();
		}else {
			shot = 0;
		}
		System.out.println("결제수단 선택[1.카드 /2.현금] : ");
		int moneySel = sc.nextInt();
		if(moneySel== 1) {
			money = true;
		}else {
			money = false;
		}
		System.out.println("[1.매장 /2.테이크아웃] : ");
		int inOutSel = sc.nextInt();
		if(inOutSel== 1) {
			inOut = true;
		}else {
			inOut = false;
		}
		System.out.println("수량 입력 : ");
		amount = sc.nextInt();
		System.out.println("주문이 완료 되었습니다.");
		brewing();
	}
	public void brewing() {
		System.out.println("    o");
		delay(500);
		System.out.println("    o");
		delay(500);
		System.out.println("    o");
		delay(500);
		System.out.println("    o");
		delay(500);
		System.out.println("    o");
		delay(500);
		System.out.println("│~~~~~~~├─┐");
		System.out.println("│       │ │");
		System.out.println("│       ├─┘");
		System.out.println("│       │");
		System.out.println("└───────┘");
		System.out.println("음료가 나왔습니다~");
	}
	
	public void delay(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//메뉴판 출력 메소드
	public void showMenu() {
		System.out.println("===== 음 료 =====");
		System.out.println("1. 아메리카노");
		System.out.println("2. 카페라떼");
		System.out.println("3. 카페모카");
		System.out.println("4. 아이스티");
		System.out.println("5. 카모마일");
	}
	
}
