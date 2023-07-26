package study.intro.section07;

import java.util.*;

public class Section0703 {
    public int DFS(int n) {
        if(n == 1) return 1;
        else return n * DFS(n - 1);
    }
    public static void main(String[] args) {
        Section0703 s7 = new Section0703();
        // 5! = 5*4*3*2*1 = 120
        System.out.print(s7.DFS(5));
    }
}