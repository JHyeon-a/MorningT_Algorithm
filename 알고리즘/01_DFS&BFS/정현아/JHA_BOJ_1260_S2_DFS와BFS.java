package BOJ_1260_S2_DFS와BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int V;
	static int E;
	static int start;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // V: 정점의 개수 (1<=N<=1,000)
		E = sc.nextInt(); // E: 간선의 개수 (1<=M<=10,000)

		start = sc.nextInt(); // start: 탐색 시작할 정점의 번호

		adjList = new ArrayList[V + 1]; // adjList: 인접리스트
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		visited = new boolean[V + 1]; // visited: 방문 체크 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);

		}
		
		for(int i=0; i<V+1; i++) {
			Collections.sort(adjList[i]);
		}

		// dfs
		DFS(start);

		System.out.println();
		// bfs
		queue = new LinkedList<>();
		Arrays.fill(visited, false);
		BFS(start);

	}// main

	// DFS
	static void DFS(int idx) {
		visited[idx] = true;
		System.out.print(idx + " ");

		for (int i = 0; i < adjList[idx].size(); i++) {
			if (!visited[adjList[idx].get(i)])
				DFS(adjList[idx].get(i));
		}

	}

	// BFS
	static void BFS(int idx) {
		queue.addAll(adjList[idx]);
		System.out.print(idx + " ");
		visited[idx] = true;

		while (!queue.isEmpty()) {
			int e = queue.poll();

			if (visited[e])
				continue;

			System.out.print(e + " ");
			visited[e] = true;
			queue.addAll(adjList[e]);
		}

	}

}
