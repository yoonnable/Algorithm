package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 골드바흐의 추측
public class P6588 {

  private static boolean[] arr = new boolean[1000001]; // 모든 입력 값에 대해 재활용 할 것

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String number;
    List<Integer> inputs = new ArrayList<>();
    while (!(number = br.readLine()).equals("0")) {
      inputs.add(Integer.parseInt(number));
    }

    // 전부 다 수소 판별해놓기
    getPrime();

    StringBuffer sb = new StringBuffer();

    for(Integer i : inputs) {
      sb.append(getResult(i)).append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  // 출력값 구하기
  public static String getResult(int input) {
    int a = 0 , b = 0;
    for(int i = 3; i <= input/2; i++) {
      if(arr[i]) continue;
      b = input - i;
      if(arr[b]) continue;
      else {
        a = i;
        break;
      }
    }

    if(a == 0) return "Goldbach's conjecture is wrong.";
    return input + " = " + a + " + " + b;
  }

  // 소수 판별 작업
  public static void getPrime() {
    arr[0] = arr[1] = true;
    for(int i = 2; i <= Math.sqrt(arr.length); i++) {
      if(arr[i]) continue;
      for(int j = i * i; j < arr.length; j+=i) {
        arr[j] = true; // 소수 아님..!!
      }
    }
  }

}
