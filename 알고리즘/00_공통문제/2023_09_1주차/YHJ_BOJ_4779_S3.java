package BOJ_4779_S3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

//그냥 계산해서 -넣으면 안 돼?
//이렇게 재귀하세요 하면 하기 싫음, 칸토어 하세요 하면 싫은데?
/*
 * N번 만큼 칸토어 해야됨(처음에 넣어줬으니까)
 * 칸토어 한 번 하면 선 개수 *2됨
 * 한 번 하면 0~3^n-1 -> 0~3^(n-1) & 3^(n-1)*2+1~3^n
 * 처음과 끝 고정
 * 숫자 넣으면 될 듯
 */

//시간초과-> buffered로 바꿈

public class Main {
	public static int N;
	public static ArrayList<Integer> idx;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(sc.hasNextLine()) {//다음 있으면
			String num = sc.nextLine();
			N = Integer.parseInt(num);
			char[] line = new char[(int)Math.pow(3, N)];//배열 형성
			idx = new ArrayList<>();
			idx.add(0);
			idx.add(line.length-1);
			
			for(int i =0; i<N; i++) {//N번 만큼 칸토어
				twice();
			}
			
			int index = 0;
			for(int i = 0; i<line.length; i++) {
				if(i == idx.get(index)) {
					bw.write("-");
//					System.out.print("-");
					index += 2;
				}else {
					bw.write(" ");
//					System.out.print(" ");
				}
			}
//			System.out.println();
			bw.write("\n");
			bw.flush();

		}//while
		bw.close();
	}//main
	
	public static void twice() {//시작과 끝 저장
		int end = idx.size();
		for(int i =0; i<end; i++) {//왜 안 멈추지?
			if(i%2 == 0) {//첫 번째 > 스타트, idx.get(0) 시작점, idx.get(1) 끝점
				idx.add(idx.get(0));
				idx.add((idx.get(1)-idx.get(0)+1)/3+idx.get(0)-1); //시작에서 시작한 새로운 끝
			}else {//나중
				idx.add(idx.get(1) - (idx.get(1)-idx.get(0)+1)/3 +1); //새로운 시작점
				idx.add(idx.get(1));
				idx.remove(0); // 새로운 숫자 뒤에 넣고, 땡겨주기
				idx.remove(0);
			}
		}//i
	}//twice
	
}