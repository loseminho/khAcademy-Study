package kh.java.func;
import java.util.Random;
import java.util.Scanner;

public class noExample {
	public void test4() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int score=0;
		
			while(true) {
			System.out.println("====== 베스킨라빈스 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.println("선택 > ");
			int sel = sc.nextInt();		
			
			if(sel==1) {
				System.out.println("===========게임 시작=========");
				while(true){
					System.out.println("<<MY TURN>>");
					System.out.println("INPUT Number : ");
					int user = sc.nextInt();
					for(int i=1;i<user+1;i++) {
						System.out.println(i+"!");
					}
					System.out.println("<<COMPUTER>>");
					int computer = r.nextInt(3)+1;
					for(int j=0;j<computer;j++) {
						System.out.println(j+"!");
					}
				}
			}
			
			
			}
	}
}