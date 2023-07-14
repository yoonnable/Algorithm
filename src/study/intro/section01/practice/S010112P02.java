package study.intro.section01.practice;
import java.util.*;

public class S010112P02 {
    public static void main(String[] args) {
        // problem01(); //문자열 찾기
        // problem02(); //대소문자 변환
        // problem03(); //문장 속 단어
        // problem04(); //단어 뒤집기
        // problem05(); //특정 문자 뒤집기
        // problem06(); //중복 문자 제거
        // problem07(); //회문 문자열
        // problem08(); //유효한 팰린드롬
        // problem09(); //숫자만 추출
        // problem10(); //가장 짧은 문자거리
        // problem11(); //문자열 압축
        problem12(); //암호
    }

    public String solution12(int n, String s) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            answer += (char)Integer.parseInt(s.substring(0, 7).replace("#", "1").replace("*", "0"),2);
            s = s.substring(7);
        }
        return answer;
    }
    public static void problem12() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        int n = kb.nextInt();
        String s = kb.next();
        System.out.print(s1.solution12(n, s));
    }

    public String solution11(String str) {
        String answer = Character.toString(str.charAt(0));
        int sum = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)) sum++;
            else {
                if(sum == 1) answer += Character.toString(str.charAt(i));
                else {
                    answer += sum + Character.toString(str.charAt(i));
                    sum = 1;
                }
            }
        }
        if(sum != 1) answer += sum;
        return answer;
    }
    public static void problem11() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.next();
        System.out.println(s1.solution11(str));
    }

    public int[] solution10(String s, char t) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) answer[i] = 0;
            else {
                if(i > 0) answer[i] = answer[i - 1] + 1;
                else answer[i] = 100;
            }
        }
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) != t) {
                if(answer[i] > answer[i + 1] + 1) answer[i] = answer[i + 1] + 1;
            }
        }
        return answer;
    }
    public static void problem10() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String s = kb.next();
        char t = kb.next().charAt(0);
        for(int i : s1.solution10(s, t)) System.out.print(i + " ");
    }

    public int solution09(String str) {
        int answer = 0;
        for(char c : str.toCharArray()) {
            if(Character.isDigit(c)) {
                answer = answer * 10 + (int)c - 48;
            }
        }
        return answer;
    }
    public static void problem09() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.next();
        System.out.print(s1.solution09(str));
    }

    public String solution08(String str) {
        String answer = "YES";
        String s = "";
        for(char c : str.toLowerCase().toCharArray()) {
            if(Character.isAlphabetic(c)) s += c;
        }
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                answer = "NO";
                break;
            }
        }
        return answer;
    }
    public static void problem08() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.nextLine();
        System.out.println(s1.solution08(str));
    }

    public String solution07(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        for(int i = 0; i < str.length() / 2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                answer = "NO";
                break;
            }
        }
        return answer;
    }
    public static void problem07() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.next();
        System.out.print(s1.solution07(str));
    }

    public String solution06(String str) {
        String answer = "";
        for(char c : str.toCharArray()) {
            if(answer.indexOf(c) == -1) answer += c;
        }
        return answer;
    }
    public static void problem06() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.next();
        System.out.print(s1.solution06(str));
    }

    public String solution05(String str) {
        String answer = "";
        char[] c = str.toCharArray();
        int rp, lp = str.length() - 1;
        for(rp = 0; rp < lp; rp++) {
            if(Character.isAlphabetic(c[rp])) {
                char tmp = c[rp];
                while(!Character.isAlphabetic(c[lp])) lp--;
                c[rp] = c[lp];
                c[lp] = tmp;
                lp--;
            }
        }
        for(char x : c) answer += x;
        return answer;
    }
    public static void problem05() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.nextLine();
        System.out.print(s1.solution05(str));
    }

    public String[] solution04(int n, String[] arr) {
        String[] answer = new String[n];
        int i = 0;
        for(String s : arr) {
            answer[i] = new StringBuffer(s).reverse().toString();
            i++;
        }
        return answer;
    }
    public static void problem04() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        int n = kb.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.next();
        }
        for(String s : s1.solution04(n, arr)) System.out.println(s);
    }

    public String solution03(String str) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        
        for(String s : str.split(" ")) {
            if(max < s.length()) {
                answer = s;
                max = s.length();
            }
        }
        return answer;
    }
    public static void problem03() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String str = kb.nextLine(); // *****
        System.out.println(s1.solution03(str));
    }

    public String solution02(String s) {
        String answer = "";
        // 아스키코드 대문자 A = 65, Z = 90 / 소문자 a = 97, z = 122
        for(char c : s.toCharArray()) {
            if(c > 64 && c < 91) answer += Character.toLowerCase(c);
            else answer += Character.toUpperCase(c);
        }
        return answer;
    }
    public static void problem02() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String s = kb.next();
        System.out.print(s1.solution02(s));
    }

    public int solution01(String s, char c) {
        int answer = 0;
        s = s.toLowerCase();
        c = Character.toLowerCase(c);
        for(char x : s.toCharArray()) {
            if(x == c) answer++;
        }
        return answer;
    }
    public static void problem01() {
        Scanner kb = new Scanner(System.in);
        S010112P02 s1 = new S010112P02();
        String s = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(s1.solution01(s, c));
    }
}