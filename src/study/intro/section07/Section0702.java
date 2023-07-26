package study.intro.section07;

import java.util.*;

public class Section0702 {
    public void DFS(int n) {
        if(n == 0) return;
        else {
            DFS( n / 2);
            System.out.print(n % 2);
        }
    }
    public static void main(String[] args) {
        Section0702 s7 = new Section0702();
        s7.DFS(11);
    }
}