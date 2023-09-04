//버퍼드 사용
package BOJ_4779_칸토어집합_S3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	public static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;

		//입력이 끝날 때까지 계속
		while ((line = br.readLine()) != null) {
			// 이후 로직 전개.
			int N = Integer.parseInt(line);	//N: 행동을 몇 번 할 건지
			int len = (int) Math.pow(3, N);	//len: 3^N (문자열의 총 길이)
			arr = new char[len];			//arr: '-'나 ' '가 들어가는 char형 배열
			for (int i = 0; i < len; i++) {
				arr[i] = '-';
			}//일단 처음엔 arr의 모든 원소를 '-'로 바꾼다.
			
			//3등분 해서 공백으로 만드는 재귀함수 호출(첫 인덱스: 0, 마지막 인덱스+1: len)
			trisection(0, len);

			//출력
			for (int i = 0; i < len; i++) {
				bw.write(arr[i]);
			}
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();

	}// main

	// 3등분 해서 공백으로 만드는 재귀 함수
	//st: 첫 인덱스, ed: 마지막 인덱스+1
	public static void trisection(int st, int ed) {
		// 기저 부분
		if (st == (ed - 1)) {	//만약  st가 ed-1과 같다면(더이상 자를 게 없다면) 리턴
			return;
		}

		// 재귀 부분
		//i는 st에 (ed-st)/3을 더한 것부터 시작해서 ed-((ed-st)/3)-1까지 공백으로 바꿔준다.
		for (int i = st + ((ed - st) / 3); i < ed - ((ed - st) / 3); i++) {
			arr[i] = ' ';
		}
		//양 옆으로 퍼져 나가기 때문에 두 개의 재귀 호출
		//왼쪽 방향 재귀(st= st, ed= st+(ed-st)/3)
		trisection(st, st + (ed - st) / 3);
		//오른쪽 방향 재귀 (st= ed-((ed-st)/3), ed = ed)
		trisection(ed - ((ed - st) / 3), ed);

	}// trisection

}
