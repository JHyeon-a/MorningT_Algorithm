package BOJ_2597_S3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double L = sc.nextDouble(); //줄자 길이
		double red1 = sc.nextDouble();
		double red2 = sc.nextDouble();
		double blue1 = sc.nextDouble();
		double blue2 = sc.nextDouble();
		double yellow1 = sc.nextDouble();
		double yellow2 = sc.nextDouble();
		
		//줄자 접기
		double m1 = (red1+red2)/2; //첫 번째 접기
		if( m1 > L-m1 ) {
			L = m1;
		}else {
			L = L-m1;
		}
		blue1 = Math.abs(m1-blue1);
		blue2 = Math.abs(m1-blue2);
		yellow1 = Math.abs(m1-yellow1);
		yellow2 = Math.abs(m1-yellow2);
		
		if(blue1 != blue2) {//파란거 기준으로 접기
			double m2 = (blue1+blue2)/2;
			if( m2 > L-m2 ) {
				L = m2;
			}else {
				L = L-m2;
			}
			yellow1 = Math.abs(m2-yellow1);
			yellow2 = Math.abs(m2-yellow2);
		}else {
		}
		
		if(yellow1 != yellow2) {
			double m3 = (yellow1+yellow2)/2;
			if( m3 > L-m3 ) {
				L = m3;
			}else {
				L = L-m3;
			}
		}else {
		}
		System.out.println(Math.floor(L*10)/10.0);	
	}//main
}