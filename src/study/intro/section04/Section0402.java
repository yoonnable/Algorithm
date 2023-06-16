package study.intro.section04;

import java.util.*;

public class Section0402 {
    public String solution(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : s2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return "NO";
            map.put(c, map.get(c) - 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0402 s4 = new Section0402();
        String s1 = kb.next();
        String s2 = kb.next();
        System.out.println(s4.solution(s1, s2));
    }

}