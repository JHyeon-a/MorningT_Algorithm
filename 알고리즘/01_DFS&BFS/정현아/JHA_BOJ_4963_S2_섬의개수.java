package BOJ_4963_S2_섬의개수;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//Node class: 행과 열을 한 번에 queue에 입력하기 위해서 만든 클래스
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 상 하 좌 우 상좌 상우 하좌 하우
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//0을 입력 받으면 멈추는 while문
		while (true) {
			int w = sc.nextInt(); // w: 너비(col)
			//만약 입력 받은 w가 0이면 stop
			if (w == 0)
				break;
			int h = sc.nextInt(); // h: 높이 (row)

			int[][] adjArr = new int[h][w]; // adjArr: 인접행렬(map 입력 받기)

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					adjArr[i][j] = sc.nextInt();
				}
			} // map 입력 끝

			//방문체크가 굳이 필요 없을 것 같아서 (왜냐면 섬인 부분이 있으면 0으로 만들어 버리면 되기 때문)
//			boolean[][] visited = new boolean[h][w];	//visited: 방문체크 배열

			Queue<Node> queue = new LinkedList<>(); // queue: 큐

			int cnt = 0;	//cnt: 섬의 개수
			for (int i = 0; i < h; i++) {		//행
				for (int j = 0; j < w; j++) {	//열
					//만약 바다면(0이면) 다음으로 넘어가기
					if (adjArr[i][j] == 0)
						continue;

					//바다가 아니면
					cnt++;	//섬의 개수 +1
					queue.add(new Node(i, j));	//queue에 i, j 넣기
					adjArr[i][j] = 0;	//해당 지점 바다로 만들기

					//bfs (queue가 비어 있기 전까지 돌리기)
					while (!queue.isEmpty()) {
						Node e = queue.poll();	//queue에서 꺼내오고

						//8방향 델타를 돌 거야
						for (int d = 0; d < 8; d++) {
							int nr = e.r + dr[d];
							int nc = e.c + dc[d];

							//map 범위 안에 있고, adjArr[nr][nc]가 땅이면
							if (nr >= 0 && nc >= 0 && nr < h && nc < w && adjArr[nr][nc] == 1) {
								adjArr[nr][nc] = 0;				//바다로 바꾸고
								queue.add(new Node(nr, nc));	//queue에 넣기
							}

						}//델타 for문

					}//bfs while

				}//w

			}//h

			System.out.println(cnt);

		} // 0이면 그만 입력 받기

	}// main

}
