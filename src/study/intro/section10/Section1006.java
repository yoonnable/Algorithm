package study.intro.section10;

import java.util.*;

class Section1006 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 문제의 갯수 입력
        int m = kb.nextInt(); // 제한 시간 입력
        int[] dy = new int[m + 1]; // 시간에 따라 받을 수 있는 최고점 넣을 배열
        for(int i = 0; i < n; i++) {
            int problemScore = kb.nextInt(); // 각 문제의 점수 입력
            int problemTime = kb.nextInt(); // 각 문제를 푸는데 걸리는 시간 입력
            
            // 입력과 동시에 작업
            // 이전 동전문제는 동전이 무한대로 중복 가능하므로 dy배열 탐색을 작은 수부터 큰수로 진행
            // 이 문제풀이 문제는 문제가 중복되어 점수가 매겨지지 않고 단 1번만 풀고 점수를 얻을 수 있으므로
            // 큰 수부터(m) 작은 수(해당 입력된 시간 이상까지)로 진행
            for(int j = m; j >= problemTime; j--) {
                if(dy[j] < dy[j - problemTime] + problemScore) { // 기존에 담긴 점수보다
                    // 현재 탐색중인 문제를 풀었을 때 점수가 더 크면
                    // 최고점 변경!
                    dy[j] = dy[j - problemTime] + problemScore;
                }
            }
        }
        System.out.println(dy[m]);
    }
}