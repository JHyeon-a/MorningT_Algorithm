package BOJ_9205_G5_맥주마시면서걸어가기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t<T; t++) {
			int n = sc.nextInt();
			//정보 받기, 0-시작, 마지막- 페스티벌
			int[][] place = new int[n+2][2];
			for(int i = 0; i<n+2; i++) {
				place[i][0] = sc.nextInt();
				place[i][1] = sc.nextInt();
			}
			//갈 수 있는 편의점 인접리스트에 저장
			List<Integer>[] al = new ArrayList[n+2];
			//초기화
			for(int i = 0; i<n+2; i++) {
				al[i] = new ArrayList<>();
			}
			
			for(int i = 0; i<n+2; i++) {
				for(int j = i+1; j<n+2; j++) {
					int tmp = Math.abs(place[i][0]-place[j][0])+Math.abs(place[i][1]-place[j][1]);
					if(tmp<=1000) {
						al[i].add(j);
						al[j].add(i);
					}
				}
			}
			
			//시작점이 리스트 타고 페스티벌까지 갈 수 있나 확인, BFS
			boolean[] visited = new boolean[n+2];
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			String result = "sad";
			
			while(!q.isEmpty()) {
				int tmp = q.poll();
				if(tmp == n+1) {
					result = "happy";
					break;
				}
				visited[tmp] = true;
				for(int i = 0; i<al[tmp].size(); i++) {
					if(!visited[al[tmp].get(i)])
					q.add(al[tmp].get(i));
				}
			}
			System.out.println(result);
		}//t
	}
}
