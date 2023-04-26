package study.intro.section01.practice;

import java.util.Scanner;

public class S010106P01 {
	public static void main(String[] args) {
//		problem01();
//		problem02();
//		problem03();
//		problem04();
//		problem05();
		problem06();// *****
	}
	
	//section1.6 *****
	public String solution06(String str) {
		String answer = "";
		for(int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
		}
		return answer;
	}
	
	public static void problem06() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(m.solution06(str));
		return;
	}
	
	//section1.5
	public String solution05(String str) {
		int lt = 0;
		int rt = str.length() - 1;
		char[] c = str.toCharArray();
		while(lt < rt) {
			if(!Character.isAlphabetic(c[lt])) lt++;
			else if(!Character.isAlphabetic(c[rt])) rt--;
			else {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
		}
		return String.valueOf(c);
	}
	
	public static void problem05() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(m.solution05(str));
		return;
	}
	
	//section1.4
	public String[] solution04(int n, String[] str) {
		String[] answer = new String[n];
		for(int i = 0; i < n; i++) {
			answer[i] = new StringBuilder(str[i]).reverse().toString();
		}
		
		return answer;
	}
	
	public static void problem04() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] str = new String[n];
		for(int i = 0; i < n; i++) {
			str[i] = kb.next();
		}
		for(String s : m.solution04(n, str)) {
			System.out.println(s);
		}
		return;
	}
	
	//section1.3
	public String solution03(String str) {
		String answer = "";
		for(String s : str.split(" ")) {
			if(answer.length() < s.length()) answer = s;
		}
		return answer;
	}
	
	public static void problem03() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(m.solution03(str));
		return;
	}
	
	//section1.2
	public String solution02(String str) {
		String answer = "";
		for(char c : str.toCharArray()) {
//			if(c > 96 && c < 123) answer += String.valueOf(Character.toUpperCase(c));
//			else answer += String.valueOf(Character.toLowerCase(c));
			
			if(Character.isLowerCase(c)) answer += String.valueOf(Character.toUpperCase(c));
			else answer += String.valueOf(Character.toLowerCase(c));
		}
		return answer;
	}
	
	public static void problem02() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(m.solution02(str));
		return ;
	}
	
	
	//section1.1
	public int solution01(String str, char t){
	    int answer = 0;
	    for(char c : str.toUpperCase().toCharArray()) {
	    	answer = c == Character.toUpperCase(t) ? ++answer : answer;
	    }
	    
	    return answer;
	}
	
	public static void problem01() {
		S010106P01 m = new S010106P01();
		Scanner kb = new Scanner(System.in);
	    String str = kb.next();
	    char t = kb.next().charAt(0);
	    
	    System.out.println(m.solution01(str, t));
	    return ;
	}
}
