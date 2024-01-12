package study.intro.section10.practice;

import java.util.Scanner;

public class S100106P01 {

    public static void main(String[] args) {
        problem01();
    }



    static int[] dy;

    public int solution01(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dy[i] = dy[i -1] + dy[i - 2];
        }
        return dy[n];
    }
    public static void problem01() {
        S100106P01 s10 = new S100106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(s10.solution01(n));
    }
}
