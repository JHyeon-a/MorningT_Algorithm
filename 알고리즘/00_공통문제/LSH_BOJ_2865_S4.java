package BOJ_2865_S4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 예선 참가자
		int M = sc.nextInt(); // 장르 수
		int K = sc.nextInt(); // 결승진출자

		HashMap<Integer, Float> map = new HashMap<>(); // key : 참가자 번호, value : 능력

		for (int i = 0; i < N; i++) {
			map.put(sc.nextInt(), sc.nextFloat()); // 순서대로 key와 value 넣기
		} // for

		for (int i = 0; i < M - 1; i++) { // 장르의 수 - 첫번째 장르에 대한 입력값은 받았으니 -1
			for (int j = 0; j < N; j++) { // 학생 수 - 장르별로 학생 수는 같기에 N번 반복
				int key = sc.nextInt(); // 참가자 번호
				float value = sc.nextFloat(); // 해당 번호의 능력
				if (value > map.get(key)) // 값이 들어오는대로 참가자 번호에 대한 현재의 value를 비교해 큰 값으로 저장
					map.put(key, value); // map에 큰 값 저장
			} // for - j
		} // for - i

		List<Float> arr = new ArrayList<>(); // 값을 다 입력하고 남아있는 value들만 저장
		map.forEach((key, value) -> {
			arr.add(value);
		});

		for (int i = 0; i < N - 1; i++) { // 값을 크기 순으로 정렬
			for (int j = i + 1; j < N; j++) {
				if (arr.get(i) < arr.get(j)) {
					float a = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, a);
				} // if
			} // for - j
		} // for - i
		float res = 0.0f;

		for (int i = 0; i < K; i++) { // 크기순으로 정렬한 value들 중 앞에서부터 본선참가자 수만큼 출력하면 됨.
			res += arr.get(i);
		} // for
		System.out.printf("%.1f", res);
	}
}
