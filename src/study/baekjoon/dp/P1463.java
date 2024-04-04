package study.baekjoon.dp;

import java.util.Scanner;

public class P1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P1463 p = new P1463();
        int n = sc.nextInt();
        System.out.println(p.solution(n));
    }

    public int solution(int n) {
        int[] arr = new int[n + 1];

        // 차근차근 작은 숫자(1)부터 시작
        // 1은 어짜피 1이니까 연산횟수 0으로 초기화 해주기
        arr[1] = 0;
        // 반복문은 2부터 시작!
        // 3의 배수냐? 나누기 3 연산 횟수 +1 -> 몫의 최소 연산수 더하기
        // 아니면 2의 배수냐? 나누기 2 연산 횟수 +1 -> 몫의 최소 연산수 더하기
        // 아니면, -1 연산 횟수 +1 -> 하나 작은 수의 최소 연산수 더하기
        // 여기서 나온 연산 수 중 가장 작은 수를 대입!!
        for(int i = 2; i < n + 1; i++) {
            int preNum = Integer.MAX_VALUE;
            if(i%3 == 0) preNum = arr[i / 3];
            if(i%2 == 0 && preNum > arr[i/2]) preNum = arr[i / 2];
            if(preNum > arr[i - 1]) preNum = arr[i - 1];
            arr[i] = preNum + 1;
        }
        return arr[n];
    }
}
