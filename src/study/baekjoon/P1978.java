package study.baekjoon;

import java.util.Scanner;

// 소수 찾기
public class P1978 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int answer = 0;
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
    for(int i = 0; i < n; i++) {
      if(arr[i] == 1) continue; // 자연수에서 1은 소수가 아니니까 일단 pass
      
      if(arr[i] == 2) answer++; // 짝수 걸러내기 전에 2는 소수니까 체크해주기
      if(arr[i]%2 == 0) continue; // 짝수 pass

      // 홀수 중에서 시작!
      int sub = arr[i]/2; // 3의 배수부터 시작되니까 약수는 무조건 절반 이하에만 존재함
      if(sub%2 == 0) sub++;
      while(sub > 1) {
        if(arr[i]%sub == 0) break;
        sub -= 2;
      }

      if(sub <= 1) answer++;

    }

    System.out.println(answer);
  }
}
