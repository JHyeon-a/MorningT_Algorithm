package BOJ_2580_G4_스도쿠;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] sudoku = new int[9][9]; // 9x9 격자 스도쿠판

		Queue<Node> queue = new LinkedList<>(); // 숫자 맞춰 넣어야 하는 queue 생성
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());

				// 0인 애를 만나면 queue에 넣기
				if (sudoku[i][j] == 0) {
					queue.add(new Node(i, j));
				}
			}
		} // 스도쿠 현황

		while (true) {
			if (queue.isEmpty())
				break;

			// queue에서 하나 꺼내와.
			Node e = queue.poll();

			int[] check = new int[10];	//check: 해당 숫자가 가로, 세로, 3x3에서 몇 번 나왔는지 세는 배열

			// 가로 세로 수 카운트
			for (int j = 0; j < 9; j++) {
				check[sudoku[e.r][j]]++;	//가로
				check[sudoku[j][e.c]]++;	//세로
			}

			// 3x3
			for (int i = (e.r / 3) * 3; i <= (e.r / 3) * 3 + 2; i++) {
				for (int j = (e.c / 3) * 3; j <= (e.c / 3) * 3 + 2; j++) {
					check[sudoku[i][j]]++;
				}
			}
			
			int zero = 0;		//zero: check 배열에서 값이 0인 애의 수
			int index = 0;		//만약 zero가 하나 밖에 없다면 해당 i의 값을 현재 구하는 칸에 넣어줘야 하기 때문에 사용하는 임시 변수
			for (int i = 1; i < 10; i++) {
				if (check[i] == 0) {
					zero++;
					index = i;
				}
			}

			//만약 0이 하나라면 스도쿠 값 넣고
			if (zero == 1) {
				sudoku[e.r][e.c] = index;
			//아니라면 큐에 다시 넣는다
			} else {
				queue.add(new Node(e.r, e.c));
			}

		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bw.write(sudoku[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.close();

	}// main

}
