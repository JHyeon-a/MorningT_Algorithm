package SWEA_1289_D3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String[] s = sc.next().split(""); // 메모리의 원래값 받아오기

			int[] arr = new int[s.length]; // 메모리의 원래값 넣을 배열

			for (int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			} // 메모리의 원래 값 한자리씩 배열에 넣기

			int cnt = 0;
			int[] re_Arr = new int[s.length]; // 초기화된 메모리
			for (int i = 0; i < arr.length; i++) { // 요소 비교
				if (arr[i] != re_Arr[i]) { // 원래 메모리와 초기화메모리 비교
					for (int j = i; j < arr.length; j++) { // 값 넣기
						re_Arr[j] = re_Arr[j] == 1 ? 0 : 1; // 1이면 0넣고 0이면 1넣고
					} // j
					cnt++;
				} // if
			} // i
			System.out.printf("#%d %d%n", tc, cnt);
		}
		sc.close();
	}
}
