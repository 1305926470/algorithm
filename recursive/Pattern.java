package recursive;

public class Pattern {
	
	private boolean matched = false;
	private char[] pattern; //正则表达式
	private int plen;		//正则表达式长度
	
	
	public Pattern(String pattern) {
		this.pattern = pattern.toCharArray();
		this.plen = this.pattern.length;
	}
	
	
	public boolean match(String text) {
		char[] t = text.toCharArray();
		int tlen = toString().length();
		matched = false;
		rmatch(0, 0, t, tlen);
		return matched;
	}
	
	//假设只有*和?两种通配符
	private void rmatch(int ti, int pj, char[] text, int tlen) {
		if (matched) return; 
		if (pj == plen) { 
			if (ti == tlen) 
				matched = true;
			return; 
		}
		//匹配任意字符*, text可以向右移动任意位(不超过tlen - ti)，而模式串只移动一位
		if (pattern[pj] == '*') {
			for (int k = 0; k < tlen - ti; k++) {
				rmatch(ti+k, pj+1, text, tlen);
			}
		} else if (pattern[pj] == '?') {//匹配通配符?
			rmatch(ti, pj+1, text, tlen);
			rmatch(ti+1, pj+1, text, tlen);
		} else if (ti < tlen && pattern[pj] == text[ti]) {//字符串完全匹配
			rmatch(ti+1, pj+1, text, tlen);
		}
		//默认matched时false，所以不符合的，什么也不做就行了
	}
	
	
	
	public static void main(String[] args) {
		String text = "acccccd";
		String p = "ac*d";
		
		Pattern pattern = new Pattern(p);
		System.out.println(pattern.match(text));
		
	}
	
	
}
