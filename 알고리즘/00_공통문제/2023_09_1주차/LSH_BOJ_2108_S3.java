package BOJ_2108_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어진 정수의 개수

		int[] arr = new int[N]; // 주어진 배열
		int sum = 0; // 산술평균을 구하기 위한 모든 요소의 합

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt(); // 배열에 저장
			sum += arr[i]; // 각 요소가 들어오는대로 더하기
		} // for

		Arrays.sort(arr); // 배열을 오름차순 정렬

		int[] count = new int[N]; // 각 배열의 요소별 개수 - 음수인 요소도 있어 앞에서부터 개수를 셌다.
		int j_idx = 0; // 비교할 인덱스의 시작점
		int idx = 0; // count의 현재 인덱스
		for (int j = 0; j < N; j++) { // arr의 각 요소별 개수를 세서 count에 넣는다.
			if (arr[j] == arr[j_idx]) { // 비교할 인덱스의 시작점과 현재 인덱스의 요소를 비교
				count[idx]++; // 해당 배열의 요소를 +1
			} else { // 다른 값이 나왔다
				j_idx = j; // 비교할 인덱스를 현재 인덱스로 변경
				count[++idx]++; // count배열의 다음 인덱스에 추가
			} // if
		} // for

		int cnt_max = -1; // 최빈값
		for (int i = 0; i < N; i++) { // 최빈값 구하기
			cnt_max = cnt_max < count[i] ? count[i] : cnt_max;
		} // for
		int cnt_max_idx = 0; // 최빈값의 인덱스
		int abc = 0; // 최빈값의 개수 - 두번째 최빈값에서 멈추기위함
		for (int i = 0; i < N; i++) {
			if (count[i] == cnt_max) { // 요소가 최빈값이라면
				cnt_max_idx = i; // 해당 인덱스를 저장
				abc++; // 개수 +1
				if (abc == 2) // 최빈값의 개수가 2개면 멈춰
					break;
			}
		}

		int cnt_sum = 0; // arr의 인덱스는 count 배열의 최댓값 이전까지 더한 값
		for (int i = 0; i < cnt_max_idx; i++) 
			cnt_sum += count[i];
		int freq = 0; // 최빈값
		freq = arr[cnt_sum];

		System.out.println(Math.round(sum / (float) N));
		System.out.println(arr[N / 2]);
		System.out.println(freq);
		System.out.println(arr[N - 1] - arr[0]);
	}
}
