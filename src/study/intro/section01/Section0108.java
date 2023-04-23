package study.intro.section01;

import java.util.Scanner;

public class Section0108 {
	
	// replaceAll + Á¤±Ô½Ä
	public String solution(String str) {
		str = str.toLowerCase().replaceAll("[^a-z]", "");
		String tmp = new StringBuilder(str).reverse().toString();
		if(str.equals(tmp)) return "YES";
		return "NO";
	}

	public static void main(String[] args) {
		Section0108 s8 = new Section0108();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(s8.solution(str));
	}

}
