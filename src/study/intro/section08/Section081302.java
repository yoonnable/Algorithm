// package study.intro.section08;

import java.util.*;

class Section081302 {

    class Point {
        int x;
        int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer, n;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    Queue<Point> q = new LinkedList<>();

    public void BFS(int x, int y, int[][] board) {
        q.offer(new Point(x, y)); // 팔방을 확인할 중심 좌표를 Queue에 담기
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 8; i++) { //팔방 확인해주기
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0; // 바다로 변경
                    q.offer(new Point(nx, ny)); // 이 육지였던 좌표 또한 팔방을 확인하도록 Queue에 담고 반복문 돌아가도록
                }
            }
        }
    }

    public void solution(int[][] board) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) { // 육지를 발견하면
                    answer++; // 섬 카운트 +1
                    board[i][j] = 0; // 찾은 육지는 바다로 변경(중복 안되도록)
                    BFS(i, j, board); // 찾은 육지와 같은 섬에 포함된 육지들 바다로 만드는 작업하도록 넘기기
                }
            }
        }
    }
    public static void main(String[] args) {
        Section081302 s8 = new Section081302();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt(); // 섬나라 아일랜드 바다와 육지 입력 중
            }
        }
        s8.solution(arr);
        System.out.println(answer);
    }
}