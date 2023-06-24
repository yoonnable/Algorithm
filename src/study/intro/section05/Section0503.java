package study.intro.section05;

import java.util.*;

public class Section0503 {
	/**
	Stack 메소드
	stack.push() : 값 넣기
	stack.pop() : 스택의 가장 상단의 값 제거
	stack.peek() : 스택의 가장 상단의 값 출력
	
	stack.clear() : 전체 값 제거(초기화)
	*/
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer+=2;
                        stack.pop();
                    } else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Section0503 s5 = new Section0503();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }
        System.out.println(s5.solution(board, moves));
    }

}