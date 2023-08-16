package BaekJoon_10825_국영수;

//시간 초과... 다음에 다시 도전!!!
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[][] arr = new String[N][4];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sc.next();
			}
		} // 배열 입력 받기

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// 1. 국어 점수가 같다면
				if (Integer.parseInt(arr[i][1]) == Integer.parseInt(arr[j][1])) {
					// 2. 영어 점수가 같다면
					if (Integer.parseInt(arr[i][2]) == Integer.parseInt(arr[j][2])) {
						// 3. 수학 점수도 같다면
						if (Integer.parseInt(arr[i][3]) == Integer.parseInt(arr[j][3])) {
							// 4. 이름 한 글자씩 비교해서 정렬(오름차순 정렬)
							name: for (int k = 0; k < arr[i][0].length(); k++) {
								//꺼내온 글자가 같으면 계속 for문을 돌리자
								if (arr[i][0].charAt(k) == arr[j][0].charAt(k)) {
									continue;
								} else if (arr[i][0].charAt(k) > arr[j][0].charAt(k)) {
									//순서 바꿔야 하는 경우(오름차순 정렬이 안 되어 있다면!)
									String[] tmp = arr[j];
									arr[j] = arr[i];
									arr[i] = tmp;
								} else {
									// 그외: 바꿀 필요 없음! 나가기
									break name;
								}
							}//이름 오름차순 정렬 끝		

						//수학 점수가 다를때
						} else {
							//비교 후 스왑
							if (Integer.parseInt(arr[i][3]) < Integer.parseInt(arr[j][3])) {
								String[] tmp1 = arr[j];
								arr[j] = arr[i];
								arr[i] = tmp1;
							}
						}// 수학 정렬 끝
					//영어 점수가 다를 때
					} else {
						//비교 후 스왑
						if (Integer.parseInt(arr[i][2]) > Integer.parseInt(arr[j][2])) {
							String[] tmp2 = arr[j];
							arr[j] = arr[i];
							arr[i] = tmp2;
						}
					}//영어 정렬 끝
				//국어 점수가 다를 때
				} else {
					//비교 후 스왑
					if (Integer.parseInt(arr[i][1]) < Integer.parseInt(arr[j][1])) {
						String[] tmp3 = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp3;
					}
				}//국어 정렬 끝

			}//for문

		} // N번 돌기
		
		

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i][0] + " ");
			System.out.println();
		} // 출력

	}// main
}// class