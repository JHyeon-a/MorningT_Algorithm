package BOJ_2606_S3_바이러스;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 컴퓨터의 수(정점 수)
		int E = sc.nextInt(); // 간선의 수

		List<Integer>[] adjList = new ArrayList[V + 1]; // 인접노드를 저장

		boolean[] visited = new boolean[V + 1]; // 방문 처리

		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>(); // 각 인접노드 배열에 리스트 생성
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1); // 1번 컴퓨터가 바이러스에 걸림
		int cnt = -1; // 연결된 컴퓨터 수 - 첫번째 컴퓨터는 제외
		
		// bfs
		while (!queue.isEmpty()) {
			int p = queue.poll();

			if (!visited[p]) {
				visited[p] = true;
				cnt++;
				for (int i = 0; i < adjList[p].size(); i++) {
					if (!visited[adjList[p].get(i)])
						queue.add(adjList[p].get(i));
				}
			}
		}
		System.out.println(cnt);
	}
}
