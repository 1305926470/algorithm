package algthink;

public class Test {
	
	
	
	//0-1背包问题回溯法
	public static void knapsack01() {
		Knapsack kp = new Knapsack();
		int[] items = {1, 2, 4, 5, 6, 7, 9, 11, 15};
		int weightLimit = 25;
		kp.recall(0, 0, items, items.length, weightLimit);
		kp.getMaxW();
	}
	
	//0-1背包问题 动态规划
	public static void dynamicPlan01() {
		Knapsack kp = new Knapsack();
		int[] items = {1, 2, 4, 5, 6, 7, 9, 11, 15};
		int weightLimit = 24;
		kp.dynamicPlan(items, items.length, weightLimit);
	}
	
	//0-1背包问题升级 动态规划
	public static void dynamicPlan011() {
		Knapsack kp = new Knapsack();
		int[] items = {1, 2, 4, 5, 6, 7, 9, 11, 15};
		int[] values = {12, 3, 5, 7, 16, 35, 18, 11, 45};
		int weightLimit = 24;
		kp.dynamic01(items, values, items.length, weightLimit);
	}
	
	
	//满减优惠 动态规划
	public static void discount() {
		DynamicPlan dp = new DynamicPlan();
		int[] prices = {121, 3, 51, 71, 16, 34, 18, 11, 45}; //物品价格
		int totalMin = 200;
		dp.discount(prices, prices.length, totalMin);
	}
	
	
	//动态规划，求二阶左上到右下最小路径
	public static void dynamic1() {
		int[][] data = {
			{1, 3, 5, 9},
			{2, 1, 3, 4},
			{5, 2, 6, 7},
			{6, 8, 4, 3}
		};
		DynamicPlan dp = new DynamicPlan();
		dp.matrixDistance(data, 0, 0, data[0][0]);
//		System.out.println(dp.minDistance);
		
		dp.matrixD(data, data.length, data[0].length);
		System.out.println(dp.matrixD1(data, data.length-1, data[0].length-1));
	}
	
	
	public static void maxSeq() {
		Recall recall = new Recall();
		
		int[] n = {2, 9, 3, 6, 5, 1, 7, 10};
		int[] seq = new int[n.length];
		recall.increaseSeq(n, 0, 0, 0);
		System.out.println(recall.maxSeq);
		
	}
	
	public static void lstEditDst() {
		Recall recall = new Recall();
		recall.lwstBT(0, 0, 0);
		System.out.println(recall.minDist);
	}
	
	
	
	public static void main(String[] args) {
		lstEditDst();
	}
	
	
	
	
}
