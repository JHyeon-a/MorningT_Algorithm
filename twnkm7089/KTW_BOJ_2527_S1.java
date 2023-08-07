import java.util.Scanner;

public class KTW_BOJ_2527_S1 {
	/*알고리즘 설명
	 * 직사각형으로 겹치는 경우의 수는 너무 많다고 생각, 그래서 d->c->b->a 순으로 소거
	 * 사각형을 A, B로 나누고, 받는 값을 A의 x좌표 최소값, y좌표 최소값, x좌표 최대값, y좌표 최대값이라는 의미로 저장.
	 * B의 경우도 같게 시행
	 * 1) 공통 부분이 없는 경우부터... 한 사각형의 x좌표 최대값보다 다른 사각형의 x좌표 최소값이 더 크면 겹치지 않는다, y좌표의 경우도 동일.
	 * 2) 이제 떨어져 있는 경우는 없다. 그렇다면 남은건 a, b, c의 경우 점으로 겹치는 경우는 4가지니 이걸로 감소.
	 * 3) 한 사각형의 x좌표 최대값이 다른 사각형의 x좌표 최소값과 겹치는 경우, 떨어진건 제외했으니 선 아니면 점.
	 * 4) 한 사각형의 y좌표 최대값이 다른 사각형의 y좌표 최소값과 같으면 점으로 겹쳐지고, 아니면 세로로 겹쳐지는 선. 
	 * 5) 사각형의 위치 바꿔가며 시행하면 c는 모두 소거. 이제 가로로 겹쳐지는 선의 경우 제외하자.
	 * 6) 이거도 찾으면 남은건 직사각형으로 겹치는 것.
	 * */
	public static void main(String[] args) {
		int AXmax, AXmin, AYmax, AYmin;
		int BXmax, BXmin, BYmax, BYmin;
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			//두 사각형의 좌표 입력 받기.
			AXmin = sc.nextInt();
			AYmin = sc.nextInt();
			AXmax = sc.nextInt();
			AYmax = sc.nextInt();
			
			BXmin = sc.nextInt();
			BYmin = sc.nextInt();
			BXmax = sc.nextInt();
			BYmax = sc.nextInt();
			
			//find case d
			if( (AXmax < BXmin) || (BXmax < AXmin) || (AYmax < BYmin) || (BYmax < AYmin) ) {
				System.out.println("d");
				//남은건 a,b,c case 만약 같으면 최소 선분인 경우 4가지
			} else if(AXmax == BXmin) { //세로로 서로 겹칠 경우
				if(AYmin==BYmax || AYmax == BYmin) { //가로로도 겹치면 점
					System.out.println("c");
				} else { //아니면 세로로 겹쳐 선
					System.out.println("b");
				}
			} else if(BXmax == AXmin) { //A,B 위치 바꾸어서 시행
				if(BYmin == AYmax || BYmax == AYmin) {
					System.out.println("c");
				} else {
					System.out.println("b");
				}
				//이제 점은 다 찾음, 남은건 가로로 겹치는 선
			} else if (AYmax == BYmin || BYmax == AYmin) { //선으로 겹치는 경우(가로)
				System.out.println("b");
			} else { //d, c, b 소거했으니 a만 남음
				System.out.println("a");
			}
		
		}
	}
}
