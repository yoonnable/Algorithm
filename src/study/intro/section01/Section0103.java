package study.intro.section01;

import java.util.Scanner;

public class Section0103 {
	// split 规侥
	public String solution1(String str) {
		String answer = "";
		String[] pos = str.split(" ");
		for(String tem : pos) {
			if(answer.length() < tem.length()) {
				answer = tem;
			}
		}
		
		return answer;
	}
	
	//indexOf + substring 规侥
	public String solution2(String str) {
		String answer = "";
		while(str.indexOf(" ") != -1) {
			if(answer.length() < (str.substring(0, str.indexOf(" "))).length()) answer = str.substring(0, str.indexOf(" "));
			str = str.substring(str.indexOf(" ") + 1);
		}
		if(str.indexOf(" ") == -1) {
			answer = answer.length() < str.length() ? str : answer;
		}
		
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		Section0103 s3 = new Section0103();
		System.out.println("split 规侥 : " + s3.solution1(str));
		System.out.println("indexOf + substring 规侥 : " + s3.solution2(str));
	}

}
