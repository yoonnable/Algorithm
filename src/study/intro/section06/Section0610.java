package study.intro.section06;

import java.util.*;

public class Section0610 {
    public int countHorseInstall(int[] arr, int dist) { // 해당 거리(dist) 간격 이상으로 말을 넣을 때 말이 몇마리까지 수용 가능한지 응답
        int count = 1;
        int ep = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - ep >= dist) {
                count++;
                ep = arr[i];
            }
        }
        return count;
    }
    public int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr); //마구간 번호 오름차순 정렬
        int lt = 1, rt = arr[n - 1]; //말을 넣은 마구간들 간의 거리 중 가능한 최소값, 최대값
        while(lt <= rt) {
            int mid = (lt + rt) / 2; //lt와 rt의 중간 값
            if(countHorseInstall(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1; // 말을 충분히 넣을 수 있으므로 거리를 더 넓혀봄
            } else rt = mid - 1; // 말이 다 안들어가므로 거리 좁혀봄
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0610 s6 = new Section0610();
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution(n, c, arr));
    }
}