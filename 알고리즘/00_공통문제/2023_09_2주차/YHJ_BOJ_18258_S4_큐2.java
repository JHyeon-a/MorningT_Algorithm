package BOJ_218258_큐2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> Q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//명령 개수
		int back = -1;
		
		for(int i = 0; i<N; i++) {
			String tmpOrder = br.readLine();
			switch(tmpOrder.split(" ")[0]) {
			case "push":
				back = Integer.parseInt(tmpOrder.split(" ")[1]);
				Q.add(back);
				break;
			case "pop":
				if(Q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(Q.poll()+"\n");
				break;
			case "size":	
					bw.write(Q.size()+"\n");
				break;
			case "empty":
				if(Q.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "front":
				if(Q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(Q.peek()+"\n");
				break;
			case "back":
				if(Q.isEmpty())
					bw.write("-1\n");
				else
					bw.write(back+"\n");
				break;
			}//switch
		}//i
		bw.flush();
		bw.close();
	}//main

}