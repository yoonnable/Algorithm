package study.intro.section02.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S020412P01 {

	public static void main(String[] args) {
		// problem04(); //피보나치 수열
		// problem05(); //소수(에라토스테네스 체)
		// problem06(); //뒤집은 소수
		// problem07(); //점수계산
		// problem08(); //등수 구하기
		// problem09(); //격자판 최대합
		// problem10(); //봉우리
		// problem11(); //임시반장 정하기
		problem12(); //멘토링
		// ex();
	}

	public static void ex() {
		for(int i = 0; i < 4; i++) {
			System.out.println("iiii " + i);
			for(int j = 0; j < 6; j++) {
				System.out.println("jjjj " + j);
			}
			if(i == 3) break;
		}
	}

	// *****
	public int solution12(int n, int m, int[][] arr) {
		int answer = 0;
		for(int i = 1; i < n + 1; i++) { // 멘토 i
			for(int j = 1; j < n + 1; j++) { // 멘티 j
				boolean flag = true;
				for(int k = 0; k < m; k++) { // k시험
					int is = 0, js = 0;
					for(int s = 0; s < n; s++) { // s등수
						if(arr[k][s] == i) is = s; //k시험의 s등이 i면, i의 등수 s를 is에 저장
						if(arr[k][s] == j) js = s; //k시험의 s등이 j면, j의 등수 s를 js에 저장
					}
					// System.out.println(k + "시험");
					// System.out.println("i =>" + i + " 등수 " + is);
					// System.out.println("j =>" + j + " 등수 " + js);
					if(is >= js) {
						// System.out.println("i " + i + "가 j " + j + "의 멘토 못함");
						flag = false; // 멘토가 될 i의 등수가 멘티가 될 j의 등수보다 같거나 낮으면(숫자는 크면) false
						break;
					}
				}
				if(flag) {
					answer++;
					// System.out.println(answer + "true i" + i + "가 j " + j + "의 멘토 함");
				}
			}
		}

		return answer;
	}

	public static void problem12() {
		Scanner kb = new Scanner(System.in);
		S020412P01 s2 = new S020412P01();
		int n = kb.nextInt(); // 학생 수
		int m = kb.nextInt(); // 시험 수
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = kb.nextInt(); //등 수 순으로 학생 번호 입력(다음 시험은 엔터로 구분)
			}
		}
		System.out.println(s2.solution12(n, m, arr));
	}

	public int solution11(int n, int[][] arr) {
		int answer = 0, max = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			int cnt = 0;
			for(int j = 1; j <= n; j++) {
				if(i != j) {
					for(int k = 0; k < 5; k++) {
						if(arr[i][k] == arr[j][k]) {
							cnt++;
							break;
						}
					}
				}
			}
			if(max < cnt) {
				answer = i;
				max = cnt;
			}
		}
		return answer;
	}

	public static void problem11(){
		Scanner kb = new Scanner(System.in);
		S020412P01 s2 = new S020412P01();
		int n = kb.nextInt();
		int[][] arr = new int[n + 1][5];
		for(int i = 1; i <= n; i++) { // 학생 돌리기
			for(int j = 0; j < 5; j++) { // 학년 돌리기
				arr[i][j] = kb.nextInt();
			}
		}
		System.out.println(s2.solution11(n, arr));
	}

	public int solution10(int n, int[][] arr) {
        int answer = 0;
        //x,y가 봉우리인지 확인하려면
        //(x-1, y)(x,y-1),(x+1, y),(x,y+1)이 x,y보다 작은지를 확인해야함
        //근데, (0,y),(x,0),(n,y),(x,n)이때는 옆에 다 0으로 되어있다고 함
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i][j-1] && arr[i][j] > arr[i+1][j] && arr[i][j] > arr[i][j+1]) answer++;
            }
        }
        return answer;
    }
	public static void problem10(){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n + 2][n + 2];
		for(int i = 1; i < n + 1; i++) {
		for(int j = 1; j < n + 1; j++) {
			arr[i][j] = in.nextInt();
		}
		}
		S020412P01 m = new S020412P01();
		System.out.print(m.solution10(n, arr));
		return ;
	}

	public int solution09(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE, xy = 0, yx = 0;
        for(int i = 0; i < n; i++) {
            int xp = 0, yp = 0;
            for(int j = 0; j < n; j++) {
                xp += arr[i][j];
                yp += arr[j][i];
            }
            if(xp > answer) answer = xp;
            if(yp > answer) answer = yp;
            xy += arr[i][i];
            yx += arr[i][n - i - 1];
        }
        if(xy > answer) answer = xy;
        if(yx > answer) answer = yx;
        return answer;
    }
	public static void problem09(){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			arr[i][j] = in.nextInt();
		}
		}
		S020412P01 m = new S020412P01();
		System.out.print(m.solution09(n, arr));
		return ;
	}

	public int[] solution08(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
	public static void problem08(){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
		arr[i] = in.nextInt();
		}
		S020412P01 m = new S020412P01();
		for(int i : m.solution08(n, arr)) System.out.print(i + " ");
		return ;
	}

	public int solution07(int n, int[] arr) {
		int answer = 0, cnt = 0;
		for(int i = 0; i < n; i++) {
		  if(arr[i] == 1) cnt++;
		  else cnt = 0;
		  answer += cnt;
		}
		return answer;
	}
		
	public static void problem07(){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
		  arr[i] = in.nextInt();
		}
		S020412P01 m = new S020412P01();
		System.out.println(m.solution07(n, arr));
		return ;
	}

	public boolean solution0602(int a) {
		boolean answer = true;
		if(a == 1) answer = false;
		for(int i = 2; i < a; i++) {
			if(a%i == 0) {
				answer = false;
				break;
			}
		}
		return answer;
	}
	public List<Integer> solution06(int n, int[] arr) {
		List<Integer> answer = new ArrayList<Integer>();
		S020412P01 m = new S020412P01();
		for(int i= 0; i < n; i++) {
			int j = 0, k = arr[i];
			while(k > 0) {
				j = j * 10 + k % 10;
				k = k / 10;
			}
			if(m.solution0602(j)) answer.add(j);
		}
		return answer;
	}
	public static void problem06(){
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
		  arr[i] = in.nextInt();
		}
		S020412P01 m = new S020412P01();
		for(int i : m.solution06(n, arr)) System.out.print(i + " ");
		return ;
	}

	public int solution05(int n) {
		int answer = 0;
	  int[] arr = new int[n + 1];
	  for(int i = 2; i < n + 1; i++) {
		  if(arr[i] == 0) {
			answer++;
			for(int j = i; j < n + 1; j = j + i) {
				arr[j] = 1;
			}
		  }
	  }
	  return answer;
	}
	public static void problem05(){
		S020412P01 m = new S020412P01();
		Scanner in=new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(m.solution05(n));
	  return ;
	}

	public int[] solution04(int n) {
        int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		for(int i = 2; i < n; i++) {
			answer[i] = answer[i - 2] + answer[i - 1];
		}
		
		return answer;
    }
    
    public static void problem04(){
        S020412P01 m = new S020412P01();
      	Scanner in=new Scanner(System.in);
      	int n = in.nextInt();
		for(int i : m.solution04(n)) System.out.print(i + " ");
		return ;
    }





}