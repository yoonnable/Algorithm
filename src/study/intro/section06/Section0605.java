package study.intro.section06;

import java.util.*;

public class Section0605 {
    public char solution(int n, int[] arr) {
        char answer = 'U';
        Arrays.sort(arr); // 정렬 후 자동 갱신
        for(int i = 0; i < n - 1; i++) if(arr[i] == arr[i + 1]) answer = 'D';
        return answer;
    }
    public static void main(String[] args) {
        Section0605 s6 = new Section0605();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s6.solution(n, arr));
    }
}