package study.intro.section06;

import java.util.*;

//문제의 답이 lt ~ rt 사이에 무조건 있다는 확신이 있을 경우 결정 알고리즘 이용.
public class Section0609 {
    public int countDVD(int[] arr, int capacity) {
        int count = 1, sum = 0;
        for(int x : arr) {
            if(sum + x > capacity) {
                count++;
                sum = x;
            } else sum += x;
        }
        return count;
    }
    //* stream(arr).max().getAsInt()
    //* stream(arr).sum()
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        //DVD 한 장의 최소 용량은 9(한 곡의 가장 큰 용량), 최대 용량은 45(주어진 곡들의 용량의 총 합)
        // lt = 9,
        // rt = 45,
        // (중간값)middle = 27 = (9 + 45) / 2
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            if(countDVD(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0609 s6 = new Section0609();
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s6.solution(n, m, arr));
    }
}