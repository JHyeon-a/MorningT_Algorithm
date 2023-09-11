package BOJ_18258_큐2_S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// Queue를 연결리스트로
		LinkedList<Integer> queue = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine()); // N: 명령의 수

		// 명령의 수만큼 돌기
		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			String cmd = st.nextToken();
			
			//switch-case로 명령어 마다 다르게 하도록
			switch (cmd) {
			case "push":	//push일 때
				//num을 queue에 넣기
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				break;
			case "pop":		//pop일 때
				if (queue.isEmpty()) {	//비어 있다면
					bw.write(-1 +"\n");	//-1
				} else {				//비어 있지 않다면
					bw.write(queue.remove() + "\n");	//반환값
				}
				break;
			case "size":	//size일 때
				bw.write(queue.size() + "\n");		//queue의 size 출력
				break;
			case "empty":	//empty일 때
				if (queue.isEmpty()) {		//비어 있다면
					bw.write(1 + "\n");		//1
				} else {					//비어 있지 않다면
					bw.write(0 + "\n");		//0
				}
				break;
			case "front":	//front일 때
				if (queue.isEmpty()) {		//비어 있다면
					bw.write(-1 + "\n");	//-1
				} else {					//비어 있지 않다면
					bw.write(queue.get(0) + "\n");	//맨 앞의 원소 출력
				}
				break;
			case "back":	//back일 
				if (queue.isEmpty()) {		//비어 있다면
					bw.write(-1 + "\n");	//-1
				} else {					//비어 있지 않다면
					bw.write(queue.get(queue.size()-1)+ "\n");	//맨 마지막 원소 출력
				}
				break;
			}
			

		}
		bw.flush();
		bw.close();
	}
}
