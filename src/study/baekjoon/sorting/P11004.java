package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< n; i++) list.add(Integer.parseInt(st2.nextToken()));
        Collections.sort(list);
        br.close();
        System.out.println(list.get(k));
    }
}
