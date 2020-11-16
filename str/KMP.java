package str;

//字符串匹配算法kmp
public class KMP {
	
	/**
	 *     失配函数
	 * next[j] 就是最大前缀后缀公共子串长度的数组
	 * @param ps
	 * @return
	 */
	public int[] getNext(String ps) {
		char[] p = ps.toCharArray();
		int[] next = new int[p.length];
		
		int j = 0;
		int k = -1;
		next[0] = -1;
		while (j < p.length - 1) {
			//模式串 abcabc j为3,4,5时，公共前后缀长度分别为1,2,3
			if (k == -1 || p[j] == p[k]) { //p[j] == p[k]表示找到了公共前后缀子串
				next[++j] = ++k;
			} else {
				//p[j] != p[k]时，就不能找到比k更长的公共子串了，k需要往前移。
				//(有点递推了，这步也是利用kmp的思想来更快移动k, 而不是总是让k从头开始)
				k = next[k];
			}
		}
		
		return next;
	}
	
	
	public int kmpSearch(String s, String p) {
		char[] main = s.toCharArray();
		char[] preg = p.toCharArray();
		int [] next = getNext(p);
		
		int i = 0;
		int j = 0;
		while (i < main.length && j < preg.length) {
			//当主串中i与模式串j匹配时，i和j都向后移；
			//当j为-1即模式串中不存在公共部分，i后移1位，j从0开始
			//失配时，且有公共子串时，i不动，j移到next[j]
			if (j == -1 || main[i] == preg[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j == preg.length)
			return i - j;
		return -1;
		
	}
	

	
	
}
