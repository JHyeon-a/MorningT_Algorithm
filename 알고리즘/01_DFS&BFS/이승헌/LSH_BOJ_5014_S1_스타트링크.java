package BOJ_5014_S1_스타트링크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int high = sc.nextInt(); // 건물의 총 층수
		int st = sc.nextInt(); // 현재 강호의 위치
		int ed = sc.nextInt(); // 목표 위치 (스타트링크 층)
		int up = sc.nextInt(); // 한번에 올라갈 수 있는 층 수
		int down = sc.nextInt(); // 한번에 내려갈 수 있는 층 수

		// 엘베가 방문한 위치 체크
		boolean[] visited = new boolean[high + 1];
		// 현재 층에서 갈 수 있는 층 저장
		Queue<Integer> queue = new LinkedList<Integer>();
		// 버튼 몇번 눌렀니
		int cnt = st == ed ? 0 : 1; // 현재가 목표 층일때를 제외해야함.
		queue.add(st);
		visited[st] = true;

		loop1: while (!queue.isEmpty()) {
			int q_size = queue.size();
			for (int i = 0; i < q_size; i++) {
				int p = queue.poll();

				int up_floor = p + up; // 올라가면
				int down_floor = p - down; // 내려가면

				if (p == ed || up_floor == ed || down_floor == ed) {
					visited[ed] = true;
					break loop1; // 층에 도달하면 멈춰
				}

				// 올라가는 조건
				if (up_floor <= high && !visited[up_floor]) {
					visited[up_floor] = true;
					queue.add(up_floor);
				}

				// 내려가는 조건
				if (down_floor > 0 && !visited[down_floor]) {
					visited[down_floor] = true;
					queue.add(down_floor);
				}
			}
			cnt++;
		}
		System.out.println(visited[ed] ? cnt:"use the stairs");
	}
}
