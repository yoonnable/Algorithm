 package study.intro.section03.practice;

import java.util.*;

public class S030106P02 {
    public static void main(String[] args) {
        // problem01(); //두 배열 합치기
        // problem02(); // 공통 원소 구하기
        // problem03(); // 최대 매출
        // problem04(); // 연속 부분수열
        // problem05(); //연속된 자연수의 합
        problem06(); // 최대 길이 연속 부분수열
    }

    public int solution06(int n, int k, int[] arr) {
        int answer = 0, lt = 0, rt = 0, cnt = 0, used = 0;
        while(rt < n) {
            if(arr[rt] == 1) cnt++;
            else {
            	if(used >= k) {
            		while(arr[lt] != 0) {
            			cnt--;
            			lt++;
            		}
            		used--;
            		cnt--;
            		lt++;
            	}
            	used++;
            	cnt++;
            }
            if(answer < cnt) answer = cnt;
            rt++;
        }
        return answer;
    }
    public static void problem06() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.print(s3.solution06(n, k, arr));
    }

    public int solution05(int n) {
        int answer = 0, k = 1, i = 2;
        while(k < n) {
            if((n - k) % i == 0) answer++;
            k += i++;
        }
        
        return answer;
    }
    public static void problem05() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(s3.solution05(n));
    }

    public int solution04(int n, int m, int[] arr) {
        int answer = 0, lp = 0, rp = 1, sum = arr[0];
        while(rp < n) {
            if(sum < m) sum += arr[rp++];
            else {
                if(sum == m) answer++;
                sum -= arr[lp++];
            }
        }
        while(lp < n) {
            if(sum == m) {
                answer++;
                break;
            }else if(sum < m) break;
            else {
                sum -= arr[lp];
                lp++;
            }
        } 
        return answer;
    }
    public static void problem04() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s3.solution04(n, m, arr));
    }

    public int solution03(int n, int k, int[] arr) {
        int sum = 0, i;
        for(i = 0; i < k; i++) sum += arr[i];
        int answer = sum;
        while(i < n) {
            sum += arr[i] - arr[i - k];
            answer = Integer.max(answer, sum);
            i++;
        }
        return answer;
    }
    public static void problem03() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = kb.nextInt();
        System.out.println(s3.solution03(n, k, arr));
    }

    public ArrayList<Integer> solution02(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int ap = 0, bp = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(ap < n && bp < m) {
            if(a[ap] == b[bp]) {
                answer.add(a[ap]);
                ap++;
                bp++;
            } else if(a[ap] < b[bp]) ap++;
            else bp++;
        }
        return answer;
    }
    public static void problem02() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = kb.nextInt();
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) b[i] = kb.nextInt();
        for(int i : s3.solution02(n, m, a, b)) System.out.print(i + " ");
    }

    public int[] solution01(int n, int m, int[] a, int[] b) {
        int[] answer = new int[n + m];
        int i = 0, j = 0, k = 0;
        while(i < n && j < m) {
            if(a[i] < b[j]) {
                answer[k] = a[i];
                i++;
            } else {
                answer[k] = b[j];
                j++;
            }
            k++;
        }
        if(i < n) {
            for(int z = i; z < n; z++) {
                answer[k] = a[z];
                k++;
            }
        }
        if(j < m) {
            for(int z = j; z < m; z++) {
                answer[k] = b[z];
                k++;
            }
        }
        return answer;
    }
    public static void problem01() {
        S030106P02 s3 = new S030106P02();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = kb.nextInt();
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) b[i] = kb.nextInt();
        for(int i : s3.solution01(n, m, a, b)) System.out.print(i + " ");
    }
}