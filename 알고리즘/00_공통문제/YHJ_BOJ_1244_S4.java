package boj_1244;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int n = Integer.parseInt(N);

		String line = sc.nextLine();
		String[] status = line.split(" ");
		int[] stat = new int[status.length];
		for (int i = 0; i < status.length; i++) {
			stat[i] = Integer.parseInt(status[i]);
		} // 스위치 정보 받기

		String SN = sc.nextLine();
		int sn = Integer.parseInt(SN);
		int[][] SS = new int[sn][2];
		for (int i = 0; i < sn; i++) {
			String Info = sc.nextLine();
			String[] info = Info.split(" ");
			SS[i][0] = Integer.parseInt(info[0]);
			SS[i][1] = Integer.parseInt(info[1]);

		} // 학생 정보 받기

		// 스위치 교정
		for (int i = 0; i < sn; i++) {
			if (SS[i][0] == 1) {
				for (int k = SS[i][1] - 1; k < status.length; k = k + SS[i][1]) {
					if (stat[k] == 0) {
						stat[k] = 1;
					} else {
						stat[k] = 0;
					}
				}
			} else if (SS[i][0] == 2) {
				loop: for (int j = 0; (j < stat.length - SS[i][1]+1 && j < SS[i][1]) || j == 0; j++) {
					if (j == 0) {
						if (stat[(SS[i][1] - 1)] == 0) {
							stat[(SS[i][1] - 1)] = 1;
						} else {
							stat[(SS[i][1] - 1)] = 0;
						}
					} else if (stat[(SS[i][1] - 1 + j)] == stat[SS[i][1] - 1 - j]) {
						if (stat[(SS[i][1] - 1 + j)] == 0) {
							stat[(SS[i][1] - 1 - j)] = 1;
							stat[(SS[i][1] - 1 + j)] = 1;
						} else {
							stat[(SS[i][1] - 1 + j)] = 0;
							stat[(SS[i][1] - 1 - j)] = 0;
						}

					} else if (j != 0) {
						break loop;
					}

				}
			}
		}
		// 스위치 출력
		for (int i = 0; i < stat.length; i++) {
			System.out.print(stat[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}

		}

	}
}
