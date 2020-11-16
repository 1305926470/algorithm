package sort;

//冒泡排序
public class BubbleSort extends BaseSort {
	
	public static void main(String[] args) {
		int [] a = {5,4,1,2,3,6,9,8,7};
		
		printAll(a);
		sort(a);
		printAll(a);
	}
	
	//冒泡排序，从前往后依次比较相邻的，后面的大就交换（大的往后移）。
	//提前退出条件，当某次遍历没有交换时，结束（说明都满足递增的顺序了）。
	public static void sort(int[] a) {
		int n = a.length;
		int tmp;
		boolean exitFlag = false; //用于提前结束循环
		for (int i = 0; i < n; i++) {
			exitFlag = true;
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j+1]) {
					tmp = a[j+1];
					a[j+1] = a[j];
					a[j] = tmp;
					exitFlag = false;
				}
			}
			if (exitFlag == true) {
				break;
			}
		}
	}
	
	
	
	
}
