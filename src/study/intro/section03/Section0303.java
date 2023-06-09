package study.intro.section03;

import java.util.*;

public class Section0303 {
    public int solution(int n, int k, int[] arr) {
        int answer, sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;
        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }
      
    
    public static void main(String[] args){
        Section0303 s3 = new Section0303();
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
        }
        
        System.out.print(s3.solution(n, k, arr));
        return ;
    }
}
