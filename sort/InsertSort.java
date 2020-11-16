package sort;

public class InsertSort extends BaseSort {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 9, 6, 3, 4, 5, 10};
		printAll(a);
		insertSort(a);
		printAll(a);
	}
	
	//插入排序
	public static void insertSort(int[] a) {
		int i,j, n, tmp;
		n = a.length;
		for (i = 1; i < n; i++) {
			tmp = a[i];
			for (j = i - 1; j >= 0; j--) {
				if (a[j] > tmp) {
					//把比大的数据往后搬
					a[j + 1] = a[j];
				} else {
					break;
				}
				//数据插入有序区
				a[j] = tmp;
			}
		}
//		return a;
	}
	
	
	
	
	
	
	
}
