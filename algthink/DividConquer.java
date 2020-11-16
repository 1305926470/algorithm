package algthink;

//分治法
public class DividConquer {
	public static void main(String[] args) {
		int[] n = {9, 2, 4, 3, 8, 6, 7};
		f1(n, n.length - 1);
	}
	
	//求一组数的逆序对, m为n数组中最后一位下标
	//分治法适合递归处理，关键是找出递推公式
	//这种方式时间复杂度太高了O(n^2), 还可利用归并排序的细想来求
	public static void f1(int[] n, int m) {
		if (m < 1)
			return;
		for (int i = 0; i < m; i++) {
			if (n[i] > n[m]) {
				System.out.println("("+n[i]+","+n[m]+")");
			}
		}
		f1(n, m-1);
	}
}
