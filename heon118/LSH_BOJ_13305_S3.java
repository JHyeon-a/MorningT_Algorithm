package BOJ_13305_주유소;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도시 개수
		long[] road = new long[N - 1]; // 도로 거리
		for (int i = 0; i < N - 1; i++) {
			road[i] = sc.nextInt();
		}
		long[] oil_Price = new long[N]; // 도시별 오일 가격
		for (int i = 0; i < N; i++) {
			oil_Price[i] = sc.nextInt();
		}

		long total = 0; // 총금액
		// 다음 도시의 주유소 가격이 더 비싸면 다음 주유소의 가격을 이전 주유소 가격으로 바꾼다.
		for (int i = 0; i < N - 1; i++) {// 기준 주유소
				if (oil_Price[i] < oil_Price[i+1]) {
					oil_Price[i+1] = oil_Price[i];
			}
			total += oil_Price[i] * road[i];
		}
		// 주유소의 배열을 최소 가격으로 바꿔놔서 곱하기만 하면됨.
		System.out.println(total);
	}
}