package BOJ_1449_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 물 새는 곳
		int L = sc.nextInt(); // 테이프 길이

		int[] water = new int[N];

		for (int i = 0; i < N; i++) {
			water[i] = sc.nextInt();
		} // 물이 새는 곳

		Arrays.sort(water);

		int idx = 0;
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (water[i+1] - water[idx] >= L) {
				cnt++;
				idx = i+1;
			}
		}
		System.out.println(cnt);

	}
}
