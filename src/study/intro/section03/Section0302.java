package study.intro.section03;

import java.util.*;
  
public class Section0302 {
  public List<Integer> solution(int n, int m, int[] a, int[] b) {
    List<Integer> answer = new ArrayList<Integer>();
    Arrays.sort(a); //오름차순 정렬
    Arrays.sort(b); //오름차순 정렬
    int p1 = 0, p2 = 0;
    while(p1 < n && p2 < m) {
      if(a[p1] == b[p2]) {
        answer.add(a[p1]);
        p1++;
        p2++;
      } else if(a[p1] > b[p2]) p2++;
      else p1++;
    }
    return answer;
  }
    
  
  public static void main(String[] args){
    Section0302 s3 = new Section0302();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int m = in.nextInt();
    int[] b = new int[m];
    for(int i = 0; i < m; i++) {
      b[i] = in.nextInt();
    }
    for(int i : s3.solution(n, m, a, b)) System.out.print(i + " ");
    return ;
  }
}
