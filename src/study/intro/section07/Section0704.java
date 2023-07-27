package study.intro.section07;

import java.util.*;

public class Section0704 {
    static int[] fibo;
    public int DFS1(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return DFS1(n - 2) + DFS1(n - 1);
    }
    public int DFS2(int n) {
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS2(n - 2) + DFS2(n - 1);
    }
    public int DFS3(int n) {
        if(fibo[n] > 0) return fibo[n]; //배열 값이 0보다 크다면 이미 계산된 값이 들어가 있으므로 바로 리턴!
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS3(n - 2) + DFS3(n - 1);
    }
    public static void main(String[] args) {
        Section0704 s7 =  new Section0704();
        int n = 45;
        
        // 피보나치 수열 방법 1
        long start1 = System.nanoTime();
        
        for(int i = 1; i <= n; i++) System.out.print(s7.DFS1(i) + " ");
        
        System.out.println();
        long DFS1times = ((System.nanoTime() - start1) / 1000000);
        System.out.println("DFS1 times : " + DFS1times); // 방법 1 걸리는 시간 => DFS1 times : 6848
        
        
        
        //피보나치 수열 방법 2 : 방법 1보다 속도 개선된 방법
        long start2 = System.nanoTime();
        
        fibo = new int[n + 1];
        s7.DFS2(n); //호출을 한 번만 해서 제일 큰 n값에서 가지치기로 나오는 값들을 배열에 담으면 끝!
        
        for(int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
        
        System.out.println();
        long DFS2times = ((System.nanoTime() - start2) / 1000000); // 방법 2 걸리는 시간 => DFS2 times : 3035
        System.out.println("DFS2 times : " + DFS2times);
        


        //피보나치 수열 방법 3 : 메모이제이션 방법 2보다 속도가 훨씬 빠른 방법(메모이제이션)
        long start3 = System.nanoTime();
        
        fibo = new int[n + 1];
        s7.DFS3(n); //호출을 한 번만 해서 제일 큰 n값에서 가지치기로 나오는 값들을 배열에 담으면 끝!
        for(int i = 1; i <= n; i++) System.out.print(fibo[i] + " ");
        
        System.out.println();
        long DFS3times = ((System.nanoTime() - start3) / 1000000); // 방법 2 걸리는 시간 => DFS3 times : 0
        System.out.println("DFS3 times : " + DFS3times);
    }
}