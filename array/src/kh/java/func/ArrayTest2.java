package kh.java.func;

public class ArrayTest2 {
	public void test1() {
		//배열 얕은 복사
		int[] arr1 = {1,2,3,4,5};
		System.out.println(arr1[2]);//3출력
		System.out.println(arr1[3]);//4출력
		int[] arr2 = arr1;
		System.out.println(arr2[4]);//5출력
		arr1[4]= 100;
		System.out.println(arr1[4]);//100
		System.out.println(arr2[4]);//100
		arr2[0] = 10;
		System.out.println(arr2[0]);//10
		System.out.println(arr1[0]);//10
	}
	public void test2() {
		//배열 깊은 복사
		int[] arr1 = {1,2,3,4,5,6};
		//1) 배열을 생성해서 제어문을 통한 직접 복사
		//1-1 원본배열과 동일한 길이의 배열 생성
		int[] arr2 = new int[arr1.length];
		//1-2 for문을 통한 데이터 복사
		for(int i=0;i<arr1.length;i++) {
			arr2[i] = arr1[i];
		}
		arr1[2] = 100;
		arr2[3] = 200;
		
		System.out.println();
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		//2)Ssytem.arraycopy 사용(배열의 일부 데이터만 복사 가능)
		//2-1 원본배열과 길이가 같은 배열 선언
		int[] arr3 = new int[arr1.length];
		//System.arraycopy
		//(원본배열,
		// 원본배열을  복사할 시작 위치,
		// 데이터가 복사될 배열
		// 복사할 길이)
		System.arraycopy(arr1, 2, arr3, 1, 2);
		//arr1{1, 2, 100, 4, 5, 6} => arr3{0, 100, 4, 0, 0, 0}
		
		int[] arr4 = new int[arr2.length];
		System.arraycopy(arr2, 2, arr4, 2, 4);
		//arr2{1,2,3,200,5,6} => arr4{0,0,3,200,5,6}
		for(int i=0;i<arr4.length;i++) {
			System.out.print(arr4[i]+" ");
		}
		System.out.println();
		
		//3) clone();
		int[] arr5 = arr1.clone();
		for(int i=0;i<arr5.length;i++) {
			System.out.print(arr5[i]+" ");
		}		
	}
	public void test3() {
		int[][] arr = new int[2][3];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;
		/*
		 int k =1;
		 arr[0][0] = k++;
		 arr[0][1] = k++;
		 arr[0][2] = k++;
		 arr[1][0] = k++;
		 arr[1][1] = k++;
		 arr[1][2] = k++;
		 */
		int[][] arr1 = {{1,2,3},{4,5,6}};
		int[][] arr2 = new int[2][3];
		int num = 1;
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				arr2[i][j] = num++;
			}
		}

		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
				arr[i][j] = num++;
			}
			System.out.println();
		}
	}
	public void test4() {
		int[][] arr = new int[5][5];
		int num=1;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = num++;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}	
	}
	public void exam1() {
		int[][] arr = new int[5][5];
		int num=1;
		
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				arr[i][j] = 5*(i+1)-j;
//			}
//		}
		for(int i=0;i<arr.length;i++) {
			for(int j=4;0<=j;j--) {
				arr[i][j] = num++;
			}
		}
		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}			
	}
	public void exam2() {
		int[][] arr = new int[5][5];
		int num=1;
		
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				arr[i][j] = 1+i+5*j;
//			}
//		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[j][i] = num++;
			}
		}		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}			
	}
	public void exam3() {
		int[][] arr = new int[5][5];
		int num=1;

		
		for(int i=0;i<arr.length;i++) {
			for(int j=4;j>=0;j--) {
				arr[j][i] = num++;
			}
		}		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}			
	}	
	public void exam4() {
		int[][] arr = new int[5][5];
		int num=1;

		for(int i=0; i<5;i++) {
				if(i%2==0) {
					for(int j=0; j<5;j++) {
						arr[i][j] = num++;					
					}
				}else {
					for(int j=4; j<0;j--) {
						arr[i][j] = num++;					
					}
				}
			}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}			
	}	
}
