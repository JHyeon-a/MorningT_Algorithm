package BaekJoon;

import java.util.Scanner;

public class B2_2292 {
	public static void main(String[] args) {
		
		/*풀이방식: ex) 1 => 1 / 2~7 =>2, 8~19 =>3, 20~37 => 4
		 * 이렇게 나와야 함.
		 * 각 층?방마다 끝방-1하면 0, 6*1, 6*2, 6*3,...
		 * 그러니까 만약 58번째를 구한다면 58보다 작으면서 6의 배수인 54(6*9)로 바꾼뒤
		 * sum(1부터 1커진 수를 더하는 변수)이 9보다 크다면 멈추고 현재 i를 구한다.
		 * 그 i가 바로 벌집까지의 방 개수...
		 * 
		 * */
		

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 주어지는 숫자 N값
		int NN = N-2; // NN: 원래 방에서 제일 처음 방인 1 뺀 방... 인데
						//답은 N-2를 해야 나온다... 왜지?
		int M = NN - (NN % 6); //6의 배수인 M으로 만들어주기 위해
		int sum = 0;
		int result;				//결과

		if (N == 1) {				//N이 1일땐 그냥 1
			System.out.println(1);
		} else {

			int number6 = M / 6;	//N이 1이 아닐 때...
									//6의 나눗셈 몫 = number6
			int i = 1;				//i는 1, 2, 3, 이렇게 늘어남
			while (true) {			
				sum = sum + i;		//sum에다가 기존 sum값 + i 더함

				if (number6 < sum) {//6의 나눗셈 몫이 sum보다 작으면
					result = i + 1;	//결과값으로 i+1 보내고 멈춰
					break;
				}
				i++;

			}

			System.out.println(result);

		}

	}

}
