package study.intro.section06;

import java.util.*;

class S060110P02 {
    public static void main(String[] args) {
        // problem01(); //선택정렬
        // problem02(); //버블정렬
        // problem03(); //삽입정렬
        // problem04(); //Least recently used
        problem05(); //중복 확인
    }

    public void solution10() {

    }
    public static void problem10() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);

    }

    public void solution09() {

    }
    public static void problem09() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        
    }

    public void solution08() {

    }
    public static void problem08() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        
    }

    public void solution07() {

    }
    public static void problem07() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        
    }

    public void solution06() {

    }
    public static void problem06() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        
    }

    public char solution05(int n, int[] arr) {
        char answer = 'U';
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) return 'D';
            }
        }
        return answer;
    }
    public static void problem05() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution05(n, arr));
    }

    public int[] solution04(int s, int n, int[] arr) {
        int[] answer = new int[s];
        int i = 0;
        while(i < n) {
            int tmp = arr[i];
            for(int j = 0; j < s; j++) {
                if(answer[j] == arr[i]) {
                    answer[j] = tmp;
                    break;
                } else {
                    int sub = tmp;
                    tmp = answer[j];
                    answer[j] = sub;
                }
            }
            i++;
        }
        return answer;
    }
    public static void problem04() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution04(s, n, arr)) System.out.print(i + " ");
    }

    public int[] solution03(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i];
            for(int j = 0; j < i; j++) {
                if(tmp < arr[j]) {
                    int sub = tmp;
                    tmp = arr[j];
                    arr[j] = sub;
                }
            }
            arr[i] = tmp;
        }

        return arr;
    }
    public static void problem03() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution03(n, arr)) System.out.print(i + " ");
    }

    public int[] solution02(int n, int[] arr) {
        while(n > 0) {
            for(int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            n--;
        }
        return arr;
    }
    public static void problem02() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution02(n, arr)) System.out.print(i + " ");
    }

    public int[] solution01(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            int tmp = arr[i], k = i;
            for(int j = i + 1; j < n; j++) {
                if(tmp > arr[j]) {
                    tmp = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
    public static void problem01() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution01(n, arr)) System.out.print(i + " ");
    }
}