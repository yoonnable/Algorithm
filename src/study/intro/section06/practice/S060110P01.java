package study.intro.section06.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class S060110P01 {
    public static void main(String[] args) {
        // problem01(); //선택 정렬
        // problem02(); //버블 정렬
        // problem03(); //삽입 정렬
        // problem04(); //Least Recently Used
        // problem05(); //중복 확인
        // problem06(); //장난꾸러기
//        problem07(); //좌표 정렬
//    	problem08(); //이분검색
//    	problem09(); //뮤직비디오(결정 알고리즘) *******************************
    	problem10(); //마구간 정하기(결정 알고리즘)
    }

    public int solution10(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1, rt = arr[n - 1] - arr[0];
        
        while(lt <= rt) {
        	int middle = (lt + rt) / 2;
        	int cnt = 1;
        	int x = arr[0];
        	for(int i = 1; i < n; i++) {
        		if(arr[i] - x < middle) {}
        		else {
        			cnt++;
        			x = arr[i];
        		}
        	}
        	if(cnt < m) rt = middle - 1;
        	else {
        		lt = middle + 1;
        		answer = middle;
        	}
        }
        
        
        return answer;
    }
    public static void problem10() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s6.solution10(n, m, arr));
    }
    
    public int count(int[] arr, int capacity) {
    	int size = 0; //DVD 한 장에 담는 사이즈
    	int cnt = 1; //DVD 장 수
    	for(int i : arr) {
    		if(size + i > capacity) { // 기준이 되는 용량보다 커지면 
    			cnt++; //DVD 장 수 증가
    			size = i; // 새로운 DVD에 지금 노래 크기로 초기화 해서 새로 담기 시작!
    		}
    		else size += i; //기준 값보다 작으면 계속 같은 DVD에 더해서 담아!
    	}
    	return cnt;
    }

    public int solution09(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); //stream 이용
        int rt = Arrays.stream(arr).sum(); //stream 이용
        while(lt <= rt) {
        	int middle = (lt + rt) / 2;
        	if(count(arr, middle) <= m) {
        		answer = middle;
        		rt = middle - 1;
        	} else {
        		lt = middle + 1;
        	}
        }
        
        return answer;
    }
    //lt부터 rt 사이에 정답이 무조건 있다!! 할 때 결정 알고리즘을 사용한다!! 
    public static void problem09() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution09(n, m, arr));
    }

    public int solution08(int n, int m, int[] arr) {
        int answer = 0, lt = 0, rt = n;
        Arrays.sort(arr);
        while(lt <= rt) {
        	int middle = (lt + rt) / 2;
        	if(arr[middle] == m) {
        		answer = middle + 1;
        		break;
        	}
        	else if(arr[middle] > m) rt = middle - 1;
        	else lt = middle + 1;
        }
        return answer;
    }
    public static void problem08() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s6.solution08(n, m, arr));
    }


    public static class Point implements Comparable<Point> {
        private int x;
        private int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
    public static void problem07() {
        Scanner kb = new Scanner(System.in);
        // S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        ArrayList<Point> plist = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            plist.add(new Point(x, y));
        }
        Collections.sort(plist);
        for(Point p : plist) System.out.println(p.x + " " + p.y);
    }

    public String solution06(int n, int[] arr) {
        String answer = "";
        int[] ori = new int[n];
        for(int i = 0; i < n; i++) ori[i] = arr[i];
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            if(arr[i] != ori[i]) answer += i + 1 + " "; 
        }
        return answer;
    }
    public static void problem06() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution06(n, arr));
    }

    public char solution05(int n, int[] arr) {
       char answer = 'U';
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j]) return 'D';
            }
        }
       return answer; 
    }
    public static void problem05() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s6.solution05(n, arr));
    }

    public int[] solution04(int s, int n, int[] arr) {
        int[] answer = new int[s];
        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            for(int j = 0; j < s; j++) {
                if(arr[i] != answer[j]) {
                    int next = answer[j];
                    answer[j] = tmp;
                    tmp = next;
                } else {
                    answer[j] = tmp;
                    break;
                }
            }
        }
        return answer;
    }
    public static void problem04() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution04(s, n, arr)) System.out.print(i + " ");
    }

    public int[] solution03(int n, int[] arr) {
        // 배열 첫번째 요소는 정렬이 되었다고 보고, 두번째 요소부터 본인 앞 요소들과 비교 시작
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i - 1; j >= 0; j--) {
                if(tmp < arr[j]) { // 비교 주체보다 앞 값들이 크면 한칸씩 뒤로 밀기
                    arr[j + 1] = arr[j];
                } else break; // 큰 값 없으면 그 앞으론 다 작은 값들 뿐이니 브레이크로 멈추기!!!
            }
            arr[j + 1] = tmp; //작은 값이 나온 index보다 한칸 뒤에 비교 주체 값 넣기
        }
        return arr;
    }
    public static void problem03() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution03(n, arr)) System.out.print(i + " ");
    }

    public int[] solution02(int n, int[] arr) {
        // 힌트 : 한 번의 반복이 끝나면, 가장 큰 원소가 배열의 마지막 위치로 이동
        for(int i = 0; i < n - 1; i++) { // 반복은 n - 1번 한다.
            for(int j = 0; j < n - i - 1; j++) { // 반복의 시작은 첫번째 원소부터 끝에서 하나씩 줄어듦
                // 반복을 할 때마다 맨 끝에 반복한 것들 중 가장 큰 값이 쌓임. 
                if(arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void problem02() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution02(n, arr)) System.out.print(i + " ");
    }

    public int[] solution01(int n, int[] arr) {
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
    public static void problem01() {
        Scanner kb = new Scanner(System.in);
        S060110P01 s6 = new S060110P01();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution01(n, arr)) System.out.print(i + " ");
    }
}