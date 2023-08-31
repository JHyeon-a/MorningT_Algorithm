package BOJ_2641_S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine(); // 숫자 개수
		int N = Integer.parseInt(num);
		String std = br.readLine(); // 표본
		int[] std1 = new int[N];
		int[] std2 = new int[N];
		
		for(int i = 0; i<N; i++) {//표본 만들기
			std1[i] = Integer.parseInt(std.split(" ")[i]);
			switch(Integer.parseInt(std.split(" ")[N-1-i])) {
			case 1:
				std2[i] = 3;
				break;
			case 2:
				std2[i] = 4;
				break;
			case 3:
				std2[i] = 1;
				break;
			case 4:
				std2[i] = 2;
				break;
			}//switch
		}//i- 표본배열 생성

		String sampleNum = br.readLine();// 주는 샘플 개수
		int sn = Integer.parseInt(sampleNum);

		ArrayList<String> al = new ArrayList<>();

		loop1: for (int t = 0; t < sn; t++) {
			String sample = br.readLine();// 샘플
			int[] S = new int[N];
			for(int i = 0; i<N; i++) {//int 배열 형성
				S[i] = Integer.parseInt(sample.split(" ")[i]);
			}
					
			int f = -1;
			//스타트지점 찾고, 거기서 부터 10개 돌리기
			//찾으면 al에 넣고, break; 아니면 새로운 find부터 시작/ 하나라도 틀리면 find로
			loop2: for(int i = 0; i<N; i++) {//std1
				if(std1[0] == S[i]) {
					f = i;//f 찾으면
					int cnt = 0;
					for(int j = 1 ; j<N-1 ; j++) {
						for(int k = f+1; k<2*N; k++) {
							if(std1[j] == S[k%N] && std1[j+1] == S[(k+1)%N]) {
								cnt++;
								j++;
							}else {
								continue loop2;//다른 f로 시작
							}
							if(cnt == N-2) {
								al.add(sample);
								cnt = 0;
								continue loop1;//다음 샘플로 가자
							}
						}//k
					}//j
				}
			}//i
			//std2도 똑같이
			loop3: for(int i = 0; i<N; i++) {//std1
				if(std2[0] == S[i]) {
					f = i;//f 찾으면
					int cnt = 0;
					for(int j = 1 ; j<N-1 ; j++) {
						for(int k = f+1; k<2*N; k++) {
							if(std2[j] == S[k%N] && std2[j+1] == S[(k+1)%N]) {
								cnt++;
								j++;
							}else {
								continue loop3;//다른 f로 시작
							}
							if(cnt == N-2) {
								al.add(sample);
								cnt = 0;
								continue loop1;//다음 샘플로 가자
							}
						}//k
					}//j
				}
			}//i
			
			
		} //t
		
		//출력
		System.out.println(al.size());
		for(int i = 0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		

	}// main
}// class