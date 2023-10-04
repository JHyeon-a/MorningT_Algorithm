package BOJ_5014_S1_스타트링크;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();    //F: 건물의 총 층수
        int S = sc.nextInt();    //S: 시작 층
        int G = sc.nextInt();    //G: 목표 층
        int U = sc.nextInt();    //U: 엘레베이터 한번에 위로 올라가는 개수(층)
        int D = sc.nextInt();    //D: 엘레베이터 한 번에 아래로 내려가는 개수(층)

        int[] arr = new int[F + 1];    //arr: 건물 배열
        boolean[] visited = new boolean[F + 1];    //visited: 방문체크 배열

        Queue<Integer> queue = new LinkedList<>();

        arr[S] = 0;        //arr[S] 시작 위치는 0으로 맞춰 놓기
        visited[S] = true;
        queue.add(S);    //queue에 시작 위치 넣기

        //bfs 시작
        while (!queue.isEmpty()) {
            int e = queue.poll();    //queue에서 하나 꺼내 오기

            //만약 목표물 발견하고 방문한 뒤라면 멈추기
            if (e == G && visited[e])
                break;

            //e가 D만큼 아래로 내려가는데 1층보다 위이며 방문하기 전인 곳이라면
            if (e - D >= 1 && visited[e - D] == false) {
                //현재 층까지 도달하는 횟수 +1 넣어주기
                arr[e - D] = arr[e] + 1;
                visited[e - D] = true;    //방문체크
                queue.add(e - D);        //queue에 넣기

            }

            //위로 올라갈 때도 마찬가지
            if (e + U < F + 1 && visited[e + U] == false) {
                arr[e + U] = arr[e] + 1;
                visited[e + U] = true;
                queue.add(e + U);
            }

        }

        //만약 도착 지점이 시작 지점과 다른데 0이라면 도달 불가능
        if (arr[G] == 0 && G != S) {
            System.out.println("use the stairs");
        } else {    //아니라면 도달 횟수 출력
            System.out.println(arr[G]);
        }
    }
}
