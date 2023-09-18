package BOJ_14501_퇴사_S2;

import java.util.Arrays;
import java.util.Scanner;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[][] schedule;
	static int max = 0;
	
	
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = sc.nextInt();
		
		schedule = new int[N][2];
		
		for(int i = 0; i<N; i++) {
			schedule[i][0] = sc.nextInt();//필요한 날짜
			schedule[i][1] = sc.nextInt();//수익
		}
		
		cal(0, 0);
		
		System.out.println(max);
		
	}
	public static void cal(int st, int p) {//처음 시작일 인덱스, 수익
		if(st>=N) {
			if(max<p) {
				max = p;
			}
			return;
		}else {
			//더하고 가기
			if(st+schedule[st][0]<=N)
			cal(st+schedule[st][0], p+schedule[st][1]);
			//pass
			cal(st+1, p);
		}
	}//cal
}