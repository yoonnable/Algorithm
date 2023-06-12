package study.intro.section03;
import java.util.Scanner;
  
public class Section0305 {
    //연속된 자연수의 합(two pointers)
    // 수학적 풀이
    public int solution2(int n) {
        int answer = 0, cnt = 1;
        n--;
        while(n > 0) {
            cnt++;
            n -= cnt;
            if(n%cnt == 0) answer++;
        }
        return answer;
    }

    //two pointers
    public int solution1(int n) {
        int answer = 0, p1 = 1, p2 = 2, sum = p1 + p2;
        while(p1 <= n / 2) {
            // System.out.println("i 시작");
            // System.out.println("p1  " + p1);
            // System.out.println("p2  " + p2);
            // System.out.println("sum : " + sum);
            // System.out.println("answer : " + answer);
            if(sum == n) {
                answer++;
                sum -= p1;
                p1++;
            } else if(sum < n) {
                p2++;
                sum += p2;
            } else {
                sum -= p1;
                p1++;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Section0305 s3 = new Section0305();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(s3.solution2(n));
        return ;
    }
}