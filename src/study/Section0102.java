package study;

import java.util.Scanner;

public class Section0102 {
	
	public String solution(String str){
	    String answer = "";
	  	for(char c : str.toCharArray()) {
	    	answer += c > 64 && c < 91 ? (char)(c+32) : (char)(c-32); 
	    }
	    return answer;
	  }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String str = in.nextLine();
	    
	    Section0102 s1 = new Section0102();
	    System.out.println(s1.solution(str));
	    return ;

	}

}
