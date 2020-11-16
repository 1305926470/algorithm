package heap;

/**
 * @description 堆, 完全二叉查找树
 * @author xingxing
 * @date 2019-04*22
 */
public class Heap {
	private int size = 32;		//堆的最大上线
	private int count = 0;		//堆中元素计数
	private int[] element = new int[size];
	
	
	public Heap(int size) {
		this.size = size;
	}
	
	
	//默认大顶堆；新节点与父元素比较，大于父级则交换
	//能否实现，堆的自动扩容 ？
	public boolean insert(int value) {
		if (count >= size - 1) 
			return false;
		int i;
		element[++count] = value;
		i = count;
		if (i < 2) 
			return true;
		
		while (element[i] > element[i/2] && i > 1) {
			swap(i, i/2);
			i = i/2;
		}
		return true;
	}
	
	
	private void swap( int a, int b) {
		int tmp;
		tmp = element[a];
		element[a] = element[b];
		element[b] = tmp;
	}
	
	//从堆顶删除元素, 然后重新调整堆
	public int pop() {
		int ret = element[1];
		if (count < 1) {
			return 0;
		}
		int i = 1;
		//用最后一个元素填补堆顶的空缺，再调整
		element[1] = element[count];
		element[count] = 0;
		count--;
		if (count > 1) {
			while (element[i] < element[2*i] || element[i] < element[2*i+1] ) {
				if ((element[2*i+1] > element[2*i]) && (2*i+1 <= count)) {
					swap(i, 2*i+1);
					i = 2*i + 1;
				} else if ((element[2*i] > element[i]) && (2*i <= count)) {
					swap(i, 2*i);
					i = 2*i;
				} else {
					break;
				}
			}
		}
		return ret;
	}
	
	
	//堆排序 从n/2开始往前，一次与子节点比较，小则交换
	public void heapSort(int[] a) {
		int n = a.length;
		int i;
		for (i = n/2; i > 1; i--) {
			//如果大于父节点，则交换
			
			
			
			
			if (a[i] > a[i/2]) {
				swap(i, i/2);
			}
		}
		
	}
	
	
	
	public void printAll() {
		for (int i = 1; i <= count; i++) {
			System.out.printf("%d, ", element[i]);
		}
		System.out.println();
	}
	
	
	
}
