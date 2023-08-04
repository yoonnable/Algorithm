package study.intro.section06.practice;

import java.util.*;

class S060110P02 {
    public static void main(String[] args) {
        // problem01(); //선택정렬
        // problem02(); //버블정렬
        // problem03(); //삽입정렬
        // problem04(); //Least recently used
        // problem05(); //중복 확인
        // problem06(); //장난꾸러기
        // problem07(); //좌표 정렬
        // problem08(); //이분 검색 : 범위를 반으로 줄여가며 찾아가는 방법
        // problem09(); //뮤직비디오
        problem10(); //마구간 정하기

    }

    public int solution10(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 마구간 사이의 거리 최소부터 최대까지
        int lt = 1, rt = arr[n - 1];
        while(lt <= rt) {
            int middle = (lt + rt) / 2;
            int before = arr[0], cnt = 1;
            for(int i = 1; i < n; i++) {
                if(arr[i] - before >= middle) {
                    cnt++;
                    before = arr[i];
                }
            }
            if(cnt >= c) {
                answer = middle;
                lt = middle + 1;
            } else rt = middle - 1;
        }
        return answer;
    }
    public static void problem10() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution10(n, c, arr));
    }

    public int solution09(int n, int m, int[] arr) {
        int answer = 0, lt = 1, rt = 10000;
        // 곡의 길이 최소부터 최대까지
        while(lt <= rt) {
            int middle = (lt + rt) / 2;
            int sum = 0, cnt = 1;
            for(int i : arr) {
                if(sum + i > middle) {
                    cnt++;
                    sum = i;
                    if(cnt > m) {
                        lt = middle + 1;
                        break;
                    }
                } else sum += i;
            }
            if(cnt <= m) {
                answer = middle;
                rt = middle - 1;
            }
        }
        return answer;
    }
    public static void problem09() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution09(n, m, arr));
    }

    public int solution08(int n, int m, int[] arr) {
        int answer = 0, lt = 0, rt = n;
        Arrays.sort(arr);
        // for(int i : arr) System.out.print(i + " > ");
        while(lt <= rt) {
            // System.out.println(lt);
            // System.out.println(rt);
            // System.out.println(" ");
            // 이분 검색 : 범위를 반으로 좁혀가며 검색
            int middle = (lt + rt) / 2; // lt와 rt 사이의 반 값!
            if(m == arr[middle]) return middle + 1;
            if(m < arr[middle]) rt = middle - 1;
            else lt = middle + 1;
        }
        return answer;
    }
    public static void problem08() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution08(n, m, arr));
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            if(this.x == o.x) return this.y - o.y; // x가 같은 값이면 y 오름차순 정렬
            // this.y >= o.y 일 경우 : 0 이상의 양수 반환 => 양수이므로 둘이 배열 바꿈
            // this.y < o.y 일 경우 : -1 이하의 음수 반환 => 음수 이므로 배열 그대로 유지
            else return this.x - o.x; // x가 다르면 x 오름차순으로 !
        }

    }
    public ArrayList<Point> solution07(int n, int[][] arr) {
        ArrayList<Point> answer = new ArrayList<>();
        
        // 먼저 이중배열 to Point 객체 리스트 로 담기
        for(int i = 0; i < n; i++) answer.add(new Point(arr[i][0], arr[i][1]));

        // 리스트 재배열
        Collections.sort(answer);
        return answer;
    }
    public static void problem07() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) arr[i][j] = kb.nextInt();
        }
        for(Point p : s6.solution07(n, arr)) System.out.println(p.x + " " + p.y);
    }

    public ArrayList<Integer> solution06(int n, int[] h) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] a = h.clone();
        Arrays.sort(h);
        for(int i = 0; i < n; i++) {
            if(h[i] != a[i]) answer.add(i + 1);
        }
        return answer;
    }
    public static void problem06() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] h = new int[n];
        for(int i = 0; i < n; i++) h[i] = kb.nextInt();
        for(int i : s6.solution06(n, h)) System.out.print(i + " ");
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
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s6.solution05(n, arr));
    }

    public int[] solution04(int s, int n, int[] arr) {
        int[] answer = new int[s];
        int i = 0;
        while(i < n) {
            int tmp = arr[i];
            for(int j = 0; j < s; j++) {
                if(answer[j] == arr[i]) {
                    answer[j] = tmp;
                    break;
                } else {
                    int sub = tmp;
                    tmp = answer[j];
                    answer[j] = sub;
                }
            }
            i++;
        }
        return answer;
    }
    public static void problem04() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution04(s, n, arr)) System.out.print(i + " ");
    }

    public int[] solution03(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i];
            for(int j = 0; j < i; j++) {
                if(tmp < arr[j]) {
                    int sub = tmp;
                    tmp = arr[j];
                    arr[j] = sub;
                }
            }
            arr[i] = tmp;
        }

        return arr;
    }
    public static void problem03() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution03(n, arr)) System.out.print(i + " ");
    }

    public int[] solution02(int n, int[] arr) {
        while(n > 0) {
            for(int i = 0; i < n - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
            n--;
        }
        return arr;
    }
    public static void problem02() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution02(n, arr)) System.out.print(i + " ");
    }

    public int[] solution01(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            int tmp = arr[i], k = i;
            for(int j = i + 1; j < n; j++) {
                if(tmp > arr[j]) {
                    tmp = arr[j];
                    k = j;
                }
            }
            arr[k] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }
    public static void problem01() {
        S060110P02 s6 = new S060110P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        for(int i : s6.solution01(n, arr)) System.out.print(i + " ");
    }
}
