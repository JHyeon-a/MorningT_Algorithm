package BOJ_14501_���_S2;

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
			schedule[i][0] = sc.nextInt();//�ʿ��� ��¥
			schedule[i][1] = sc.nextInt();//����
		}
		
		cal(0, 0);
		
		System.out.println(max);
		
	}
	public static void cal(int st, int p) {//ó�� ������ �ε���, ����
		if(st>=N) {
			if(max<p) {
				max = p;
			}
			return;
		}else {
			//���ϰ� ����
			if(st+schedule[st][0]<=N)
			cal(st+schedule[st][0], p+schedule[st][1]);
			//pass
			cal(st+1, p);
		}
	}//cal
}