package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 국영수
public class P10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Report> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            String name = arr[0];
            int korean = Integer.parseInt(arr[1]);
            int english = Integer.parseInt(arr[2]);
            int math = Integer.parseInt(arr[3]);
            list.add(new Report(name, korean, english, math));
        }
        Collections.sort(list);
        for(Report report : list) System.out.println(report);
    }

}

class Report implements Comparable<Report> {
    String name;
    int korean, english, math;

    public Report(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Report o) {
        int result = o.korean - this.korean;
        if(result == 0) result = this.english - o.english;
        if(result == 0) result = o.math - this.math;
        if(result == 0) result = this.name.compareTo(o.name);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
