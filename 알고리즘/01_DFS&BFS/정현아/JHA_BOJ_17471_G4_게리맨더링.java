package BOJ_17471_G4_게리맨더링;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.Select;

public class Main {
	static int N;
	static int[] people;
	static List<Integer>[] adjList;
	static int min;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();			//N: 구역 개수
		people = new int[N+1];		//people: 각 구역의 인구수 배열
		for(int i=1; i<=N; i++) {
			people[i] = sc.nextInt();
		}//인구수 입력 끝
		
		adjList = new ArrayList[N+1];	//adjList: 연결되어 있는 리스트...
		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<>();
			
		}//인접리스트 초기화
		
		
		for(int i=1; i<=N; i++) {
			int M = sc.nextInt();
			
			for(int m = 0; m<M; m++) {
				int end = sc.nextInt();
				
				adjList[i].add(end);
			}
		}//인접리스트에 값 넣기 끝
		
		
		min = Integer.MAX_VALUE;	//min: 인구수 차이 최소
		
		visited = new boolean[N+1];			//visited: 방문체크 배열
		
		partBfs(1);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
			
		}
		
		
		
		
	}//main
	
	static void partBfs(int idx) {
		if(idx == N+1) {
			List<Integer> selectList =new ArrayList<>();	//selectList: 선택된 애들 담은 리스트
			List<Integer> unselectList =new ArrayList<>();	//unselectList: 선택 안 된 애들 담은 리스트
			
			
			int selectSum = 0;
			int unselectSum = 0;
			for(int i=1; i<=N; i++) {
				//방문한 곳이면
				if(visited[i]) {
					//선택
					selectList.add(i);
					selectSum += people[i];
				}else {
					//방문 X면 안 선택
					unselectList.add(i);
					unselectSum += people[i];
				}
			}
			
			//전체 선택하거나 전체 선택 안 됨이면 돌려 보내기
			if(selectList.size() == N || unselectList.size() == N) {
				Arrays.fill(visited, false);
				return;
			}
			
			//tmpList: adjList 복사 리스트 만들기
			List<Integer>[] tmpList = new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				tmpList[i] = new ArrayList<>();
				
			}
		
			for(int i=1; i<=N; i++) {
				int M = adjList[i].size();
				
				for(int m = 0; m<M; m++) {
					int end = adjList[i].get(m);
					
					tmpList[i].add(end);
				}
			}
			
			
			//선택된 리스트의 사이즈만큼 돌면서
			for(int i=0; i<selectList.size(); i++) {
				//선택된 리스트의 한 원소의 간선을 삭제 할 거야.
				for(int j=0; j<tmpList[selectList.get(i)].size(); j++) {
					if(selectList.contains(tmpList[selectList.get(i)].get(j))) {
						continue;
					}
					
					int tmp = tmpList[selectList.get(i)].remove(j);
					
					for(int k=0; k<tmpList[tmp].size(); k++) {
						if(tmpList[tmp].get(k) == selectList.get(i)) {
							tmpList[tmp].remove(k);
						}
					}
					
				}

			}
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(unselectList.get(0));
			boolean[] check = new boolean[N+1];
			boolean yes = true;	//yes: 끝까지 나오면 true
			
			while(!queue.isEmpty()) {
				int e = queue.poll();
				if(check[e])
					continue;
				
				check[e] = true;
				for(int i=0; i<tmpList[e].size(); i++) {
					if(!check[tmpList[e].get(i)] && unselectList.contains(tmpList[e].get(i)))
						queue.add(tmpList[e].get(i));
					
				}
			}
			
			queue.add(selectList.get(0));
			
			while(!queue.isEmpty()) {
				int e = queue.poll();
				if(check[e])
					continue;
				
				check[e] = true;
				for(int i=0; i<tmpList[e].size(); i++) {
					if(!check[tmpList[e].get(i)] && selectList.contains(tmpList[e].get(i)))
						queue.add(tmpList[e].get(i));
					
				}
			}
			
			//만약 선택 안 된 리스트가... 방문체크가 안 되어 있다면 불가능
			for(int i=1; i<=N; i++) {
				if(check[i] == false) {
					yes = false;
				}
			}
			
			if(yes) {
				min = Math.min(min, Math.abs(selectSum - unselectSum));
			}
			
//			//디버깅
//			System.out.print("선택 배열: ");
//			for(int i=0; i<selectList.size(); i++) {
//				System.out.print(selectList.get(i) + " ");
//			}
//			System.out.println();
//			System.out.print("비선택 배열: ");
//			for(int i=0; i<unselectList.size(); i++) {
//				System.out.print(unselectList.get(i) + " ");
//			}
//			
//			System.out.println();
//			System.out.println(Math.abs(selectSum - unselectSum));
//			System.out.println();
//			//
			
//			Arrays.fill(visited, false);	//visited: 되돌리기
			return;
		}
		
		visited[idx] = false;
		partBfs(idx+1);
		
		visited[idx] = true;
		partBfs(idx+1);
		
		
	}

}
