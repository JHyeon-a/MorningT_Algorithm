package BOJ_2644_S2_촌수계산;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제설명 - 간선 1개 당 +1촌 - 알고 싶은 정점 x, y의 촌수가 몇인지 구하는 문제 풀이 - bfs로 풀까 생각을 했지만 dfs가
 * 맞는 것 같다.
 */

public class Main {
	static int V;
	static int a;
	static int b;
	static int E;

	static List<Integer>[] relative;
	static boolean[] visited;

	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // V: 전체 사람의 수(정점의 개수)
		a = sc.nextInt();
		b = sc.nextInt(); // a, b: 촌수 계산해야 하는 번호
		E = sc.nextInt(); // E: 간선의 개수

		relative = new ArrayList[V + 1]; // relative: 인접리스트
		for (int i = 0; i < V + 1; i++) {
			relative[i] = new ArrayList<>();
		} // relative 초기화

		visited = new boolean[V + 1]; // visited: 정점 방문체크 배열

		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			relative[x].add(y);
			relative[y].add(x);
		}
		
		result = -1;
		
		dfs(a, 0);
		
		System.out.println(result);

	}// main

	//a부터 b까지의 간선의 개수를 구하기 위해선 count 매개변수를 하나 넣어줘야 한다..!!!
	//cnt라고 따로 변수 만들어서 0으로 초기화 한 후 1를 더하면... 답이 전체 개수를 구하는 걸로 나옴!!
	//매개변수 활용 잘하자... 사실상 못 푼 문제임 ㅠㅠ
	static void dfs(int v, int count) {
		visited[v] = true;
		if(v == b) {
			result = count;
			return;
		}
		

		for(int i=0; i<relative[v].size(); i++) {
			if(visited[relative[v].get(i)])
				continue;
			
			
			dfs(relative[v].get(i), count+1);

		}

	}
}