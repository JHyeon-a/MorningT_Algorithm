package BOJ_2078_S2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int R = sc.nextInt();

		List<int[]> tree = new ArrayList<>();
		tree.add(new int[] { 1, 1 }); // 루트
		tree.add(new int[] { 2, 1 }); // 루트

		int cnt_L = 1;
		int cnt_R = 0;

		int idx = 2; // tree에 값을 넣을 인덱스
		while (true) {
			int[] arr = new int[2];
			if (idx % 2 == 0) {
				arr[0] = tree.get(idx / 2)[0] + tree.get(idx / 2)[1];
				arr[1] = tree.get(idx / 2)[1];
				tree.add(arr);
			} else {
				arr[0] = tree.get(idx / 2)[0];
				arr[1] = tree.get(idx / 2)[0] + tree.get(idx / 2)[1];
				tree.add(arr);
			}
			if ((tree.get(idx)[0] == L && tree.get(idx)[1] == R) || (tree.get(idx)[1] == L && tree.get(idx)[0] == R)) {
				while (true) {
					if (idx % 2 == 0) {
						idx /= 2;
						cnt_L++;
					} else {
						idx = (idx - 1) / 2;
						cnt_R++;
					}
					if (idx == 1)
						break;
				}
				if(tree.get(idx)[1] == L && tree.get(idx)[0] == R) {
					int dept = cnt_L;
					cnt_L = cnt_R;
					cnt_R = dept;
				}
				break;
			}
			idx++;
		} // while
		System.out.println(cnt_L + " " + cnt_R);

	}
}
