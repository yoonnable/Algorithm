package study.intro.section01;

import java.util.Scanner;

public class Section0107 {
	
	//char ���
	public String solution1(String str) {
		str = str.toLowerCase();
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return "NO";
		}
		return "YES";
	}
	
	// StringBuilder ��� *equalsIgnoreCase()
	public String solution2(String str) {
		String tmp = new StringBuilder(str).reverse().toString();
		if(!str.equalsIgnoreCase(tmp)) return "NO";
		return "YES";
	}

	public static void main(String[] args) {
		Section0107 s7 = new Section0107();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println("char ���" + s7.solution1(str));
		System.out.println("StringBuilder ��� *equalsIgnoreCase()" + s7.solution2(str));
	}

}
