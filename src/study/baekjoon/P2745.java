package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 진법 변환
public class P2745 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    br.close();

    StringTokenizer st = new StringTokenizer(input);
    String n = st.nextToken();
    String B = st.nextToken();

    int temp = 1, result = 0;

    for(int i = n.length() - 1; i >= 0; i--) {
      char c = n.charAt(i);
      if(c >= 'A') {
        result += (c - 'A' + 10) * temp;
      } else {
        result += (c - '0') * temp;
      }
      temp *= Integer.parseInt(B);
    }
    System.out.println(result);
  }
}
