package BOJ_14501_S3_퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static int N;
	public static int[][] arr;
	public static int p = 0;
	public static int max = 0;
	public static int[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		check = new int[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());//상담시간
			arr[i][1] = Integer.parseInt(st.nextToken());//수익
		}//i
		
		profit(0);//시작날짜
		System.out.println(max);
		
	}//main
	
	public static void profit(int st) {//조합
		//재귀
		for(int i= st; i<N; i++) {
			System.out.println("st "+st+"  i "+i);
			if(check[i] == 0) {
				if(i+arr[i][0] > N) {
					System.out.println(p);
					if(max<p)
						max = p;
					return;
				}else if(i+arr[i][0] == N) {
					p += arr[i][1];
					System.out.println(p);
					if(max<p)
						max = p;
					p -= arr[i][1];
					return;
				}
				p += arr[i][1];
				profit(i + arr[i][0]);
				p -= arr[i][1];
			}
			profit(i+1);
		}//i

	}//profit

}