package BOJ_13305_������;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // ���� ����
		long[] road = new long[N - 1]; // ���� �Ÿ�
		for (int i = 0; i < N - 1; i++) {
			road[i] = sc.nextInt();
		}
		long[] oil_Price = new long[N]; // ���ú� ���� ����
		for (int i = 0; i < N; i++) {
			oil_Price[i] = sc.nextInt();
		}

		long total = 0; // �ѱݾ�
		// ���� ������ ������ ������ �� ��θ� ���� �������� ������ ���� ������ �������� �ٲ۴�.
		for (int i = 0; i < N - 1; i++) {// ���� ������
				if (oil_Price[i] < oil_Price[i+1]) {
					oil_Price[i+1] = oil_Price[i];
			}
			total += oil_Price[i] * road[i];
		}
		// �������� �迭�� �ּ� �������� �ٲ���� ���ϱ⸸ �ϸ��.
		System.out.println(total);
	}
}