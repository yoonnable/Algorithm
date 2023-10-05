package study.intro.section10;

import java.util.*;

class Section1003 {

    public int solution(int[] arr) {
        int answer = 0;
        int[] dy = new int[arr.length]; // 각 데이터 별 수열 최대 길이 담는 배열 선언 초기화
        dy[0] = 1; // 첫번째 데이터는 앞에 아무것도 없으니 무조건 길이가 1
        answer = dy[0]; // 데이터가 1개일 경우를 대비해서
        for(int i = 1; i < arr.length; i++) {
            int max = 0; // 탐색하는 요소보다 전 요소들 중 최대길이 담을 변수 선언 초기화
            for(int j = i - 1; j >= 0; j--) { // 탐색하는 요소 전 요소들
                if(arr[i] > arr[j] && dy[j] > max) max = dy[j]; // 탐색하는 데이터보다 작은 데이터이고, 수열 길이는 최대인 요소의 수열 길이를 담는다
            }
            dy[i] = max + 1; // 이 전까지의(본인보다 작은 수들의) 최대 수열 길이 + 1(본인)
            answer = Integer.max(answer, dy[i]); // 각 데이터의 최대 수열 중에서도 가장 큰 수열을 정답
        }
        return answer;
    }
    public static void main(String[] args) {
        Section1003 s10 = new Section1003();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 데이터 수 입력 받음
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt(); // 데이터들 입력 받음
        System.out.println(s10.solution(arr));
    }
}