package BOJ_1448_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Scanner 사용하면 시간초과
		int N = Integer.parseInt(br.readLine()); // 빨대 개수

		int[] straw = new int[N]; // 빨대 배열

		for (int i = 0; i < N; i++) { // 빨대 배열에 값 입력
			straw[i] = Integer.parseInt(br.readLine());
		} // for - i

		Arrays.sort(straw); // 선택정렬이나 이중 반복문 사용하면 시간초과

		int sum = -1;
		for (int i = N-1; i > 1; i--) {
			if (straw[i] < straw[i - 1] + straw[i - 2]) { // 가장 긴 변의 길이가 나머지 두 변의 길이의 합보다 작을 때 삼각형 성립
				sum = straw[i] + straw[i - 1] + straw[i - 2];
				break;
			} // if
		} // for
		System.out.println(sum);
	} // main
} // class
