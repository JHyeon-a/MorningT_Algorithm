package SWEA_1953_탈주범검거;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] map;
	static Queue<Node> queue;
	static boolean[][] visited;
	static int max;
	static int numCnt;

	static class Node {
		int r, c, cnt;

		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt(); // N: 세로 길이 (행)
			M = sc.nextInt(); // M: 가로 길이(열)
			R = sc.nextInt(); // R: 세로 위치
			C = sc.nextInt(); // C: 가로 위치
			L = sc.nextInt(); // L: 시간

			map = new int[N][M]; // map: 지도
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 지도 입력 끝

			max = 0;

			visited = new boolean[N][M]; // visited: 방문체크 배열

			queue = new LinkedList<>();
			queue.add(new Node(R, C, 1)); // 맨 처음 넣기

			visited[R][C] = true;

			numCnt = 0; // numCnt: 갯수 세는

			while (!queue.isEmpty()) {
				Node e = queue.poll(); // queue에서 e를 꺼내 오고

				max = Math.max(max, e.cnt);

				if (max > L)
					break;

				numCnt++;

				switch (map[e.r][e.c]) {
				case 1:
					top(e);
					bottom(e);
					left(e);
					right(e);

					break;
				case 2:
					top(e);
					bottom(e);
					break;
				case 3:
					left(e);
					right(e);
					break;
				case 4:
					top(e);
					right(e);
					break;
				case 5:
					bottom(e);
					right(e);
					break;
				case 6:
					bottom(e);
					left(e);
					break;
				case 7:
					top(e);
					left(e);
					break;

				default:
					break;
				}

			}

			System.out.println("#" + tc + " " + numCnt);

		} // tc

	}// main

	public static void top(Node e) {
		int nr = e.r - 1;
		if (nr >= 0 && nr < N && !visited[nr][e.c]) {
			if (map[nr][e.c] == 1 || map[nr][e.c] == 2 || map[nr][e.c] == 5 || map[nr][e.c] == 6) {
				visited[nr][e.c] = true;
				queue.add(new Node(nr, e.c, e.cnt + 1));
			}
		}
	}

	public static void bottom(Node e) {
		int nr = e.r + 1;
		if (nr >= 0 && nr < N && !visited[nr][e.c]) {
			if (map[nr][e.c] == 1 || map[nr][e.c] == 2 || map[nr][e.c] == 4 || map[nr][e.c] == 7) {
				visited[nr][e.c] = true;
				queue.add(new Node(nr, e.c, e.cnt + 1));
			}
		}

	}

	public static void left(Node e) {
		int nc = e.c - 1;
		if (nc >= 0 && nc < M && !visited[e.r][nc]) {
			if (map[e.r][nc] == 1 || map[e.r][nc] == 3 || map[e.r][nc] == 4 || map[e.r][nc] == 5) {
				visited[e.r][nc] = true;
				queue.add(new Node(e.r, nc, e.cnt + 1));
			}
		}

	}

	public static void right(Node e) {
		int nc = e.c + 1;
		if (nc >= 0 && nc < M && !visited[e.r][nc]) {
			if (map[e.r][nc] == 1 || map[e.r][nc] == 3 || map[e.r][nc] == 6 || map[e.r][nc] == 7) {
				visited[e.r][nc] = true;
				queue.add(new Node(e.r, nc, e.cnt + 1));
			}
		}

	}

}
