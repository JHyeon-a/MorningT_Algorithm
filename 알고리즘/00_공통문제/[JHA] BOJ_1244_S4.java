package BaekJoon;

import java.util.Scanner;

public class S4_1244 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int switchN = sc.nextInt();				//swtichN: 스위치의 개수
		int[] switchArray = new int[switchN];	//switchArray[]: 스위치의 값이 들어 있는 1차원 배열
		for (int i = 0; i < switchN; i++) {		
			switchArray[i] = sc.nextInt();		//switchArray 배열에 스위치 값 입력
		}

		int studentN = sc.nextInt();			//studentN: 학생수

		for (int i = 0; i < studentN; i++) {	//학생수만큼 반복
			int gender = sc.nextInt();			//gender: 성별 (남자=1, 여자=2)
			int getN = sc.nextInt();			//getN: 학생이 받은 숫자

			if (gender == 1) {					//만약 학생(gender)이 남자(1)라면
				for (int j = 0; j < switchN; j++) {						//스위치 개수만큼 돌면서 getN의 배수 찾기
					if ((j + 1) % getN == 0) {							//getN번째 바꾸기 (index는 0부터 시작이므로 +1 해주기)
						switchArray[j] = (switchArray[j] == 0) ? 1 : 0;	//swtichArray[j]가 0이라면 1로, 아니라면(1이라면) 0으로 바꾸기
					}
				}
			}

			if (gender == 2) {					//만약 학생(gender)이 여자(2)라면
				switchArray[getN-1] = (switchArray[getN-1] == 0) ? 1 : 0;	//일단 본인은 바꿔주기
				int j = 1;													//양옆 비교부터 시작해야하니 1로 시작하는 인덱스 j
				while ((getN-1 - j) >= 0 && (getN-1 + j) < switchN && switchArray[getN-1 - j] == switchArray[getN-1 + j]) {
				//일단 배열 범위를 벗어나는지 확인 && -j한 것과 +j한 것이 같을 때 반복문 돌리기
				//여기서 getN-1을 한 건 배열 인덱스가 0부터 시작하기 때문
					switchArray[getN-1 - j] = (switchArray[getN-1 - j] == 0) ? 1 : 0;	//swtichArray[j]가 0이라면 1로, 아니라면(1이라면) 0으로 바꾸기
					switchArray[getN-1 + j] = (switchArray[getN-1 + j] == 0) ? 1 : 0;	//swtichArray[j]가 0이라면 1로, 아니라면(1이라면) 0으로 바꾸기
					j++;	//그 다음 비교해야하니 +1
				}
			}
		}

		for (int i = 0; i < switchN; i++) {
			System.out.print(switchArray[i] + " ");		//switch 배열 하나씩 찍어주기

			if ((i + 1) % 20 == 0) {					//그런데 만약 20번째라면 엔터를 추가해주기
				System.out.println();
			}
		}

	}

}
