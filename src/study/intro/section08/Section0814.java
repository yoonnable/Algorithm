package study.intro.section08;

import java.util.*;

class Section0814 {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m, answer = Integer.MAX_VALUE;
    static ArrayList<Point> hs = new ArrayList<>(), pz = new ArrayList<>();
    static int len; // 원래 입력받은 피자집(2) 갯수
    static int[] combi;

    public void DFS(int level, int s) {
        if(level == m) {// 선택할 피자집이 다 채워지면 
            // for(int i : combi) System.out.print(i + " ");
            // System.out.println();
            // 즉, 조합 하나가 다 완성이 되면!!! 각 조합의 "도시의 피자배달 거리" 를 구해서 비교
            // "도시의 피자 배달 거리"를 구하려면 먼저 "집들의 피자 배달 거리"를 구해야함
            int sum = 0;
            for(Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for(int i : combi) {
                    int hx = h.x; // h(집)의 x 좌표
                    int px = pz.get(i).x; //i 번째 선택된 피자집의 x 좌표
                    int hy = h.y; // h(집)의 y 좌표
                    int py = pz.get(i).y; //i 번째 선택된 피자집의 y 좌표
                    
                    dis = Math.min(dis, Math.abs(hx - px) + Math.abs(hy - py)); // 집 h 각각의 피자 배달 거리!!
                }
                sum += dis; // 하나의 조합으로 선택된 피자집 조합에 따른 도시의 피자 배달 거리
            }

            answer = Math.min(sum, answer); // 최소 피자 배달 거리

        } else {
            for(int i = s; i < len; i++) { // 중복 조합이 아니기때문에 초기값 셋팅은 지금 넘어온 index부터 시작
                combi[level] = i; // 하나의 조합을 담는 리스트
                DFS(level + 1, i + 1);
            }
        }
    }


    public static void main(String[] args) {
        Section0814 s8 = new Section0814();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        m = kb.nextInt();
        int[][] arr = new int[n][n];
        combi = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
                if(arr[i][j] == 1) hs.add(new Point(i, j)); // 입력받은 집들 좌표 리스트에 담는 중
                else if(arr[i][j] == 2) pz.add(new Point(i, j)); // 입력받은 피자집들 좌표 리스트에 담는 중
            }
        }
        
        // 1. 조합의 경우 구하기
        len = pz.size();
        s8.DFS(0, 0);// level(선택된 피자집 중 몇번째 선택인지) : 0, s(입력받은 피자집을 리스트에 담았을 때의 index) : 0 당연히 0부터 시작
        System.out.println(answer);

    }
}