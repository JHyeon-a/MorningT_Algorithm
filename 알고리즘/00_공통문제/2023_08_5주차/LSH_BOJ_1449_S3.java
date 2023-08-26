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

		int idx = 0; // 테이프 시작 위치
		int cnt = 1; // 테이프 개수 - 아래 반복문으로는 마지막 물 새는 곳은 붙일 수 없으므로 1로 시작
		for (int i = 0; i < N - 1; i++) {
			if (water[i+1] - water[idx] >= L) { // 다음 물 새는 곳이 테이프가 닿지 않는다면?
				cnt++; // 일단 테이프 붙여
				idx = i+1; // 테이프를 다음 물 새는 곳부터 시작해
			}
		}
		System.out.println(cnt);
	}
}
