package linkedlist;

public class SinglyLinkedList {
	private Node head = null;

	//根据值寻找节点, 0(n)
	public Node findByValue(int value) {
		Node p = head;
		while (p != null && p.data != value) {
			p = p.next;
		}
		return p;
	}
	
	//根据index查找节点
	public Node findByIndex(int index) {
		Node p = head;
		int pos = 0;
		while (p != null && pos != index) {
			p = p.next;
			pos++;
		}
		return p;
	}
	
	public void insertToHead(int value) {
		Node newNode = new Node(value, null);
		insertToHead(newNode);
	}
	
	
	//在头部插入新节点
	public void insertToHead(Node newNode) {
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	//在链表尾部插入节点，需要先遍历？为毛不来个尾指针
	public void insertTail(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
		} else {
			Node qNode = head;
			while (qNode != null && qNode.next != null) {
				qNode = qNode.next;
			}
			newNode.next = qNode.next;
			qNode.next = newNode;
			
		}
	}
	
	
	public void insertAfter(Node p, int value) {
		Node newNode = new Node(value, null);
		insertAfter(p, newNode);
	}
	
	//特定节点后插入
	public void insertAfter(Node p, Node newNode) {
		if (p.next == null) {
			return;
		} else {
			newNode.next = p.next;
			p.next = newNode;
		}
	}
	
	public void insertBefore(Node p, int value) {
		Node newNode = new Node(value, null);
        insertBefore(p, newNode);
	}
	
	public void insertBefore(Node p, Node newNode) {
		if (p.next == null) 
			return;
		if (p == head) {
			insertToHead(newNode);
			return;
		}
		
		//需要先遍历链表找到前驱节点
		Node qNode = head;
		while (qNode != null && qNode.next != p) {
			qNode = qNode.next;
		}
		
		if (qNode == null)
			return;
		
		newNode.next = p;
		qNode.next = newNode;
	}
	
	//删除节点
	public void deleteByNode(Node p) {
		Node qNode = head;
		while (qNode != null && qNode.next != p) {
			qNode = qNode.next;
		}
		qNode.next = qNode.next.next;
	}
	
	//根据值删除节点
	public void deleteByValue(int value) {
		Node p = head;
		Node preNode = null;
		while (p != null && p.data != value) {
			preNode = p;
			p = p.next;
		}
		
		if (p == null)
			return;
		
		if (preNode == null) {
			head = head.next;
		} else {
			preNode.next = preNode.next.next;
		}
	}
	
	public void printAll() {
		Node p = head;
		if (p != null) {
			System.out.println(p.data);
			p = p.next;
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//链表节点
	public static class Node {
		private int data;
		private Node next;
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
		
		public int getData() {
			return data;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1111);
	}
}

