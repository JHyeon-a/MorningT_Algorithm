package BOJ_1260_S2_DFS와BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static List<Integer>[] arrList;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt(); // 탐색 시작점

		arrList = new ArrayList[N + 1];

		visited = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			arrList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			arrList[A].add(B);
			arrList[B].add(A);
		}

		for(int i=0;i<N+1;i++) {
			Collections.sort(arrList[i]);
		}
		DFS(V);
		System.out.println();
		BFS(V);
	}

	private static void DFS(int v) {
		if(!visited[v]) {
			System.out.print(v + " ");
			visited[v] = true;
		}
		for(int i=0;i<arrList[v].size();i++) {
			if(!visited[arrList[v].get(i)]) DFS(arrList[v].get(i));
		}
		
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		queue.add(v);

		while (!queue.isEmpty()) {
			int p = queue.poll();

			if (!visited[p]) {
				visited[p] = true;
				for (int i = 0; i < arrList[p].size(); i++) {
					if (!visited[arrList[p].get(i)])
						queue.add(arrList[p].get(i));
				}
				System.out.print(p + " ");
			}

		}

	}
}
