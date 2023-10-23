package BOJ_1912_S2_연속합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] s = (br.readLine()).split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		int max = arr[0];
		int sum = arr[0];
		for (int i = 1; i < n; i++) {
			sum += arr[i];
			sum = Math.max(sum, arr[i]);
			max = Math.max(max, sum);
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(max));

		bw.flush();
		bw.close();

	}
}
