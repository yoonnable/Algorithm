package study.intro.section09;

import java.util.*;

class Section0901 {
    // Section06에 좌표 정렬 문제 복습하고 풀면 도움 된다.
    static class Body implements Comparable<Body>{
        int height, weight;

        public Body (int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height; // 음수, 0이면 그대로, 양수면 자리바꿔 정렬(키 내림차순 정렬)
        }
    }

    public int solution(List<Body> list) {
        int cnt = 0;
        Collections.sort(list); // 키를 기준으로 내림차순 정렬 => 이때 compareTo 메서드 실행 됨
        int maxWeight = Integer.MIN_VALUE; // 최댓값을 담아줄 것이므로 최소값으로 초기화
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).weight>maxWeight) {
                maxWeight = list.get(i).weight;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Section0901 s9 = new Section0901();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Body> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int h = kb.nextInt();
            int w = kb.nextInt();
            list.add(new Body(h, w));
        }

        System.out.println(s9.solution(list));
    }
}