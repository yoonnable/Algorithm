package study.intro.section01;

import java.util.Scanner;

public class Section0105 {
	
	//*Character.isAlphabetic()
	public String solution(String str) {
		String answer = "";
		char[] c = str.toCharArray();
		int lt = 0, rt = c.length - 1;
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
		answer = String.valueOf(c);
		return answer;
	}

	public static void main(String[] args) {
		Section0105 s5 = new Section0105();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(s5.solution(str));
	}

}
