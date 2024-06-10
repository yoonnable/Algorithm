package study.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 네 수
public class P10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        String ab = st.nextToken() + st.nextToken();
        String bc = st.nextToken() + st.nextToken();
        System.out.println(Long.parseLong(ab) + Long.parseLong(bc));
    }
}
