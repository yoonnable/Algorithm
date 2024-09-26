package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 구하기
public class P1929 {

    public static boolean[] prime;
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      prime = new boolean[N + 1];
      getPrime();

      StringBuilder sb = new StringBuilder();

      for(int i = M; i <= N; i++) {
        
        // false인 것만 출력하기 = index가 소수인 것만 출력하기
        if(!prime[i]) {
          sb.append(i).append('\n');
        }
      }
      System.out.println(sb.toString());
    }

    public static void getPrime() {
      prime[0] = prime[1] = true; // index인 0,1은 소수 아니니까 true로 변경


      // Math.sqrt(a) : a의 제곱근을 double형으로 리턴한다. ex) Math.sqrt(16) = 4.0
      for(int i = 2; i <= Math.sqrt(prime.length); i++) { // = Math.sqrt(17) = 4.12310562562

        if(prime[i]) continue; // prime[i]가 true면, continue = i가 소수가 아닌게 확정 되었으면, continue (왜냐하면, 아래 코드는 i의 배수를 모두 소수가 아니라는 작업을 하는 코드라 i가 소수가 아닌 게 표시가 되었다면? 그 수의 배수도 소수가 아니라고 표시 되어 있을 것 이므로!)

        // i의 배수 모두 소수가 아닌 것으로 확정 시키기
        for(int j = i * i; j < prime.length; j += i) {
          prime[j] = true;
        }
      }
    }
}
