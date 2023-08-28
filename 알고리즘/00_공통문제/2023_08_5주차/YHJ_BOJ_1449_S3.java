package boj_1449_s3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//일단 다 카운트
		//그 다음에 세서 새로운 배열에 카운트
		//배열에서 구하기
		
		//꼭 연속 아니어도 커버 가능
		//ex- 12346(L==3) > 123/456(테이프 2개만 사용해도 가능)
		//길이 카운트하지 말고, 파이프 배열에 바로 수리하자
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//물 새는 곳 개수
		int L = sc.nextInt();//테이프 길이
		int[] pipe = new int[1001];
		
		for(int i = 0; i<N; i++) {
			pipe[sc.nextInt()]++;
		}//파이프 수리해야 하는 곳 체크
		
		int cnt = 0;
		for(int i = 1; i<pipe.length; i++) {
			if(pipe[i] == 1) {
				cnt++;
				for(int j = 0; j<L; j++) {
					if(i+j<pipe.length)
					pipe[i+j] = 0;
				}
			}
		}
		
		System.out.println(cnt);
		
		
//		int[] cnt = new int[1001];
//		int tmp = 0;
//		for(int i = 0; i<pipe.length; i++) {//수리해야하는 곳 길이 카운트
//			if(pipe[i] == 1 && pipe[i+1] == 1) {
//				tmp++;
//			}else if(pipe[i] == 1 && pipe[i+1] == 0) {
//				tmp++;
//				cnt[tmp]++;
//				tmp = 0;
//			}
//		}
//		
//		int tape = 0;
//		for(int i = 0; i<cnt.length; i++) {//필요한 테이프 개수 세기
//			if(cnt[i] != 0 && cnt[i]%L == 0) {
//				tape += cnt[i]*(i/L);
//			}else if(cnt[i] != 0 && cnt[i]%L != 0) {
//				tape += cnt[i]*((i/L)+1);
//			}
//		}
//		System.out.println(tape);
	}

}
