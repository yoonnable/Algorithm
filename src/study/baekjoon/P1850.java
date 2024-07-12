package study.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 최대공약수
// 유클리드 알고리즘
public class P1850 {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    long a = sc.nextLong();
    long b = sc.nextLong();
    if(a < b) {
      long temp = a;
      a = b;
      b = temp;
    }

    P1850 m = new P1850();
    m.solution02(a, b);
  }

  /**
   * 반복문
   */
  public void solution01(long a, long b) throws IOException {
    while (b > 0) {
      long temp = b;
      b = a % b;
      a = temp; // 나머지가 0이라면, 그 때 b가 최대공약수!!!
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(a-- > 0) {
      bw.write("1");
    }
    bw.flush();
    bw.close();
  }

  /**
   * 재귀함수
   */
  public void solution02(long a, long b) throws IOException {
    if(b == 0) {
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      while (a-- > 0) {
        bw.write("1");
      }
      bw.flush();
      bw.close();
    } else {
      solution02(b, a % b);
    }
  }
}
