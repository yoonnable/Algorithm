package study.intro.section07;

public class Section0701 {
	// 재귀함수 (스택 프레임) : 후입선출!!!!
	// 본인을 호출해서 반복하는 함수
	// 일단 if else 문으로 반복을 빠져나올 조건식 형태로 구현을 시작한다.
	public void DFS(int n) {
		if(n == 0) return;
		else {
			DFS(n - 1); // 2. 하나씩 줄어들어 본인을 다시 호출한다.
			//3. 나중에 호출한 것들이 먼저 나오면서 아래 라인 계속 진행
			System.out.print(n + " ");
		}
	}
	
	public static void main(String[] args) {
		Section0701 s7 = new Section0701();
		s7.DFS(3); // 1. 3부터 넣어서 호출 시작!
	}
}