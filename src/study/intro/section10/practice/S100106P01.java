package study.intro.section10.practice;

import java.util.*;

public class S100106P01 {

    public static void main(String[] args) {
        S100106P01 s10 = new S100106P01();
//        s10.problem01(); // 계단오르기
//        s10.problem02(); // 돌다리 건너기
//        s10.problem03(); // 최대 부분 증가수열
//        s10.problem04(); // 가장 높은 탑 쌓기
        s10.problem05(); // 동전교환(냅색알고리즘) *****
    }

    public int solution05(int[] coin, int goal) {
        int[] arr = new int[goal + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0; // arr[0]은 0원을 말하므로 for문에서 넣지 못하니 따로 초기화 해줌
        for(int i = 0; i < coin.length; i++) {
            for(int j = coin[i]; j <= goal; j++) {
                if(arr[j] > arr[j - coin[i]] + 1) arr[j] = arr[j - coin[i]] + 1;
//                System.out.println(coin[i] + " =>>> " + j + " = " + arr[j]);
            }
        }

        return arr[goal];
    }

    public void problem05() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        int goal = sc.nextInt();

        System.out.println(solution05(coin, goal));
    }




    static class P4 implements Comparable<P4> {
        int bottom;
        int height;
        int weight;

        @Override
        public int compareTo(P4 o) {
            if(o.bottom > this.bottom) return 1;
            return -1;
        }
    }
    public int solution04(List<P4> list, int n) {
        int answer = 0;
        Collections.sort(list);


        answer = list.get(0).height;
        int[] harr = new int[n];
        harr[0] = answer;
        for(int i = 0; i < n; i++) {
            int hx = 0;
            for(int j = i - 1; j >=0; j--) {
                if (list.get(j).weight > list.get(i).weight && harr[j] > hx) {
                    hx = harr[j];
                }
            }
            harr[i] = hx + list.get(i).height;
            answer = Integer.max(answer, harr[i]);
        }
        return answer;
    }

    public void problem04() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<P4> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            P4 p = new P4();
            p.bottom = sc.nextInt();
            p.height = sc.nextInt();
            p.weight = sc.nextInt();
            list.add(p);
        }

        System.out.println(solution04(list, n));
    }

    public int solution03(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int[] count = new int[arr.length];
        count[0] = 1;
        for(int i = 1; i < n; i++) { // 0번째는 1로 초기화 했으니 1번째부터 하는게 정확
            for(int j = 0; j < i; j++) {
//                if(arr[i] > arr[j] && count[i] <= count[j]) count[i] = count[j] + 1; // 앞에 본인보다 작은게 하나도 없으면 1을 줘야해서 여기서 더하면 안되네,,
                if(arr[i] > arr[j] && count[i] < count[j]) count[i] = count[j];
            }
            count[i] = count[i] + 1; //앞에 본인보다 작은 숫자가 하나도 없을 경우 때문에 if문 밖에서 +1을 해줘야 한다,,,!
            System.out.println(arr[i] + " = " + count[i]);
            max = Integer.max(max, count[i]);
        }
        return max;
    }
    public void problem03() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution03(arr, n));
    }



    int[] dy;

    public int solution02(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i < n + 2; i++) {
            dy[i] = dy[i -1] + dy[i - 2];
        }
        return dy[n + 1];
    }
    public void problem02() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 2];
        System.out.println(solution02(n));
    }

    public int solution01(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i < n + 1; i++) {
            dy[i] = dy[i -1] + dy[i - 2];
        }
        return dy[n];
    }
    public void problem01() {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(solution01(n));
    }
}
