package boj_2659;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//시계수 순서 세기
		//1~9, 중복 조합, 배열은 오름차순만 가능
		//1. 현재 수를 받기. 2. 시계수 구하기 3.그보다 작은 수 들 중 시계수인 수 개수세기
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[4];
		for(int i =0; i<4; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int cnt = 0;
		int num = arr[0]*1000 + arr[1]*100+ arr[2]*10+ arr[3];
		int[] temp = new int[4];
		for(int i=1111; i<num; i++) {
			temp[3] = i%10;
			temp[2] = (i/10)%10;
			temp[1] = (i/100)%10;
			temp[0] = i/1000;
			Arrays.sort(temp);
			if(temp[0] != 0 && i == temp[0]*1000+temp[1]*100+temp[2]*10+temp[3]) {
				cnt++;
				System.out.println(i);
			}
		}
		System.out.println(cnt+1);		
	}

}
