package BOJ_2078_S2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt(); // 노드의 왼쪽
		int R = sc.nextInt(); // 노드의 오른쪽
		
		int cnt_L = 0; // 왼쪽으로 몇번 움직였나
		int cnt_R = 0; // 오른쪽으로 몇번 움직였나
		
		// 찾을 노드에서 시작해 아래서 위로 이동하기
		while(L > 1 || R > 1) { // 현재 노드인 (L,R)이 (1,1)이면 멈춰((1,1)이 루트이다)
			// 왼쪽 자식은 (a+b,b) / 오른쪽 자식은 (a,a+b)
			// a,b는 자연수이므로 왼쪽이 크면 왼쪽 자식, 오른쪽이 크면 오른쪽 자식이다.
			if(L>R) { // 왼쪽이 크다면
				cnt_L++; // 왼쪽 자식이므로 왼쪽 이동횟수를 추가
				L -=R; // 왼쪽 자식 (a+b,b)에서 부모 노드 (a,b) 되려면 R은 그대로, L은 R을 빼야함
			}else { // 오른쪽이 크다면
				cnt_R++; // 오른쪽 자식이므로 오른쪽 이동횟수를 추가
				R -= L; // 오른쪽 자식 (a,a+b)에서 부모 노드 (a,b) 되려면 L은 그대로, R은 L을 빼야함
			}
		} // while
		System.out.println(cnt_L + " " + cnt_R); // 출력
	} // main
} // class