package SWEA_1220_Magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 2차원 배열 입력
			int[][] res = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res[i][j] = sc.nextInt();
				}
			}
			int total = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (res[j][i] == 1) {
						for (int k = j + 1; k < N; k++) {
							if (res[k][i] == 1) {
								break;
							} else if (res[k][i] == 2) {
								total++;
								break;
							} // 1을 만나면 중지, 2를 만나면 교착상태 +1, 중지
						} // 1인 값이 나오면 해당 열을 아래로 탐색
					} // 값이 1인 경우만 생각하면 됨
				} // 행 탐색 반복문
			} // 열 탐색 반복문
			System.out.printf("#%d %d%n", test_case, total);
		}
	}
}