package BOJ_2644_S2_촌수계산;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adjList; // 인접 노드
	static boolean[] visited; // 방문체크
	static int st, ed;
	static int ans = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt(); // 사람 수
		st = sc.nextInt();
		ed = sc.nextInt();

		int E = sc.nextInt(); // 간선의 수

		adjList = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}
		dfs(st, 0); // 시작점과 깊이를 넣는다.
		System.out.println(ans);
	}

	// dfs
	private static void dfs(int now, int deep) {
		if (now == ed) { // 현재 숫자가 찾는 숫자면 끝
			ans = deep; // 현재 깊이가 답
			return;
		}
		if (!visited[now]) { // 방문했나요?
			visited[now] = true;
			for (int i = 0; i < adjList[now].size(); i++) { // 인접노드 방문
				if (!visited[adjList[now].get(i)]) {
					dfs(adjList[now].get(i), deep + 1); // 하나 더 들어가
				}
			}
		}
	}
}
