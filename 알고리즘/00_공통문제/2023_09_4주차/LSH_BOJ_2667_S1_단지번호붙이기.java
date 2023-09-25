package BOJ_2667_S1_단지번호붙이기;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 지도의 크기

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s.split("")[j]);
			}
		}
		
		// 영역 저장, 오름차순정렬을 위해 우선순위큐 이용
		PriorityQueue<Integer> res = new PriorityQueue<>();
		
		// bfs - 큐생성
		Queue<int[]> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0 }; // 상하좌우
		int[] dy = { 0, 0, -1, 1 }; // 상하좌우

		for (int i = 0; i < N; i++) { // row
			for (int j = 0; j < N; j++) { // column
				int cnt = 0; // 연결된 영역의 개수
				if (map[i][j] == 1) { // 해당 영역이 채워져있다면
					queue.add(new int[] { i, j }); // 큐에 추가
					// 해당 영역을 0으로 변경 - 다시 방문하지 않기 위함
					map[i][j] = 0;
					cnt++; // 영역 개수 +1
				}
				while (!queue.isEmpty()) { // 연결된 큐가 빌 때까지
					int[] A = queue.poll(); // 뽑아
					for (int k = 0; k < 4; k++) { // 상하좌우 탐색
						int nx = A[0] + dx[k];
						int ny = A[1] + dy[k];
						if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny]==1) { // map내에 있으면서 1이다
							queue.add(new int[] { nx, ny }); // 큐에 추가
							map[nx][ny] = 0; // 다시 방문하지 않기 위해 0으로 변경
							cnt++; // 영역 수 +1
						}
					}
				}
				if(cnt !=0) res.add(cnt); // 우선순위큐에 추가
			}
		}
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(res.size()).append("\n");
		while(!res.isEmpty()) {
			sb.append(res.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
