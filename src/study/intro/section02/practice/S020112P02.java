package study.intro.section02.practice;

import java.util.*;

public class S020112P02 {
    public static void main(String[] args) {
        // problem01(); //큰 수 출력하기   
        // problem02(); //보이는 학생  
        // problem03(); //가위 바위 보  
        // problem04(); //피보나치 수열
        // problem05(); //소수(에라토스테네스 체)
        // problem06(); //뒤집은 소수
        // problem07(); //점수 계산
        // problem08(); // 등수 구하기
        // problem09(); //격자판 최대합
        // problem10(); //봉우리
        // problem11(); //임시 반장 구하기
        problem12(); //멘토링
    }
    public int solution12(int n, int m, int[][] arr) {
        int answer = 0;
        for(int to = 1; to < n + 1; to++) {
            for(int ti = 1; ti < n + 1; ti++) {
                boolean check = true;
                for(int i = 0; i < m; i++) {
                    int tog = 0, tig = 0;
                    for(int j = 0; j < n; j++) {
                        if(arr[i][j] == to) tog = j;
                        if(arr[i][j] == ti) tig = j;
                    }
                    if(tog >= tig) {
                        check = false;
                        break;
                    }
                }
                if(check) answer++;
            }
        }
        return answer;
    }
    public static void problem12() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        //반 학생 수 : n
        //시험 치루는 횟수 : m
        //n = 4일 때 배열 한 줄에 2 4 1 3 이면, 1등이 2번 학생, 2등이 4번학생, 3등이 1번학생 4등이 3번학생
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(s2.solution12(n, m, arr));
    }

    public int solution11(int n, int[][] arr) {
        int answer = 0, max = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < 5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        sum++;
                        break;
                    }
                }
            }
            if(max < sum) {
                answer = i + 1;
                max = sum;
            }
            sum = 0;
        }
        return answer;
    }
    public static void problem11() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][5];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.print(s2.solution11(n, arr));
    }

    public int solution10(int n, int[][] arr) {
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //상 arr[i - 1][j], i == 0 인 건 패스
                //하 arr[i + 1][j], i == n - 1 인 건 패스
                //좌 arr[i][j - 1], j == 0 인 건 패스
                //우 arr[i][j + 1], j == n - 1 인 건 패스
                if((i == 0 || arr[i - 1][j] < arr[i][j]) && 
                (i == n - 1 || arr[i + 1][j] < arr[i][j]) && 
                (j == 0 || arr[i][j - 1] < arr[i][j]) && 
                (j == n - 1 || arr[i][j + 1] < arr[i][j])
                ) answer++;
            }
        }
        return answer;
    }
    public static void problem10() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(s2.solution10(n, arr));
    }

    public int solution09(int n, int[][] arr) {
        int answer = 0, crossLeftSum = 0, crossRightSum = 0;
        for(int i = 0; i < n; i++){
            int lowSum = 0, colSum = 0;
            for(int j = 0; j < n; j++) {
                lowSum += arr[i][j];
                colSum += arr[j][i];
            }
            if(lowSum > answer) answer = lowSum;
            if(colSum > answer) answer = colSum;
            crossLeftSum += arr[i][i];
            crossRightSum += arr[i][n - 1 - i];
        }
        if(crossLeftSum > answer) answer = crossLeftSum;
        if(crossRightSum > answer) answer = crossRightSum;
        return answer;
    }
    public static void problem09() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(s2.solution09(n, arr));
    }

    public int[] solution08(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = 1;
            for(int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) answer[i]++;
            }
        }
        return answer;
    }
    public static void problem08() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s2.solution08(n, arr)) System.out.print(i + " ");
    }

    public int solution07(int n, int[] arr) {
        int answer = 0, score = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) answer += ++score;
            else score = 0;
        }
        return answer;
    }
    public static void problem07() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s2.solution07(n, arr));
    }

    public boolean helper(int num) {
        boolean answer = true;
        if(num < 2) return false;
        // 만약 num이 2이면??????
        //포문은 i = 2부터 시작한다.
        //근데 포문이 돌기 위한 조건식이 i < num
        //즉, num이 2일 땐 i < 2 인건데
        //i는 2부터 시작이므로
        // 2 < 2는 false이므로 포문 돌지 않고
        //바로 처음에 초기화한 true 값이 리턴된다.
        for(int i = 2; i < num; i++) {
            if(num%i == 0) return false;
        }
        return answer;
    }
    public ArrayList<Integer> solution06(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < n; i++) {
            while(arr[i] > 0) {
                num = (num * 10) + arr[i] % 10;
                arr[i] = arr[i] / 10;
            }
            if(helper(num)) answer.add(num);
            num = 0;
        }

        return answer;
    }
    public static void problem06() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s2.solution06(n, arr)) System.out.print(i + " ");
    }

    public int solution05(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        for(int i = 2; i < n; i++) {
            if(arr[i] == 0) {
                answer++;
                for(int j = i; j < n; j = j + i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }
    public static void problem05() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(s2.solution05(n));
    }

    public int[] solution04(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;
        for(int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        return answer;
    }
    public static void problem04() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i : s2.solution04(n)) System.out.print(i + " ");
    }

    public char[] solution03_2(int n, int[][] arr) {
        // 1:가위, 2:바위, 3:보
        char[] answer = new char[n];
        for(int i = 0; i < n; i++) {
            if(arr[0][i] == arr[1][i]) answer[i] = 'D';
            else if(arr[0][i] == 1 && arr[1][i] == 3) answer[i] = 'A';
            else if(arr[0][i] == 2 && arr[1][i] == 1) answer[i] = 'A';
            else if(arr[0][i] == 3 && arr[1][i] == 2) answer[i] = 'A';
            else answer[i] = 'B';
        }
        return answer;
    }
    public char[] solution03(int n, int[][] arr) {
        // 1:가위, 2:바위, 3:보
        char[] answer = new char[n];
        for(int i = 0; i < n; i++) {
            // System.out.println("A" + arr[0][i]);
            // System.out.println("B" + arr[1][i]);
            if(arr[0][i] == 1) {
                switch(arr[1][i]) {
                    case 1 : answer[i] = 'D'; break;
                    case 2 : answer[i] = 'B'; break;
                    case 3 : answer[i] = 'A'; break;
                }
            }
            if(arr[0][i] == 2) {
                switch(arr[1][i]) {
                    case 1 : answer[i] = 'A'; break;
                    case 2 : answer[i] = 'D'; break;
                    case 3 : answer[i] = 'B'; break;
                }
            }
            if(arr[0][i] == 3) {
                switch(arr[1][i]) {
                    case 1 : answer[i] = 'B'; break;
                    case 2 : answer[i] = 'A'; break;
                    case 3 : answer[i] = 'D'; break;
                }
            }
        }
        return answer;
    }
    public static void problem03() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[2][n];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) arr[i][j] = kb.nextInt();
        }
        // for(char c : s2.solution03(n, arr)) System.out.println(c);
        for(char c : s2.solution03_2(n, arr)) System.out.println(c);
    }

    public int solution02(int n, int[] arr) {
        int answer = 1, cnt = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] >= arr[i]) break;
                else cnt++;
            }
            if(cnt == i) answer++;
            cnt = 0;
        }
        return answer;
    }
    public static void problem02() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s2.solution02(n, arr));
    }

    public ArrayList<Integer> solution01(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]) answer.add(arr[i]);
        }
        return answer;
    }
    public static void problem01() {
        S020112P02 s2 = new S020112P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s2.solution01(n, arr)) System.out.print(i + " ");
    }
}
