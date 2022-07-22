package kh.java.func;

public class ForExam {
	public void exam1() {
		for(int i=0;i<5;i++) {
			System.out.print("*");
		}
	}
	public void exam2() {
		for(int i=0;i<5;i++) {
			System.out.print("*");
			System.out.println();
		}
	}
	public void exam3() {
		for(int i=0;i<5;i++) {
			for(int j=1;j<5;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam4() {
		for(int i=1;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	public void exam5() {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<6;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public void exam6() {
		for(int i=0;i<5;i++) {
			for(int j=1;j<6;j++) {
				System.out.print(i+j);
			}
			System.out.println();
		}
	}			
	public void exam7() {
		for(int i=0;i<5;i++) {
			for(int j=5;j<10;j++) {
				System.out.print(j-i);
			}
			System.out.println();
		}
	}
	public void exam8() {
		for(int i=1;i<6;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam9() {
		for(int i=5;i>0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam10() {
		for(int i=1;i<6;i++) {
			
			for(int j=1;j<i;j++) {
				System.out.print(" ");
			}
			
			for(int k=0;k+i<6;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}	
	public void exam11() {
		for(int i=1;i<6;i++) {
			
			for(int j=0;j+i<6;j++) {
				System.out.print(" ");
			}
			
			for(int k=0;k<i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam12() {
		for(int i=1;i<2;i++) {
			for(int j=1;j+i<7;j++) {
				for(int k=0;k<j;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int j=1;j+i<7;j++) {
				for(int k=5;j<k;k--) {
					System.out.print("*");
				}
				System.out.println();			
			}
		}
	}	
	public void exam13() {
		for(int i=1;i<2;i++) {
			for(int j=1;j+i<7;j++) {
				for(int k=6;j<k;k--) {
					System.out.print("*");
				}
				System.out.println();
			}			
			for(int j=2;j<6;j++) {
				for(int k=0;k<j;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	public void exam16() {
		for(int i=1;i<6;i++) {
			for(int j=0;j<5-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<2*i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam17() {
		for(int i=1;i<6;i++) {
			for(int j=1;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<12-2*i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam18() {
		for(int i=1;i<6;i++) {
			for(int j=0;j<5-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++) {
				System.out.print("*");
			}		
			System.out.println();
		}
		for(int a=1;a<6;a++) {
			for(int b=1;b<a;b++) {
				System.out.print(" ");
			}
			for(int c=1;c<12-2*a;c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void exam19() {
		for(int i=1;i<5;i++) {
			for(int j=0;j<6-i;j++) {
				System.out.print("*");
			}
			for(int k=0;k<2*i-1;k++) {
				System.out.print(" ");
			}
			for(int l=0;l<6-i;l++) {
				System.out.print("*");
			}			
			System.out.println();
		}
		for(int a=1;a<6;a++) {
			for(int b=0;b<a;b++) {
				System.out.print("*");
			}
			for(int c=1;c<12-2*a;c++) {
				System.out.print(" ");
			}
			for(int d=0;d<a;d++) {
				System.out.print("*");
			}			
			System.out.println();
		}
	}

}

