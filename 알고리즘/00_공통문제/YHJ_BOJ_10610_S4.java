package boj_10610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		/*8:41-8:49-9:15
		 * 30의 배수가 되는 가장 큰 수 
		 * 1. 버퍼로 입력받기 
		 * 2. Char로 나누기(charAt사용) 
		 * 3. 배열에 넣기(숫자로 변환해서) 
		 * 4. 조건 확인 (0이 없으면 안 됨, 모두 더한 수가 3의 배수여야 함)
		 * 5. sort로 가장 큰 수 부터 넣기 
		 * 6. 나열
		 */
		
		//buffered writer 쓰니까 네모박스안의 ?가 떴는데 굳이 버퍼드사용할 필요 없었음. 시간부족 뜰 줄 알았는데ㅠㅠㅠㅠ
		//버퍼드리더&writer
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String number = bf.readLine();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//숫자로 바꿔서 배열에 입력
		int[] arr = new int[number.length()];
		for(int i = 0; i<number.length(); i++) {
			arr[i] = Character.getNumericValue(number.charAt(i));
		}
		//System.out.println(123);
		//arrays.sort 사용해서 올림차순으로 바꾸기(역순으로 출력하기)
		Arrays.sort(arr);
		//조건 확인
		if(arr[0] == 0) {
//			if(Arrays.stream(arr).sum()%3 == 0) {
			int sum = 0;
			for(int i = 0; i<number.length(); i++) {
				sum +=arr[i];
			}//합구하기 for
			if(sum%3 == 0) {
				//조건 다 맞을 시 출력
				for(int i = number.length()-1; i>=0;i--) {
					System.out.print(arr[i]);
					//bw.write(arr[i]);
				}
				bw.flush();
				bw.close();
			}else {
				System.out.println(-1);
			}
		}else{//조건 0
			System.out.println(-1);
		}
	}//main

}//Main
