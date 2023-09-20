package study.intro.section08;

import java.util.*;

class Section0812 {
    static class Point {
        int x, y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> q = new LinkedList<>();
    static int a, b;
    static int[][] board, dis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int BFS() {
        while(!q.isEmpty()) {
            Point point = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < a && ny < b && board[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[point.x][point.y] + 1;
                }
            }

        }


        int max = 0;
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                max = Math.max(max, dis[i][j]);
                if(board[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Section0812 s8 = new Section0812();
        Scanner kb = new Scanner(System.in);

        b = kb.nextInt();
        a = kb.nextInt();
        board = new int[a][b];
        dis = new int[a][b];
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                board[i][j] = kb.nextInt();
                // 먼저 이미 익어 있는것(1)은 BFS 돌기 전에 Queue에 넣기
                if(board[i][j] == 1) {
                    q.offer(new Point(i, j)); // Point의 x,y는 x축, y축의 좌표가 아닌 그냥 단순 배열의 좌표로 인식(반대 개념)
                }
            }
        }
        System.out.println(s8.BFS());
        
        

    }
}
