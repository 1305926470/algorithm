package str;

//字典数
public class Trie {
	private TrieNode root = new TrieNode('/');
	
	public void insert(String text) {
		char[] cs = text.toCharArray();
		
		TrieNode p = root;
		//hello
		for (int i = 0; i < cs.length; i++) {
			int index = cs[i] - 'a';
			if (p.child[index] == null) {
				TrieNode newNode = new TrieNode(cs[i]);
				p.child[index] = newNode;
			}
			p = p.child[index];
		}
		p.isEnd = true;
	}
	
	
	public boolean find(String text) {
		TrieNode p = root;
		char[] cs = text.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			int index = cs[i] - 'a';
			if (p.child[index] != null) {
				p = p.child[index];
			} else {
				return false;
			}
		}
		return true;
	}
		
	//字典树节点
	public class TrieNode {
		public char data;
		public TrieNode[] child = new TrieNode[26];	//用于存储子节点
		public boolean isEnd = false;
		
		public TrieNode(char data) {
			this.data = data;
		}
	}
}
