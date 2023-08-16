package boj_28278;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine()); // 명령 개수
		ArrayList<Integer> stack = new ArrayList<>(); // 안 되서 List로 바꿈
		for (int n = 0; n < N; n++) {
			String[] input = bf.readLine().split(" ");
			int orderSort = Integer.parseInt(input[0]);// 명령 종류
			
			switch (orderSort) {
			case 1:// push
				int x = Integer.parseInt(input[1]);
				push(stack, x);
				break;
			case 2: // pop
				pop(stack, bw);
				break;
			case 3: // 스택 정수 개수 출력(정수>0)
				bw.write(stack.size()+"\n");
				break;
			case 4: // 스택 비었으면 1 아니면 0
				bw.write(isEmpty(stack) ? "1\n": "0\n");
				break;
			case 5: // 스택에 정수 존재>맨 위 정수 출력 , 없으면 -1출력
				bw.write(isEmpty(stack)?"-1\n":stack.get(stack.size()-1)+"\n");
				break;
			}
		}
		bf.close();
		bw.flush();
		bw.close();
	}

	public static void push(ArrayList<Integer> stack, int x) {
		stack.add(x);
	}

	public static boolean isEmpty(ArrayList<Integer> stack) {
		return stack.isEmpty();
	}

	public static void pop(ArrayList<Integer> stack, BufferedWriter bw) throws IOException {
		if (!isEmpty(stack)) {
			bw.write(stack.get(stack.size()-1)+"\n");
			stack.remove(stack.size() - 1);
		} else {
			bw.write("-1\n");
		}
	}
}
