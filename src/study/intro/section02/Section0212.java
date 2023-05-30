import java.util.Scanner;
  
public class Section0212 {
  public int solution(int n, int m, int[][] arr) {
  	int answer = 0;
    for(int i = 1; i < n + 1; i++) { // 멘토가 될 학생 번호 i
      for(int j = 1; j < n + 1; j++) { //멘티가 될 학생 번호 j
        int cnt = 0;
        for(int k = 0; k < m; k++) { //문제 수
          int qi = 0, qj = 0;
          for(int s = 0; s < n; s++) { //등수
            if(arr[k][s] == i) qi = s; // i의 등수
            if(arr[k][s] == j) qj = s; // j의 등수
          }
          if(qi < qj) cnt++;
        }
        if(cnt == m) answer++;
      }
    }
    return answer;
  }
  
  public static void main(String[] args){
    Section0212 s2 = new Section0212();
    Scanner sb = new Scanner(System.in);
    //학생 수
    int n = sb.nextInt();
    //수학문제 갯수
    int m = sb.nextInt();
    int[][] arr = new int[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        arr[i][j] = sb.nextInt();
      }
    }
    System.out.println(s2.solution(n, m, arr));
    return ;
  }
}
