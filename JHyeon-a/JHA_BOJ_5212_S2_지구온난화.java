package BOJ_5212_지구온난화_S2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();	//R: 지도의 세로 (행)
		int C = sc.nextInt();	//C: 지도의 가로 (열)
		
		char[][] map = new char[R][C];	//map: 처음 지도
		
		for(int i=0; i<R; i++) {
			map[i] = sc.next().toCharArray();
		}	//map에 지도 넣기
		
		//상 하 좌 우 델타
		int[] dr = {-1, 1, 0, 0};	//행
		int[] dc = {0, 0, -1, 1};	//열
		
		List<Integer> listR = new ArrayList<>();	//listR: 50년 뒤 바다로 바뀌는('.') 섬의 x좌표
		List<Integer> listC = new ArrayList<>();	//listL: 50년 뒤 바다로 바뀌는('.') 섬의 y좌표
		
		
		for(int i=0; i<R; i++) {	//행
			for(int j=0; j<C; j++) {	//열
				if(map[i][j] == 'X') {	//만약 X면
					int cnt = 0;	//cnt: 주변 4곳 중 3곳 이상이 바다인가?
					loop: for(int d=0; d<4; d++) {	//델타 반복문
						int nr = i +dr[d];
						int nc = j +dc[d];
						//만약 상 하 좌 우 중 한 곳이 .으로 되어 있거나 범위 밖으로 넘어가면(바다임)
						if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc] == '.' || nr<0 || nc<0 || nr>=R || nc>=C) {
							cnt++;
							//만약 cnt가 3 이상이라면 (바다가 3 이상)
							if(cnt>=3) {
								//바다로 바뀌는 섬의 x좌표와 y좌표 저장 후 반복문 나가기
								listR.add(i);
								listC.add(j);
								break loop;
							}
						}
						
					}//loop
				//만약 X가 아니라면 다음
				}else {
					continue;
				}//if-else
			}//j
		}//i
		
		//minX, minY: 왼쪽의 시작 좌표들
		//maxX, maxY: 오른쪽의 끝 좌표들
		int minX = R, minY= C;
		int maxX = -1, maxY= -1;

		//일단 50년 후 바다로 바뀌는 곳을 바다로 바꾼다.
		for(int i=0; i<listR.size(); i++) {
			map[listR.get(i)][listC.get(i)] = '.';
		}
		
		//섬인 곳들을 찾아서 minX, minY, maxX, maxY 갱신
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'X') {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
		
		//지도 출력
		for(int i=minX; i<=maxX; i++) {
			for(int j=minY; j<=maxY; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
