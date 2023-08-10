package boj_10807;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		int N = Integer.parseInt(n);
		
		String Num = sc.nextLine();
		String[] num = Num.split("\\s");
		int[] number = new int[num.length];
		for(int i = 0; i<num.length; i++) {
			number[i] = Integer.parseInt(num[i]);
		}
		
		String V = sc.nextLine();
		int v = Integer.parseInt(V);
		
		int cnt = 0;
		for(int i = 0; i<number.length; i++) {
			if(number[i]==v) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
