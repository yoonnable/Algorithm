package study.intro.section08;

import java.util.*;

public class Section0801 {
    // DFS 는 스택!!
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;

    public void DFS(int index, int sum, int[] arr) {
        if(flag) return;
        if(total - sum < sum) return; // 이미 모든 요소 합의 절반보다 큰 값이 되어 버렸다는건,,, 이미 둘로 나눴을 때 같은 값이 나올리 없다는 것! 그러므로 여기서 반환시켜 실행 시간을 단축 시키자!!
        if(index == n) {
            if(total - sum == sum) { // 쌤 수업에선 total / 2 == sum 도 가능하다곤 했지만,,, total이 홀수일 경우엔 나머지 1이 생기면서 나온 몫이랑 비교하기 때문에 정확히 맞지 않아서 오답이 나옴.
                answer = "YES";
                flag = true; // YES 한 번만 나와도 back 해서 또 요소 체크 굳이굳이 할 필요 없으니 전체적으로 재귀함수 실행을 막아버리쟛!!
            }
        } else {
            DFS(index + 1, sum + arr[index], arr); //지금 실행 중인 함수!DFS에 들어온 나! index 번호에 있는 숫자를 포함하고 다음 index로 슝슝
            DFS(index + 1, sum, arr); // 나는 포함 안하고 다음 index 탐색하러 슝슝!!
        }
    }

    public static void main(String[] args) {
        Section0801 s8 = new Section0801();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }
        s8.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
