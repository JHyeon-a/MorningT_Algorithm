//완전탐색
package BOJ_1431_시리얼번호_S3;

import java.util.Scanner;

public class Main {
	static String[] serial;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		serial = new String[N];

		for (int i = 0; i < N; i++) {
			serial[i] = sc.next();

		} // 입력 끝

		// 하나씩 비교하면서 스왑
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				char[] serialI = serial[i].toCharArray();	// serialI: 문자열 serial[i]를 한 글자씩 잘라서 char형으로
				char[] serialJ = serial[j].toCharArray();	// serialJ: 문자열 serial[j]를 한 글자씩 잘라서 char형으로
				//1. 만약 serial[i]의 길이가 serial[j]의 길이보다 작다면 스왑
				if (serial[i].length() > serial[j].length()) {
					swap(i, j);
				//만약 serial[i]의 길이가 serial[j]의 길이보다 작다면 다음 j로 넘어가기
				} else if (serial[i].length() < serial[j].length()) {
					continue;
				//2. 만약 serail[i]의 길이가 serial[j]의 길이와 같다면 숫자 합 비교
				} else if (serial[i].length() == serial[j].length()){
					int iSum = 0;	//iSum: serial[i]에서의 숫자들의 합
					int jSum = 0;	//jSum: serial[j]에서의 숫자들의 합
					//2-1. serial[i]의 길이만큼 돌면서 serialI[k]가 숫자라면 iSum에 더하고, serialJ[k]가 숫자라면 jSum에 더한다
					for (int k = 0; k < serial[i].length(); k++) {
						if (serialI[k] >= '0' && serialI[k] <= '9') {
							iSum += serialI[k]-'0';
						}
						if (serialJ[k] >= '0' && serialJ[k] <= '9') {
							jSum += serialJ[k]-'0';
						}
					}
					//2-2. 만약 jSum이 iSum보다 작다면 serial[i]와 serial[j] 스왑
					if (jSum < iSum) {
						swap(i, j);
					//2-3. 만약 jSum이 iSum과 같다면
					} else if(jSum == iSum) {
						//3. 사전순으로 정렬
						//serial[i]의 길이만큼 돌면서 한 글자씩 비교
						for (int k = 0; k < serial[i].length(); k++) {
							//3-1. 만약 serialI[k]가 serialJ[k]랑 같다면 다음 글자 비교하기 위해 넘어가기
							if(serialI[k] == serialJ[k]) {
								continue;
							//3-2. 만약 serialJ[k]가 숫자라면
							} else if(serialJ[k] >= '0' && serialJ[k] <= '9') {
								//3-2-1. 만약 serialI[k]가 문자라면 스왑하고 그만.
								if(serialI[k] <'0' || serialI[k] >'9') {
									swap(i, j);
									break;
								//3-2-2. 만약 serialI[k]가 숫자라면
								} else {
									//만약 serialJ[k]가 serial[k]보다 작다면 스왑하고 멈추고 같거나 크면 그냥 멈추기
									if(serialJ[k] < serialI[k]) {
										swap(i, j);
										break;
									} else {
										break;
									}
								}
							//3-3. 만약 serialJ[k]가 문자라면 
							} else if(serialJ[k] <'0' || serialJ[k] >'9') {
								//3-3-1. 만약 serialI[k]가 숫자라면 그냥 멈추고
								if(serialI[k] >='0' && serialI[k] <='9') {
									break;
								//3-3-2. 만약 serialI[k]가 문자라면
								} else {
									//만약 serialJ[k]가 serialI[k]보다 작다면 스왑하고 멈추고 같거나 크면 그냥 멈추기
									if(serialJ[k] < serialI[k]) {
										swap(i, j);
										break;
									} else {
										break;
									}
								}
								
							}//3-3 for문

						}// 사전순 정렬을 위한 for문 끝

					//2-4. 만약 jSum이 iSum보다 크다면
					} else {
						break;
					}

				}//2 숫자 합 비교 끝

			}//j

		}//i
		
		for(int i=0; i<N; i++) {
			System.out.println(serial[i]);
		}

	}// main
	
	//swap 함수
	public static void swap(int i, int j) {
		String tmp = serial[i];
		serial[i] = serial[j];
		serial[j] = tmp;
	}

}
