package study.intro.section07.practice;

import java.util.*;

public class S070114P01 {
    public static void main(String[] args) {
        problem01();
    }
    public static void problem14() {

    }
    public static void problem13() {
        
    }
    public static void problem12() {
        
    }
    public static void problem11() {
        
    }
    public static void problem10() {
        
    }
    public static void problem09() {
        
    }
    public static void problem08() {
        
    }
    public static void problem07() {
        
    }
    public static void problem06() {
        
    }
    public static void problem05() {
        
    }
    public static void problem04() {
        
    }

    public static void problem03() {
        
    }

    public static void problem02() {
        
    }


    public void DFS01(int n) {
        if(n <= 0) return;
        else {
            DFS01(n - 1);
            System.out.print(n + " ");
        }
    }
    // 재귀함수를 이용하여 1 ~ N 까지 출력
    public static void problem01() {
        Scanner kb = new Scanner(System.in);
        S070114P01 s7 = new S070114P01();
        int n = kb.nextInt();
        s7.DFS01(n);
    }
}
