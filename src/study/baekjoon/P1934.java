package study.baekjoon;

import java.util.Scanner;

// 최소공배수
public class P1934 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < T; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int max, min;
      if(a < b) {
        max = b;
        min = a;
      } else {
        max = a;
        min = b;
      }
      int temp = max;
      while(true) {
        if(temp % min == 0) {
          sb.append(temp).append("\n");
          break;
        }
        temp += max;
      }
    }
    System.out.println(sb.toString());
  }

}
