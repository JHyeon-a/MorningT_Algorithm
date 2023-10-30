//풀지 못 해서...
package BOJ_9663_G4_NQueen;

import java.util.Scanner;

public class Main2 {
    static int N;
    static int[] col; // col[i]: i번째 행에 배치한 퀸의 열 번호
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        cnt = 0;
        
        dfs(0);
        
        System.out.println(cnt);
    }

    //dfs (row: 행 위치)
    public static void dfs(int row) {
    	//N개면 찾은 거니까 cnt++ 후 리턴
        if (row == N) {
            cnt++;
            return;
        }
        
        
        for (int c = 0; c < N; c++) {
        	//row행, c열에서 다른 퀸과 충돌하는지 확인
            if (isSafe(row, c)) {
            	//충돌하지 않는다면 col[row]에 c 저장
                col[row] = c;
                //다음행 넘어가기
                dfs(row + 1);
            }
        }
        //방문체크 배열 쓰지 않아도 되는 이유
        //한 행과 한 열에 무조건 하나의 퀸만 가능.
        //일차원 배열로 만들어서(col[]) 계속 한 행에서 열을 갱신하기 때문에 배열을 되돌릴 필요 없음
    }

    //퀸과 충돌하지 않는지 확인하는 메소드
    public static boolean isSafe(int r, int c) {
    	
        for (int i = 0; i < r; i++) {
            // 같은 열에 퀸이 있는지 확인
            if (col[i] == c) {
                return false;
            }

            // 대각선 방향에 퀸이 있는지 확인
            //r, c: 현재 퀸 위치
            //i, col[i]: 이전 퀸 위치
            if (Math.abs(r - i) == Math.abs(c - col[i])) {
                return false;
            }
        }
        
        //같은 열에 없고 대각선에도 없다면 충돌하지 않는다는 의미로 true 반환
        return true;
    }
}
