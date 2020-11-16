package search;

public class BinarySearch extends BaseSearch {
	public static void main(String[] args) {
		int[] a = {1, 22, 22, 22, 43, 44, 65, 86, 97, 98, 99, 190};
		System.out.println(search(a, 22));
		System.out.println(search1(a, 22));	
		int ret = binarySearch(a, 0, a.length-1, 22);
		System.out.println(ret);	
	}
	
	// a 为有序数组
	public static int search(int[] a, int target) {
		int begin = 0;
		int end = a.length - 1;
		int mid;
		while (begin <= end) {
			mid = begin + ((end - begin) >> 1);  //mid = (begin + end) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (target > a[mid]) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}	
		return -1;
	}
	
	// a 为有序数组， 二分法变形，找出第一次出现的下表
	public static int search1(int[] a, int target) {
		int begin = 0;
		int end = a.length - 1;
		int mid;
		while (begin < end - 1) {
			mid = (begin + end) / 2;
			//得到第一个相等的index
			if (target <= a[end]) {
				end = mid;
			} else {
				begin = mid;
			}
			
			//得到最后一个相等的index
//			if (target >= a[mid]) {
//				begin = mid;
//			} else {
//				end = mid;
//			}
		}
		
		if (a[begin] == target) return begin;
		if (a[end] == target) return end;
		
		return -1;
	}
	
	
	//递归实现二分法
	public static int binarySearch(int[] a, int begin, int end,  int target ) {
		int mid = (begin + end) / 2;
		
		if (a[mid] == target) {
			return mid;
		} else if (target > a[mid]) {
			begin = mid;
		} else {
			end = mid;
		}
		
		if (end - begin <= 1) {
			if (a[begin] == target) return begin;
			if (a[end] == target) return end;
			return -1;
		} else {
			return binarySearch(a, begin, end, target);
		}
	}	
}
