package BOJ_2108_S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//버퍼드 사용 준비
		String num = br.readLine();
		int N = Integer.parseInt(num); //숫자 개수
		int[] numbers = new int[N]; //숫자 받을 배열
		int[] cnt = new int[2*4001]; //카운트 배열로 최빈값 구할 것, (인덱스)양수 = 2*수, 음수 = 2*수(절대)+1
		int sum = 0;//산술평균 준비
		for(int i = 0; i<N; i++) {//숫자 받기 & 산술평균 구하기 &카운트
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
			if(numbers[i]>=0) {//카운트
				cnt[numbers[i]*2]++;
			}else {
				cnt[(-numbers[i])*2+1]++;
			}
		}
		ArrayList<Integer> mode = new ArrayList<>();
		int result[] = new int[4]; //결과 넣을 배열, 순서대로 산술평균, 중앙값, 최빈값, 범위
		result[0] = (int) Math.round(1.0*sum/N);//산술평균
		Arrays.sort(numbers);//중앙값, 범위 구하기
		result[1] = numbers[N/2];//중앙값
		
		if(N == 1) {
			result[3] = 0;
		}else {
			result[3] = numbers[N-1] - numbers[0];//범위			
		}
		
		//최대 빈도수 파악, 다른 배열에 복사해서 arrays.sort할 것
		int[] copy = Arrays.copyOf(cnt, cnt.length);
		Arrays.sort(copy);
		int maxHz = copy[cnt.length-1];
		
		for(int i = 0; i<cnt.length; i++) {//최빈값 구하기
			if(cnt[i] == maxHz) {
				if(i%2 == 0) {
					mode.add(i/2);					
				}else {
					mode.add(-i/2);
				}
			}//if-maxHz
		}
		Collections.sort(mode);//오름차순 정렬
		if(mode.size()>1) {
			result[2] = mode.get(1);//2번째 가져오기 			
		}else {
			result[2] = mode.get(0);//한 개일때,
		}
		//출력
		for(int i = 0; i<4; i++) {
			System.out.println(result[i]);
		}
		
	}//main

}