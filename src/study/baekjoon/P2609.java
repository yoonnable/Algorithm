package study.baekjoon;

import java.util.Scanner;

// 최대공약수와 최소공배수
public class P2609 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int answer1 = 0;
    int answer2 = 0;

    int max = Math.max(a, b);
    int min = Math.min(a, b);
    int i = min;
    while(true) {
      if(min%i == 0 && max % i == 0) {
        answer1 = i;
        break;
      }
      i--;
    }

    int j = max;
    while (true) {
      if(j%max == 0 && j%min == 0) {
        answer2 = j;
        break;
      }
      j += max;
    }

    System.out.println(answer1);
    System.out.println(answer2);
  }

}
