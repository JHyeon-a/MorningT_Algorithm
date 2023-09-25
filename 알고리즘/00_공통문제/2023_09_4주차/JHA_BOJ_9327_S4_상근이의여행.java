package BOJ_9372_S4_상근이의여행;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N: 국가의 수
			int M = sc.nextInt(); // M: 비행기의 종류

			for (int i = 0; i < M; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
			}

			System.out.println(N - 1); // 최소 간선: N(들러야 하는 국가 수)-1

		} // TC

	}// main

}
