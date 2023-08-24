package bronze;

import java.util.Scanner;

public class BOJ_2810_B1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 좌석의 개수 N개
		
		String seat = sc.next(); // 좌석의 정보
		
		// 반복문을 통해 문자열을 쪼개서 S와 N의 개수 세
//		int cnt_S = 0;
//		int cnt_L = 0;
//		
//		for(int i=0; i<seat.length(); i++) {
//			if(seat.charAt(i) == 'S')
//				cnt_S++;
//			if(seat.charAt(i) == 'L')
//				cnt_L++;
//		}
//		
//		int cup = cnt_S + cnt_L/2 + 1;
		
		// replace를 사용해 S와 L 대신 공백을 넣어 개수 구하기
		int cup = seat.replace("L", "").length() + seat.replace("S", "").length()/2 + 1; 
		
		if(cup >= N) {
			System.out.println(N);
		}else {
			System.out.println(cup);
		}
		
	}
}
