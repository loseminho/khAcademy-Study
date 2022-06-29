package kh.java.func;

import kh.java.func2.MethodTest2;

public class MethodTest {
	public void test1() {
		MethodTest2 mt2 = new MethodTest2();
		mt2.test3();
		test2();
		System.out.println("test1 메소드 입니다.");
		test2();
	}
	private void test2() {
		System.out.println("test2 메소드 입니다.");
	}
	
	public int test4() {
		
	}
}
