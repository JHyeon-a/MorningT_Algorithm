package SWEA_1220_Magnetic;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 2���� �迭 �Է�
			int[][] res = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res[i][j] = sc.nextInt();
				}
			}
			int total = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (res[j][i] == 1) {
						for (int k = j + 1; k < N; k++) {
							if (res[k][i] == 1) {
								break;
							} else if (res[k][i] == 2) {
								total++;
								break;
							} // 1�� ������ ����, 2�� ������ �������� +1, ����
						} // 1�� ���� ������ �ش� ���� �Ʒ��� Ž��
					} // ���� 1�� ��츸 �����ϸ� ��
				} // �� Ž�� �ݺ���
			} // �� Ž�� �ݺ���
			System.out.printf("#%d %d%n", test_case, total);
		}
	}
}