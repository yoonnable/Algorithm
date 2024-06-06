package study.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문저열 분석
public class P10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuffer sb = new StringBuffer();
         while ((str = br.readLine()) != null) {
             char[] arr = str.toCharArray();
             long[] answer = new long[4];

             for(char c : arr) {
                 if(Character.isLowerCase(c)) answer[0]++;
                 else if(Character.isUpperCase(c)) answer[1]++;
                 else if(Character.isDigit(c)) answer[2]++;
                 else answer[3]++;
             }

             sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]).append(" ").append(answer[3]).append("\n");
         }
         br.close();
        System.out.println(sb.toString());
    }
}
