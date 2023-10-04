package BOJ_2606_S3_바이러스;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static List<Integer>[] al;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		visited = new boolean[N+1];
		
		al = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) {
			al[i] = new ArrayList<>();
		}
		
		int line = sc.nextInt();
		for(int i = 0; i<line; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			al[a].add(b);
			al[b].add(a);
		}
		DFS(1);
		System.out.println(cnt);
		
		
	}//main
	
	public static void DFS(int st) {
		visited[st] = true;
		for(int i = 0; i<al[st].size(); i++) {
			int next = al[st].get(i);
			if(!visited[next]) {
				cnt++;
				DFS(next);
			}
			
		}
		
		
	}
	

}
