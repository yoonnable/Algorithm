package study.intro.section08;

import java.util.*;

class Section0802 {
    static int answer = Integer.MIN_VALUE, c, n;

    public void DFS(int index, int sum, int[] arr) {
        if(sum > c) return;
        if(index == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(index + 1, sum + arr[index], arr); // 바둑이 승차
            DFS(index + 1, sum, arr); // 바둑이 승차 안함
        }
    }

    public static void main(String[] args) {
        Section0802 s8 = new Section0802();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        s8.DFS(0, 0, arr);
        System.out.println(answer);
    }
}