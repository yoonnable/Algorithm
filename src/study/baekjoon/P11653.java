package study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// 소인수분해
public class P11653 {

  private static boolean[] primes;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 소수 판별 작업
    getPrime(n);

    // 입력값의 소인수분해 구하기
    StringBuffer sb = new StringBuffer();
    for (int i = 2; i <= n; i++) {
      while(!primes[i] && n % i == 0) { // i가 소수이고 && n이 i로 나누어 떨어질 때
        sb.append(i).append("\n");
        n/= i;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  private static void getPrime(int n) {
    primes = new boolean[n + 1];
    primes[0] = primes[1] = true;

    for(int i = 2; i < Math.sqrt(n); i++) {
      if(primes[i]) continue;

      for(int j = i * i; j <= n; j = j + i) {
        primes[j] = true;
      }
    }
  }


}
