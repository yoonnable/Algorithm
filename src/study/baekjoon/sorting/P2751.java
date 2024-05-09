package study.baekjoon.sorting;

import java.io.*;
import java.util.*;

// 수 정렬하기 2
public class P2751 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) list.add(Integer.parseInt(br.readLine()));

        br.close();


        Collections.sort(list); // 정렬 실행 - tim sort 알고리즘 O(nlogn)

        for (int i : list) bw.write(i + "\n");

        bw.flush(); // 버퍼 닫기 전에, 버퍼에 남아있는 데이터 모두 출력
        bw.close();
    }
}
