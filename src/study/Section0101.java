package study;

import java.util.Scanner;

public class Section0101 {

	public int solution(String str, char t) {
		int answer = 0;
		str = str.toUpperCase();
		t = Character.toUpperCase(t);
		for(char s : str.toCharArray()) {
			answer = t == s? ++answer : answer;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Section0101 s1 = new Section0101();
		Scanner kb = new Scanner(System.in);
	    String str = kb.nextLine();
	    char t = kb.nextLine().charAt(0);
	    
	    System.out.println(s1.solution(str, t));
	}

}
