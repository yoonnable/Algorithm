package study.intro.section06;

import java.util.Scanner;

public class Section0601 {
	public int[] solution(int n, int[] arr) {
		for(int i = 0; i < n - 1; i++) {
			int idx = i;
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[idx]) idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Section0601 s6 = new Section0601();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		for(int i : s6.solution(n, arr)) System.out.print(i + " ");
	}

}
