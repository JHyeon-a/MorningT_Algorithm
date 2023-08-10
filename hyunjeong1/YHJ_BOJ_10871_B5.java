package boj_10871;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String first = sc.nextLine();
		String[] First = first.split(" ");
		int N = Integer.parseInt(First[0]);
		int X = Integer.parseInt(First[1]);
		
		String Second = sc.nextLine();
		String[] Sec = Second.split(" ");
		int[] sec = new int[Sec.length];
		
		for(int i = 0; i<Sec.length; i++) {
			sec[i] = Integer.parseInt(Sec[i]);
		}
		for(int i = 0; i<sec.length; i++) {
			if(X>sec[i]) {
				System.out.print(sec[i]+" ");
			}
		}
	}

}
