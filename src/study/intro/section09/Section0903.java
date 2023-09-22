package study.intro.section09;

import java.util.*;

class Section0903 {
    // 같은 시간에 입장, 퇴장이 동시에 있다면 퇴장 먼저 처리한 후 입장 처리하기!
    static class Time implements Comparable<Time> {
        int time; // 입퇴장 시간을 담는 변수
        char state; // 입장인지 퇴장인지 담는 변수(입장 : s(start의 s), 퇴장 : e(end의 e))
        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            // 음수면 그대로, 양수면 자리 바꿈!!!!!!!
            if(this.time == o.time) return this.state - o.state; // 퇴장이 입장보다 앞에 위치해야 하므로 알파벳 순서상 e가 s보다 앞에 있으므로 오름차순으로 정렬하면 됨!
            return this.time - o.time; // 시간 순으로 정렬이므로 오름차순 정렬!
        }
    }

    public int solution(List<Time> list) {
        int cnt = 0, answer = Integer.MIN_VALUE;
        Collections.sort(list);
        for(Time t : list) {
            if(t.state == 's') {
                cnt++;
                answer = Math.max(answer, cnt);
            } else cnt--;
        }
        return answer;
    }


    public static void main(String[] args) {
        Section0903 s9 = new Section0903();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = kb.nextInt(); // 입장 시간 입력
            int e = kb.nextInt(); // 퇴장 시간 입력
            list.add(new Time(s, 's')); // 입장 시간, 입장 상태 값 입력
            list.add(new Time(e, 'e')); // 퇴장 시간, 퇴장 상태 값 입력
        }
        System.out.println(s9.solution(list));
    }
}