package study.baekjoon.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DFS와 BFS
public class P1260 {

  private static int[][] arr; // 정점들의 연결 상태 담을 배열
  private static boolean[] checked; // 탐색 완료 정점 체크
  private static int N, M, V;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt(); // 정점의 개수
    M = sc.nextInt(); // 간선의 개수
    V = sc.nextInt(); // 탐색을 시작할 정점

    // 1. DFS, BFS 탐색 결과 출력
    // 2. 후보 정점이 여러개일 경우, 작은 번호부터 탐색
    // 3. 정점 번호는 1부터 N까지


    arr = new int[N + 1][N + 1];
    checked = new boolean[N + 1];

    // 그래프를 배열로 표현하기 위한 셋팅
    for(int i = 0; i < M; i++) {
      int left = sc.nextInt();
      int right = sc.nextInt();

      arr[left][right] = arr[right][left] = 1; // left와 right의 정점은 서로 연결되어 있다.
    }


    DFS(V);
    System.out.println();
    Arrays.fill(checked, false); // 탐색 체크 초기화
    BFS(V);


  }

  public static void DFS(int start) {
    checked[start] = true; // start는 탐색을 했다!

    System.out.print(start + " "); // 탐색 순서 출력(결과)

    for(int i = 1; i <= N; i++) {
      if(arr[start][i] == 1 && !checked[i]) { // stare와 인접해 있고, 탐색 전이면
        DFS(i); // 탐색하라.
      }
    }
  }

  public static void BFS(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    checked[start] = true;

    while(!queue.isEmpty()) {
      start = queue.poll(); // 선입선출인 queue는 들어간 순서대로 탐색한 것이므로
      System.out.print(start + " "); // 나온 순서대로 출력해주면 됨

      for(int i = 1; i < arr.length; i++) {
        if(arr[start][i] == 1 && !checked[i]) { // 현재 탐색중인 정점에서 인접해있는 정점 모조리 queue에 넣기
          queue.add(i);
          checked[i] = true;
        }
      }
    }
  }
}
