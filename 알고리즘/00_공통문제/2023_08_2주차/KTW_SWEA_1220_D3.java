import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	/*알고리즘 설명
	 * 이 문제의 핵심은 세로로 한줄 한줄 탐색하면서 N이 나온 후 S가 나오는 횟수를 세는 것.
	 * 그래서 배열을 세로로 순회하며 N(1)이 나오면 N_stat을 1로 바꾸어 주고,
	 * 만약 순회 도중 S(2)가 나왔는데 이전에 N을 만난 상태(N_stat==1)면 cnt(갯수)값을 1 더하고 N_stat을 다시 0으로 바꾸어
	 * 한 줄에 여러 경합 상태가 나오는 경우를 고려했다.
	 * */
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0; //정답(경합 갯수)
            int size = sc.nextInt(); //size 입력(항상 100이긴 함)
            int[][] map = new int[size][size]; //공간 할당
            for(int i = 0; i < size; i++){ //공간 정보 입력받기
                for(int j = 0; j < size; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            
            int N_stat = 0; //N을 이전에 만났는가?
            //세로로 순회니 j를 기준으로 i 값 변화
            for(int j = 0; j < size; j++){
                N_stat = 0; //다음 줄로 넘어갈 때 초기화
            	for(int i = 0; i < size; i++){
                	if(map[i][j] == 1){ //N 만나면
                    	N_stat = 1; //N_stat=1로 상태 변화
                    } else if((map[i][j] == 2) && N_stat == 1){ //이전에 N만난 상태에서 S 만나면
                    	N_stat = 0; //N_stat 초기화(한 줄에 여러 경합 고려)
                        cnt++; //횟수 증가
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + cnt); //결과 출력

		}
	}
}