package BOJ_1564_ÆÑÅä¸®¾ó5_S2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long ans = 1;
		long tmp = 1000000000000L;
		
		for(int i = 1; i<=N; i++) {
			ans *= i;
			while(ans%10 == 0) {
				ans /= 10;
			}
			ans %= tmp;
		}
		ans %=100000;
		
		if(ans>10000) {
			System.out.println(ans);						
		}else {
			if(ans>1000) {
				System.out.println("0"+ans);
			}else if(ans>100) {
				System.out.println("00"+ans);
			}else if(ans>10) {
				System.out.println("000"+ans);
			}else if(ans>1){
				System.out.println("0000"+ans);
			}else {
				System.out.println("00000");
			}
		}
		
	}

}