package BOJ_9205_G5_맥주마시면서걸어가기;

//그냥 BFS로 풀었는데 다익스트라 알고리즘으로 풀었으면 더 빨랐을 것 같기도?

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static int startX;
	static int startY;
	static Node[] cvs;
	static int endX;
	static int endY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // testCase: 테스트케이스 개수
		for (int tc = 1; tc <= testCase; tc++) {
			N = sc.nextInt(); // N: 편의점 개수
			startX = sc.nextInt(); // startX: 집의 x좌표
			startY = sc.nextInt(); // startY: 집의 y좌표

			String result = "sad";	//result: 출력할 문장, 일단 sad로 설정
			
			//만약 편의점의 개수가 0 이라면 출발지와 도착지만 비교 후 결과를 가져오기
			if(N == 0) {
				endX = sc.nextInt();	//endX: 축제 x 좌표
				endY = sc.nextInt();	//endY: 축제 y 좌표
				
				//출발지에서 도착지로 가능하면 happy로 바꾸기
				if(calOX(startX, startY, endX, endY)) {
					result = "happy";
				}
			//편의점의 개수가 0이 아니라면
			} else {
				Node[] cvs = new Node[N]; // cvs: 편의점 좌표 담아두는... 배열
				for (int i = 0; i < N; i++) {
					int x = sc.nextInt(); // 편의점 x 좌표
					int y = sc.nextInt(); // 편의점 y 좌표
					cvs[i] = new Node(x, y);
				}
				
				endX = sc.nextInt();	//endX: 축제 x 좌표
				endY = sc.nextInt();	//endY: 축제 y 좌표
				
				//출발지에서 도착지로 가능하면 happy로 바꾸기
				if(calOX(startX, startY, endX, endY)) {
					result = "happy";
				}
				
				//편의점 개수만큼 돌린다.
				loop: for(int k=0; k<N; k++) {
					//bfs를 위한 Node 담는 queue
					Queue<Node> queue = new LinkedList<>();

					boolean[] visited = new boolean[N];	//visited: 방문 체크 배열
					
					//만약 출발지에서 k번째 편의점 못 가면 다음 편의점으로!
					if(calOX(startX, startY, cvs[k].r, cvs[k].c) == false) {
						continue;
					//출발지에서 k번째 편의점 갈 수 있으면 queue에 넣고 시작
					} else {
						queue.add(cvs[k]);
					}
					
					//bfs 시작
					while(!queue.isEmpty()) {
						Node e = queue.poll();	//queue에서 하나 꺼내오고
						
						//만약 현재 거리에서 축제까지 갈 수 있다면 happy로 설정 후 for문 반복 빠져나오기
						if(calOX(e.r, e.c, endX, endY)) {
							result = "happy";
							break loop;
						}
						
						//for문 돌면서 자기 자신 제외 & 방문한 정점 제외한 곳을 calOX로 계산후 queue에 넣을 것.
						for(int i=0; i<N; i++) {
							//본인이거나 방문한 곳이면 다음으로
							if(k == i || visited[i])
								continue;
							//본인이 아니고 방문하지 않은 곳이라면 갈 수 있는지 계산 후 가능하면
							if(calOX(e.r, e.c, cvs[i].r, cvs[i].c)) {
								visited[i] = true;	//방문체크 한 뒤
								queue.add(cvs[i]);	//queue에 넣는다.
							}
						}
					}
					
				}// bfs 끝
				
			}
			
			System.out.println(result);

		} // tc

	}// main
	
	static boolean calOX(int x1, int y1, int x2, int y2) {
		
		//calXY: 거리
		int calXY = Math.abs(x2 - x1) + Math.abs(y2-y1);
		
		//만약 맥주 20개로 갈 수 있는 거리보다 계산한 거리가 작다면 OK!!
		if(calXY <= 20*50) {
			return true;
		//아니라면 false
		} else {
			return false;
		}
		
		
	}

}
