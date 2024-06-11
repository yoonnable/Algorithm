package study.leetcode.dp;

// Closest Dessert Cost
public class P1774 {
    public static void main(String[] args) {
        int[] baseCosts = {5,77,38,61,97};
        int[] toppingCosts = {62,7,100,30,16,84};
        int target = 73;

        P1774 me = new P1774();
        System.out.println(me.closestCost(baseCosts, toppingCosts, target));
    }
    int closestCost;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        closestCost = baseCosts[0];

        for(int base : baseCosts) {
            calculator(base, toppingCosts, 0, target);
        }


        return closestCost;
    }

    public void calculator(int cost, int[] toppingCosts, int index, int target) {
        int o = Math.abs(target - cost);
        int t = Math.abs(target - closestCost);
        if(t > o || (t == o) && cost < closestCost) closestCost = cost;

        if (index == toppingCosts.length || cost == target) {
            return;
        }

        // 토핑 하나 추가한 값 비교하러 가기
        calculator(cost + toppingCosts[index], toppingCosts, index + 1, target);
        // 토핑 2개 추가한 값 비교하러 가기
        calculator(cost + toppingCosts[index] * 2, toppingCosts, index + 1, target);
        // 지금 인덱스의 토핑은 추가 안하지만, 그 상황에 다른 토핑 추가한 경우 비교하기
        calculator(cost, toppingCosts, index + 1, target); // 이게 생각하기 어렵다...

    }
}
