package study.intro.section05;

import java.util.Scanner;
import java.util.Stack;

public class Section0504 {
	//Character.isDigit(c) : char형 c가 숫자인지 확인 숫자면 true
	// 아스키코드 char의 아스키코드 - 48 = 실 숫자 (즉, 숫자 0의 아스키코드는 48)
	public int solution(String str) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) stack.push(c - 48);
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(c == '+') stack.push(lt + rt);
				else if(c == '-') stack.push(lt - rt);
				else if(c == '*') stack.push(lt * rt);
				else if(c == '/') stack.push(lt/rt);
			}
		}
		answer = stack.get(0);
		return answer;
	}
	public static void main(String[] args) {
		Section0504 s5 = new Section0504();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.print(s5.solution(str));
	}

}
