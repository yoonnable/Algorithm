package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 2진수 8진수
public class P1373 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    BigInteger bigInteger = new BigInteger(input, 2);
    String result = bigInteger.toString(8);
    System.out.println(result);
  }
}
