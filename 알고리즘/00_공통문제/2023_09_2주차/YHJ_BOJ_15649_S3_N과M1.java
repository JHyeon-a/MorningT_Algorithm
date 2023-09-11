package BOJ_15649_N과M;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static int N = sc.nextInt();
	public static int M = sc.nextInt();
	public static int[] arr = new int[M];
	public static int idx = 0;
	public static int check = 0;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		perm();		
		bw.flush();
		bw.close();
	
	}//main
	public static void perm() throws IOException {
		//기저
		if(idx >= M) {
			for(int i = 0; i<M; i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		//재귀
		for(int i = 1; i<=N; i++) {
			if(( check & (1<<(i-1) ) ) == 0) {
				arr[idx++] = i;
				check = check| (1<<(i-1));//사용하면 체크
				perm();
				idx--;
				check = check&(~(1<<(i-1)));//check 초기화
			}//if
		}
		
	}
}
