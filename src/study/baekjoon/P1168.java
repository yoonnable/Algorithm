package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 요세푸스 문제 2
// 시간 초과 미해결
public class P1168 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken()) - 1;

    List<Integer> list = new ArrayList<>();

    for(int i = 1; i <= n; i++) {
      list.add(i);
    }

    int index = 0;
    StringBuffer sb = new StringBuffer();
    sb.append("<");
    for(int i = 0; i < n - 1; i++) {
      index = index + k;

      if(index >= list.size()) {
        index = index % list.size();
      }

      sb.append(list.remove(index) + ", ");
    }

    sb.append(list.remove(0)).append(">");

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
