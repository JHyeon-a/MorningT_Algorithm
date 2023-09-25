package boj_2667_단지번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static boolean[][] visited; //갔다온지 체크
	static int[][] map; //마을 정보
	static List<Integer> vil; //단지 별 집 수 넣을 리스트
	static int[] dirx; //방향
	static int[] diry;
	static int houses; //단지 별 집 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new int[N][N];
		vil = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			String line = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}//i
		
		//방향- 하상우좌(의미 없음, 다 돌거니까)
		dirx = new int[]{1, -1, 0, 0};
		diry = new int[]{0, 0, 1, -1};
		
		//아직 안 지나 간 집 찾기
		for(int i= 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					houses = 0; //단지별 집 수 초기화(아직 카운트 안 했으니)
					group(i, j); //단지별 집 카운트
					vil.add(houses); //넣기
				}
				
			}
		}
		
		Collections.sort(vil); //오름차순
		
		//출력
		System.out.println(vil.size());
		for(int i = 0; i<vil.size(); i++) {
			System.out.println(vil.get(i));
		}
		
	}//main
	
	public static void group(int x, int y) {
		visited[x][y] = true; //x, y 지나감
		houses++; //x, y 셈
		//델타탐색
		for(int i = 0; i<4; i++) {
			int nx = x+dirx[i];
			int ny = y+diry[i];
			//범위 안에 있고, 집이 있고, 안 지나갔을 때>세기
			if(0<=nx && nx<map.length && 0<=ny && ny<map.length && map[nx][ny] == 1 && !visited[nx][ny]) {
				group(nx, ny);
			}
			
		}//i
	}//group

}
