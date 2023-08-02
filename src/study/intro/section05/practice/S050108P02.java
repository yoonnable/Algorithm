package study.intro.section05.practice;

import java.util.*;

class S050108P02 {
    public static void main(String[] args) {
        // problem01(); //올바른 괄호
        // problem02(); //괄호 문자 제거
        // problem03(); //크레인 인형뽑기(카카오)
        // problem04(); //후위식 연산(postfix)
        // problem05(); //쇠막대기
        // problem06(); //공주구하기
        // problem07(); //교육과정 설계
        problem08(); //응급실
    }

    class Patient {
        int no;
        int emergency;
        Patient(int no, int e) {
            this.no = no;
            this.emergency = e;
        }
    }
    public int solution08(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Patient> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) q.offer(new Patient(i, arr[i]));
        
        while(q.size() > 0) {
            Patient patient = q.poll();
            int rest = q.size();
            for(Patient other : q) {
                if(patient.emergency < other.emergency) {
                    q.offer(patient);
                    break;
                }
            }
            if(rest == q.size()) {
                answer++;
                if(patient.no == m) return answer;
            }
        }
        
        return answer;
    }
    public static void problem08() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s5.solution08(n, m, arr));
    }

    public String solution07(String a, String b) {
        Queue<Character> essential = new LinkedList<>();
        for(char c : a.toCharArray()) {
            essential.offer(c);
        }
        for(int i = 0; i < b.length(); i++) {
            if(essential.contains(b.charAt(i))) {
                if(essential.poll() != b.charAt(i)) return "NO";
            }
        }
        if(!essential.isEmpty()) return "NO";
        return "YES";
    }
    public static void problem07() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        String a = kb.nextLine();
        String b = kb.nextLine();
        System.out.println(s5.solution07(a, b));
    }

    public int solution06(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int j = 1;
        while(q.size() > 1) {
            if(j == k) {
                q.poll();
                j = 1;
            } else {
                q.offer(q.poll());
                j++;
            }
        }
        return q.poll();
    }
    public static void problem06() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(s5.solution06(n, k));
    }

    public int solution05(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                stack.pop();
                if(s.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            } else stack.push(s.charAt(i));
        }
        return answer;
    }
    public static void problem05() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(s5.solution05(s));
    }

    public int solution04(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) stack.push((int)c - 48);
            else {
                int after = stack.pop();
                int before = stack.pop();
                if(c == '+') stack.push(before + after);
                else if(c == '-') stack.push(before - after);
                else if(c == '*') stack.push(before * after);
                else stack.push(before / after);
            }
        }
        return stack.get(0);
    }
    public static void problem04() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(s5.solution04(s));
    }

    public int solution03(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : moves) {
            int y = 0;
            while(y < n && board[y][i - 1] == 0) y++;
            if(y >= n) y--;
            if(!stack.isEmpty() && stack.peek() == board[y][i - 1]) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(board[y][i - 1]);
            }
            board[y][i - 1] = 0;
        }
        return answer;
    }
    public static void problem03() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) board[i][j] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) moves[i] = kb.nextInt();
        System.out.println(s5.solution03(n, board, m, moves));
    }

    public String solution02_2(String s) {
        String answer = "";
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                cnt++;
            } else if(c == ')'){
                cnt--;
            } else {
                if(cnt == 0) answer += Character.toString(c);
            }
        }
        return answer;
    }
    
    public Stack<Character> solution02_1(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                while(stack.pop() != '(') {}
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public static void problem02() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        for(char c : s5.solution02_1(s)) System.out.print(c);
    }

    public String solution01(String s) {
        String answer = "YES";
        Stack stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else {
                if(stack.size() <= 0) return "NO";
                else stack.pop();
            }
        }
        if(stack.size() != 0) return "NO";
        return answer;
    }
    public static void problem01() {
        S050108P02 s5 = new S050108P02();
        Scanner kb = new Scanner(System.in);
        String s = kb.nextLine();
        System.out.println(s5.solution01(s));
    }
}