package BOJ_2839_S4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 배달해야하는 설탕의 양
		int bong = -1; // 봉지의 개

		// 배달해야하는 설탕의 양을 5로 나눠 각 나머지 별로 3으로 나눠떨어지게끔 계산
		switch (N % 5) {
		case 0:
			bong = N / 5;
			break;
		case 1:
			if (N < 6) {
			} else {
				bong = (N - 6) / 5 + 6 / 3;
			}
			break;
		case 2:
			if (N < 12) {
			} else {
				bong = (N - 12) / 5 + 12 / 3;
			}
			break;
		case 3:
			if (N < 3) {
			} else {
				bong = (N - 3) / 5 + 3 / 3;
			}
			break;
		case 4:
			if (N < 9) {
			} else {
				bong = (N - 9) / 5 + 9 / 3;
			}
			break;
		}
		System.out.println(bong);
	}
}
