package kh.java.func;
import java.util.Scanner;

public class IfTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 10을 입력해보세요 : ");
		int num = sc.nextInt();
		if(num == 10) {
			System.out.println("잘했어요!");
		}
		if(num != 10) {
			System.out.println("10 입력하라니깐요?");
		}
		System.out.println("끝!!!!!!!!!");
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num%2==0) {
			System.out.println("짝수 입니다.");
		}else {
			System.out.println("홀수 입니다.");
		}
		
	}
	
	public void test3() {
		System.out.println("======숫자 구별 프로그램 ========");
		Scanner sc = new Scanner(System.in);
		System.out.println("임의의 정수를 입력 하세요 : ");
		int num = sc.nextInt();
		if(num==0) {
			System.out.println("당신이 입력한 수 "+num+"은(는) 0입니다.");
		}
		if(num>0) {
			System.out.println("당신이 입력한 수 "+num+"은(는) 양수입니다.");
		}
		if(num<0) {
			System.out.println("당신이 입력한 수 "+num+"은(는) 음수입니다.");
		}
	}
	
	public void test4() {
		System.out.println("======두수 비교 프로그램 ========");
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		if(num1<num2) {
			System.out.println(num1+"<"+num2);
			System.out.println("두번째 수가 더 큽니다.");
		}
		if(num1==num2) {
			System.out.println(num1+"="+num2);
			System.out.println("두 수가 같습니다.");
		}
		if(num1>num2) {
			System.out.println(num1+">"+num2);
			System.out.println("첫번째 수가 더 큽니다.");
		}		
	}
	
	public void test5() {
		System.out.println("====== 계산기 프로그램 ========");
		Scanner sc = new Scanner(System.in);
		System.out.println("연산자를 입력하세요(+,-,*,/) : ");
		char oper = sc.next().charAt(0);
		System.out.println("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		if(oper=='+') {
			int ans = num1+num2;
			System.out.println(num1+"+"+num2+"="+ans);
			//System.out.println("%d+%d=%d",num1,num2,num1+num2);
		}
		if(oper=='-') {
			int ans = num1-num2;
			System.out.println(num1+"-"+num2+"="+ans);
			//System.out.println("%d-%d=%d",num1,num2,num1-num2);
		}
		if(oper=='*') {
			int ans = num1*num2;
			System.out.println(num1+"*"+num2+"="+ans);
			//System.out.println("%d*%d=%d",num1,num2,num1*num2);
		}
		if(oper=='/') {
			double ans = (double)num1/num2;
			System.out.println(num1+"/"+num2+"="+ans);
			//System.out.println("%d/%d=%f",num1,num2,(double)num1/num2);
		}	
		//만약 String으로 문자 기입을 하고 싶을 시. 비교문에서는 equals()을 사용 해야 함.
		//ex)...    "-".equals(oper)  OR   oper.equals("+")
	}
	
	public void test6() {
			Scanner sc = new Scanner(System.in);
			System.out.println("정수를 입력하세요 : ");
			int num = sc.nextInt();
			int result = num%2;
			if(result == 0) {
				System.out.println("짝수입니다.");
			} else {
				System.out.println("홀수입니다.");
			}
	}
	
	public void test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		String str;
		if(num%2 == 0) {
			str = "짝수";
		}else {
			str = "홀수";
		}
		System.out.println(str);	
		
	}
	
	public void test8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num > 1000) {
			System.out.println("1000보다 큰 수 입니다.");
		}else if(num > 100) {
			System.out.println("100보다 큰 수 입니다.");
		}else if(num > 10) {
			System.out.println("10보다 큰 수 입니다.");
		}	
	}
	
	public void test9() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입장하실 총 인원은 몇명입니까? : ");
		int num1 = sc.nextInt();
		System.out.print("어른은 몇명입니까?(1인당 15000원) : ");
		int num2 = sc.nextInt();		
		System.out.print("아이는 몇명입니까?(1인당 5000원) : ");
		int num3 = sc.nextInt();

		if(num1 ==num2+num3) {
			System.out.println("지불하실 총 금액은"+(num2*15000+num3*5000)+"원 입니다.");
		}else if(num1 !=num2+num3){
			System.out.println("인원수가 맞지 않습니다.");
		}else {
			System.out.println("입장하실 인원을 다시 입력해주세요.");
		}		
	}
	
	public void test10() {
		System.out.println("==========퀴즈 프로그램===========");
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 퀴즈");
		System.out.println("사과는 영어로 무엇일까요(1.apple, 2.스티브잡스)? :");
		int ans = 0;
		int num1 = sc.nextInt();

		
		if(num1 ==1) {
			System.out.println("정답!!!");
			ans++;
		}else {
			System.out.println("땡!!");
		}
		
		System.out.println("두번째 퀴즈");
		System.out.println("바나나는 길어 길으면 기차 기차는 (1. 비싸,2.빨라)? :");
		int num2 = sc.nextInt();
		
		if(num2 ==1) {
			System.out.println("땡!!");
		}else {
			System.out.println("정답!!!");
			ans++;
		}
		System.out.println("총 "+ans+"문제를 맞췄습니다.");
	}
	
	public void test11() {
		System.out.println("==========심리테스트===========");
		Scanner sc = new Scanner(System.in);
		System.out.println("당신은 술을 좋아하십니까(1.yes,2.no)? : ");
		int num1 = sc.nextInt();
		
		if(num1==1) {
			System.out.println("당신은 담배를 피웁니까(1.yes,2.no)? : ");
			int num2 = sc.nextInt();
			
			if(num2 == 1) {
				System.out.println("담배는 건강에 좋지 않습니다.");
			}else {
				System.out.println("술은 간에 좋지 않습니다.");
			}
		}else {
			System.out.println("당신은 이성친구가 있습니까(1.yes,2.no)? : ");
			int num3 = sc.nextInt();
			if(num3==1) {
			System.out.println("올...ㅋ");
				}else {
					System.out.println("힘내요 ㅠㅠ");
					}
			}
	}
	
	public void test12() {
		System.out.println("===============대/소문자 변환 프로그램======================");
		Scanner sc = new Scanner(System.in);
		System.out.println("문자입력 : ");
		char num1 = sc.next().charAt(0);
		System.out.println("=====결과==========");
		//(65<= num1 && num1 <=90)
		//('a' <= num1 && num1 <= 'z')
		//(num1-32) == (num1^32) == (num1+32)
		
		if(num1>64) {
			if(num1<123) {
				if(num1>96) {
					System.out.println("소문자를 입력 하였습니다.");
					System.out.println("대문자로 변환 : "+ (char)(num1-32));
				}else if(num1<91) {
					System.out.println("대문자를 입력 하였습니다.");
					System.out.println("소문자로 변환 : "+(char)(num1+32));
				}
			}else {
				System.out.println("잘못입력하셨습니다. 영문자를 입력해주세요.");
			}
		}else {
			System.out.println("잘못입력하셨습니다. 영문자를 입력해주세요.");
		}
	}
	
	public void test13() {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력 : ");
		int num1 = sc.nextInt();
		System.out.println("===== 결과 =====");

		if(num1%3 == 0) {
			if(num1%4 ==0) {
				if(num1 ==0) {
					System.out.println("[0]은(는) 3의 배수도 4의 배수도 아닙니다.");
				}else {
					System.out.println("["+num1+"]은(는) 3의 배수면서 4의 배수입니다.");
				}
			}else {
				System.out.println("["+num1+"]은(는) 3의 배수 입니다.");
			}
		}else if(num1%4 == 0) {
			System.out.println("["+num1+"]은(는) 4의 배수 입니다.");
		}else {
			System.out.println("["+num1+"]은(는) 3의 배수도 4의 배수도 아닙니다.");
		}	
	}
	
	
	
}
