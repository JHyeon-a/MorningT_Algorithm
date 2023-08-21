package boj_2865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		double sum = 0;
		double[] score = new double[N + 1];// 배열 만들기
		for (int i = 0; i < M; i++) {// 점수 배열에 점수 넣기
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				int idx = Integer.parseInt(st.nextToken());
				double grade = Double.parseDouble(st.nextToken());
				if(score[idx]< grade) {
					score[idx] =  grade;
				}
			}
		} // M번 반복
		Arrays.sort(score);
		for (int j = N; j > N - K; j--) {
			sum += score[j];
		}
		System.out.printf("%.1f\n", sum);
	}
}