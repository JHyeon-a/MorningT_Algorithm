//맞은거
package BOJ_1449_수리공항승_S3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		//N: 물이 새는 곳의 개수
		int L = sc.nextInt();		//L: 테이프의 길이
		int[] pipe = new int[N];	//pipe 배열: 물이 새는 곳의 위치 배열
		
		//pipe을 이용해 카운팅 배열을 만들기 위한 최대값 찾기
		int max = 0;				
		for(int i=0; i<N; i++) {
			pipe[i] = sc.nextInt();
			max = Math.max(max, pipe[i]);
		}//물 새는 곳 입력 완
		
		//좌우 0.5만큼 간격을 줘야 한다 했으니
		//tapeFix 배열: pipe 배열을 0.5로 쪼갠뒤 만든 pipe의 카운팅 배열
		boolean[] tapeFix = new boolean[max*2+1];	//0.5씩 나눈!
		
		//물이 새는 곳만 체크
		for(int i=0; i<N; i++) {
			//물이 새는 곳이 0이 아니라면(0이면 밑 코드의 인덱스가 -1이 되기 떄문에 제외시킴)
			if(pipe[i] != 0) {
				//tapeFix(0.5로 쪼개져 있는 카운팅 배열)의 2*pipe[i]-1을 true로 바꾼다.
				//2를 곱하는 이유는 tapeFix가 0.5씩 되어 있는 배열이기 때문
				tapeFix[2*pipe[i]-1] = true;
			}
			//그리고 오른쪽도 마찬가지로 true로 바꿔준다.
			tapeFix[2*pipe[i]] = true;
		}
		int sum =0;	//sum: 필요한 테이프의 개수
		
		int i =0;	//i: tapeFix를 순회할 인덱스
		while(i<=max*2) {	//i가 max*2보다 커지면 stop
			if(tapeFix[i] == true) {	//tapeFix[i]가 true라면(테이프 시작 지점이라면)
				int k = i;	//k에 i를 넣고
				for(int tmp = k; tmp<k+L*2; tmp++) {	//k + L*2까지  i를 넘긴다.
					//L*2 = 테이프의 길이 x 2 (tapeFix는 0.5씩 잘랐으니까...)
					//어차피 테이프를 붙여야 하는 시작점이 tapeFix[i]이기 때문에 그 뒤에는 true든 false든 상관 없이 테이프는 붙인다.
					i++;
					
				}
				//테이프 하나 붙였으니 sum = sum+1
				sum++;

			} else {	//tapeFix[i]가 false면(테잎 안 붙이는 곳)
				i++;	//i(인덱스)만 증가시키고 계속
				continue;
			}
		}
		
		//출력
		System.out.println(sum);
		
	}//main

}
