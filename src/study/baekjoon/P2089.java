package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// -2진수
public class P2089 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    if (n == 0) {
      System.out.println(0);
    }

    Stack<Integer> stack = new Stack<>();

    while (n != 0) {
      int temp = n % -2;
      n /= -2;
      if(temp < 0) {
        temp += 2;
        n += 1;
      }
      stack.push(temp);
    }

    while(!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }
}
