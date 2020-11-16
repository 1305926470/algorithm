package sort;

import java.util.Arrays;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Test {
	public static void main(String[] args) {
		//int[][] a = {{1,1,0}, {1,0,1}, {0,1,1}};
//		flipAndInvertImage(a);
		
		
//		System.out.println(Integer.valueOf('a'));
		
		
		test1();
	}
	
	
	//获取ascii Integer.valueOf('A')
	//需保持小写内部，大写内部稳定，要么搬移数据，要么额外内存；如果要想原地排序，要么搬移要么交换，破坏稳定性
	public static void test1() {
		//采用原地排序，搬移数据
		char[] s = {'D', 'F', 'B', 'a', 'c', 'z', 'A'};
		int n = s.length;
		int i, j, k;
		char tmp;
		k = 0;
		for (i = 0; i < n; i++) {
			if (Integer.valueOf(s[i]) >= 97) {
				tmp = s[i];
				for (j = i; j > k; j--) {
					s[j] = s[j-1];
				}
				s[k++] = tmp;
			}
		}
		System.out.println(s);
		
	}
	
	
	
	/**
	 * @desc 合并5个有序的数组，合并后依然有序
	 * 
	 */
	public static void merge() {
		//合并n个有序的数组，合并后依然有序
		int [] a1 = {1, 2, 3, 4}; 
		int [] a2 = {3, 4, 5, 6}; 
		int [] a3 = {6, 7, 8, 9}; 
		int [] a4 = {11, 12, 13, 14}; 
		int [] a5 = {5, 6, 7, 14}; 
		
		
		
		
	}
	
	
	private static void mergeSortInternally(int[][] a, int p, int r) {
		if (p >= r)
			return;
		int q = (p + r) / 2;
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q+1, r);
	}
	
	private void merg(int[][] a, int p, int r) {
		int i = 0;
		int j = 0;
		int[] a1 = a[p];
		int[] a2 = a[r];
		while (i < a1.length && j < a2.length) {
			
		}
		
		
		
	}
	
	
	
}
