package study.intro.section09;

import java.util.*;

// 문제에서 유념해야할 부분은 (시작 시간 <= 끝나는 시간)
// 시작시간과 끝나는 시간이 같을 수도 있다는 점.
// 즉, 끝나는 시간을 기준으로 오름차순 한 다음
// 끝나는 시간이 같은 건 시작 시간으로도 오름차순할 필요가 있다.
class Section0902 {

    static class Meetting implements Comparable<Meetting> {
        int start, end;
        public Meetting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meetting o) {
            // 음수면 그대로, 양수면 자리바꿔 재배열
            if(o.end == this.end) return this.start - o.start;// 오름차순
            else return this.end - o.end; // 오름차순****시작, 끝 시간이 같을 수 있음
        }
    }

    public int solution(List<Meetting> list) {
        int cnt = 0;
        Collections.sort(list); // Meetting의 compareTo 메서드 반환값을 기준으로 정렬
        int totalEndTime = 0;
        for(Meetting m : list) {
            if(totalEndTime <= m.start) {
                cnt++;
                totalEndTime = m.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Section0902 s9 = new Section0902();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Meetting> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            list.add(new Meetting(s, e));
        }
        System.out.println(s9.solution(list));
    }
}