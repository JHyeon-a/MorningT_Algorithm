package 컵홀더;

import java.util.Scanner;

public class BOJ_2810_B1 {
	public static void main(String[] args) {
		//자리의 오른쪽에 컵홀더를 놓을지 말지 결정하는 코드로 진행
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();						//N 입력 받기		
		boolean L = true;							//왼쪽도 오른쪽도 L이 있을 때 컵홀더 놓을 수 있는 L인지 확인
													//false는 왼쪽 L이 같은 커플석이 아닌 다른 커플석의 L이라는 의미
													//true는 왼쪽 L이 같은 커플석 (오른쪽에 컵홀더 놓기)
		
		String[] cupArray = sc.next().split("");
		//N개의 문자를 입력 받을 cupArray에 입력 받아서 배열로 만들기
			
		int cupSum = 0;								//컵홀더의 개수 합
		
		for(int i=0; i<N; i++) {					//N번 반복
			if(i == 0) {							//만약 가장 첫 번째 자리라면
				cupSum++;							//컵홀더++ (가장 왼쪽 컵홀더)
				if(cupArray[i].equals("S")) {		//거기에 S라면
					cupSum++;						//컵홀더++ (자신의 오른쪽 컵홀더)
				}
			} else if (cupArray[i].equals("S")) {	//첫 번째가 아니고 S라면
				cupSum++;							//컵홀더++ (자신의 오른쪽 컵홀더)

			} else if (cupArray[i].equals("L")) {	//첫 번째가 아니고 L이고
				if(cupArray[i-1].equals("L")) {		//자신의 왼쪽 자리가 L이며
					if(L == true) {					//왼쪽 L이 자신의 커플석이라면
						cupSum++;					//컵홀더++ (자신의 오른쪽 컵홀더)
						if(i+1 >= N|| cupArray[i+1].equals("S")) {
						//만약 자신이 가장 마지막이거나 자신의 오른쪽에 S가 있다면
							L = true;				//L을 true로 바꿔주기
						}else {						//자신의 오른쪽에 L이 있다면
							L = false;				//자신의 오른쪽 L은 자신과 커플석이 아니라는 의미로 false
						}
						
					} else {
					//만약 첫 번째가 아니고 L이고 자신의 왼쪽 자리가 L이며 왼쪽 L이 자신의 커플석이 아니라면
						L = true;					//다음 L은 커플석일 것이므로 true로 바꿔주기
					}

				}
			}
		}
		
		//컵을 컵홀더에 놓을 수 있는 최대 사람의 수 출력
		if(cupSum>N) {								//컵홀더의 개수가 사람 수보다 많다면			
			System.out.println(N);					//최대 사람수는 N
		}else {										//아니라면
			System.out.println(cupSum);				//최대 사람수는 컵홀더의 합
		}
	}
}
