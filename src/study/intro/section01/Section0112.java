package study.intro.section01;

import java.util.Scanner;

public class Section0112 {
	// replace() + Integer.parseInt(String, 2)
	public String solution(int n, String str) {
		String answer = "";
		for(int i = 0; i < n; i++) {
			answer += (char)Integer.parseInt(str.substring(0, 7).replace("#", "1").replace("*", "0"), 2);
			str = str.substring(7);
		}
		return answer;
	}

	public static void main(String[] args) {
		Section0112 s12 = new Section0112();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String str = kb.next();
		System.out.println(s12.solution(n, str));
	}

}
