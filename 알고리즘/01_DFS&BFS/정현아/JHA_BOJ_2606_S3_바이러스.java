package BOJ_2606_S3_바이러스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // V: 컴퓨터의 수 (정점의 수)
		int E = sc.nextInt(); // E: 네트워크 연결된 컴퓨터 쌍의 수

		boolean[] visited = new boolean[V + 1]; // visited: 방문체크 배열
		List<Integer>[] adjList = new ArrayList[V + 1]; // adjList: 인접리스트

		// 인접리스트 초기화
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt(); // A: 시작 정점
			int B = sc.nextInt(); // B: 끝 정점

			adjList[A].add(B); // 인접리스트에 넣기
			adjList[B].add(A);	//무방향이니까... 제발... 이걸 꼭... 넣자......
		}

		Queue<Integer> queue = new LinkedList<>();	//정점 넣을 queue 생성

		queue.addAll(adjList[1]);	//queue에 adjList[1]의 모든 걸 넣음

		int cnt = 0;		//cnt: 감염되는 컴퓨터 수
		visited[1] = true;	//1번은 방문 했음

		//bfs
		while (!queue.isEmpty()) {
			int e = queue.poll();

			if (visited[e])
				continue;

			visited[e] = true;
			queue.addAll(adjList[e]);

			cnt++;
		}

		System.out.println(cnt);

	}// main

}
