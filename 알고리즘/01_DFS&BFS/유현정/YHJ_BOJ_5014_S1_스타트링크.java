package BOJ_5014_S1_스타트링크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();//총 층의 수
		int S = sc.nextInt();//현재 층
		int G = sc.nextInt();//목적 층
		int U = sc.nextInt();//위로 올라가는 층 수
		int D = sc.nextInt();//밑으로 내려가는 층 수
		
		int[] visited = new int[F+1];//방문에 이용
		
		for(int i = 1; i<=F; i++) {
				visited[i] = Integer.MAX_VALUE;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(S);
		
		String result = "use the stairs";

		int cnt = 0;
		loop: while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i<size; i++) {
				int x = q.poll();
				
				//종료조건
				if(x == G) {
					result = Integer.toString(cnt);
					break loop;
				}
				
				int upper = x+U;
				int lower = x-D;
				
				if(upper<=F && visited[upper]>cnt) {
					visited[upper]= cnt;
					q.add(upper);
				}
				
				if(lower>=0 && visited[lower]>cnt) {
					visited[lower]= cnt;
					q.add(lower);
				}
				
				
			}
			cnt++;
			
		}
		
		
		System.out.println(result);
		
		
	}//main

}
