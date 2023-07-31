package study.intro.section07;

import java.util.*;

public class Section0706 {
    // 부분집합은 하나의 원소를 포함한다/안한다 두 가지 경우 뿐
    // tree 구조로 경우의 수를 구함
    static int n; //집합 원소의 갯수 (static 메소드(main)에서 접근해야해서 static)
    static int[] ch; //원소 포함여부 체크
    public void DFS(int L) {
        if(L == n + 1) {
            String tmp = "";
            for(int i = 1; i < n + 1; i++) {
                if(ch[i] == 1) tmp += i + " ";
            }
            if(tmp.length() > 0) System.out.println(tmp);
        } else {
            ch[L] = 1; //원소 L 를 포함한다
            DFS(L + 1); //L 다음 숫자 탐색
            ch[L] = 0; //원소 L 를 포함하지 않는다
            DFS(L + 1); //L 다음 숫자 탐색
        }
    }
    public static void main(String[] args) {
        Section0706 s7 = new Section0706();
        n = 3;
        ch = new int[n + 1]; //원소의 포함 여부 체크 배열 초기화
        s7.DFS(1);
    }
}