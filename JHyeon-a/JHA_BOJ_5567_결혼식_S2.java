//이거 성공!!!
package BOJ_5567_결혼식_S2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
	public static void main(String[] args) {
		List<Integer> relationFormer = new ArrayList<>(); // relationFormer: 첫 번째 관계
		List<Integer> relationLatter = new ArrayList<>(); // relationLatter: 첫 번째 관계의 친구
		List<Integer> relationCheckTmp = new ArrayList<>(); // relationChecktmp: 상근이의 친구만 저장한 리스트
		List<Integer> result = new ArrayList<>(); // result: 상근의 결혼식에 초대할 사람들

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N: 상근이의 동기 수
		int M = sc.nextInt(); // M: 관계 조사 리스트 개수

		for (int m = 0; m < M; m++) {
			int former = sc.nextInt();	//former: 왼쪽 사람
			relationFormer.add(former);	//relationFormer에 former 추가
			int latter = sc.nextInt();	//latter: 오른쪽 사람
			relationLatter.add(latter);	//relationLatter에 latter 추가

			if (former == 1) {		//former가 1이면(상근이면)
				relationCheckTmp.add(latter);	//상근이의 친구만 저장한 리스트(relationCheckTmp)에 latter 추가
				result.add(latter);				//상근이의 결혼식에 초대할 사람들 리스트(result)에 latter 추가
			} // 만약 상근이 친구면 check 리스트에 넣기
			if (latter == 1) {
				relationCheckTmp.add(former);
				result.add(former);
			} // 만약 상근이 친구면 check 리스트에 넣기
		} // 친구 리스트 받기

		Set<Integer> set = new HashSet<Integer>(relationCheckTmp);
		List<Integer> relationCheck = new ArrayList<Integer>(set); // 중복 제거를 위해 set으로 바꿨다가 다시 리스트로 바꾸기

		int sizeC = relationCheck.size(); //sizeC: relationCheck(상근이 친구만 저장한 리스트)의 크기

		// 관계 조사 리스트 개수만큼(M) 돌기
		for (int m = 0; m < M; m++) {
			// former나 latter가 1이면 이미 relationCheck에 저장된 친구들이니 다음으로 넘어가기
			if (relationFormer.get(m) == 1) {
				continue;
			}
			if (relationLatter.get(m) == 1) {
				continue;
			}
			
			//former 기준으로 찾기
			//relationCheck를 돌거야
			loop: for (int c = 0; c < sizeC; c++) {
				//만약 relationFormer의 m인덱스 원소(현재 고정된 애)가 relationCheck의 c 인덱스 원소(지금 돌리는 애)와 같다면
				// => (상근이-상근이 친구)가 아닌 상근이 친구를 찾았다면
				if (relationFormer.get(m).equals(relationCheck.get(c))) {
					//상근이의 친구의 친구(relationLatter의 m 인덱스 원소)가 이미 상근이의 친구 리스트(relationCheck)에 올라와 있는지 확인
					for (int c2 = 0; c2 < sizeC; c2++) {
						//만약 발견 되면 loop 반복문을 빠져 나간다.
						if (relationLatter.get(m).equals(relationCheck.get(c2))) {
							break loop;
						}
					}
					//상근이 친구 리스트에 없는 애라면 상근이의 결혼식에 초대할 사람이니 result에 넣기
					result.add(relationLatter.get(m));
				}
			}
			
			//latter 기준으로 찾기
			//아래 코드는 위와 같음 former와 반대로 적으면.
			loop2: for (int c = 0; c < sizeC; c++) {
			
				if (relationLatter.get(m).equals(relationCheck.get(c))) {
					for (int c2 = 0; c2 < sizeC; c2++) {
						if (relationFormer.get(m).equals(relationCheck.get(c2))) {
							break loop2;
						}
					}
					result.add(relationFormer.get(m));
				}

			}
		}

		Set<Integer> set2 = new HashSet<Integer>(result);
		List<Integer> result2 = new ArrayList<Integer>(set2); // 중복 제거를 위해 set으로 바꿨다가 다시 리스트로 바꾸기

		System.out.println(result2.size());	//상근이의 결혼식에 초대할 사람들 출력

	}

}
