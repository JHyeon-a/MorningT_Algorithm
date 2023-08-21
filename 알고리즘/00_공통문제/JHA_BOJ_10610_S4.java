package BOJ_10610_30_S4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();				//한줄의 string으로 입력 받고
		int[] arr = new int[str.length()];	//int 배열 생성

		boolean zero = false;				//0이 들어 있는지 아닌지 확인
		int result = -1;					//result = -1로 초기화
		int sum = 0;						//sum: 3의 배수인지 확인하기 위해 구하는 합

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';	//int 배열 arr에 string을 char로 바꾼뒤 '0'을 빼서 저장
			if (arr[i] == 0) {				//arr[i]가 0 이라면
				zero = true;				//zero = true로 바꿔주기
			}
			sum += arr[i];					//sum에 arr[i] 더하기
		}// arr에 한 글자씩 입력 완료/0이 들었는지 확인 완료/sum 구하기 완료

		if (zero) {							//1번째 조건: 0이 있다면
			if (sum % 3 == 0) {				//2번째 조건: sum이 3으로 나누어 떨어진다면
				Arrays.sort(arr);			//정렬(오름차순)
				for (int i = arr.length - 1; i >= 0; i--) {	//(내림차순으로 출력해야 가장 크기 때문에 뒤에서부터 출력)
					System.out.print(arr[i]);
				}
			} else {						//2번째 조건 탈락일 경우
				System.out.print(result);	//-1 출력
			}

		} else {							//1번째 조건 탈락일 경우
			System.out.print(result);		//-1 출력
		}// if-else로 30의 배수인지 확인


	}//main

}//MainClass
