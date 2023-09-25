package BOJ_2667_S1_단지번호붙이기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	//행, 열 좌표 저장하기 위한 클래스
	static class node {
		int r;
		int c;

		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 지도의 크기
		int[][] map = new int[N][N]; // map: 지도

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		} // map 입력 끝

		boolean[][] visited = new boolean[N][N]; // visited: 방문체크

		Queue<node> queue = new LinkedList<>(); // queue (정점 담아둘 것)

		List<Integer> result = new ArrayList<>(); // result: 결과 담는 리스트
		int resultSize = 0;	//resultSize: 총 단지의 수
		
		//행, 열을 돌면서 bfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0; //cnt: 현재 단지내 집의 수
				//만약 현재 지점이 방문하지 않은 곳이고 집이 있는 곳(1)이라면
				if (!visited[i][j] && map[i][j] == 1) {
					resultSize++;	//총 단지 수 +1
					cnt++;			//현재 단지내 집의 수 +1
					
					//queue에 현재의 i, j를 넣는다.
					queue.add(new node(i, j));
					visited[i][j] = true;	//방문체크

					//queue가 비어 있을 때까지 while문 반복
					while (!queue.isEmpty()) {
						//queue에서 꺼내온 node를 e라 하고
						node e = queue.poll();

						//4방향 델타를 돌 것
						for (int d = 0; d < 4; d++) {
							int nr = e.r + dr[d];
							int nc = e.c + dc[d];

							//만약 nr과 nc가 배열 범위 안이고 방문하지 않은 곳이며 map[nr][nc]가 집이 있는 곳이라면
							if (isInside(nr, nc, N) && !visited[nr][nc] && map[nr][nc] == 1) {
								//queue에 nr, nc를 포함하는 node 추가
								queue.add(new node(nr, nc));
								visited[nr][nc] = true;	//방문체크
								cnt++;	//현재 단지내 집의 수 +1
							} // if

						} // 델타

					} // while문

				}

				result.add(cnt);	//reuslt에 집의 수(cnt)를 추가

			} // j
		} // i

		System.out.println(resultSize);	//총 단지 수 출력

		Collections.sort(result);	//집의 수 오름차순 정렬

		//result.get(i)가 0이 아니면 출력
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) != 0) {
				System.out.println(result.get(i));
			}

		}

	}// mian

	//isInside: 배열 범위 안에 존재하면 true, 밖이라면 false 반환하는 메소드
	static boolean isInside(int nr, int nc, int N) {
		if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
			return true;
		} else {
			return false;
		}
	}

}// Class Main
