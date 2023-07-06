package study.intro.section06;

import java.util.*;

public class Section0606 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp); // 정렬 후 자동 갱신
        for(int i = 0; i < n; i++) if(arr[i] != tmp[i]) answer.add(i + 1);
        return answer;
    }
    public static void main(String[] args) {
        Section0606 s6 = new Section0606();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution(n, arr)) System.out.print(i + " ");
    }
}