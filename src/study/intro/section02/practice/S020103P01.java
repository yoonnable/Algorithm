package study.intro.section02.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S020103P01 {

	public static void main(String[] args) {
		problem01(); //큰 수 출력하기
		problem02(); //보이는 학생
		problem03(); //가위 바위 보
	}
	public char[] solution03(int n, int[][] arr) {
	  	char[] answer = new char[n];
	    //1:가위, 2:바위, 3:보
	    for(int i = 0; i < n; i++) {
	      	if(arr[0][i] == arr[1][i]) answer[i] = 'D';
	    	else if(arr[0][i] == 1 && arr[1][i] == 3) answer[i] = 'A';
	      	else if(arr[0][i] == 2 && arr[1][i] == 1) answer[i] = 'A';
	      	else if(arr[0][i] == 3 && arr[1][i] == 2) answer[i] = 'A';
	      	else answer[i] = 'B';
	    }
	    
	    return answer;
	}
	public static void problem03(){
	    S020103P01 m = new S020103P01();
	    Scanner in=new Scanner(System.in);
	    int n = in.nextInt();
	    int[][] arr = new int[2][n];
	    for(int i = 0; i < 2; i++) {
	    	for(int j = 0; j < n; j++) {
	        	arr[i][j] = in.nextInt();
	        }
	    }
	    for(char c : m.solution03(n, arr)) System.out.println(c);
	    return ;
	}
	
	public int solution02(int n, int[] arr) {
	  	int answer = 0, max = Integer.MIN_VALUE;
	    for(int i = 0; i < n; i++) {
	    	if(arr[i] > max) {
	          answer++;
	          max = arr[i];
	        }
	    }
	    return answer;
	}
	public static void problem02(){
		S020103P01 m = new S020103P01();
	    Scanner in=new Scanner(System.in);
	    int n = in.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0; i < n; i++) {
	    	arr[i] = in.nextInt();
	    }
	    System.out.println(m.solution02(n, arr));
	    return ;
	}
	
	public List<Integer> solution01(int n, int[] arr) {
	  	List<Integer> answer = new ArrayList<Integer>();
	    answer.add(arr[0]);
	    for(int i = 1; i < n; i++) {
	    	if(arr[i] > arr[i - 1]) answer.add(arr[i]);
	    }
	    
	    return answer;
	  }
	public static void problem01(){
		S020103P01 m = new S020103P01();
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();    
		}
		for(int i : m.solution01(n, arr)) System.out.print(i + " ");
	    return ;
	}

}
