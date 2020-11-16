package linkedlist;



/**
 * @date 2019-04-16
 * @author xingxing
 *
 */
public class LinkedListAlgo {
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
	
	
	//单链表反转(把链表头变成尾，尾变成头)
	public static Node reverse(Node list) {
		Node curr, pre, next;
		curr = list;
		pre = list;
		while (curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
	
	//链表环检测
	public static boolean checkCircle(Node list) {
		if (list == null)
			return false;
		Node fast = list.next, slow = list;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow)
				return true;
		}
		return false;
	}
	
	//有序链表合并
	public static Node mergeSortedList(Node la, Node lb) {
		if (la == null)
			return lb;
		if (lb == null)
			return la;
		
		Node head;
		Node p = la;
		Node q = lb;	
		//头节点还是要单独处理
		if (p.data < q.data) {
			head = p;
			p = p.next;
		} else {
			head = q;
			q = q.next;
		}
		
		Node r = head;
		
		while (p != null && q != null) {
			if (p.data < q.data) {
				r.next = p;
				p = p.next;
			} else {
				r.next = q;
				q = q.next;
			}
			r = r.next;
		}
		
		if (p != null) {
			r.next = p;
		}
		if (q != null) {
			r.next = q;
		}
		
		return head;
	}
	
	//删除链表倒数第K个节点 count = n + ( count - n)
	public static Node deleteLastKth(Node list, int k) {
		Node fast, slow, pre;
		
		fast = list;
		slow = list;
		int i = 0;
		while (fast != null && i < k) {
			fast = fast.next;
			i++;
		}
		
		if (fast == null)
			return list;
		pre = null;
		while (fast != null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		
		if (pre == null) {
			list = list.next;
		} else {
			pre = pre.next.next;
		}
		return list;
	}
	
	//删除链表中间节点 (fast每次两步。slow每次一步，fast到头，slow刚好走一半)
	public static Node findMidNode(Node list) {
		if (list == null) 
			return null;
		Node fast = list;
		Node slow = list;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
