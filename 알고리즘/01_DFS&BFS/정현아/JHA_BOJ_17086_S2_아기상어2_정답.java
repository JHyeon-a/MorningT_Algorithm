package BOJ_17086_S2_아기상어2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * bfs 문제 (검색 후 이건 bfs+dp문제라는 것을 알게 됐다.)
 * 1. 상어 있는 곳을 queue에 담은 뒤
 * 2. queue에서 꺼내서 8방향 돌면서 방문하지 않은 0인 곳들을 +1 해 준뒤 queue에 담는다.
 * 3. 반복
 * 4. 마지막 max는 -1해서 출력한다.
 */

public class Main {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N: 공간의 크기(행의 개수)
		int M = Integer.parseInt(st.nextToken()); // M: 공간의 크기(열의 개수)

		// 상 하 좌 우 상좌 상우 하좌 하우
		int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

		int[][] adjArr = new int[N][M]; // adjArr: 인접행렬로 나타내기 위한 배열
		
		Queue<Node> queue = new LinkedList<>(); // bfs를 위한 queue 생성
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				adjArr[i][j] = Integer.parseInt(st2.nextToken());// adjArr[i][j]에 입력 받기
				if(adjArr[i][j] == 1) {
					queue.add(new Node(i, j));
				}
			}
		}

		
		
		while (!queue.isEmpty()) {
			Node e = queue.poll();

			for (int d = 0; d < 8; d++) {
				int nr = e.r + dr[d];
				int nc = e.c + dc[d];

				if (nr < N && nc < M && nr >= 0 && nc >= 0 && adjArr[nr][nc] == 0) {
					adjArr[nr][nc] = adjArr[e.r][e.c]+ 1; 
					queue.add(new Node(nr, nc));
				}

			}

		}


		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max = Math.max(max, adjArr[i][j]);

			}
		}

		
		bw.write(Integer.toString(max-1));
		bw.flush();
		bw.close();

	}// main

}
