import java.util.Scanner;
  
public class Main {
  int[] dx = {0, -1, 0, 1};
  int[] dy = {-1, 0, 1, 0};
  
  public int solution(int n, int[][] arr) {
  	int answer = 0;
    for(int i = 0; i < n; i++) {
    	for(int j = 0; j < n; j++) {
          	boolean flag = true;
        	for(int k = 0; k < 4; k++) {
            	int nx = i + dx[k];
              	int ny = j + dy[k];
              	if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] >= arr[i][j]) {
                  flag = false;
                  break;
                }
            }
          	if(flag) answer++;
        }
    }
    
    return answer;
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();
    int[][] arr = new int[n][n];
    for(int i = 0; i < n; i++) {
    	for(int j = 0; j < n; j++) {
        	arr[i][j] = in.nextInt();
        }
    }
    System.out.println(m.solution(n, arr));
    return ;
  }
}
