package study.intro.section03;
import java.util.Scanner;
  
public class Section0304 {
    // 연속 부분 수열(복합적 문제)
    public int solution(int n, int m, int[] arr) {
        int answer = 0, lt = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            while(sum >= m) {
                if(sum == m) answer++;
                sum -= arr[lt];
                lt++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Section0304 s3 = new Section0304();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(s3.solution(n, m, arr));
        return ;
    }
}