package BOJ_2108_통계학_S3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 수의 개수
		int[] arr = new int[N]; // arr: N개의 수를 담아둔 배열
		int sum = 0; // sum: N개 수들의 합
		int[] count = new int[8001]; // count: arr의 카운트 배열
		int frequencyMax = 0; // frequencyMax: 최대 빈도수

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i]; // 합 구하고

			count[arr[i] + 4000]++; // 빈도수 구하고
			frequencyMax = Math.max(frequencyMax, count[arr[i] + 4000]); // 최대 빈도수 갱신
		}

		// 정렬
		Arrays.sort(arr); // arr 배열 정렬
		int mid = arr[N / 2]; // mid: 중앙값
		int max = arr[N - 1]; // max: 최댓값
		int min = arr[0]; // min: 최솟값

		List<Integer> count2 = new ArrayList<>();
		int idx = 0; // idx: count2의 인덱스

		for (int i = 0; i < 8001; i++) {
			if (count[i] == frequencyMax) {
				count2.add(i - 4000);
				idx++;
			}
		}

		// 산술평균
		if (sum < 0) {
			double result = Math.rint((double) sum / N);
			System.out.println((int) result);

		} else {
			System.out.println(Math.round((double)sum / N));

		}

		// 중앙값
		System.out.println(mid);

		// 최빈값
		Collections.sort(count2);
		if (idx == 1) {
			System.out.println(count2.get(0));
		} else if (idx > 1) {
			System.out.println(count2.get(1));
		}

		// 최댓값과 최솟갑의 차이
		System.out.println(max - min);

	}// main

}
