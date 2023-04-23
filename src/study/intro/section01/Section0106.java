package study.intro.section01;

import java.util.Scanner;

public class Section0106 {
	//*for¹®, indexOf
	public String solution(String str) {
		String answer = "";
		for(int i = 0; i < str.length(); i++) {
			answer += i == str.indexOf(str.charAt(i)) ? str.charAt(i) : "";
		}
		return answer;
	}

	public static void main(String[] args) {
		Section0106 s6 = new Section0106();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(s6.solution(str));
	}
}
