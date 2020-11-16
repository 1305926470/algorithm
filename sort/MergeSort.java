package sort;

//归并排序
public class MergeSort extends BaseSort {
	
	public static void merge_sort(int[] a, int n) {
		mergeSortInternally(a, 0, n - 1);
	}
	
	/**
	 * @desc 分治法细想，不断的拆成更小的区间任务，递归，拆分合并
	 * @param a
	 * @param p
	 * @param r
	 */
	public static void mergeSortInternally(int[] a, int p, int r) {
		if (p >= r)
			return;
		int q = (p + r)/2;
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q + 1, r);
		
		merge(a, p, q, r);
	}
	
	
	public static void merge(int[] a, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int[] tmp = new int[r-p+1];
		int k = 0;
		//依次去处两个区间小的值，放入tmp中
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		
		//去处剩余区间的数据
		int start = i;
		int end = q;
		if (j <= r) {
			start = j;
			end = r;
		}
		while (start <= end) {
			tmp[k++] = a[start++];
		}

		//把数据复制会原数组a中
		for (i = 0; i <= r-p; i++) {
			a[p+i] = tmp[i];
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 9, 6, 3, 4, 5, 10};
		merge_sort(a, 9);
		
		printAll(a);
	}
	
}
