package BOJ_2573_G4_빙산;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();


		int[][] arr = new int[N][M];

		// 빙산 받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[] diri = new int[] { 0, 0, 1, -1 };
		int[] dirj = new int[] { 1, -1, 0, 0 };
		Queue<Integer> q = new LinkedList<>();

		int t = 0;
		while(true) {
			t++;
			int max = 0;
			boolean[][] visited = new boolean[N][M];
			int cnt = 0;
			int[][] seanum = new int[N][M];
			// 녹이기-1. 주변 바다 인접 면 수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int ni = i + diri[k];
							int nj = j + dirj[k];
							if (ni >= 0 && ni < N && nj >= 0 && nj < M && arr[ni][nj] == 0 && arr[i][j] > 0)
								seanum[i][j]++;
						} // k
					}
				} // j
			} // i
			// 녹이기-2. 녹이기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = Math.max(0, arr[i][j] - seanum[i][j]);
					if(max<arr[i][j]) max = arr[i][j];
				} // j
			} // i
			
			if(max == 0) {
				System.out.println(0);
				break;
			}
			
			// 덩어리 개수 찾기, BFS
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 0 && !visited[i][j]) {
						cnt++;
						q.add(i);
						q.add(j);
						visited[i][j] = true;
						while (!q.isEmpty()) {
							int pi = q.poll();
							int pj = q.poll();
							for (int k = 0; k < 4; k++) {
								int ni = pi + diri[k];
								int nj = pj + dirj[k];
								// 범위 안에 들어가고, 바다가 아니고, 방문 안 한 경우
								if (ni >= 0 && ni < N && nj >= 0 && nj < M && arr[ni][nj] != 0 && !visited[ni][nj]) {
									q.add(ni);
									q.add(nj);
									visited[ni][nj] = true;
								}
							} // k
						}
					}
				} // j
			} // i

			if (cnt >= 2) {
				System.out.println(t);
				break;
			}

		} // t

	}

}
