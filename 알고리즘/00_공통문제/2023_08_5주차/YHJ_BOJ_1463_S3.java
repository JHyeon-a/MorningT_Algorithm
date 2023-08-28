package boj_1463_s3;

import java.util.Scanner;

public class Main {
	public static int X;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		int X1 = X;
		int X2 = X;
		int X3 = X;
		int cnt1 = 0;
		while(X1 != 1) {
			if(X1%3 == 0) {
				X1 /= 3;
				cnt1++;
			}else if(X1%2 == 0) {
//				System.out.println(123);
				X1 /= 2;
				cnt1++;
			}else {
				X1 -= 1;
				cnt1++;
			}
		}
		
		int cnt2 = 0;
		while(X2 != 1) {
			if(X2%3 == 0) {
				X2 /= 3;
				cnt2++;
			}else {
//				System.out.println(456);
				X2 -= 1;
				cnt2++;
			}
		}
		
		int cnt3 = 0;
		while(X3 != 1) {//가끔 -1먼저 왔으면 좋겠는데
			if(X3%3 == 0) {
				X3 /= 3;
				cnt3++;
			}else {
//				System.out.println(456);
				X3 -= 1;
				cnt3++;
			}
		}
//		System.out.println("1 "+cnt1+" 2 "+cnt2);
		if(cnt1>cnt2 && cnt2<cnt3) {
			System.out.println(cnt2);
		}else if(cnt1<cnt2 && cnt1<cnt3){
			System.out.println(cnt1);
		}else {
			System.out.println(cnt3);
		}
		
		
		
	}//main
	public static void cal(int init) {//카운트는 어떻게?
		if(init<X) {
			method2(init);
			cal(init);
			method3(init);
			cal(init);
			method1(init);
			
		}else if(init == X) {
			
		}
	}
	public static void method1(int init) {
		init += 1;
	}
	public static void method2(int init) {
		init *= 3;
	}
	public static void method3(int init) {
		init *= 2;
	}
	
	
	
}
