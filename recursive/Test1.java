package recursive;


public class Test1 {
	Node head;
	
	
	
	
	
	public static void main(String[] args) {
		
		Test1 test = new Test1();
		test.head = test.init(5);
		System.out.println(test.getData());
		System.out.println(test.getData());
		System.out.println(test.getData());
		System.out.println(test.getData());
		System.out.println(test.getData());
		System.out.println(test.getData());
	}
	
	
	
	//给一个数n，打印出全排列的所有情况
	//如 n=3; 则 1,2,3;  1,3,2; 2,1,3;  2,3,1;  3,1,2;  3,2,1
	public static void f4(int m, int n) {
		int i;
		int k = n;
		StringBuilder str = new StringBuilder();
		str.append(m);
		str.append(", ");
		if (n <= 1) {
			System.out.println(str.toString());
			return;
		}
		
		for(i = 1; i <=n; i++) {
			f4(n, k - 1);
		}
	}
	
	public static void f5(int[] a, int n) {
		int i;
		for(i = 1; i <=n; i++) {
//			for ()
		}
	}
	
	
	//从数组a中取出下标index的数，后面的数填补空缺
	public Node init(int n) {
		Node newNode = new Node(1, null);
		Node head = newNode;
		Node pNode = head;
		int i;
		for (i = 2; i <= n; i++) {
			pNode.next = new Node(i, null);
			pNode = pNode.next;
		}
		return head;
	}
	
	class Node {
		public int data;
		Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public void printAll(Node head) {
		Node pNode = head;
		while (pNode != null) {
			System.out.print(pNode.data);
			System.out.print(",");
			pNode = pNode.next;
		}
	}
	
	public int getData() {
		if (head == null) {
			return 0;
		}
		int ret = head.data;
		head = head.next;
		return ret;
	}
	
	
	
	

}
