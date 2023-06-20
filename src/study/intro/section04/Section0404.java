package study.intro.section04;
import java.util.*;

public class Section0404 {
    public int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        // 기준 세팅
        for(char x : t.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        // 초기값 세팅
        int l = t.length() - 1;
        for(int i = 0; i < l; i++) am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        // 비교 실행
        int lt = 0;
        for(int rt = l; rt < s.length(); rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer++;
            am.put(s.charAt(lt), am.get(s.charAt(lt)) - 1);
            if(am.get(s.charAt(lt)) == 0) am.remove(s.charAt(lt));
            lt++;
        }
        
        return answer;
    }
    public static void main(String[] args) {
        Section0404 s4 = new Section0404();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        String t = kb.next();
        System.out.println(s4.solution(s, t));
    }
}