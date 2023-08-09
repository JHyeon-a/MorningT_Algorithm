package swea_1220;

import java.util.Scanner;

public class Solving {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;//테스트 케이스
		
		int arr[][] = new int[100][100];
		
		
		for(int t=1; t<=T; t++) {		
			String N = sc.nextLine();//배열 수
			int cnt = 0;
			for(int i = 0;i<100;i++) {
				String line;
				line = sc.nextLine();
				String[] strmag = line.split("\\s");
				
				for(int j = 0;j<strmag.length;j++) {
					arr[i][j] = Integer.parseInt(strmag[j]);
				}			
			}
			//접합부분 찾기(1/2)
			for(int y =0; y<100; y++) {
				for(int x=0;x<100;x++) {
					if(arr[x][y]==1) {
						loop : for(int a=x+1;a<100;a++) {
							if(arr[a][y]==1) {
								break loop;
							}else if(arr[a][y]==2) {
								cnt++;
								break loop;
							}
						}	
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	
		
		
	}

}
