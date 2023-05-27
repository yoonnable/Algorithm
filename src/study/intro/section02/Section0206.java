package study.intro.section02;

import java.util.*;
  
public class Section0206 {
  // ***** �떊寃쎌뜥�빞 �븷 寃� 留롮쓬! 瑗� �떎�떆 ���옄!!
  public boolean isPrime(int num) {
    if(num < 2) return false;
    for(int i = 2; i < num; i++) {
    	if(num%i == 0) return false;
    }
    return true;
  }
  public List<Integer> solution(int n, int[] arr) {
    Section0206 m = new Section0206();
    List<Integer> answer = new ArrayList<Integer>();
    for(int i = 0; i < n; i++) {
      	int tmp = arr[i];
        int res = 0;
    	while(tmp > 0) {
        	int t = tmp%10;
          	res = res * 10 + t;
          	tmp = tmp/10;
        }
      if(m.isPrime(res)) answer.add(res);
    }
    return answer;
  }
  public static void main(String[] args){
    Section0206 m = new Section0206();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
    	arr[i] = in.nextInt();
    }
    
    for(int i : m.solution(n, arr)) System.out.print(i + " ");
    return ;
  }
}
