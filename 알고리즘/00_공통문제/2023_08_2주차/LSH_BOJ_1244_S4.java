package BOJ_1244_S4;

import java.util.Scanner;

public class LSH_BOJ_1244_S4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스위치 개수
		int N = sc.nextInt();
		sc.nextLine();
		// 스위치 받아와서 배열에 넣기
		String[] swi = sc.nextLine().split(" ");
		int[] swit = new int[N];
		// String 배열을 int배열로 변
		for (int i = 0; i < N; i++) {
			swit[i] = Integer.parseInt(swi[i]);
		}
		// 학생수
		int stu_N = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < stu_N; i++) {
			// 학생 정보
			String[] stu = sc.nextLine().split(" ");
			int stu_sex = Integer.parseInt(stu[0]);
			int stu_num = Integer.parseInt(stu[1]);
			// 스위치 변경하기
			if (stu_sex == 1) {
				for (int j = 0; j < N; j++) {
					if ((j + 1) % stu_num == 0) {
						if (swit[j] == 0) {
							swit[j] = 1;
						} else {
							swit[j] = 0;
						}
					}
				}
			} else {
				// 성별이 여자인 경우
				if (stu_num <= N / 2) {
					for (int k = 0; k < stu_num; k++) {
						if (swit[stu_num - 1 - k] == swit[stu_num - 1 + k]) {
							if (swit[stu_num - 1 - k] == 0) {
								swit[stu_num - 1 - k] = 1;
								swit[stu_num - 1 + k] = 1;
							} else {
								swit[stu_num - 1 - k] = 0;
								swit[stu_num - 1 + k] = 0;
							}
						}else {
							break;
						}
					}
				} else {
					for (int k = 0; k <= N - stu_num; k++) {
						if (swit[stu_num - 1 - k] == swit[stu_num - 1 + k]) {
							if (swit[stu_num - 1 - k] == 0) {
								swit[stu_num - 1 - k] = 1;
								swit[stu_num - 1 + k] = 1;
							} else {
								swit[stu_num - 1 - k] = 0;
								swit[stu_num - 1 + k] = 0;
							}
						}else {
							break;
						}
					}
				}
			}
		}
		for (int i=0; i<swit.length; i++) {
			System.out.print(swit[i] + " ");
			if((i+1)%20 == 0)
				System.out.println();
		}
	}
}
