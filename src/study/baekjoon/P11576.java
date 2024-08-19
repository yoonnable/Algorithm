package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Base Conversion
public class P11576 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line1 = br.readLine();
    String line2 = br.readLine();
    String line3 = br.readLine();

    // input값 셋팅
    StringTokenizer st = new StringTokenizer(line1);
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    String[] numberA = line3.split(" ");

    // A진수 -> 10진수
    int digit = 0; // 자릿수 = A를 곱할 횟수
    int decimal = 0; // 10진수 담을 변수
    for(int i = numberA.length - 1; i >= 0; i--) {
      int temp = Integer.parseInt(numberA[i]);
      for(int j = digit; j > 0; j--) {
        temp *= A;
      }
      decimal += temp;
      digit++;
    }

    // 10진수 -> B진수
    Stack<Integer> stack = new Stack<>();
    while (decimal > 0) {
      stack.push(decimal % B);
      decimal /= B;
    }

    // 출력
    while(!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  }
}
