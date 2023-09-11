package BOJ_18258_S4_큐2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 큐는 선입선출 구조이다. ArrayList를 통해 값을 넣고 빼자
	 * 처음엔 간단하게 add와 remove를 통해 구현했지만 계속 시간초과나서 바꿈
	 * remove 메서드가 시간이 오래걸린다는 것을 알았고 remove를 사용하지 않고
	 * start 변수를 통해 큐의 시작점을 계속 바꿔줌.
	 * 찾아보니 deque라는 것을 사용하면 된다라는 것을 봤지만 아직 안배워서 사용 안함.
	 */

	public static void main(String[] args) throws IOException {
		List<Integer> Queue = new ArrayList<>(); // 큐를 구현할 List
		int start = -1, ed = -1;
		//start : 현재 큐의 가장 앞 요소/ ed: 현재 큐의 가장 마지막 요소의 위치
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine()); // 명령의 수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			switch (st.nextToken()) {
			case "push":
				Queue.add(Integer.parseInt(st.nextToken()));
				ed++;
				break;
			case "pop":
				bw.write((start == ed ? -1 : Queue.get(++start)) + "\n");
				break;
			case "size":
				bw.write((ed - start) + "\n");
				break;
			case "empty":
				bw.write((ed == start ? 1 : 0) + "\n");
				break;
			case "front":
				bw.write((ed == start ? -1 : Queue.get(start + 1)) + "\n");
				break;
			case "back":
				bw.write((ed == start ? -1 : Queue.get(ed)) + "\n");
				break;
			} // switch
		} // for
		bw.flush();
		bw.close();
	} // main
}
