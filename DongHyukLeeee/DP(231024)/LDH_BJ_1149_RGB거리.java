package Study;

import java.util.*;

import java.io.*;

	
public class LDH_BJ_1149_RGB거리 {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(input1);
		
		int N = sc.nextInt();
		
		int numbers[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			numbers[i][0]=sc.nextInt();
			numbers[i][1]=sc.nextInt();
			numbers[i][2]=sc.nextInt();
		}
		int d[][] = new int[N][3];
		d[0][0]=numbers[0][0];
		d[0][1]=numbers[0][1];
		d[0][2]=numbers[0][2];
		for(int i=1; i<N ;i++) {
			d[i][0]=Math.min(numbers[i][0]+d[i-1][1], numbers[i][0]+d[i-1][2]);
			d[i][1]=Math.min(numbers[i][1]+d[i-1][0], numbers[i][1]+d[i-1][2]);
			d[i][2]=Math.min(numbers[i][2]+d[i-1][0], numbers[i][2]+d[i-1][1]);
		}
		System.out.println(Math.min(d[N-1][0], Math.min(d[N-1][1], d[N-1][2])));
		
		
		
		
		
	}
	static String input1 = "3\r\n"
			+ "26 40 83\r\n"
			+ "49 60 57\r\n"
			+ "13 89 99";//96
	static String input2 = "3\r\n"
			+ "1 100 100\r\n"
			+ "100 1 100\r\n"
			+ "100 100 1";//3
	static String input3 = "3\r\n"
			+ "1 100 100\r\n"
			+ "100 100 100\r\n"
			+ "1 100 100";//102
}