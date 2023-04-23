package study.intro.section01;

import java.util.Scanner;

public class Section0109 {
	// 아스키코드 숫자 0~9 : 48~57
	public int solution1(String str) {
		int answer = 0;
		for(char c : str.toCharArray()) {
			if(c > 47 && c < 58) answer = answer * 10 + (c - 48);
		}
		return answer;
	}
	
	// Character.isDigit() -> String to int
	public int solution2(String str) {
		int answer = 0;
		String tmp = "";
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) tmp += c;
		}
		answer = Integer.parseInt(tmp);
		return answer;
	}

	public static void main(String[] args) {
		Section0109 s9 = new Section0109();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println("아스키코드 숫자 0~9 : 48~57                   " + s9.solution1(str));
		System.out.println("Character.isDigit() -> String to int     " + s9.solution1(str));
	}

}
