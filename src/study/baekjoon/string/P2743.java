package study.baekjoon.string;

import java.io.*;

// 단어 길이 재기
public class P2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(br.readLine().length())); // 파라미터 문자열일 때 출력됨
        br.close();
        bw.flush();
        bw.close();
    }
}
