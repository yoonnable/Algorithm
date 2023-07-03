package study.intro.section06;

import java.util.*;

public class Section0602 {
    public int[] solution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Section0602 s6 = new Section0602();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int i : s6.solution(n, arr)) System.out.print(i + " ");
    }
}