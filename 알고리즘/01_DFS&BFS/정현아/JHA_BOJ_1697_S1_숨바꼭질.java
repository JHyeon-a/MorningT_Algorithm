package BOJ_1697_S1_숨바꼭질;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 수빈이가 있는 위치
		int K = sc.nextInt(); // K: 동생이 있는 위치

		int[] arr = new int[100001]; // arr: 전체 배열
		Arrays.fill(arr, Integer.MAX_VALUE);	//모든 배열을 가장 큰 값으로 설정

		int[] visited = new int[100001]; // visited: 방문체크용 배열 (총 2번까지 갱신 가능하니까 int로 만들었음)

		Queue<Integer> queue = new LinkedList<>();

		arr[N] = 0;		//시작 위치는 0으로 바꿔준다.
		queue.add(N);	//queue에 시작 위치 넣고

		//bfs 시작
		while (!queue.isEmpty()) {
			int e = queue.poll();
			
			//배열의 크기가 정말 크기 때문에 중간에 K를 만났고, K의 방문체크가 2번 됐으면 빠져나오게 설정
			if(e == K && visited[e] == 2) {
				break;
			}
			
			//e-1이 범위 안에 있고 2번 미만으로 방문했다면
			if (e - 1 >= 0 && visited[e - 1] < 2) {
				arr[e - 1] = Math.min(arr[e] + 1, arr[e - 1]);	//최소값 갱신
				visited[e - 1]++;	//방문체크 해 주고
				queue.add(e - 1);	//queue에 e-1를 넣는다.

			}

			// e+1과 e*2일 때도 e-1과 마찬가지
			if (e + 1 < arr.length && visited[e + 1] < 2) {
				arr[e + 1] = Math.min(arr[e] + 1, arr[e + 1]);
				visited[e + 1]++;
				queue.add(e + 1);

			}

			if (e * 2 >= 0 && e * 2 < arr.length && visited[e * 2] < 2) {
				arr[e * 2] = Math.min(arr[e] + 1, arr[e * 2]);
				visited[e * 2]++;
				queue.add(e * 2);

			}

		}

		//K까지의 거리 출력 (arr[K])
		System.out.println(arr[K]);

	}// main

}
