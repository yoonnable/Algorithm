package study.intro.section08;

import java.util.*;

class Section0811 {
    class Point {
        public int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board, dis;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};


    public void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        while(!q.isEmpty()) {
            Point point = q.poll();
            x = point.x;
            y = point.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[x][y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Section0811 s8 = new Section0811();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for(int i = 1; i < 8; i++) {
            for(int j = 1; j < 8; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        board[1][1] = 1;
        s8.BFS(1, 1);
        if(board[7][7] == 0) System.out.println("-1");
        else System.out.println(dis[7][7]);
    }
}