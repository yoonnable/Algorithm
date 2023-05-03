package study.intro.section02;

import java.util.Scanner;

public class Section0202 {
	
	public int solution(int n, int[] arr) {
		int answer = 1, max = arr[0];
		
		for(int i = 1; i < n; i++) {
			if(arr[i] > max) {
				answer++;
				max = arr[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Section0202 s2 = new Section0202();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(s2.solution(n, arr));

	}

}
