package BOJ_10158_S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input_wh = br.readLine().split(" ");
		int w = Integer.parseInt(input_wh[0]); // 너비
		int h = Integer.parseInt(input_wh[1]); // 높이

		String[] input_ji = br.readLine().split(" ");
		int x = Integer.parseInt(input_ji[0]); // 초기 x좌표
		int y = Integer.parseInt(input_ji[1]); // 초기 y좌표

		int t = Integer.parseInt(br.readLine()); // 시간
		// 항상 대각선으로 움직이기에 x좌표가 움직이는 것과 y좌표가 움직이는 것을 따로 계산
		// 너비의 2배만큼 움직이면 처음 시작과 같은 상태의 x좌표이다.
		// 너비의 2배로 나눈 나머지가 너비보다 크면 되돌아오는 방향이 때문에 너비의 2배에서 빼고
		// 너비의 2배로 나눈 나머지가 너비보다 작으면 가는 방향이라 그냥 나머지값으로 한다.
		x = (t + x) % (2 * w) >= w ? 2 * w - ((t + x) % (2 * w)) : (t + x) % (2 * w);
		y = (t + y) % (2 * h) >= h ? 2 * h - ((t + y) % (2 * h)) : (t + y) % (2 * h);

		StringBuilder sb = new StringBuilder();
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
	}
}
