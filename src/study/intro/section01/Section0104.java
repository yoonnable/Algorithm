package study.intro.section01;

import java.util.ArrayList;
import java.util.Scanner;

public class Section0104 {
	//StringBuilder
	public ArrayList<String> solution1(String[] str) {
		ArrayList<String> answer = new ArrayList<String>();
		for(String s : str) {
			answer.add(new StringBuilder(s).reverse().toString());
		}
		return answer;
	}
	
	//��Į�ڸ��� ��Ÿ�Ϸ� ������  *String.valueOf()
	public ArrayList<String> solution2(String[] str) {
		ArrayList<String> answer = new ArrayList<String>();
		for(String s : str) {
			char[] c = s.toCharArray();
			int lt = 0, rt = s.length() - 1;
			while(lt < rt) {
				char tmp = c[lt];
				c[lt] = c[rt];
				c[rt] = tmp;
				lt++;
				rt--;
			}
			String a = String.valueOf(c);
			answer.add(a);
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Section0104 s4 = new Section0104();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] str = new String[n];
		for(int i=0; i < n; i++) {
			str[i] = kb.next();
		}
		
		System.out.println("StringBuilder ���");
		for(String s : s4.solution1(str)) {
			System.out.println(s);
		}
		
		System.out.println("��Į�ڸ��� ��Ÿ�Ϸ� ������  *String.valueOf() ���");
		for(String s : s4.solution2(str)) {
			System.out.println(s);
		}
	}

}
