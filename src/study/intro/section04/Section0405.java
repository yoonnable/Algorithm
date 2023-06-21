package study.intro.section04;

import java.util.*;

public class Section0405 {
    /******************************************
     * TreeSet
     * - 객체를 중복해서 저장할 수 없다.(Set의 성질)
     * - 저장 순서가 유지되지 않는다.(Set의 성질)
     * - 이진 탐색 트리 구조(정렬, 검색에 높은 성능) => 레드-블랙 트리
     * 
     
     * new TreeSet<>(Collections.reverseOrder()); // 내림차순으로 설정(인수 없으면 기본 오름차순)
     * treeSet.add(value);
     * treeSet.remove(value);
     * treeSet.size(); //원소의 갯수
     * treeSet.first(); //정렬 맨 앞의 값
     * treeSet.last(); //정렬 맨 뒷 갚
     ***/


    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int i : tSet) {
            cnt++;
            // System.out.println(cnt + "     " + i);
            if(cnt == k) return i;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0405 s4 = new Section0405();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s4.solution(arr, n, k));
    }
}