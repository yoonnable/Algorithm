package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 진법변환2
public class P11005 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    br.close();

    StringTokenizer st = new StringTokenizer(input);
    Long n = Long.parseLong(st.nextToken());
    Integer B = Integer.parseInt(st.nextToken());

    Stack<Long> stack = new Stack<>();
    while (n >= B) {
      stack.add(n%B);
      n = n/B;
    }
    if(n != 0) stack.add(n);

    StringBuffer sb = new StringBuffer();
    while(!stack.empty()) {
      long temp = stack.pop();
      if(temp > 9) {
        char source = (char) ('A' + (temp - 10));
        sb.append(source);
      } else {
        sb.append(temp);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}
