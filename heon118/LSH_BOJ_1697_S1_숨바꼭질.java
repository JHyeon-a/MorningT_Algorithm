package BOJ_1697_S4_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수빈이의 위치
		int K = sc.nextInt(); // 동생의 위치

		// 수빈이의 이동경로를 모두 저장할 큐
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[200001];
		queue.add(N); // 시작 위치 저장

		int sec = (N == K) ? 0 : 1; // 몇 초 지났는지 세보자
		// bfs
		loop1: while (N != K) {
			// 현재 큐의 사이즈가 현재 시간에서 진행할 수 있는 모든 경우의 수
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				int loc = queue.poll(); // 저장해놓은 것 하나 뽑아
				visited[loc] = true; // loc를 방문했다. 다시 나오지마

				int minus = loc - 1;
				int plus = loc + 1;
				int multi = loc * 2;
				// 뽑은 것에 저장할 것들이 이번 시간에 해당하는 값들 -> K와 같다면 멈춰
				if (minus == K || plus == K || multi == K)
					break loop1;
				
				// minus가 양수이면서 방문하지 않았어함
				if (minus>0 && !visited[minus])
					queue.add(minus);
				
				// plus는 무조건 양수이기 때문에 방문체크만
				if (!visited[plus])
					queue.add(plus);
				
				// loc * 2가 구해야하는 수 K보다 2배 이 크면 의미가 없다 + 방문체크
				if (multi < K * 2 && !visited[multi])
					queue.add(multi);
			}
			sec++; // 다음 초 진행
		}
		System.out.println(sec);
	}
}
