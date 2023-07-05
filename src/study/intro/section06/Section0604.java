package study.intro.section06;

import java.util.*;
// ******************* 어려움 //
public class Section0604 {
    public int[] solution(int s, int n, int[] arr) {
        int[] answer = new int[s];
        for(int i : arr) {
            int pos = s - 1;
            for(int j = 0; j < s; j++) if(answer[j] == i) pos = j;
            for(int j = pos; j > 0; j--) {
                answer[j] = answer[j - 1];
            }
            answer[0] = i;
            // for(int k : answer) System.out.print(k + " ");
            // System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0604 s6 = new Section0604();
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }
        for(int i : s6.solution(s, n, arr)) System.out.print(i + " ");
    }
}