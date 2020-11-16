package str;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
//		test1();
		
		test5();
		
	}
	
	
	public static void test5() {
		Trie trie = new Trie();
		trie.insert("how");
		trie.insert("hello");
		trie.insert("hollor");
		trie.insert("ico");
		trie.insert("bug");
		trie.insert("buger");
		System.out.println(trie.find("how"));
		System.out.println(trie.find("hohw"));
		System.out.println(trie.find("buger"));
		
	}
	
	
	
	
	
	
	public static void test4() {
		KmpSearch kmp = new KmpSearch();
		String str1 = "ababacd";
		String str2 = "acd";
		int ret = kmp.kmpSearch(str1, str2);
		System.out.println(ret);
		
//		String s = "ABCDABD";
//		int[] res = kmp.getNext(s.toCharArray());
//		System.out.println(Arrays.toString(res));
		
	}
	
	
	
	
	
	
	
	
	public static void test3() {
		KMP kmp = new KMP();
		String str1 = "ababacd";
		String str2 = "acd";
//		int ret = kmp.kmpSearch(str1, str2);
//		System.out.println(ret);
		
		
		
		
		
		String s = "ABCDABD";
		int[] res = kmp.getNext(s);
		System.out.println(Arrays.toString(res));
		
	}
	
	
	
	
	
	//bm运行测试
	public static void test2() {
		BM bm = new BM();
		String str1 = "abcabcabdabc";
		String str2 = "abd";
		char[] mainStr = str1.toCharArray();
		char[] preg = str2.toCharArray();
		int ret;
		ret = bm.bm(mainStr, mainStr.length, preg, preg.length);
		System.out.println(ret);
		
		
	}
	
	
	
	private static final int SIZE = 256;
	
	/**
	 * 
	 * @param preg	模式串
	 * @param pregLength 模式串长度
	 * @param asciiTable 哈希表
	 */
	public void generateBC(char[] preg, int pregLength, int[] asciiTable) {
		for (int i = 0; i < SIZE; i++) {
			asciiTable[i] = -1;
		}
		
		for (int i = 0; i < pregLength; i++) {
			int ascii = (int)preg[i];	//计算字符ascii码值
			asciiTable[ascii] = i;
		}
	}
	
	
	public int bm(char[] bc, int n, char[] b, int m) {
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void test1() {
		String str1 = "abd";
		char[] preg = str1.toCharArray();
		int[] asciiTable = new int[256];
		
		Test test = new Test();
		test.generateBC(preg, preg.length, asciiTable);
		System.out.println(Arrays.toString(asciiTable));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
