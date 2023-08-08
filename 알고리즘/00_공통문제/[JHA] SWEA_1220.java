package SWEA;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Scanner;

/*내가 사용한 방법.(두번째)
 * 각 열마다 순회를 돌면서 1을 찾고, 1 뒤에 2가 나올 때마다 교착상태의 합을 +1 하기
 * 이렇게 한다면 (세로)112 이렇게 있어도, 122가 있어도 하나만 +1을 할 수 있다.
 * 사실... 이건 첫 번째 방법으로 구현하다 막혀서 swea 해당 문제 댓글을 보다가...
 * '각 열 기준으로 1,2만으로 이루어진 String 생성한 다음에 "12" 개수 세서 모두 더하면 쉽게 구할 수 있습니다.'
 * 라는 댓글을 보고 아이디어를 얻었음
 * 그래서 온전히 스스로 푼 문제는 X!!
 */

public class swea1220 {
	public static void main(String[] args) {
		/*try {
			System.setIn(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ //이부분은 파일로 입력을 받기 위해 잠시 사용한 코드

		Scanner sc = new Scanner(System.in);
		int[] result = new int [10];
			
		for(int t=0; t<10; t++) {	// 10개의 테스트 케이스만큼 for문 돌리기
			int number100 = sc.nextInt();	//정사각형 테이블의 한 변의 길이 받기
			int[][] NStable = new int[number100][number100];
				//100x100 테이블 만들기
			int sum =0;
			
			for(int i=0; i<number100; i++) {				//이중 for문으로 테이블에 하나씩 숫자 넣기
				for(int j=0; j<number100; j++) {
					NStable[i][j] = sc.nextInt();
				}
			}
			
			//c: 열, r: 행 => 열은 고정, 행이 움직이며 위에서 아래로 한 열씩 배열 순회
			for(int c=0; c<number100; c++) {
				for(int r=0; r<number100-1; r++) {
					if (NStable[r][c] == 1) {
					//만약 1을 찾으면
						while (NStable[r+1][c] != 2) {
							r++;
							if(r==99) {
								break;
							}
						}
						//다음에 2가 나올때까지 r(행)을 계속더해서 찾아
						//근데 99행이면 빠져나와(마지막이니까)
						
						if(r!= 99 && NStable[r+1][c] == 2) {
							sum++;
						}
						//만약 r이 99가 아니고 다음 행에서 2를 찾았다면 합을 더하자
					}
				}
			}
			
			result[t] = sum;		//결과값 저장

			
			//처음에 생각했던 건 하나씩 해 보려고 했었음
			/* 1은 1이나 2가 나오기 전까지 아래로, 2는 1이나 2가 나오기 전까지 위로.
			1은 아래서부터 시작, 2는 위에서 부터 시작
			만약 배열을 벗어 났다면 원래 있던 자리에 0을 넣으며...
			근데 맞닥뜨린 문제점: 1과 2가 같은 열에 있다면 같은 칸만큼 움직여야하는데
			처음 생각했던 방식대로 한다면 1이 먼저 후루룩 끝내버린다
			그래서 생각을 해보다가 도저히 생각이 안 나서... 2번째 방법을... */
			
			//이 코드는 처음 하려고 했던 코드
//			for(int i= number100-1; i>=0; i--) {		//행 거꾸로
//				for(int j=number100-1; j>=0; j--) {		//열 거꾸로 //배열 뒤에서부터 돌리기
//					if(NStable[i][j] == 1) {			//자성체가 1이라면
//						int Nnumber = i;
//						while(NStable[Nnumber-1][j] != 1 || NStable[Nnumber-1][j] != 2) {
//							Nnumber--;
//						}
//					}
//					
//				}
//			}
			
	
		}
		
		for(int t=0; t<10; t++) {
			System.out.printf("#%d %d\n", t+1, result[t] );

		}
		
	}

}
