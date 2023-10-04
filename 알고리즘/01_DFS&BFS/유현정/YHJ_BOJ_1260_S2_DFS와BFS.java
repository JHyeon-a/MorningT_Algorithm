package BOJ_1260_S2_DFS와BFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int V;
	static List<Integer>[] arr;
	static boolean[] cnt;
	static int[] cnt2;
	static int[] h;
	static int idx = 0;

	public static void main(String[] args) throws IOException {
		N = sc.nextInt(); //정점
		M = sc.nextInt(); //간선
		V = sc.nextInt(); //시작 정점
		cnt = new boolean[N + 1]; //dfs 지나갔는지 확인
		cnt[0] = true;
		cnt2 = new int[N + 1]; // bfs 0: 아무것도 안 함, 1: 출력, 2: 지나감
		cnt2[0] = 2;
		h = new int[N]; //bfs에서 담는데 사용
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			arr[A].add(B);
			arr[B].add(A);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		}
		dfs(V);
		bw.newLine();
		bfs(V, 0);
		bw.flush();
		bw.close();
	}

	public static void dfs(int st) throws IOException {
		if (cnt[st]) {
			return;
		} else {
			bw.write(st + " ");
			cnt[st] = true;
			for (int i = 0; i < arr[st].size(); i++) {
				dfs(arr[st].get(i));
			}
		}
	}// dfs

	public static void bfs(int st, int index) throws IOException {
		if (index >= N) {
			return;
		} else {
			cnt2[st] = 2;
			bw.write(st + " ");
			for (int i = 0; i < arr[st].size(); i++) {
				if (cnt2[arr[st].get(i)] == 0) {
					h[idx++] = arr[st].get(i);
					cnt2[arr[st].get(i)] += 1;
				}
			}
			if (cnt2[h[index]] < 2)
				bfs(h[index], ++index);
		}
	}// bfs
}