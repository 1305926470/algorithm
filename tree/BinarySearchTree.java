package tree;

/**
 * @description 二叉查找树
 * @author xingxing
 * @date 2019-04-20
 */
public class BinarySearchTree {
	Node head;
	
	public boolean insert(int target) {
		Node newNode = new Node(target);
		if (head == null) {
			head = newNode;
		}
		//TODO 重复插入同一个值时
		Node pNode = head;
		
		//找到一个空位置
		while (pNode.right != null && pNode.left != null) {
			if (pNode.data > target) {
				pNode = pNode.left;
			} else {
				pNode = pNode.right;
			}
		}
		
		//插入节点
		if (pNode.right == null)
			pNode.right = newNode;
		if (pNode.left == null)
			pNode.left = newNode;
		return true;
	}
	
	//在特定的二叉查找树中查询特定值
	public int find(Node tree, int target) {
		Node pNode = tree;
		if (pNode.data == target) {
			return pNode.data;
		} else if (pNode.data > target) {
			pNode = pNode.left;
		} else {
			pNode = pNode.right;
		}
		return find(pNode, target);
	}
	
	//前序遍历
	public void scan(Node tree) {
		Node pNode = tree;
		if (pNode.right == null && pNode.left == null) return;
		
		System.out.println(pNode.data);
		scan(pNode.left);
		scan(pNode.right);
	}

	public class Node {
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			this.data = data;
		}
	}
}
