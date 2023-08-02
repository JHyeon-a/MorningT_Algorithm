import java.util.Scanner;

public class yhj_bj_2810 {
	
	//1. String 이용(indexOf사용)
	public static void main(String[] args) {
	
		int N; //좌석 수
		String seat;
		int cupN;//컵홀더 수
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		seat = sc.next();

		//기본 컵홀더 수 = N+1
		//컵홀더 수 = N+1-(LL의 수/2) = 컵홀더를 사용 가능한 사람의 수
		cupN = N+1;
		int p = N;//L위치
		int cnt = 0;
		for(int i=(N-1); i>=0; i--) {
			if(seat.indexOf("L",i)!=-1 && seat.indexOf("L",i)<p) {
				cnt++;
				p = seat.indexOf("L", i);
			}else {
				continue;
			}
		}
		cupN = N + 1 - (cnt/2);

		if(cupN>N)
			System.out.println(N);
		else
			System.out.println(cupN);		
	}
	
	
	//2. 배열 이용
//	public static void main(String[] args) {
//		int N; //좌석수 
//		int cupN; //컴홀더 수
//		int cnt = 0;//L 개수
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		String[] seat = new String[N]; //좌석정보
//		for(int i = 0; i<seat.length; i++) {
//			seat[i]=sc.nextLine();
//		}
//		for(int l = 0; l<seat.length; l++) {
//			if(seat[l] == "L")
//				cnt++;
//		}
//		cupN = N + 1 - (cnt/2);
//		if(cupN>N)
//			System.out.println(N);
//		else
//			System.out.println(cupN);
//	}	
}
