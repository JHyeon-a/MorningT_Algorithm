package BOJ_11047_동전0_S4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		//N: 동전의 개수
		int K = sc.nextInt();		//K: 만들 숫자
		int[] arr = new int[N];		//arr: 동전 담아둔 배열

		for (int i = N - 1; i >= 0; i--) {
			arr[i] = sc.nextInt();
		} // 오름차순으로 동전이 주어지기 때문에 내림차순으로 동전을 받기 위해 뒤에서부터 받았다.

		int cnt = 0; // 동전 개수 최솟값

		for (int i = 0; i < N; i++) {	//동전의 개수만큼 돌면서
			if (arr[i] > K) {				//만약 동전이 만들 수(K)보다 크다면
				continue;						//넘어가기!
			} else {						//만약 동전이 만들 수(K)보다 작다면
				while ((K - arr[i]) >= 0) {		//K에서 동전을 뺐을 때 0보다 같거나 클때까지 돌린다!
					K -= arr[i];					//그리고 K에서 동전 뺀다
					cnt++;							//그리고 cnt를 +1 해준다
				}
			}
		}

		//출력
		System.out.println(cnt);

	}

}
