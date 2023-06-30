package study.intro.section05.practice;

import java.util.*;
public class S050108P01 {
    public static void main(String[] args) {
        // problem01(); //올바른 괄호
        // problem02(); //괄호 문자 제거
        // problem03(); //크레인 인형뽑기(카카오)
        // problem04(); //후위 연산식(postfix)
        // problem05(); //쇠막대기
        // problem06(); //공주 구하기
        // problem07(); //교육과정 설계
        problem08(); //응급실
    }

    class Patient {
        int id = 0;
        int value = 0;
        Patient(int id , int value) {
            this.id = id;
            this.value = value;
        }
        @Override
        public String toString() {
            return " " + id + value;
        }
    }

    public int solution08(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Patient> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.offer(new Patient(i, arr[i]));
        }
        int i = 0;
        while(!q.isEmpty()) {
            Patient now = q.poll();
            // System.out.println(now);
            boolean flag = true;
            for(Patient pa : q) {
                if(now.value < pa.value) {
                    q.offer(now);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                i++;
                if(now.id == m) {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void problem08() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s5.solution08(n, m, arr));
    }

    public String solution07(String a, String b) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char c : a.toCharArray()) {
            q.offer(c);
        }
        for(char c : b.toCharArray()) {
            if(q.size() == 0) return "YES";
            if(c == q.peek()) q.poll();
        }
        if(q.size() > 0) return "NO";
        return answer;
    }

    public static void problem07() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(s5.solution07(a, b));
    }

    public int solution06(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int i = 0;
        while(!q.isEmpty()) {
            i++;
            if(i == k) {
                q.poll();
                i = 0;
            } else q.offer(q.poll());
            if(q.size() == 1) answer = q.poll();
        }
        return answer;
    }

    public static void problem06() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.print(s5.solution06(n, k));
    }

    public int solution05(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                if(s.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void problem05() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(s5.solution05(s));
    }

    public int solution04(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) stack.push(c - 48);
            else {
                int rt = stack.pop(), lt = stack.pop();
                if(c == '+') stack.push(lt + rt);
                else if(c == '-') stack.push(lt - rt);
                else if(c == '*') stack.push(lt * rt);
                else if(c == '/') stack.push(lt / rt);
            }
            System.out.println(stack);
        }
        answer = stack.get(0);
        return answer;
    }
    public static void problem04() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(s5.solution04(s));
    }

    public int solution03(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves) {
            int i = 0;
            while(i < board.length && board[i][m - 1] == 0) i++;
            if(i < board.length) {
                if(!stack.isEmpty() && stack.peek() == board[i][m - 1]) {
                    stack.pop();
                    answer += 2;
                } else stack.push(board[i][m - 1]);
                board[i][m - 1] = 0;
            }
        }
        return answer;
    }

    public static void problem03() {
        S050108P01 s5 = new S050108P01();
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
        System.out.print(s5.solution03(board, moves));
    }

    public String solution02(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c != ')') stack.push(c);
            else {
                while(stack.pop() != '(') {} 
            }
        }
        for(char c : stack) {
            answer += c;
        }
        return answer;
    }

    public static void problem02() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(s5.solution02(s));
    }

    public String solution01(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') stack.push(c);
            else {
                if(stack.size() == 0) return "NO";
                stack.pop();
            }
        }
        if(stack.size() != 0 ) return "NO";
        return answer;
    }

    public static void problem01() {
        S050108P01 s5 = new S050108P01();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        System.out.println(s5.solution01(s));
    }
}
