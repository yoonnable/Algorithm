package study.baekjoon;

import java.util.Scanner;

// 팩토리얼 0의 개수
public class P1676 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;

    while(n >= 5) {
      count = count + (n / 5);
      n = n / 5;
    }
    System.out.println(count);
  }
}
