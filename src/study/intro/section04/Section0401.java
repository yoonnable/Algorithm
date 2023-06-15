package study.intro.section04;
import java.util.*;

public class Section0401 {

    /**
    HashMap
    *****map.getOrDefault(key,defaultValue)
    키에 key이 있으면 그 키의 값을
    키에 key가 없으면 값이 defaultValue고 키가 key인 값을 map에 만들기

    map.keySet() : 맵의 키값들을 탐색

    map.containsKey(key) -> return boolean : 키 존재 여부



    map.put(key, value) : map에 키, 값 넣기
    map.get(key) : key에 대응하는 값
    map.size() : key의 갯수
    map.remove(key) -> return value값 : 키, 값 삭제
    */
    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Section0401 s4 = new Section0401();
        int n = kb.nextInt();
        String s = kb.next();
        System.out.print(s4.solution(n, s));
    }
}