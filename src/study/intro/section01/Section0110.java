package study.intro.section01;

import java.util.Scanner;

public class Section0110 {
	// * Math.min()
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		int p = 1000;
		for(int i = 0; i < s.length(); i++) {
			if(t != s.charAt(i)) p++;
			else p = 0;
			answer[i] = p;
		}
		for(int i = s.length() - 1; i > -1; i--) {
			if(t != s.charAt(i)) {
				p++;
				answer[i] = Math.min(answer[i], p);
			} else p = 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		Section0110 s10 = new Section0110();
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		char t = kb.next().charAt(0);
		for(int i : s10.solution(s, t)) {
			System.out.print(i + " ");
		}
	}

}
