package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 8진수, 2진수
public class P1212 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String A = br.readLine();
    BigInteger bigInteger = new BigInteger(A, 8);
    String result = bigInteger.toString(2);
    System.out.println(result);
  }
}
