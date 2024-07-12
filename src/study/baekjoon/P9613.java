package study.baekjoon;

import java.util.Scanner;

// GCD 합
public class P9613 {

  public static void main(String[] args) {
    P9613 m = new P9613();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    StringBuffer sb = new StringBuffer();

    while (t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      long answer = 0;
      for (int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
          int max = Math.max(arr[i], arr[j]);
          int min = Math.min(arr[i], arr[j]);
          int gcd = m.solution(max, min);
          answer += gcd;
        }
      }
      sb.append(answer).append("\n");
    }

    System.out.println(sb.toString());
  }

  public int solution(int a, int b) {
    if(b == 0) return a;
    else return solution(b, a % b);
  }
}
