package SWEA_1289;

import java.util.Scanner;
//최초의 1부터, 숫자 달라질때마다 카운트(연속된 같은 수는 한 개 취급)
//원재의 메모리 복구하기, d3
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String TestCase = sc.nextLine();
		int T = Integer.parseInt(TestCase);
		
		for(int t = 1; t<=T; t++) {
			String line = sc.nextLine();
			int start = line.indexOf("1");
			int cnt = 1;//처음에 0에서 1가야하니까
			int[] address = new int[line.length()];
			for(int i = 0; i<line.length(); i++) {
				address[i] = (int)(line.charAt(i));
			}//배열에 주소 넣기
			
			
			for(int i = start; i<line.length()-1; i++) {
				if(address[i] != address[i+1]) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);	
		}	
	}

}
