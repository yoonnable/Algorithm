package study.baekjoon;

import java.util.Scanner;

// 팩토리얼 !
// 그 수보다 작거나 같은 모든 양의 정수의 곱
// 0! = 1인 이유는?
// 먼저, 4! = 4 * 3 * 2 * 1
// = 4 * (4 - 1)!
// 그럼, 1! = 1 * (1 - 1)! = 1
// = 1 * 0! = 1
// 0! = 1
public class P10872 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n == 0) {
      System.out.println(1);
    } else {
      for(int i = n - 1; i > 0; i--) {
        n *= i;
      }
      System.out.println(n);
    }
  }
}
