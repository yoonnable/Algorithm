package study.intro.section10;

import java.util.*;

class Section1004 {
    static class Brick implements Comparable<Brick> {
        int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }
        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }

    public int solution(ArrayList<Brick> list) {
        int answer = 0;
        int[] dy = new int[list.size()]; // 각 벽돌이 쌒을 수 있는 최대 높이 담을 배열
        Collections.sort(list); // 우선 벽돌 넓이의 내림차순으로 정렬시킴
        dy[0] = list.get(0).h; // 제일 무거운 벽돌은 본인밖에 못쌓으니까 자기 자신 높이가 최대임
        answer = dy[0]; // 벽돌이 1개일 수도 있으므로!
        for(int i = 1; i < list.size(); i++) {
            int maxH = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(list.get(i).w < list.get(j).w && dy[j] > maxH) maxH = dy[j]; // 탐색 벽돌이 이 전 애들보다 무게가 적게 나가야 쌓아올릴 수 있고, 이전까지 쌓은 높이가 최대인 것!
            }
            dy[i] = maxH + list.get(i).h; // 탐색 벽돌 높이까지 더한 값 넣기
            answer = Integer.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Section1004 s10 = new Section1004();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 벽돌 갯수 입력 받음
        ArrayList<Brick> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = kb.nextInt(); // 벽돌 넓이
            int h = kb.nextInt(); // 벽돌 높이
            int w = kb.nextInt(); // 벽돌 무게
            list.add(new Brick(s, h, w));
        }
        System.err.println(s10.solution(list));
    }
}