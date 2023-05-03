package study.intro.section02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Section0201 {
	
	public List<Integer> solution(int n, int[] arr) {
		List<Integer> answer = new ArrayList<Integer>();
		answer.add(arr[0]);
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i - 1]) answer.add(arr[i]);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Section0201 s2 = new Section0201();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		for(Integer i : s2.solution(n, arr)) {
			System.out.print(i + " ");
		}

	}

}
