package BOJ_1213_S3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 데이터 받아오기
		char[] data = sc.next().toCharArray();

		int N = data.length;

		// 오름차순정렬
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (data[i] > data[j]) {
					char m = data[j];
					data[j] = data[i];
					data[i] = m;
				} // if - 비교
			} // j
		} // i

		// count - 각 요소별 개수 세기
		int[] count = new int[data[data.length - 1] + 1];
		for (int i = 0; i < N; i++) {
			count[data[i]]++;
		} // count반복문

		// 홀수의 개수에 따라 회문을 만들 수 있는지 없는지 판단 가능
		int cnt1 = 0; // 홀수 개수
		char element1 = 0; // 개수가 홀수인 것의 요소
		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 == 1) {
				cnt1++; // 홀수의 개수 카운팅
				element1 = (char) i; // 홀수인 값 저장
			} // if
		} // for - 홀수 구하기

		String res = "I'm Sorry Hansoo"; // 결과값 초기화

		if (cnt1 == 1) { // 요소의 개수가 홀수인 것이 하나일 때 - 해당 요소를 제외시키고 한칸씩 앞으로 땡기기, 해당 요소 맨 뒤로 보내기
			char[] sort_Arr = new char[N]; // 정렬된 배열
			int index = 0; // 개수가 홀수인 것의 인덱스

			for (int i = 0; i < N; i++) { // 인덱스 구하는 for
				index = (data[i] == element1) ? i : index; // 위에서 구한 홀수인 값과 비교해서 index 구하기
			} // for - index구하기

			for (int i = index; i < N - 1; i++) { // index 뒤에서부터 한칸씩 땡겨오기 - 맨뒤에 한칸 남게됨
				data[i] = data[i + 1];
			} // for - 한칸씩 땡기기

			data[N - 1] = (char) element1; // 배열 마지막칸에 홀수인 값

			for (int i = 0; i < N / 2; i++) { // 정렬하기 - 개수가 다 짝수고 크기순 정렬되어있으니 번갈아가면서 앞과 뒤에 채워주면 됨.
				sort_Arr[i] = data[2 * i]; // 앞을 채워
				sort_Arr[N - 1 - i] = data[2 * i + 1]; // 뒤를 채워
			} // for - 정렬
			sort_Arr[N / 2] = data[N - 1]; // 가운데는 홀수인 값이 들어가야됨

			res = ""; // res 초기화
			for (char c : sort_Arr) // 결과값 구하기
				res += c;

		} else if (cnt1 == 0) { // 요소의 개수가 홀수인 것이 없을때 - 그냥 정렬하면된다.
			char[] sort_Arr = new char[N]; // 배열 생성
			for (int i = 0; i < N / 2; i++) { // 정렬하기 - 개수가 다 짝수고 크기순 정렬되어있으니 번갈아가면서 앞과 뒤에 채워주면 됨.
				sort_Arr[i] = data[2 * i]; // 앞을 채워
				sort_Arr[N - 1 - i] = data[2 * i + 1]; // 뒤를 채워
			} // for - 정렬

			res = ""; // res 초기화
			for (char c : sort_Arr) // 결과값 구하기
				res += c;
		}
		System.out.println(res); // 출력
	}
}
