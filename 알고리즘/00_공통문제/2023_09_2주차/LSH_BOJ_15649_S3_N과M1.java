package BOJ_15649_S3_N과M1;

import java.util.Scanner;

public class Main {

	public static int N; // N까지의 자연수
	public static int M; // 출력하는 수열의 길이
	public static boolean[] checked; // 해당 숫자를 방문했는지 체크

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		String path = "";

		checked = new boolean[N];

		dfs(0, path);
	}

	public static void dfs(int deep, String path) { // 그래프로 그려보기
		if (deep == M) { // 깊이가 M이 되면 출력
			System.out.println(path);
			return; // 원래 코드로 돌아가
		}
		for (int i = 1; i <= N; i++) { // 1부터 뽑아야지
			if (checked[i - 1]) { // 이미 갔던 경로이면(중복)
				continue; // 반복문의 이번 i는 넘어가
			} else { // 중복이 아니라면
				checked[i - 1] = true; // 방문했다고 check
				dfs(deep + 1, path + i + " "); // 다음에 방문할 곳으로(한 층 더 내려가)
				checked[i - 1] = false; // 바로 위 dfs가 끝난 상태로 다음 i를 새로 체크하기 위함
			}
		}

	}
}
