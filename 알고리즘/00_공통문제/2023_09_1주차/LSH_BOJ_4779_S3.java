package BOJ_4779_S3;

import java.util.Scanner;

public class Main {
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) { // hasNextInt() -> 입력받을 값이 있으면 true, 없으면 false
			N = sc.nextInt(); // 3의 N제곱
			System.out.println(blank((int) Math.pow(3, N))); // math.pow는 double형이므로 형변환
		} // while
	} // main

	// 3등분하여 가운데 구간을 공백으로 만드는 재귀함수
	public static String blank(int N) {
		if (N == 1) // 1이 들어오면 "-" 반환
			return "-";
		StringBuilder sb = new StringBuilder(); // 처음엔 replace를 사용할 생각으로 sb사용
		sb.append(blank(N / 3)); // 3등분의 첫번째
		for (int i = 0; i < N / 3; i++) { // 3등분 중 가운데 부분은 공백
			sb.append(" ");
		}// for
		sb.append(blank(N / 3)); // 3등분 중 세번째는 첫번째와 같다

		return sb.toString(); // 반환
	} // blank 메서드
} // class - Main
