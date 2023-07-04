package study.intro.section06;

import java.util.*;

public class Section0603 {
    public int[] solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > tmp) arr[j + 1] = arr[j];
                else break; 
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        Section0603 s6 = new Section0603();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int i : s6.solution(n, arr)) System.out.print(i + " ");
    }
}