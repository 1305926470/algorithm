package search;

import java.util.Random;


/**
 * @description 跳跃表
 * @author xingxing
 * @Date 2019-04-19
 *
 */
public class SkipList {
	private static final int MAX_LEVEL = 16;  //跳表最大高度
	private int levelCount = 1;
	private Node head = new Node();
	private Random r = new Random();
	
	//层数随机产生
	private int randomLevel() {
		int level = 1;
		for (int i = 1; i < MAX_LEVEL; i++) {
			if (r.nextInt() % 2 == 1) {
				level++;
			}
		}
		return level;
	}
	
	
	public void insert(int value) {
		Node newNode = new Node();
		newNode.data = value;
		int level = randomLevel();
		newNode.maxLevel = level;
		Node pNode = head;
		int i;
		//插入节点涉及更新的节点
		Node[] toUpdateNode = new Node[level];
		
		//第一个节点，需把head节点放入toUpdateNode，
		for (i = 0; i < level; i++) {
			toUpdateNode[i] = head;
		}
		
		//找到需要更新的节点，即每层刚好小于newNode值的节点
		for (i = 0; i < level; i++) {
			while (pNode.forwords[i] != null && pNode.forwords[i].data < value) {
				pNode = pNode.forwords[i];
			}
			toUpdateNode[i] = pNode;
		}
		
		//插入新节点
		for (i = 0; i < level; i++) {
			newNode.forwords[i] = toUpdateNode[i].forwords[i];
			toUpdateNode[i].forwords[i] = newNode;
		}
		
		//更新调表当前高度
		if (level > levelCount)
			levelCount = level;	
	}
	
	//根据值查找节点
	public void find(int target) {
		int i;
		Node pNode = head;
		//从最高层一次往下找
		for (i = levelCount - 1; i >= 0; i-- ) {
			//找出每层比target刚好小的节点，然后跳到下一层继续寻找
			while (pNode.forwords[i] != null && pNode.forwords[i].data < target) {
				pNode = pNode.forwords[i];
			}
		}
		
		if (pNode.forwords[0].data == target)
			System.out.println(pNode.forwords[0]);
		else
			System.out.println("not found");
	}
	
	
	//删除特定的节点
	public void delete(int target) {
		//先找到要删除的节点,再删除
		int i;
		Node pNode = head;
		//从最高层一次往下找
		for (i = levelCount - 1; i >= 0; i-- ) {
			//找出每层比target刚好小的节点，然后跳到下一层继续寻找
			while (pNode.forwords[i] != null && pNode.forwords[i].data < target) {
				pNode = pNode.forwords[i];
			}
		}
		
		//后面节点覆盖前一个节点（删除）
		if (pNode.forwords[0].data == target) {
			pNode.forwords = pNode.forwords[0].forwords;
		} else {
			System.out.println("not found");
		}
	}
	
	//打印出所有节点
	public void printAll() {
		Node pNode = head;
		while (pNode != null && pNode.forwords[0] != null) {
			pNode = pNode.forwords[0];
			System.out.println(pNode);
		}
	}
	
	public class Node {
		private int data = -1;
		private Node forwords[] = new Node[MAX_LEVEL];
		private int maxLevel = 0;
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
		    builder.append("{ data: ");
		    builder.append(data);
		    builder.append("; levels: ");
		    builder.append(maxLevel);
		    builder.append(" }");
		    return builder.toString();
		}	
	}
}
