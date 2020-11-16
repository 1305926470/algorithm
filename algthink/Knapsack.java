package algthink;

import java.util.Arrays;

//背包问题
//0-1背包问题 n 个物品，每个物品的重量不等，并且不可分割。期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大。
public class Knapsack {
	public int maxW = 0;	//记录各种装入方式的最大重量
	
	public void getMaxW() {
		System.out.println(maxW);
	}
	
	
	/**
	 * 0-1背包问题，回溯法求解, 回溯的本质其实就是枚举，复杂度也是指数级的, 存在重复计算枚举的情况，效率太低
	 * @param i 第i-1个物品下标
	 * @param currentW 当前背包物品重量
	 * @param items 物品重量数组
	 * @param itemLength 物品数量
	 * @param wLimit 背包重量上限
	 */
	public void recall(int i, int currentW, int[] items, int itemLength, int wLimit) {
		if (currentW > wLimit|| i >= itemLength) {//超过背包上限，结束
			return;
		}
		if (currentW > maxW) {//如果大于之前最大的总重，则更新最大总重
			maxW = currentW;
		}
		//第i-1个物品没放进背包时
		recall(i+1, currentW, items, itemLength, wLimit);
		//第i-1个物品放入背包时	
		recall(i+1, currentW + items[i], items, itemLength, wLimit);
	}
	
	
	
	
	/**
	 * 0-1背包问题，动态规划
	 * @param weight 物品重量数组
	 * @param num 物品数量
	 * @param wLimit 背包重量上限
	 */
	public void dynamicPlan(int[] weight, int num, int wLimit) {
		boolean[] states = new boolean[wLimit+1];//用于记录每个阶段的状态
		//把第0个物品放进去，单独处理，因为没有前一行了
		states[0] = true; 
		states[weight[0]] = true;
		
		for (int i = 1; i < num; i++) {	//分成num个阶段，
			for (int w = wLimit; w >= 0; w--) {//需要充大到小的遍历，不然，前面的会有干扰，
				if (states[w] == true) {//前一个阶段的状态
					//第i个物品不放进去时，代码省略 states[w+0] = true;	
					//第i个物品放进去时
					if (w+weight[i] <= wLimit)
						states[w+weight[i]] = true; 
				}
			}
		}
		
		//打印出最接近背包最大重量的值
		for (int i = wLimit; i >= 0; i--) {
			if (states[i] == true) {
				System.out.print(i+", ");	
				//break;
			}
		}
		
	}
	
	//0-1背包问题，升级版，n个物品，每个物品有一定的价值，怎么在不超重的情况求出价值最大的组合
	//在重量相同的情况下，保留价值最大的
	//不就是把单位重量价值最大的优先方进入吧
	/**
	 * 0-1背包问题，动态规划
	 * @param weight 物品重量数组
	 * @param values 物品价值数组
	 * @param num 物品数量
	 * @param wLimit 背包重量上限
	 */
	public void dynamic01(int[] weight, int[] values, int num, int wLimit) {
		int[][] states = new int[num][wLimit+1];//用于记录每个阶段的状态
		//初始化
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < wLimit+1; j++) {
				states[i][j] = -1;
			}
			//System.out.println(Arrays.toString(states[i]));
		}
		
		states[0][0] = 0;
		states[0][weight[0]] = values[0];
		
		for (int i = 1; i < num; i++) {
			for (int j = 0; j <= wLimit - weight[i]; j++) {
				//第i个物品不放进去时
				if (states[i-1][j] >= 0) {
					states[i][j] = states[i-1][j];
				}
				
				//第i个物品放进去时
				if (states[i-1][j] >= 0) {
					int v = states[i-1][j] + values[i];
					if (v > states[i][j+weight[i]]) {
						states[i][j+weight[i]] = v;
					}
				}
			}
		}
		
		//找出最大的价值
		int maxValue = -1;
		for (int i = 0; i <= wLimit; i++ ) {
			if (states[num-1][i] > maxValue) {
				maxValue = states[num-1][i];
			}
		}
		
		System.out.println(maxValue);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
