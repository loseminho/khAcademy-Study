package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public void test1() {
		// 난수 : 임의의 값 / 무작위로 만들어지는 알 수 없는 값
		// 자바에서 난수를 제공하는 기능 : Random
		// Random 사용방법
		// 1) import java.util.Random
		// 2) Random r = new Random();
		Random r = new Random();
		int num = r.nextInt();// int 범위 내에서 랜덤숫자 1개 가져옴
		System.out.println(num);
		// random수의 범위를 지정하는법
		int num1 = r.nextInt(10);// 0부터 10개 중에 랜덤1개 가져옴
		System.out.println(num1);
		// 0 ~ 15 사이의 랜덤 숫자를 가져오고 싶다면?
		int num2 = r.nextInt(16);
		System.out.println(num2);
		// 10 ~ 30 사이의 랜덤 숫자를 가져오고 싶다면?
		int num3 = r.nextInt(21) + 10;
		System.out.println(num3);
		// 20 ~ 35 사이의 랜덤 숫자를 가져오고 싶다면?
		int num4 = r.nextInt(16) + 20;
		System.out.println(num4);
	}

	public void test2() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int win = 0;// 맞춘 횟수를 저장하기 위한 변수
		int lose = 0;// 틀린 횟수를 저장하기 위한 변수

		while (true) {
			System.out.println("====== 동전 앞/뒤 맞추기 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.println("선택 > ");
			int sel = sc.nextInt();

			if (sel == 1) {
				int coin = r.nextInt(2) + 1;
				System.out.println("동전은 앞면 일까요 뒷면 일 까요?(1:앞면, 2:뒷면) : ");
				int userSelect = sc.nextInt();
				if (userSelect == coin) {
					win++;
					System.out.println("정답입니다!");
				} else {
					lose++;
					System.out.println("틀렸습니다!");
				}
				System.out.println("코인의 값은 '" + coin + "' 이였습니다~");
			} else if (sel == 2) {
				System.out.println("게임 스코어 출력");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
			} else if (sel == 3) {
				System.out.println("게임 종료");
				break;
			}
		} // 메뉴 무한반복 while 종료지점
	}

	public void test3() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int win = 0;// 맞춘 횟수를 저장하기 위한 변수
		int lose = 0;// 틀린 횟수를 저장하기 위한 변수

		while (true) {
			System.out.println("=== 가위 바위 보 게임 ===");
			System.out.println("숫자를 선택하세요(1.가위/2.바위/3.보) : ");

			int uc = sc.nextInt();
			int computer = r.nextInt(3) + 1;
			String ans1;
			String ans2;
			System.out.println(uc);
			System.out.println(computer);

			if (uc == 1) {
				ans1 = "가위";
			} else if (uc == 2) {
				ans1 = "바위";
			} else {
				ans1 = "보";
			}

			if (computer == 1) {
				ans2 = "가위";
			} else if (computer == 2) {
				ans2 = "바위";
			} else {
				ans2 = "보";
			}
			System.out.println("======= 결과 ========");
			System.out.println("당신은 " + ans1 + "를 냈습니다.");
			System.out.println("컴퓨터는 " + ans2 + "를 냈습니다.");
			System.out.println("=====================");

			if (uc == computer) {
				System.out.println("비겼습니다.");
			} else if (uc == 1 && computer == 2) {
				System.out.println("당신이 졌습니다ㅠㅠ.");
			} else if (uc == 2 && computer == 3) {
				System.out.println("당신이 졌습니다ㅠㅠ.");
			} else if (uc == 3 && computer == 1) {
				System.out.println("당신이 졌습니다ㅠㅠ.");
			} else {
				System.out.println("당신이 이겼습니다.!!");
			}
			System.out.println();
			System.out.println();
		}
	}

	public void test4() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int score = 0;

		while (true) {
			System.out.println("====== 업/다운 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.println("선택 > ");
			int computer = r.nextInt(100) + 1;
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("===========게임 시작=========");
				while (true) {
					System.out.print(count + "회차 번호 입력 : ");
					int user = sc.nextInt();

					if (user == computer) {
						System.out.println("정답!!!");
						if (score == 0 || score > count) {
							score = count;
						}
						count = 1;
						break;
					} else if (user < computer) {
						count++;
						System.out.println("<<UP!!>>");
					} else {
						count++;
						System.out.println("<<DOWN>>");
					}
				}
				System.out.println(score);
			} else if (sel == 2) {
				if (score == 0) {
					System.out.println("아직 기록이 없습니다.");
				} else {
					System.out.println("게임 스코어 출력");
					System.out.println("당신의 최고 기록은 : " + score + "입니다!");
				}
			} else if (sel == 3) {
				System.out.println("게임 종료");
				break;
			}
		}
	}

	public void test5() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int score = 0;

		while (true) {
			System.out.println("====== 베스킨라빈스 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.println("선택 > ");
			int sel = sc.nextInt();
			int num = 0;
			int win = 0;
			int lose = 0;

			if (sel == 1) {
				System.out.println("===========게임 시작=========");
				while (true) {
					System.out.println("<<MY TURN>>");
					System.out.println("INPUT Number : ");
					int user = sc.nextInt();
					for (int i = 0; i < user; i++) {
						num++;
						System.out.println(num + "!");
					}
					if (num > 30) {
						System.out.println("당신의 패배입니다");
						lose++;
						break;
					}
					System.out.println("<<COMPUTER>>");
					int computer = r.nextInt(3) + 1;
					for (int j = 1; j < computer + 1; j++) {
						System.out.println(num + j + "!");
					}
					if (num + computer > 30) {
						System.out.println("컴퓨터의 패배입니다");
						win++;
						break;
					}
					num = num + computer;
				}
			} else if (sel == 2) {
				System.out.println("<<당신의 전적>>");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
			} else {
				System.out.println("게임 종료");
				break;
			}
		}
	}

	public void test6() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int money = 10000;
		int win = 0;
		int lose = 0;
		int draw = 0;

		while (true) {
			System.out.println("====== 다이스 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");
			System.out.println("선택 > ");
			int sel = sc.nextInt();
			int num = 0;

			if (sel == 1) {
				System.out.println("===========게임 시작=========");
				while (true) {
					if (money <= 0) {
						System.out.println("잔액이 없습니다. Bye~");
						break;
					}
					int num1 = r.nextInt(6) + 1;
					int num2 = r.nextInt(6) + 1;
					int num3 = r.nextInt(6) + 1;
					int num4 = r.nextInt(6) + 1;
					int num5 = r.nextInt(6) + 1;
					int num6 = r.nextInt(6) + 1;
					System.out.println("1번째 주사위 값 : " + num1);
					System.out.println("2번째 주사위 값 : " + num2);
					System.out.println("3번째 주사위 값 : " + num3);
					System.out.println("내 주사위 총 합" + (num1 + num2 + num3));
					System.out.println("배팅 하시겠습니까?[y/n] : ");
					char choi = sc.next().charAt(0);
					if ((int) choi == 110) {
						break;
					} else {
						System.out.println("얼마를 배팅하시겠습니까(현재 내 소지금 " + money + "원 : ");
						int mon = sc.nextInt();
						System.out.println("컴퓨터 1번째 주사위 값 : " + num4);
						System.out.println("컴퓨터 2번째 주사위 값 : " + num5);
						System.out.println("컴퓨터 3번째 주사위 값 : " + num6);
						System.out.println("내 주사위 총 합" + (num4 + num5 + num6));
						System.out.println("<< 결 과 >>");
						if ((num1 + num2 + num3) == (num4 + num5 + num6)) {
							System.out.println("비겼습니다!");
							draw++;
						} else if ((num1 + num2 + num3) > (num4 + num5 + num6)) {
							System.out.println("승리!!");
							win++;
							money += mon;
							System.out.println("+" + mon + "원!!");
						} else {
							System.out.println("패배!!");
							lose++;
							System.out.println("-" + mon + "원!!");
							money -= mon;
							if (money <= 0) {
								System.out.println("거지 Bye~");
								break;
							}
						}
						System.out.println("한번 더 하시겠습니까?[y/n] : ");
						char re = sc.next().charAt(0);
						if (re == (int) 110) {
							break;
						}
					}
				}
			} else if (sel == 2) {
				System.out.println("<<당신의 전적>>");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				System.out.println("DRAW : " + draw);
				System.out.println("내 소지금 : " + money + "원");
			} else {
				System.out.println("게임 종료");
				break;
			}
		}
	}

}
