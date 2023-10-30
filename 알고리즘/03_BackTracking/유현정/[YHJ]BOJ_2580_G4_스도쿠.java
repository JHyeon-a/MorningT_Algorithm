package BOJ_2580_Sudoku;

import java.util.Scanner;

public class Main {
	static int[][] sudoku;
	static int[] arri;
	static int[] arrj;
	static int idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sudoku = new int[9][9];
		arri = new int[81];
		arrj = new int[81];
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				sudoku[i][j] = sc.nextInt();
				if(sudoku[i][j] == 0) {
					arri[idx] = i;
					arrj[idx++] = j;
				}
			}
		}
		
			check();
		
		//출력
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}//main
	
	public static void check() {

		while(idx != 0) {
			
			for(int k = 0; k<idx; k++) {
				int[] num = new int[10];
				int i = arri[k];
				int j = arrj[k];
				//가로체크
				for(int l = 0; l<9; l++) {
					num[sudoku[i][l]]++;
				}
				//세로체크
				for(int l = 0; l<9; l++) {
					num[sudoku[l][j]]++;
				}
				//박스 체크
				int ni = i/3;
				int nj = j/3;
				
				for(int l = 0+ni*3; l<3+ni*3; l++) {
					for(int m = 0+nj*3; m<3+nj*3; m++) {
						num[sudoku[l][m]]++;
					}
				}
				
				
				//숫자 넣기-넣을 수 있는게 한 개면
				int check = 0;
				int tmp = -1;
				for(int l = 1; l<10; l++) {
					if(num[l] == 0) {
						check++;
						tmp = l;
					}
				}
				if(check == 0) {
					sudoku[i][j] = tmp;
					idx--;
				}
			}//k
			
		}//while
	}//check

}
