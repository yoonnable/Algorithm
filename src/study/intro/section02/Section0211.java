package study.intro.section02;

import java.util.Scanner;

public class Section0211 {
	
	public int solution(int n, int[][] arr) {
		int answer = 0, max = Integer.MIN_VALUE;
		for(int i = 1; i < n + 1; i++) {
			int cnt = 0;
			for(int j = 1; j < n + 1; j++) {
				for(int k = 1; k < 6; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if(cnt > max) {
				answer = i;
				max = cnt;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Section0211 m = new Section0211();
		Scanner sb = new Scanner(System.in);
		int n = sb.nextInt();
		int[][] arr = new int[n + 1][6];
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < 6; j++) {
				arr[i][j] = sb.nextInt();
			}
		}
		System.out.println(m.solution(n, arr));

	}

}
