//못 풀고 답 봤어용...

package BOJ_10158_개미;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); // 격자의 너비
		int h = sc.nextInt(); // 격자의 높이
		int p = sc.nextInt(); // 현재 행 위치
		int q = sc.nextInt(); // 현재 열 위치
		int t = sc.nextInt(); // 시간

		// w*2만큼 반복되기 때문에...
		// 일단 시간 t를 2배로 나누고 그걸 p에 더한다
		// (q도 마찬가지)
		p = p + (t % (w * 2));
		q = q + (t % (h * 2));

		if (p > w) { // 만약 p가 w보다 크다면
			p = Math.abs(2 * w - p); // 2*w에서 p 뺀 값의 절대값.
		}
		if (q > h) { // 만약 q가 h보다 크면
			q = Math.abs(2 * h - q); // 2*h에서 q 뺀 값의 절대값
		}

		System.out.println(p + " " + q); // 최종 위치 출력
	}
}


//이게 원래 제가 작성한 코드인데... ㅠㅠ 틀린 코드입니다...
//public class Main2 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int w = sc.nextInt(); // w 길이
//		int h = sc.nextInt(); // h 길이
//		int p = sc.nextInt(); // 현재 행 위치 p
//		int q = sc.nextInt(); // 현재 열 위치 q
//		int time = sc.nextInt(); // 시간
//
//		// 오른쪽대각선위, 왼쪽 대각선 위, 왼쪽 대각선아래 순서
//		int[] dr = { 1, -1, -1 }; // x위치 변경
//		int[] dc = { 1, 1, -1 }; // y위치 변경
//
//		int d = 0; // d는 0부터 시작(대각선 위로 올라가는 방향)
//
//		for (int t = 1; t <= time; t++) {
//			if (p == w) {
//				d = 1;
//			} else if (q == h) {
//				d = 2;
//			} else if (p == 0) {
//				d = 0;
//			} else if (q == 0) {
//				d = 1;
//			}
//
//			int nr = p + dr[d % 3];
//			int nc = q + dc[d % 3];
//
//			if (nc > h) {
//				d = 2;
//			}
//			if (nc < 0) {
//				d = 0;
//			}
//
//			nr = p + dr[d % 3];
//			nc = q + dc[d % 3];
//
//			p = nr;
//			q = nc;
//
//		} // t시간만큼 돌기
//
//		System.out.printf("%d %d", p, q);
//
//	}
//
//}
