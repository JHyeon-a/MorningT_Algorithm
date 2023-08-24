package BOJ_10610_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String snum = br.readLine(); // String으로 입력 받아오기
		
		int N = snum.length(); // 길이

		char[] cList = snum.toCharArray(); // char로 입력받는 배열 생성
		
		StringBuilder sb = new StringBuilder(); // StringBuilder 사용으로 시간단축
		sb.append(-1); // false일 때로 기본 -1 설정

		if (snum.contains("0")) { // 10의 배수이려면 0을 포함해야함
			long sum = 0; // 자릿수의 총합
			for (int i = 0; i < N; i++) { // 자릿수의 총합이 3으로 나눠떨어지면 3의 배수
				sum += (int) cList[i]; // 아스키코드 0 -> 48 / 즉, 아스키코드를 기준으로 자릿수 합을 구하고 3의 배수 판단 가능
			} // for
			if (sum % 3 == 0) { // 자릿수의 총합이 3으로 나눠떨어지면 3의 배수
				Arrays.sort(cList); // 정렬, 내림차순 정렬할 줄 몰라서 그냥 했다. 뒤에서 reverse로 뒤집음
				
				sb.setLength(0); // 초기화
				
				for (char n : cList) // 값 StringBuilder에 넣기 
					sb.append(n);
				sb.reverse(); // 위에서 오름차순정렬을 했기 때문에 뒤집어야한다 
			} // if
		} // if
		System.out.println(sb.toString()); // 출력
	} // main
} // class