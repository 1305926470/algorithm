package heap;

public class Test {
	public static void main(String[] args) {
//		Heap heap = new Heap(10);
//		heap.insert(1);
//		heap.insert(4);
//		heap.insert(5);
//		heap.insert(2);
//		heap.insert(3);
//		heap.insert(-2);
//		heap.printAll();
//		
//		System.out.println(heap.pop());
//		System.out.println(heap.pop());
//		System.out.println(heap.pop());
//		System.out.println(heap.pop());
//		System.out.println(heap.pop());
//		System.out.println(heap.pop());
		
		
		
		HeapSort hSort = new HeapSort();
		int[] a = {0, 1, 3, 2, 14, 332, 33, 22, 2};
		hSort.sort(a, 8);
		printAll(a);
		
		
	}
	
	
	public static void printAll(int[] a ) {
		for (int i = 1; i < a.length; i++) {
			System.out.printf("%d, ", a[i]);
		}
		System.out.println();
	}
	
	
}
