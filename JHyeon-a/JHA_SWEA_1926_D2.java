package SWEA_1926_369게임;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 주어지는 정수 N
		int[] nArray = new int[N];

		for (int i = 0; i < N; i++) {
			nArray[i] = i + 1;
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;

			int x = nArray[i] / 100;
			int renewal = nArray[i] - 100 * x;
			int y = renewal / 10;
			renewal = renewal - 10 * y;
			int z = renewal;

			if (x == 3 || x == 6 || x == 9) {
				cnt++;
			}

			if (y == 3 || y == 6 || y == 9) {
				cnt++;
			}

			if (z == 3 || z == 6 || z == 9) {
				cnt++;
			}

			if (cnt == 0) {
				System.out.print(nArray[i] + " ");
			} else if (cnt == 1) {
				System.out.print("- ");
			} else if (cnt == 2) {
				System.out.print("-- ");
			} else if (cnt == 3) {
				System.out.print("--- ");
			}

		}

	}

}
