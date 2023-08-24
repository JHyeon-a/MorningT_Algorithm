import java.util.Scanner;

public class KTW_BOJ_1244_S4 {
	/*알고리즘 설명
	 * 일단 배열로 스위치 상태 저장.
	 * 성별과 번호 입력 받기.
	 * 처음 위치를 입력받은값 - 1로 설정(배열은 스위치 번호와 달리 0부터 시작)
	 * 남성의 경우 원본 입력 값을 num으로 받아 index값 idx에 num-1 저장후
	 * 스위치 상태 바꾼 후 num을 더해주며 스위치 갯수 넘어갈 때까지 상태 변화
	 * 여성의 경우 스위치의 좌우를  left, right로 한 후, num-1로 둘 다 초기화 후 상태 변화
	 * 그 후 left값은 1 더하고 right는 1 빼서 탐색 범위 넘어가지 않는 상황에서 둘이 같으면 바꿔주고 달라지면 좌우대칭 깨졌으니 break
	 * */
	public static void main(String[] args) {
		//scanner 함수
		Scanner sc = new Scanner(System.in);
		
		int sw_num = sc.nextInt(); //스위치 개수 입력 받아 배열 공간 할당
		int[] sw = new int[sw_num];
		
		//배열 상태 저장.
		for(int i = 0;  i < sw_num; i++) {
			sw[i] = sc.nextInt();
		}
		
		int st_num = sc.nextInt(); //학생 수 입력
		int stat = 0; //성별
		int num = 0; //번호
		int idx = -1; //남학생 탐색 시 index
		int left = -1; //여학생 탐색 시 좌측 index
		int right = -1; //여학생 탐색 시 우측 index
		for(int i = 0; i < st_num; i++) { //학생 수만큼 입력 반복
			//입력 받기
			stat = sc.nextInt(); 
			num = sc.nextInt();
			if(stat == 1) { //남학생의 경우
				idx = num-1; //index 초기화(시작이 1이 아닌 0임을 고려)
				while(idx < sw_num) { //스위치 개수 내에서
					if(sw[idx] == 0) { //상태전환
						sw[idx] = 1;
					} else {
						sw[idx] = 0;
					}
					idx += num; // 다음 배수
				}
			} else if(stat == 2){ //여학생의 경우
				//index 초기화(시작이 1이 아닌 0임을 고려, 우선 같은 위치에서)
				left = num-1;
				right = num-1;
				while((left >= 0) && (right < sw_num)) { //스위치 범위 내에서
					if(sw[left] == sw[right]) { //상태 변환(좌우대칭이니 어차피 같은 값, 둘 동시 변환)
						if(sw[left] == 0) {
							sw[left] = 1;
							sw[right] = 1;
						} else {
							sw[left] = 0;
							sw[right] = 0;
						}
						//다음 인덱스로 좌로 한칸, 우로 한칸
						left--;
						right++;
						
					} else { //좌우대칭 깨짐
						break;//break
					}
				}
			}
		}
		//출력
		//줄 당 20개씩 출력이니 20번마다 줄 바꿈
		for(int i = 0; i < sw_num; i++) {
			System.out.print(sw[i] + " ");
			if(i % 20 == 19) {
				System.out.println("");
			}
		}
		
	}
}
