package heap;


public class HeapSort {
	//堆排序
	public void sort(int[] arr, int n) {
		int k = n;
		int tmp;
		buildHeap(arr, k);
		while (k > 1) {
			tmp = arr[1];
			arr[1] = arr[k];	//把当前堆最大的与末尾的交换
			arr[k] = tmp;
			k--;
			heapify(arr, k, 1);
		}
		
	}
		
		
	//建堆
	public void buildHeap(int[] a, int n) {
		for (int i = n/2; i >= 1; i--) {
			heapify(a, n, i);
		}
	}
	
	//堆调整,当前节点与子节点比较，小于大儿子节点，则交换
	public void heapify(int[] a, int n, int i) {
		int maxPos = i;
		while (true) {
			if (2*i <= n && a[2*i] > a[i])
				maxPos = 2*i;
			if (2*i + 1 <= n && a[2*i+1] > a[maxPos])
				maxPos = 2*i + 1;
			if (i == maxPos)
				break;	//已经满足父节点大于子节点或者无子节点时推出
			swap(a, i, maxPos);
			i = maxPos;
		}
	}
	
	private void swap(int[] arr, int a, int b) {
		int tmp;
		tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
		
}
