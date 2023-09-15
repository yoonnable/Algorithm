package study.intro.section08;

import java.util.*;

class Section0810 {
    static int answer = 0;
    int[] dy = {-1, 0, 1, 0}; // 12시 방향, 3시 방향, 6시 방향, 9시 방향의 y 좌표 이동값
    int[] dx = {0, 1, 0, -1}; // 12시 방향, 3시 방향, 6시 방향, 9시 방향의 x 좌표 이동값
    static int[][] board;

    public void DFS(int x, int y) {
        if(x == 7 && y == 7) answer++;
        else {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 1 && ny >= 1 && nx <= 7 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        } 
    }
    public static void main(String[] args) {
        Section0810 s8 = new Section0810();
        Scanner kb = new Scanner(System.in);
        board = new int[8][8];
        for(int i = 1; i < 8; i++) {
            for(int j = 1; j < 8; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1; // 이거 안하면 돌아갔다 다시 같은 경로로 도착지 가는 경로까지 추가됨
        s8.DFS(1, 1);
        System.out.println(answer);
    }
}