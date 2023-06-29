package study.intro.section04.practice;

import java.util.*;

public class S040105P01 {
    public static void main(String[] args) {
        // problem01(); //학급회장
        // problem02(); //Anagram
        // problem03(); //매출액의 종류
        // problem04(); //모든 아나그램 찾기
        problem05(); //K번째 큰 수
    }

    public int solution05(int n, int k, int[] arr) {//***********************************
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        // System.out.println(set);
        int cnt = 0;
        for(int i : set) {
            cnt++;
            if(cnt == k) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void problem05() {
        Scanner kb = new Scanner(System.in);
        S040105P01 s4 = new S040105P01();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(s4.solution05(n, k, arr));
    }

    public int solution04(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length() - 1; i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
        }
        int lt = 0;
        for(int rt = t.length() - 1; rt < s.length(); rt++) {
            map2.put(s.charAt(rt), map2.getOrDefault(s.charAt(rt), 0) + 1);
            if(map.equals(map2)) answer++;
            map2.put(s.charAt(lt), map2.get(s.charAt(lt)) - 1);
            if(map2.get(s.charAt(lt)) == 0) map2.remove(s.charAt(lt));
            lt++;
        }
        
        return answer;
    }

    public static void problem04() {
        Scanner kb = new Scanner(System.in);
        S040105P01 s4 = new S040105P01();
        String a = kb.next();
        String b = kb.next();
        System.out.print(s4.solution04(a, b));
    }

    public ArrayList<Integer> solution03(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());
        int lt = 0;
        for(int rt = k; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            answer.add(map.size());
            lt++;
        }
        return answer;
    }

    public static void problem03() {
        Scanner kb = new Scanner(System.in);
        S040105P01 s4 = new S040105P01();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for(int i : s4.solution03(n, k, arr)) System.out.print(i + " ");
    }

    public String solution02(String a, String b) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : b.toCharArray()) {
            if(map.containsKey(c)) {
                if(map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                }
            } else return "NO";
        }
        return answer;
    }

    public static void problem02() {
        Scanner kb = new Scanner(System.in);
        S040105P01 s4 = new S040105P01();
        String a = kb.next();
        String b = kb.next();
        System.out.println(s4.solution02(a, b));
    }

    public char solution01(int n, String str) {
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > max) {
                answer = c;
                max = map.get(c);
            }
        }
        return answer;
    }

    public static void problem01() {
        Scanner kb = new Scanner(System.in);
        S040105P01 s4 = new S040105P01();
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(s4.solution01(n, str));
    }
}
