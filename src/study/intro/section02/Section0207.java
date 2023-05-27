package study.intro.section02;

import java.util.Scanner;
  
public class Section0207 {
  public int solution(int n, int[] arr) {
  	int cnt = 0, answer = 0;
    for(int i = 0; i < n; i++) {
    	if(arr[i] == 1) {
        	cnt++;
         	answer += cnt;
        } else cnt = 0;
    }
    return answer;
  }
  
  public static void main(String[] args){
    Section0207 m = new Section0207();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
    	 arr[i] = in.nextInt();
    }
    System.out.println(m.solution(n, arr));
    return ;
  }
}
