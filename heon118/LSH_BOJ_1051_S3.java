package BOJ_1051_S3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // row
		int M = sc.nextInt(); // column

		int[][] square = new int[N][M]; // N*M 2차원 배열 생성
		for (int i = 0; i < N; i++) { // 입력값을 String으로 받아와 int로 넣기
			String[] s_square = sc.next().split("");
			for (int j = 0; j < M; j++) {
				square[i][j] = Integer.parseInt(s_square[j]);
			} // for - j
		} // for - i

		int[] dr = { 1, 0, 1 }; // 순서대로 우, 하, 우하단측 꼭짓점
		int[] dc = { 0, 1, 1 }; // 순서대로 우, 하, 우하단측 꼭짓점

		int res = 1; // 정사각형의 한 변의 길이
		int min = N > M ? M : N; // N과 M 중 작은 값
		for (int l = 1; l < min; l++) { // 정사각형의 크기 -> 1부터 아닌 min-1부터 시작하면 반복문을 덜 돌릴 수 있다.
			loop1: for (int i = 0; i < N - l; i++) { // [i]
				for (int j = 0; j < M - l; j++) { // [j]
					int cnt = 1; // [i][j]와 값이 같은 정사각형의 꼭짓점 개수
					for (int k = 0; k < 3; k++) { // dr, dc 요소 개수
						int nr = i + dr[k] * l; // [i][j]와 비교할 row값
						int nc = j + dc[k] * l; // [i][j]와 비교할 column값
						if (square[i][j] == square[nr][nc]) // 값 비교
							cnt++; // 값이 같으면 ++
						if (cnt == 4) { // 꼭짓점 4개의 값이 모두 같다면
							res = l + 1; // 정사각형의 한 변의 길이는 정해놓은 정사각형의 크기 l + 1
							break loop1; // 같은 l값으로 굳이 반복문을 진행할 필요는 없다.
						} // if - cnt==4
					} // for - k
				} // for - j
			} // for - i
		} // for - l
		System.out.println(res * res);
	} // main
} // class
