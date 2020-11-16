package hash;


public class Hash {
	private int size = 20;
	Node<String> head = null;
	Node[] hashNodes = new Node[size];
	
	public static void main(String[] args) {
		Hash hash = new Hash();
		hash.insert("word");
		hash.insert("world");
		hash.insert("words");
		hash.insert("hello");
		hash.find("words");
	}
	
	public boolean insert(String s) {
		int i;
		char c;
		int hashCode;
		int sum = 0;
		
		//计算出字符串ASCII码之和
		for (i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			sum += Integer.valueOf(c);
		}
		hashCode = sum % size;
		Node<String> newNode = new Node<String>(s, null);
		
		if (hashNodes[hashCode] == null) {
			head = newNode;
			hashNodes[hashCode] = head;
		} else {
			Node<String> pNode = hashNodes[hashCode];
			while (pNode != null && pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = newNode;
		}
		
		return true;
	}
	
	public void find(String s) {
		int i;
		char c;
		int hashCode;
		int sum = 0;
		
		//计算出字符串ASCII码之和
		for (i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			sum += Integer.valueOf(c);
		}
		hashCode = sum % size;
		
		if (hashNodes[hashCode] != null) {
			Node<String> pNode = hashNodes[hashCode];
			while (pNode.data != s && pNode.next != null) {
				pNode = pNode.next;
			}
			if (pNode.data == s) {
				System.out.println(pNode.data);
				return;
			}
		}
		System.out.println("not found");
	}
	
	//怎么储存，怎么解决冲突，怎么让分布均匀点
	//用于存储数据的节点
	public class Node<T> {
		private T data;
		private Node<T> next;
		public Node (T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		public T getData() {
			return data;
		}
	}
}
