package study.intro.section02;

import java.util.Scanner;
  
public class Section0204 {

  // 諛곗뿴 �궗�슜
  public int[] solution1(int n) {
    int[] answer = new int[n];
    answer[0] = 1;
    answer[1] = 1;
    for(int i = 2; i < n; i++) {
      answer[i] = answer[i - 2] + answer[i - 1];
    }
    return answer;
  }

  // �넀肄붾뵫 諛⑹떇
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
    Section0204 m = new Section0204();
    Scanner in=new Scanner(System.in);
    int n = in.nextInt();

    System.out.println("諛곗뿴 �궗�슜");
    for(int i : m.solution1(n)) System.out.print(i + " ");

    System.out.println("�넀肄붾뵫 諛⑹떇");
    m.solution2(n);
    return ;
  }
}
