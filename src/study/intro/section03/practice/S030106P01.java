package study.intro.section03.practice;

import java.util.*;
  
public class S030106P01 {
    public static void main(String[] args){
        // problem01(); // 두 배열 합치기
        // problem02(); //공통 원소 구하기
        // problem03(); //최대 매출
        // problem04(); //연속 부분수열
        // problem05(); // 연속된 자연수의 합
        problem06(); //최대 길이 연속 부분 수열
    }
    
    public int solution06(int n, int k, int[] arr) {
        int answer = 0, p1 = 0, p2 = 1, max = arr[0], cnt = 0;
        while(p2 < n) {
            if(arr[p2] == 0) {
                cnt++;
                while(cnt > k) {
                    if(arr[p1] == 0) cnt--;
                    max--;
                    p1++;
                }
            }
            p2++;
            max++;
            answer = Math.max(answer, max);
        }
        return answer;
    }

    public static void problem06() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s3.solution06(n, k, arr));
    }

    public int solution0502(int n) {
        int answer = 0, tmp = 1;
        for(int i = 2; tmp < n; i++) {
            tmp = tmp + i;
            if((n - tmp) % i == 0) answer++;
        }
        return answer;
    }

    public int solution0501(int n) {
        int answer = 0, sum = 0, p1 = 1;
        for(int i = 1; i <= n / 2 + 1; i++) {
            sum += i;
            while(sum > n) {
                sum -= p1;
                p1++;
            }
            if(sum == n) answer++;
        }
        return answer;
    }

    public static void problem05() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(s3.solution0501(n));
        System.out.print(s3.solution0502(n));
    }

    public int solution04(int n, int m, int[] arr) {
        int answer = 0, p1 = 0, p2 = 1, sum = arr[0];
        while(p1 < n && p2 < n) {
            if(sum == m) {
                answer++;
                sum -= arr[p1];
                p1++;
            } else if(sum < m) {
                sum += arr[p2];
                p2++;
            } else {
                sum -= arr[p1];
                p1++;
            }
        }
        while(p1 < n) {
            if(sum == m) {
                answer++;
                sum -= arr[p1];
                p1++;
            } else if(sum > m) {
                sum -= arr[p1];
                p1++;
            } else break;
        }
        return answer;
    }
    public static void problem04() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s3.solution04(n, m, arr));
    }

    public int solution03(int n, int k, int[] arr) {
        int answer, sum = 0;
        for(int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(sum, answer);
        }
        return answer;
    }

    public static void problem03() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s3.solution03(n, k, arr));
    }

    public List<Integer> solution02(int n, int[] a, int m, int[] b) {
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if(a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return answer;
    }

    public static void problem02() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }
        for(int i : s3.solution02(n, a, m, b)) System.out.print(i + " ");
    }

    public int[] solution01(int n, int[] a, int m, int[] b) {
        int[] answer = new int[n + m];
        int p1 = 0, p2 = 0, i = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] < b[p2]) {
                answer[i] = a[p1];
                p1++;
            } else {
                answer[i] = b[p2];
                p2++;
            }
            i++;
        }
        while(p1 < n) {
            answer[i] = a[p1];
            p1++;
            i++;
        }
        while(p2 < m) {
            answer[i] = b[p2];
            p2++;
            i++;
        }
        return answer;
    }
    public static void problem01() {
        S030106P01 s3 = new S030106P01();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = kb.nextInt();
        }
        for(int i : s3.solution01(n, a, m, b)) System.out.print(i + " ");
    }
}
