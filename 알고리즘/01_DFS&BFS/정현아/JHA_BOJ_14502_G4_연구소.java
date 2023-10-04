package BOJ_14502_G4_연구소;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//bfs + 조합으로 풀었음 근데... 온전히 내 힘으로 풀진 않았다...
//<풀이 방식>
//1. Node 클래스 (행, 열 담아두는)를 만든다.
//2. N, M, 연구소(lab) 입력 받기
//3-1. 0의 행과 열을 담아두는 Node를 담는 zero 배열 생성 (크기는 zeroNum(0의 개수))
//3-2. 0의 행과 열을 담아두는 Node를 담는데 3개만 담을 result 배열 생성(조합 이용을 위해) (크기는 zeroNum(0의 개수))
//4. 조합 돌리면서 bfs
//4-1. 재귀 파트 작성 
//4-2. 기저 파트 작성
//4-2-1. cnt(바이러스 감염 안 된 애들) 0으로 초기화, lab2 생성, lab을 깊은 복사 (값만 복사하는)하는 배열
//4-2-2. 복사 함과 동시에 바이러스(2)라면 queue에 넣기
//4-2-3. 조합으로 생성해낸 result 배열에 있는 것들을 꺼내서 1로 만들어주기
//4-2-4. bfs (queue 비어 있을 때까지 while문, 델타 4방향 확인해서 범위 밖이 아니고 0이라면 2로 바꿔주고 queue에 넣어준다.)
//4-2-5. 마지막으로 바이러스 감염 안 된 애들 발견하면 cnt에 +1 하며 더한다.
//4-2-6. max(바이러스 감염 안 된 현재 최대 값)과 방금 센 cnt 중 더 큰 값을 max로 갱신
//5. max 출력


public class Main {
	static int N;
	static int M;
	static int[][] lab;
	static int max = 0;
	static Node[] zero;
	static Node[] result;
	static int zeroNum;
	static Queue<Node> queue;
	// 상 하 좌 우 (4방향 델타)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;

	// 1. Node 클래스 만들기
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 2. N, M, 연구소(lab) 입력 받기
		N = sc.nextInt(); // N: 세로 크기 (행)
		M = sc.nextInt(); // M: 가로 크기 (열)
		lab = new int[N][M]; // lab: 연구소
		zeroNum = 0; // zeroNum: 0의 개수
		queue = new LinkedList<>(); // queue: 큐

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab[i][j] = sc.nextInt();
				// 만약 0이라면 0의 개수 세기
				if (lab[i][j] == 0)
					zeroNum++;
			}
		} // 연구소 입력 끝

		// 3-1. 0의 행과 열을 담아두는 Node를 담는 zero 배열 생성 (크기는 zeroNum(0의 개수))
		zero = new Node[zeroNum];
		// 3-2. 0의 행과 열을 담아두는 Node를 담는데 3개만 담을 result 배열 생성(조합 이용을 위해) (크기는 zeroNum(0의
		// 개수))
		result = new Node[3];

		int idx = 0; // zero의 인덱스
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) // 값이 0인 애들만 zero 배열에 넣기
					zero[idx++] = new Node(i, j);
			}
		} // zero에도 입력 끝

		// 4. 조합 돌리면서 bfs
		three(0, 0);

		// 5. max 출력
		System.out.println(max);

	}// main

	static void three(int idx, int sidx) {
		// 4-2.기저 파트
		if (sidx == 3) {
			cnt = 0; // 바이러스가 걸리지 않는 칸

			// 4-2-1. lab2 생성, lab을 깊은 복사 (값만 복사하는)하는 배열
			int[][] lab2 = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					lab2[i][j] = lab[i][j]; // 깊은 복사
					// 4-2-2. 복사 함과 동시에 바이러스(2)라면 queue에 넣기
					if (lab2[i][j] == 2)
						queue.add(new Node(i, j));
				}
			}

			// 4-2-3. 조합으로 생성해낸 result 배열에 있는 것들을 꺼내서 1로 만들어주기
			for (int i = 0; i < 3; i++) {
				lab2[result[i].r][result[i].c] = 1;
			}

			// 4-2-4. bfs (queue 비어 있을 때까지 while문, 델타 4방향 확인해서 범위 밖이 아니고 0이라면 2로 바꿔주고 queue에
			// 넣어준다.)
			// queue가 없을 때까지!!!
			while (!queue.isEmpty()) {
				Node e = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = e.r + dr[d];
					int nc = e.c + dc[d];

					if (nr >= 0 && nc >= 0 && nr < N && nc < M && lab2[nr][nc] == 0) {
						lab2[nr][nc] = 2;
						queue.add(new Node(nr, nc));

					}

				}

			}

			// 4-2-5. 마지막으로 바이러스 감염 안 된 애들 발견하면 cnt에 +1 하며 더한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 바이러스 감염 안 된 애들 세서 넣기
					if (lab2[i][j] == 0)
						cnt++;
				}
			}

			// 4-2-6. max(바이러스 감염 안 된 현재 최대 값)과 방금 센 cnt 중 더 큰 값을 max로 갱신
			max = Math.max(max, cnt);

			return;
		}

		if (idx == zeroNum)
			return;

		// 4-1. 재귀 파트
		result[sidx] = zero[idx];
		three(idx + 1, sidx + 1); // 뽑거나
		three(idx + 1, sidx); // 안 뽑거나
	}

}
