package BOJ_2644_S2_촌수계산;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	/*
	 * BFS이용
	 * 직계자손 찾기&그 외로 나누기(안 나눠도 괜찮을 듯)
	 * 형제 = 올라갔다+내려갔다
	 */
	public static void main(String[] args) {
		//형제 2로 계산, 옆에 찾고 없으면 올라가고 내려가기
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int m = sc.nextInt();
		
		//인접행렬 생성
		int[][] family = new int[n+1][n+1];
		boolean[] visited = new boolean[n+1];
		
		for(int i = 0; i<m; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			
			family[p][c] = 1; //열이 부모
		}
		
		Queue<Integer> q = new LinkedList<>();
		int sum = 0;
		int relationship = -1;

		
		//p1부터 찾을 것
		q.add(p1);
		
		//자손확인
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int i = 0; i<size; i++) {
				
				int x = q.poll();
				visited[x] = true;//방문
				
				if(x == p2) {
					relationship = sum;
					break;
				}
				
				for(int j = 1; j<=n; j++) {
					if(family[x][j] == 1) {
						q.add(j);
					}
				}
			}
			sum++;
		}//while
		
		
		if(relationship == -1) {
			//그 외 확인
			int idx = 0;
			for(int i = 1; i<=n; i++) {
				if(family[i][p1] == 1) {//부모찾기
					idx = i;
					q.add(i);
				}
			}
			sum = 1;
			while(!q.isEmpty()) {
				
				int size = q.size();
				
				//부모에서 내려가기
				for(int i = 0; i<size; i++) {
					
					int x = q.poll();
					visited[x] = true; //방문함
					
					//원하는 사람 찾으면 종료
					if(x == p2) {
						relationship = sum;
						break;
					}

					//자손 넣기
					for(int j = 1; j<=n; j++) {
						if(family[x][j] == 1 && !visited[j]) {
							q.add(j);
						}
					}//j
					
					//조상으로 올라가기
					for(int j = 1; j<= n; j++) {
						if(family[j][x] == 1 && !visited[j]) {
							q.add(j);
						}
					}

				}//i, size
				
				sum++;
				
			}//while
			
		}
		
		System.out.println(relationship);
		
	}//main
}
