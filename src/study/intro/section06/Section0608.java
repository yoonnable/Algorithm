package study.intro.section06;
import java.util.*;

public class Section0608 {
    //이분검색 : 중간 값을 기준으로 범위를 좁혀가는 것
    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0, rt = n - 1;
        Arrays.sort(arr);
        while(lt <= rt) {
            int mid = (lt + rt) / 2; // 여기 주의!!!!!!!!
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }
            if(arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0608 s6 = new Section0608();
        int n = kb.nextInt();
        int[] arr = new int[n];
        int m = kb.nextInt();
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s6.solution(n, m, arr));
    }

}