package sort;

public class QuickSort extends BaseSort {
	public static void main(String[] args) {
//		int[] a = {1, 2, 3, 9, 6, 3, 4, 5, 10};
		
		int[] a = {11, 21, 31, 1, 4, 55, 5, 5, 9, 26, 23, 14, 65, 100};
		int n = a.length - 1;
		printAll(a);
		qs(a, 0, n);
//		quickSort(a, n);
		printAll(a);
	}
	
	
	public static void quickSort(int[] a, int n) {
		quickSortInternally(a, 0, n-1);
	}
	
	private static void quickSortInternally(int[] a, int p, int r) {
		if (p >r) return;
		int q = partion(a, p, r);
		quickSortInternally(a, p, q - 1);	
		quickSortInternally(a, q + 1, r);
	}
	
	private static int partion(int[] a, int p, int r) {
		int i = p;	//记录小于pivot的个数
		int j;  //遍历分区使用
		int pivot = a[r];
		int tmp;
		
		pivot = a[r];	//以最右边的为参考
		
		for (j = p; j < r; j++) {
			if (a[j] < pivot) {
				if (i == j) {  //相等说明之前遍历的都是小于的，无需交换
					i++;
				} else {
					//交换
					tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
					i++;
				}
			}
		}
		
		tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		return i;
	}
	
	public static void qs(int[] a, int p, int r) {
		int q = 0, tmp = 0;
		if (p >= r)
			return;
		q = p; //把区间左边的作为临界值
		int i,j;
		//把所有小于临界值的移到左边；遍历完小于临界值的都在左边，大于的都在右边。临界值位置确定
		//数组搬移操作，耗时较多，可以改进为交换，但是可能丧失排序的稳定性
		for (i = p + 1; i <=r; i++) {
			if (a[i] < a[q]) {
				tmp = a[i];
				for (j = i; j > q; j--) {
					a[j] = a[j-1];
				}
				a[q] = tmp;
				q++;
			}
		}
		
		qs(a, p, q - 1);
		qs(a, q + 1, r);
	}
	
}
