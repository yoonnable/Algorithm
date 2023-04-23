package study.intro.section01;

import java.util.Scanner;

public class Section0111 {
	
	// 맨 뒤 문자 하나 더 넣기
	public String solution(String str) {
		String answer = "";
		str += " ";
		int cint = 1;
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) cint++;
			else {
				answer += str.charAt(i);
				if(cint != 1) answer += cint;
				cint = 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Section0111 s11 = new Section0111();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(s11.solution(str));
	}
}
