import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * 알고리즘 설명
		 * 좌석 수가 N일 때, 모두 일반좌석일 경우, 양 끝까지 포함해 컵홀더는 총 N+1개.
		 * 커플석이 한 쌍(두자리) 나올 때마다 컵홀더는 하나씩 없어짐.
		 * 고로, 컵홀더의 개수는 N+1-(커플석 수/2)
		 * 컵홀더 개수가 사람보다 많으면 최대 사람 수는 모든 사람의 수.
		 * 적으면 최대 사람 수는 컵홀더 개수.
		 * */
		Scanner sc = new Scanner(System.in);
		int coupleNum = 0;
		
		//좌석수 입력
		int n = sc.nextInt();
		
		//좌석 정보 입력
		String seat = sc.next();
		for(int i = 0; i < n; i++) {
			if(seat.charAt(i) == 'L') {
				coupleNum += 1;
			}
		}

		int cupHolder = (n + 1 - (coupleNum/2));
		if(cupHolder >= n) {
			System.out.println(n);
		} else {
			System.out.println(cupHolder);
		}
	
	}
		
}
