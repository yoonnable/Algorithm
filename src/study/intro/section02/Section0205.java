import java.util.Scanner;
  
public class Main {
  public int solution(int n) {
  	int answer = 0;
    int[] arr = new int[n + 1];
    for(int i = 2; i <= n; i++) {
    	if(arr[i] == 0) {
          answer++;
          for(int j = i; j <= n; j = j + i) {
           	arr[j] = 1;
          }
       }
    }
    
    return answer;
  }
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    
    System.out.println(m.solution(n));
    return ;
  }
}
