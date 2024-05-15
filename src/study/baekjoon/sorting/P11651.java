package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 좌표 정렬하기 2
public class P11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point2> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for(Point2 point2 : list) System.out.println(point2);
    }
}

class Point2 implements Comparable<Point2> {
    int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2 o) {
        int result = this.y - o.y;
        if(result == 0) result = this.x - o.x;
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
