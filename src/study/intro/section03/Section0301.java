package study.intro.section03;
import java.util.*;

public class Section0301 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < m) answer.add(b[p2++]);
        return answer;
    }
 public static void main(String[] args) {
    Scanner sb = new Scanner(System.in);
    Section0301 s3 = new Section0301();
    int n = sb.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++) {
        a[i] = sb.nextInt();
    }
    int m = sb.nextInt();
    int[] b = new int[m];
    for(int i = 0; i < m; i++) {
        b[i] = sb.nextInt();
    }
    for(int i : s3.solution(n, m, a, b)) System.out.print(i + " ");
 }
}
