package study.intro.section02;

import java.util.Scanner;
  
public class Section0211 {
  public int solution(int n, int[][] arr) {
  	int answer = 0, max = Integer.MIN_VALUE;
    for(int i = 1; i < n + 1; i++) {
      int cnt = 0;
      for(int j = 1; j < n + 1; j++) {
        for(int k = 1; k <= 5; k++) {
          if(arr[i][k] == arr[j][k]) {
            cnt++;
            break;
          }
        }
      }
      if(cnt > max) {
        answer = i;
        max = cnt;
      }
    }
    return answer;
  }
  
  public static void main(String[] args){
    Section0211 s2 = new Section0211();
    Scanner sb = new Scanner(System.in);
    //학생 수
    int n = sb.nextInt();
    int[][] arr = new int[n + 1][6];
    for(int i = 1; i < n + 1; i++) { //학생 번호
      for(int j = 1; j < 6; j++) {//학년 (1~5학년)
        arr[i][j] = sb.nextInt();
      }
    }
    System.out.println(s2.solution(n, arr));
    return ;
  }
}
