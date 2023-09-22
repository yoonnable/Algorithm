package study.intro.section04.practice;

import java.util.*;

class S040105P02 {
    public static void main(String[] args) {
        // problem01(); //학급회장(해쉬)
        // problem02(); //아나그램(해쉬)
        // problem03(); //매출액의 종류
        // problem04(); //모든 아나그램 찾기
        problem05(); //k번째 큰수
    }

    public int solution05(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    set.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int i : set) {
            cnt++;
            if(cnt == k) {
                return i;
            }
        }

        return answer;
    }
    public static void problem05() {
        Scanner kb = new Scanner(System.in);
        S040105P02 s4 = new S040105P02();
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(s4.solution05(n, k, arr));
    }

    public int solution04(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> ana = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            ana.put(s.charAt(i), ana.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(map.equals(ana)) answer++;
        for(int i = t.length(); i < s.length(); i++) {
            ana.put(s.charAt(i - t.length()), ana.get(s.charAt(i - t.length())) - 1);
            if(ana.get(s.charAt(i - t.length())) == 0) ana.remove(s.charAt(i - t.length()));
            ana.put(s.charAt(i), ana.getOrDefault(s.charAt(i), 0) + 1);
            if(map.equals(ana)) answer++;
        }
        return answer;
    }
    public static void problem04() {
        Scanner kb = new Scanner(System.in);
        S040105P02 s4 = new S040105P02();
        String s = kb.nextLine();
        String t = kb.nextLine();
        System.out.println(s4.solution04(s, t));
    }

    public ArrayList<Integer> solution03(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());
        for(int i = k; i < n; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if(map.get(arr[i - k]) == 0) map.remove(arr[i - k]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());
        }
        return answer;
    }
    public static void problem03() {
        Scanner kb = new Scanner(System.in);
        S040105P02 s4 = new S040105P02();
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
        char[] ac = a.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] bc = b.toCharArray();
        for(int i = 0; i < ac.length; i++) {
            map.put(ac[i], map.getOrDefault(ac[i], 0) + 1);
        }
        for(int i = 0; i < bc.length; i++) {
            if(map.containsKey(bc[i])) {
                map.put(bc[i], map.get(bc[i]) - 1);
                if(map.get(bc[i]) == 0) map.remove(bc[i]);
            } else return "NO";
        }
        if(map.size() > 0) return "NO";
        return answer;
    }
    public static void problem02() {
        Scanner kb = new Scanner(System.in);
        S040105P02 s4 = new S040105P02();
        String a = kb.next();
        String b = kb.next();
        System.out.println(s4.solution02(a, b));
    }

    public char solution01(int n, String s) {
        char answer = ' ';
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            if(max < map.get(c[i])) {
                answer = c[i];
                max = map.get(c[i]);
            }
        }
        return answer;
    }
    public static void problem01() {
        Scanner kb = new Scanner(System.in);
        S040105P02 s4 = new S040105P02();
        int n = kb.nextInt();
        String s = kb.next();
        System.out.println(s4.solution01(n, s));
    }
}