package study.baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 나이순 정렬
public class P10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bw.readLine());
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] temp = bw.readLine().split(" ");
            list.add(new Person(Integer.parseInt(temp[0]), temp[1]));
        }
        Collections.sort(list);
        for(Person p : list) System.out.println(p);
    }
}

class Person implements Comparable<Person> {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
