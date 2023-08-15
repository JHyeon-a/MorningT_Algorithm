package SWEA_1289_원재의메모리복구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();	//테스트케이스 입력받기

		for (int tc = 1; tc <= testCase; tc++) {
			String str = sc.next();		//공백 구분이 되어있지 않아서 String으로 입력 받고
			int memoryLen = str.length();	//memoryLen: 메모리의 총 길이
			int[] arr = new int[memoryLen];	//string의 길이를 크기로 만든 배열 생성 

			for (int i = 0; i < memoryLen; i++) {
				arr[i] = str.charAt(i) - '0';
			} // 입력 받아서 arr[]에 하나씩 정수로 넣기

			int idxOne = 0;
			for (int i = 0; i < memoryLen; i++) {
				if (arr[i] == 1) {
					idxOne = i;	//idxOne: 가장 먼저 발견하는 1의 인덱스
					break;	//찾으면 멈추고 나가기
				}
			} // 가장 먼저 나오는 1 찾기

			boolean isOne = true;	//i-1번째가 1인지 0인지 구분하는 boolean 변수
			int cnt = 0;	//i번째가 i-1번째와 같은 숫자라면(연속이라면) +1을 해주는!

			for (int i = idxOne + 1; i < memoryLen; i++) {
			//처음 찾은 1부터 끝까지
			//처음(idxOne)은 1이기 때문에 idxOne 다음부터 검사하기 위해 i는 idxOne+1부터 시작
				if (isOne == true) {//이전 문자가 1이고
					if (arr[i] == 1) {	//현재 문자가 1이면
						isOne = true;		//다음 문자의 이전 문자가 1이라는 정보를 주기 위해 isOne은 true로 설정
						cnt++;				//1 => 1 이므로 연속! +1를 해준다
					} else {			//현재 문자가 0이면
						isOne = false;		//0이라는 걸 알려주기 위해 false로
					}

				} else {			//이전 문자가 1이 아니고(0이고)
					if (arr[i] == 0) {	//현재 문자가 0이면
						isOne = false;		//다음 문자에게 이전 문자는 0이라고 알려주기
						cnt++;				//0 => 0이므로 연속! +1를 해준다
					} else {			//현재 문자가 1이면
						isOne = true;		//다음 문자에게 이전 문자는 1이라고 알려주기
					}

				}
			}

			int result = memoryLen - idxOne - cnt;
			//총 수정횟수(result)는 총 길이(memoryLen)-처음1발견한곳(idxOne)-연속갯수(cnt)
			
			System.out.printf("#%d %d\n", tc, result);	//출력

		}

	}// main

}
