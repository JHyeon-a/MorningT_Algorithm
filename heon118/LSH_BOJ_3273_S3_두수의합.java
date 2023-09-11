package BOJ_3273_S3_두수의합;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 수열의 크기

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int x = sc.nextInt();

		int cnt = 0;
		
		Arrays.sort(arr); // 정렬
		for (int i = 0; i < n - 1; i++) { // i번째 수
			for (int j = i + 1; j < n; j++) { // i번째 이후의 수
				if (arr[i] + arr[j] == x) { // 합이 x이면
					cnt++; // 개수 count
					break; // 서로 다른 양의 정수이기에 만약 합이 x인 쌍이 나온다면 한 쌍 밖에 안됨.
				}
			}
		}
		System.out.println(cnt);
	}
}
