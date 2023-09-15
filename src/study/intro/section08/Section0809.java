package study.intro.section08;

import java.util.*;

class Section0809 {
    static int n, m;
    static int[] combi;

    public void DFS(int level, int start) { // level: 선택 순서, start: 선택한 구슬 번호
        if(level == m) { // 선택하고자 하는 구슬의 갯수에 도달했을 때
            for(int i : combi) System.out.print(i + " ");
            System.out.println();
        } else {
            for(int i = start; i <= n; i++) { // 현재 선택된 구슬 번호보다 큰 수를 그 구슬 뒤로 선택할 수 있음.(오름차순으로)
                combi[level] = i; // 현재 선택 순서 자리에 선택한 구슬 번호 담기
                // 보면, n = 4, m = 2를 입력했다고 가정하면,
                // combi[0] 자리에는 1 ~ 4까지 들어갈 테지만 4는 4보다 큰 수가 없기에 다음자리인 combi[1]에 들어갈 숫자가 없어서 출력까진 안가고,
                // combi[1] 자리에는 start가 뭐냐에 따라 start보다 1 큰수부터 4까지 들어간다.

                DFS(level + 1, i + 1); // 다음 선택 순서 값과 다음 선택 구슬 번호를 보낸다.
            }
        }
    }
    public static void main(String[] args) {
        Section0809 s8 = new Section0809();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi = new int[m];
    
        s8.DFS(0, 1);
    }
}