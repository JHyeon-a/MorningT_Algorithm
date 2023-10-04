package BOJ_1697_S1_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();//수빈
		int Y = sc.nextInt();//동생
		
		boolean[] visited = new boolean[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		int time = 0;
		
		
		loop: while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i<size; i++) {
				int pos = q.poll();
				visited[pos] = true;
				if(pos == Y) {
					System.out.println(time);
					break loop;
				}
				
				if(pos-1>=0 && !visited[pos-1]) q.add(pos-1);
				if(pos+1<=100000 && !visited[pos+1]) q.add(pos+1);
				if(pos*2<=100000 && !visited[pos*2]) q.add(2*pos);
			}
			time++;
			
			
		}
		
		
	}

}
