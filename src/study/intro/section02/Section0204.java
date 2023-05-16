import java.util.Scanner;
  
public class Main {

  // 배열 사용
  public int[] solution1(int n) {
    int[] answer = new int[n];
    answer[0] = 1;
    answer[1] = 1;
    for(int i = 2; i < n; i++) {
      answer[i] = answer[i - 2] + answer[i - 1];
    }
    return answer;
  }

  // 손코딩 방식
  public void solution2(int n) {
    int a = 1, b = 1, c;
    System.out.print(a + " " + b + " ");
    for(int i = 2; i < n; i++) {
      c = a + b;
      System.out.print(c + " ");
      a = b;
      b = c;
    }
  }
  
  public static void main(String[] args){
    Main m = new Main();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();

    System.out.println("배열 사용");
    for(int i : m.solution1(n)) System.out.print(i + " ");

    System.out.println("손코딩 방식");
    m.solution2(n);
    return ;
  }
}
