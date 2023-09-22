package study.intro.section09;

import java.util.*;

class Section0904 {

    static class Lecture implements Comparable<Lecture> {
        int money, days;
        public Lecture(int money, int days) {
            this.money = money;
            this.days = days;
        }
        @Override
        public int compareTo(Lecture o) {
            // 일수 기준 내림차순!
            return o.days - this.days; // 음수면 그대로, 양수면 체인지!!
        }
    }

    static int maxDays = Integer.MIN_VALUE, n;
    // 우선순위 큐PQ
    public int solution(List<Lecture> list) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        // PrioityQueue : 우선순위 큐(자동으로 정렬이 됨)
        // 파라미터 없으면 자동으로 오름차순 정렬됨.
        // 파라미터 Collections.reversOrder() 을 받으면 반대로 내림차순 정렬 됨.
        // 여기선 money를 큰 것 부터 차례대로 담을 것이므로 내림차순 정렬 해야함


        Collections.sort(list); // Lecture에 compareTo() 메서드를 적용해서 일 수 별 내림차순 정렬

        int j = 0;
        for(int i = maxDays; i >= 1; i--) {
            for( ; j < n; j++) {
                if(list.get(j).days != i) break; // 해당 유효 일수 내에 강연 가능한 것들만 체크
                pQ.offer(list.get(j).money);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Section0904 s9 = new Section0904();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        ArrayList<Lecture> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            list.add(new Lecture(m, d));
            if(d > maxDays) maxDays = d;
        }
        System.out.println(s9.solution(list));
    }
}