package BOJ_1463_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		
		arr = new int[N + 1];
		System.out.println(calc(N));
		System.out.println(Arrays.toString(arr));
	}

	public static int calc(int N) {
		if (N == 1)
			return 0;
		if (arr[N] != 0)
			return arr[N];
		cnt++;
		switch (N % 3) {
		case 0:
			System.out.println(N + " /3");
			N /= 3;
			arr[N] = calc(N);
			return arr[N];
		case 1:
			if (N % 2 == 0) {
				System.out.println(N + " case1 %2==0");
				N = calc(N / 2) < calc(N - 1) ? N / 2 : N - 1;
				System.out.println(N + " case1 %2==0");
				arr[N] = calc(N);
				return arr[N];
			} else {
				System.out.println(N + "case1 %2==1");
				N -= 1;
				arr[N] = calc(N);
				return arr[N];
			}
		case 2:
			if (N % 2 == 0) {
				System.out.println(N + " case2 %2==0");
				N = calc(N / 2) < calc(N - 1) ? N / 2 : N - 1;
				System.out.println(N + " case2 %2==0");
				arr[N] = calc(N);
				return arr[N];
			} else {
				System.out.println(N + " case2 %2==1");
				N -= 1;
				arr[N] = calc(N);
				return arr[N];
			}
		default:
			System.out.println("default");
			return arr[N];
		}

	}
}
