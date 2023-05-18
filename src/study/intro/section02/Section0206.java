import java.util.*;
  
public class Main {
  // ***** 신경써야 할 것 많음! 꼭 다시 풀자!!
  public boolean isPrime(int num) {
    if(num < 2) return false;
    for(int i = 2; i < num; i++) {
    	if(num%i == 0) return false;
    }
    return true;
  }
  public List<Integer> solution(int n, int[] arr) {
    Main m = new Main();
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
    Main m = new Main();
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
