package Study;
import java.util.*;
import java.io.*;

public class LDH_BJ_9663_N퀸 {
	static int map[];
	static int cnt =0;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N];
		dfs(0);
		System.out.println(cnt);
		
	}
	public static void dfs(int index) {
		if(index==N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			map[index]=i;
			if(Possible(index)) {
				dfs(index+1);
			}
		}
	}
		
		
	
	public static boolean Possible(int col) {
	
		for(int i=0; i<col; i++) {
			if(map[i]==map[col]) {
				return false;
			}
			else if(Math.abs(map[i]-map[col])==Math.abs(i-col)) {
				return false;
			}
		}
		return true;
		
	}
}