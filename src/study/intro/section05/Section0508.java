package study.intro.section05;

import java.util.*;
public class Section0508 { // ******************
    public class Person {
        int id = 0;
        int priority = 0;
        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }
        while(!q.isEmpty()) {
            Person tmp = q.poll();
            for(Person x : q) {
                if(tmp.priority < x.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) {
                answer++;
                if(tmp.id == m) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Section0508 s5 = new Section0508();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(s5.solution(n, m, arr));
    }
}