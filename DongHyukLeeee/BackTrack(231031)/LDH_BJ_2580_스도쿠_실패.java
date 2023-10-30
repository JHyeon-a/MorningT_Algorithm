package Study;
import java.util.Scanner;

public class LDH_BJ_2580_스도쿠_실패 {

	static int map [][];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N =9;
		map = new int[N][N];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
			map[i][j]=sc.nextInt();
			
			}
		}
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j]==0) {
					for(int k=1; k<=9; k++) {
						map[i][j]=k;
						if(i_check_j_check(i, j)) {
							break;
						}
					}
					
				}
			
			}
		}		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
			System.out.printf("%d" , map[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
	static boolean i_check_j_check(int starti, int startj) {
		int [] checkingI = new int[10];
		int [] checkingJ = new int[10];
		
		for(int i=0; i<9; i++) {
			checkingI[map[i][startj]]++;
		}
		for(int i=0; i<9; i++) {
			checkingJ[map[starti][i]]++;
		}
		for(int i=1; i<=9; i++) {
			if(checkingI[i]>=2||checkingJ[i]>=2) {
				return false;
			}
		}
		
		int counting[] = new int[10];
		int a = (starti/3)*3;
		int b = (startj/3)*3;
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				counting[map[i][j]]++;
			}
		}
		
		for(int i=1 ;i<=9; i++) {
			if(counting[i]>=2)
				return false;
		}
		
		
		return true;

	}
	
	static String input1 = "0 3 5 4 6 9 2 7 8\r\n"
			+ "7 8 2 1 0 5 6 0 9\r\n"
			+ "0 6 0 2 7 8 1 3 5\r\n"
			+ "3 2 1 0 4 6 8 9 7\r\n"
			+ "8 0 4 9 1 3 5 0 6\r\n"
			+ "5 9 6 8 2 0 4 1 3\r\n"
			+ "9 1 7 6 5 2 0 8 0\r\n"
			+ "6 0 3 7 0 1 9 5 2\r\n"
			+ "2 5 8 3 9 4 7 6 0";
}
