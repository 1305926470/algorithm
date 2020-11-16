package algthink;

import java.util.Arrays;

//动态规划
public class DynamicPlan {
	public int minDistance = Integer.MAX_VALUE;
	
	
	/**
	   *     优惠活动满200减50 动态规划
	 * @param prices 物品价格列表
	 * @param num 物品数量
	 * @param totalMin 满减最小价钱
	 */
	public void discount(int[] prices, int num, int totalMin) {
		int totalMax = 2*totalMin;
		//记录每个阶段的状态，
		boolean[][] states = new boolean[num][totalMax+1]; 
		
		states[0][0] = true;
		states[0][prices[0]] = true;
		
		for (int i = 1; i < num; i++) {
			for (int price = 0; price <= totalMax; price++ ) {
				if (states[i-1][price] == true) {
					states[i][price+0] = true;	//第i个商品不放进去时
					if (price+prices[i] <= totalMax)
						states[i][price+prices[i]] = true; //第i个商品放进去时
				}
			}
		}
		
		//找出接近200的
		int p;
		for (p = totalMin; p <= totalMax; p++) {
			if (states[num-1][p] == true) {
				System.out.println(p);
				break;
			}
		}
		if (p == totalMax) {
			System.out.println("not found");
			return;
		}
			
		//倒推出满足条件的组合
		for (int i = num - 1; i > 0; i--) {
			if (p - prices[i] > 0 && states[i-1][p - prices[i]] == true) {
				System.out.print(prices[i] + ", ");
				p = p - prices[i];
			}
		}
		if (p != 0)
			System.out.print(prices[0]);
	}
	
	

	//动态规划，求二阶左上到右下最小路径
	/**
	   *    回溯
	 * @param matrix
	 * @param x
	 * @param y
	 * @param distance
	 */
	public void matrixDistance(int[][] matrix, int x, int y, int distance) {
		if (x == matrix.length - 1 && y == matrix[0].length - 1)
			if (distance < minDistance)
				minDistance = distance;
		if (y < matrix[0].length - 1)
			matrixDistance(matrix, x, y+1, distance + matrix[x][y+1]);
		if (x < matrix.length - 1)
			matrixDistance(matrix, x + 1, y, distance + matrix[x+1][y]);
	}
	
	
	
	//递推加备忘录, 去掉重复的计算
	//f(x,y) = min(f(x-1,y), f(x,y-1)) + matrix[x][y]
	public int matrixD1(int[][] matrix, int x, int y) {
		int[][] d = new int[matrix.length][matrix[0].length];
		if (x == 0 && y==0)
			return matrix[0][0];
		int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
		if (x > 0)
			up = matrixD1(matrix, x-1, y);
		if (y > 0)	
			left = matrixD1(matrix, x, y-1);
		return Math.min(up, left) + matrix[x][y];
	}
	
	
	/**
	  *  动态规划，求二阶左上到右下经过点和最小的路径
	 * @param matrix
	 * @param x
	 * @param y
	 * @param distance
	 */
	public void matrixD(int[][] matrix, int x, int y) {
		int[][] d = new int[x][y];
		int d1 = Integer.MAX_VALUE, d2 = Integer.MAX_VALUE;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (i == 0 && j == 0) {
					d[0][0] = matrix[0][0];
					continue;
				}
				
				if (j > 0)
					d1 = d[i][j-1];  	//左边点到起点的距离
				
				if (i > 0)
					d2 = d[i-1][j];		//上边点到起点的距离
				
				d[i][j] = matrix[i][j] + Math.min(d1, d2);
			}
		}
		System.out.println(d[x-1][y-1]);
	}
	
	
	
	//一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度
	//如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
