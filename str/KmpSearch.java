package str;


public class KmpSearch {
	
	/**
	  *     计算失配函数，用于获取j失配时，下一个位置
	 * @param p
	 * @return
	 */
	public int[] getNext(char[] p) {
		int[] next = new int[p.length];
		int k = -1;
		int j = 0;
		next[0] = -1;
		while (j < p.length - 1) {
			//这里相当于p[0~j]是主串，p[0~k]是模式串
			if (k == -1 || p[j] == p[k]) {//p[j] == p[k]表示找到了公共前后缀子串,加到next中，继续往后
				j++;
				k++;
				next[j] = k;
			} else {
				//p[j] != p[k]时，就不能找到比k更长的公共子串了，k需要重新开始，但是next[k]更快的移动。
				//还是利用kmp，p[0~j]是主串，p[0~k]是模式串，k类似之前的j，还是找最大前缀后缀公共子串
				k = next[k]; 
			}
		}
		return next;
	}
	
	
	public int kmpSearch(String mainStr, String preg) {
		int i = 0;//主串搜索
		int j = 0;//模式串搜索
		
		char[] s = mainStr.toCharArray();
		char[] p = preg.toCharArray();
		int[] next = getNext(p);
		while (i < s.length && j < p.length) {
			if (j == -1 || s[i] == p[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j >= p.length)
			return i - j;
		
		return -1;
	}
	
	
	
	
	
	
	
	
}
