import java.util.Scanner;
import java.util.Stack;
/*알고리즘 설명
 * 1. 스택에 넣은 자료는 LIFO 구조에 의해 거꾸로 나옴. 이러한 규칙은 문자열 뒤집기에 좋음.
 * 2. 하지만 태그 안에 있거나 공백인 경우는 문자열이 뒤집어지지 않고 그대로 출력
 * 3. 그래서 태그나 공백은 그대로 정답 문자열에 추가.
 * 4. 태그의 시작점, 공백을 만나면 기존에 스택에 저장했던 정보를 모두 빼며 거꾸로 저장.
 * 5. 문자열의 끝에서 스택 모두 빼기.
 * */
public class KTW_BOJ_17413_S3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); //문자열 입력받기
		String answer = ""; //정답 저장할 문자열 생성
		Stack<Character> stack = new Stack<>(); //스택 생성
		
		boolean tag = false; //태그 안에 있는지 확인
		for(int i = 0; i < s.length(); i++) { //문자열 탐색 시작
			if(s.charAt(i) == '<') { //태그 시작할 때,
				int size = stack.size(); //현재 스택에 있던거 모두 빼기
				for(int j = 0; j < size; j++) {
					answer += stack.pop();
				}
				tag = true; //태그 안에 있다고 전환
			} else if(s.charAt(i) == '>') { //태그 끝
				answer += s.charAt(i); //tag가 false가 되며 이쪽 값이 뒤의 logic으로 저장 안되므로 미리 추가
				tag = false; //tag false 전환
			}
			
			if(tag == true) { //태그 안이면
				answer += s.charAt(i); //현재 문자 그냥 추가
			} else if(s.charAt(i) == ' ') { //공백만나면
				int size = stack.size(); //스택에 있던 거 다 빼기
				for(int j = 0; j < size; j++) {
					answer += stack.pop();
				}
				answer += ' '; //공백 추가
			} else if(s.charAt(i) != '>') { //문자가 >라 누락된거 제외 공백도, 태그안도 아니면
				stack.push(s.charAt(i)); //스택에 넣기
			}
			
			if(stack.size() >= 1 && i == (s.length()-1)) { //문자열 끝에서 스택 빼기
				int size = stack.size();
				for(int j = 0; j < size; j++) {
					answer += stack.pop();
				}
			}
			
		}
		
		System.out.println(answer); //결과 출력
		

	}
}
