package study.intro.section06;

import java.util.*;

public class Section0607 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> pList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            pList.add(new Point(x, y));
        }
        Collections.sort(pList); // 이 때 재정의한 compareTo 기준으로 정렬
        for(Point p : pList) System.out.println(p.x + " " + p.y);
    }
}

class Point implements Comparable<Point> { //이 객체에 대한 정렬 기준을 다시 정의하기 위해 Comparable 인터페이스를 상속
    public int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 객체 정렬 기준 재정의
    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
    /**
     * compareTo의 정렬 기준
        compareTo의 리턴 결과가 양수
        -> compareTo 메서드를 부르는 객체가 더 크고, 파라미터로 들어온 o 객체가 더 작다고 판별된다.
        -> 주체객체와 대상객체가 교체하여 정렬된다.

        compareTo의 리턴 결과가 0
        -> 두 객체의 값이 동일하다고 판별된다.
        -> 정렬을 유지한다.

        compareTo의 리턴 결과가 음수
        -> compareTo 메서드를 부르는 객체가 더 작고, 파라미터로 들어온 o 객체가 더 크다고 판별된다.
        -> 정렬을 유지한다.

        주체 객체의 score가 100, 파라미터 객체의 core가 150 이고 내림차순으로 정렬한다고 가정해보자.
        o.getScore() - getScore() = 150 - 100 = 50 > 0 --> 리턴 값이 양수
        실제 score는 주체 객체가 더 작지만 리턴 값이 양수이므로 주체 객체가 크다고 판별된다. 그러므로 교체하여 정렬된다.
        정렬 된 결과는 [150, 100] 이 된다. 내림차순 정렬이 잘 된 것을 볼 수 있다.

        Collections.sort(객체)
        사용 시 대상 객체가 정렬된다. 그 기준은 위에서 Comparable 인터페이스로 정의한 기준에 따라 정렬된다. 기본 데이터형과 달리 객체의 경우 정렬 기준을 정의하지 않으면 컴파일 에러가 난다.
     */
}