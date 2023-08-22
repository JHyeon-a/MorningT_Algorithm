package boj_2659;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[4];
		for(int i =0; i<4; i++) {
			arr[i] = sc.nextInt();
		}
		
		//가장 작은 수 찾기(시계수 = 주어진 숫자가 시계방향으로 돌 때, 가장 작은 수)
		//ex- 5 7 8 4>>5784, 7845, 8457, 4578>>시계수 4578
		int idx;
		int min = 10000;
		
		for(int i = 0; i<4; i++) {
			int num = 0;
			for(int k = 0; k<4; k++) {
				idx = i+k;
				if(idx>3) {
					idx -= 4;
				}
			num += arr[idx]*(int)Math.pow(10, 3-k);
			}
			if(min>num) {
				min = num;
			}
		}		
		//개수 세기(몇 번째인지)
		//조건: 0이 있으면 안 됨/tempmin(시계수)가 i일 경우만 세기
		int cnt = 0;
		int tempmin;
		int[] temp = new int[4];
		for(int i=1111; i<min; i++) {//temp[]에 저장
			temp[3] = i%10;
			temp[2] = (i/10)%10;
			temp[1] = (i/100)%10;
			temp[0] = i/1000;
			tempmin = 100000;
			loop: for(int j = 0; j<4; j++) {//시계수 찾기
				int tempNum = 0;
				for(int k = 0; k<4; k++) {
					if(temp[k] == 0) {//0이 있을경우 break;
						break loop;
					}
				}
				for(int k = 0; k<4; k++) {
					idx = j+k;
					if(idx>3) {
						idx -= 4;
					}
				tempNum += temp[idx]*(int)Math.pow(10, 3-k);
				}
				if(tempmin>tempNum) {
					tempmin = tempNum; //시계수 찾음
				}
			}
			if(tempmin == i) { //i == 시계수 >> 카운트
				cnt++;
			}

			
		}//count 반복
		System.out.println(cnt+1);		
	}

}
