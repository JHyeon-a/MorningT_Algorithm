package boj_1541_s2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//+먼저하고 -나중에 > -값이 커짐
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] arr = new char[line.length()];
		for(int i = 0; i<line.length(); i++) {
			arr[i] = line.charAt(i);
		}
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i = 0; i<line.length(); i++) {
			if(arr[i] == '-') {
				tmp.add(-2);
			}else if(arr[i] == '+') {
				tmp.add(-1);
			}else {//숫자
				tmp.add(Character.getNumericValue(arr[i]));
			}
		}
//		for(int i = 0; i<tmp.size(); i++) {
//			System.out.print(" 1 "+tmp.get(i));			
//		}
//		System.out.println();
		for(int i = 0; i<tmp.size(); i++) {//계산 시작
			if(i+1<tmp.size() && tmp.get(i)>= 0 && tmp.get(i+1) >= 0) {//연속해서 숫자>숫자 붙여줌
				tmp.add(i, tmp.get(i)*10+tmp.get(i+1));
				tmp.remove(i+1);
				tmp.remove(i+1);
				i--;
			}
		}
//		for(int i = 0; i<tmp.size(); i++) {
//			System.out.print(" 2 "+tmp.get(i));			
//		}
//		System.out.println();
		for(int i = 0; i<tmp.size(); i++) {
			if(i-1>=0 && i+1< tmp.size() && tmp.get(i) == -1) {//덧셈 먼저
				tmp.add(i-1,tmp.get(i-1)+tmp.get(i+1));
				tmp.remove(i);
				tmp.remove(i);
				tmp.remove(i);
				i -= 2;
			}
		}
//		for(int i = 0; i<tmp.size(); i++) {
//			System.out.print(" 3 "+tmp.get(i));			
//		}
//		System.out.println();
		for(int i = 0; i<tmp.size(); i++) {//빼기
			if(i-1>=0 && i+1< tmp.size() && tmp.get(i) == -2) {
				tmp.add(i-1, tmp.get(i-1)-tmp.get(i+1));
				tmp.remove(i);
				tmp.remove(i);
				tmp.remove(i);
				i -= 2;
			}
		}
//		for(int i = 0; i<tmp.size(); i++) {
//			System.out.print(" 4 "+tmp.get(i));			
//		}
//		System.out.println();
		System.out.println(tmp.get(0));
	
	}//main

}
