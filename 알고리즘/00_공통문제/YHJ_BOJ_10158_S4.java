package boj_10158;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//가로, 세로 움직임 따로 볼 것
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt();
		int t = sc.nextInt();
		//최종값
		int x = 0;
		int y = 0;
		//세로방향 움직임
		int verticalShare = (t + q)/(2*h); //p,0에서 부터 움직일게, 중복은 뺀다.
		int verticalRemainder = (t + q)%(2*h);//찐 움직임
		if(verticalRemainder>h) {
			y = h - (verticalRemainder-h) ;
		}else {
			y = verticalRemainder;
		}
		//가로방향 움직임
		int horizontalShare = (t+p)/(2*w); //0,q에서 움직임, 중복 빼고
		int horizontalRemainder = (t+p)%(2*w);
		if(horizontalRemainder>w){
			x = w - (horizontalRemainder-w);
		}else {
			x = horizontalRemainder;
		}
		System.out.println(x+" "+y);
		
		
	}

}
//28m