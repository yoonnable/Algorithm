package study.baekjoon.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 수 정렬하기 3
public class P10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for(int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 10001; i++) {
            if(arr[i] > 0) {
                bw.write((i + "\n").repeat(arr[i]));
            }
        }
        bw.flush();
        bw.close();
    }

    // 메모리 초과
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        Collections.sort(list);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Integer i : list) bw.write(i + "\n");
        bw.flush();
        bw.close();
    }*/

    // 시간초과
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i : arr) System.out.println(i);
    }*/
}
