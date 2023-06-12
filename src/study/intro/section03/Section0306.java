package study.intro.section03;
import java.util.Scanner;
  
public class Section0306 {
    //최대 길이 연속 부분수열(복합적 문제)
    public int solution(int n, int k, int[] arr) {
        int answer = 0, lt = 0, cnt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
    public static void main(String[] args){
        Section0306 s3 = new Section0306();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(s3.solution(n, k, arr));
        return ;
    }
}