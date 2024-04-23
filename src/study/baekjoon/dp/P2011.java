package study.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 암호코드
public class P2011 {
    public static void main(String[] args) throws IOException {
        P2011 m = new P2011();
        System.out.println(m.solution2());
//        System.out.println(m.solution()); // 런타임에러
    }
    public int solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        // 맨 앞자리가 0이면 무효
        if(ch[0] == '0') return 0;

        // ch는 index 0부터 조회
        // dp는 dp[i-2]때문에 index 1부터 계산
        // ch[0]의 가짓수는 dp[1]에 저장됨.
        int[] dp = new int[ch.length+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= ch.length; i++) {
            // 한 자리수로 볼 때 가능한 경우의 수 (이 전 경우의 수와 동일 => 숫자 하나만 추가한 것이므로)
            if(ch[i-1] != '0') {
                dp[i] = dp[i-1];
            }
//            System.out.println(i + " 한 자리 수만 가능한 겅우의 수 : " + dp[i]);

            // 두 자릿수로 볼 때 가능한 경우의 수 (이 전전 경우의 수와 동일 => 이 전 숫자 + 현재 숫자가 두 자릿수로 빠지는 것이므로)
            int two = ((ch[i-2] - '0') * 10) + (ch[i-1] - '0');
//            System.out.println("두 자리수 : " + two);
            if(two >= 10 && two <= 26) dp[i] += dp[i-2] % 1000000;
//            System.out.println("두 자리 수까지 가능한 겅우의 수 : " + dp[i]);
        }
        return dp[ch.length] % 1000000;

    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // ***** s가 0이거나 첫번째 자리가 0이면 => 0가지
        // s가 한자리 일 때 => 1가지
        // s가 두자리 일 때, s <= 26이면 2가지, 아니면 1가지
        // s가 두자리 이상일 때 => arr[n]에 각 자리의 수를 넣었다고 했을 때
        // "arr[n-1]" + "arr[n]"이 <= 26 이면 dp[n] = dp[n-1] + dp[n-2], 아니면 dp[n] = dp[n-1]
        // ***** 중간에 0이 있다!?
        // 0으로 시작하는 두자리 수는 애초에 한자리 수와 동일하므로,
        // 숫자 중간에 0이 있다면, 0 앞자리 숫자와 합쳐 하나의 숫자로 본다.
        // ***** 입력: 230 / 답: 0
        // 0을 합친 수가 이미 26을 초과한다? 그럼 이 입력값 자체는 무효임.

        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(s.charAt(0)));
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                list.set(i-1, list.get(i-1) + "0"); // 0을 앞자리 숫자와 합쳐 하나의 숫자로 다룸
                if(Integer.parseInt(list.get(i-1)) > 26) return 0; // 0을 합친 수가 이미 26을 초과한다? 그럼 이 입력값 자체는 무효임.
            }
            else list.add(String.valueOf(s.charAt(i)));
        }
        int n = list.size();

        // 디버깅
        for(String c : list) System.out.println("list => " + c);

        int[] dp = new int[n];
        dp[0] = 1;
        if(Integer.parseInt(list.get(0) + list.get(1)) <= 26) dp[1] = 2;
        else dp[1] = 1;
        for(int i = 2; i < n; i++) {
            if(Integer.parseInt(list.get(i-1) + list.get(i)) <= 26) dp[i] = (dp[i-1] + dp[i-2]) % 1000000;
            else dp[i] = dp[i-1];
        }
        return dp[n-1];
    }
}
