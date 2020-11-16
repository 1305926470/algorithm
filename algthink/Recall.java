package algthink;

import java.util.Arrays;

//回溯算法
public class Recall {
	
	//怎么记录每个阶段的状态

	//一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度
	//如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
	public int maxSeq = 0;
	public void increaseSeq(int[] n, int m, int preMax, int max) {
		if (max > maxSeq) {
			maxSeq = max;
		}
		
		for (int i = m; i < n.length; i++) {
			//第i个不进入序列时
			increaseSeq(n, i+1, preMax ,max);
			//第i个进入序列
			if (n[i] > preMax) {
				increaseSeq(n, i+1, n[i], max+1);
			}
		}
	}
	
	
	//最小编辑距离
	private char[] a = "mitcmu".toCharArray();
	private char[] b = "mtacnu".toCharArray();
	private int n = 6;
	private int m = 6;
	public int minDist = Integer.MAX_VALUE; // 存储结果
	//莱温斯坦距离（最小编辑距离）
	public void lwstBT(int i, int j, int edist) {
		if (i == n || j == m) {
			if (i < n) 
				edist += n - i;
			if (i < m)
				edist += m- j;
			if (edist < minDist)
				minDist = edist;
			return;
		}
		
		//字符串匹配时
		if (a[i] == b[j]) {
			lwstBT(i+1, j+1, edist);
		} else {//不匹配时,
			// 删除 a[i] 或者 b[j] 前添加一个字符
			lwstBT(i+1, j, edist+1);
			// 删除 b[j] 或者 a[i] 前添加一个字符
			lwstBT(i, j+1, edist+1);
			// 将 a[i] 和 b[j] 替换为相同字符
			lwstBT(i+1, j+1, edist+1);
		}
		
	}
	
}
