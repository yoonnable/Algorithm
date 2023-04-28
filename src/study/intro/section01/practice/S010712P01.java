package study.intro.section01.practice;

import java.util.Scanner;

public class S010712P01 {
	public static void main(String[] args) {
//		problem07();
//		problem08();
//		problem09();
//		problem10();
//		problem11();
		problem12();
	}
	
	//section1.12 *****2진수 to 10진수
	public String solution12(int n, String str) {
		String answer = "";
		str = str.replace("#", "1").replace("*", "0");
		for(int i = 0; i < n; i++) {
			answer += (char)Integer.parseInt(str.substring(i * 7, i * 7 + 7), 2);
		}
		return answer;
	}
	
	public static void problem12() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String s = kb.next();
		System.out.println(m.solution12(n, s));
		return;
	}
	
	//section1.11
	public String solution11(String str) {
		String answer = "";
		str += " ";
		int n = 1;
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) n++;
			else {
				answer += n > 1 ? str.charAt(i) + String.valueOf(n) : str.charAt(i);
				n = 1;
			}
		}
		return answer;
	}
	
	public static void problem11() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		System.out.println(m.solution11(s));
		return;
	}
	
	//section1.10
	public int[] solution10(String str, char t) {
		int[] answer = new int[str.length()];
		int n = 1000;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == t) n = 0;
			else n++;
			answer[i] = n;
		}
		for(int i = str.length() - 1; i > - 1; i--) {
			if(str.charAt(i) == t) n = 0;
			else {
				n++;
				if(answer[i] > n) answer[i] = n;
			}
		}
		return answer;
	}
	
	public static void problem10() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		String s = kb.next();
		char t = kb.next().charAt(0);
		for(int i : m.solution10(s, t)) {
			System.out.print(i + " ");
		}
		return;
	}
	
	//section1.9 *****(char to int)
	public int solution09(String str) {
		int answer = 0;
		for(char c : str.toCharArray()) {
//			if(Character.isDigit(c)) answer = answer * 10 + (int)c - '0';
			if(Character.isDigit(c)) answer = answer * 10 + Character.getNumericValue(c);
		}
		return answer;
	}
	
	public static void problem09() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(m.solution09(str));
		return;
	}
	
	//section1.8
	public String solution08(String str) {
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return "NO";
		}
		return "YES";
	}
	
	public static void problem08() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(m.solution08(str));
		return;
	}
	
	//section1.7
	public String solution07(String str) {
		for(int i = 0; i < str.length() / 2; i++) {
			if(Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(str.charAt(str.length() - 1 - i))) return "NO";
		}
		return "YES";
	}
	
	public static void problem07() {
		S010712P01 m = new S010712P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(m.solution07(str));
		return;
	}
}
