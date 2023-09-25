package BOJ_7562_나이트의이동_S1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int l = sc.nextInt(); //체스판 길이
			int pi = sc.nextInt(); //현재 말 위치
			int pj = sc.nextInt();
			int fi = sc.nextInt(); //말 목표 위치
			int fj = sc.nextInt();
			int[] ti = {-2, -2, -1, -1, 1, 1, 2, 2};
			int[] tj = {-1, 1, -2, 2, -2, 2, -1, 1};
			Queue<Integer> q1 = new LinkedList<>();
			Queue<Integer> q2 = new LinkedList<>();
			boolean[][] visited = new boolean[l][l];
			
			//시작점 넣기
			q1.add(pi);
			q2.add(pj);
			System.out.println("present "+pi+","+pj);
			System.out.println("goal "+fi+","+fj);
			int cnt = 0;
			
			//BFS
			fin: while(!q1.isEmpty()) { //도착하면 멈추기
				int size = q1.size();
//				System.out.println("cnt "+cnt);

				for(int j = 0; j<size; j++) {
//					System.out.println(123);
					int y = q1.poll();
					int x = q2.poll();
					if(x == fj && y == fi) {
						break fin;
					}
					
					visited[y][x] = true;
					
					for(int i = 0; i<8; i++) {
//						System.out.println((y+ti[i])+","+(x+tj[i]));
						if(0<=y+ti[i] && 0<= x+tj[i] && y+ti[i]<l && x+tj[i]<l && !visited[y+ti[i]][x+tj[i]]) {
							q1.add(y+ti[i]);
							q2.add(x+tj[i]);
						}
					}
				}
				cnt++;
				
			}//while
			
			
			System.out.println(cnt);
			
		}//t
	}//main
	
}

