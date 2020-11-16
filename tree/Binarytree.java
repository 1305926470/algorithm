package tree;

/**
 * @description 二叉树
 * @author xingxing
 *
 */
public class Binarytree {
	//数组存储完全二叉树，即优先从高到低，从左往右存储
	char[] bt = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
	
	public static void main (String[] args) {
		Binarytree binarytree = new Binarytree();
		System.out.println(binarytree.height(1));;
	}
	
	//为了存储方便通常从下标1开始存储；第i个节点存在下标i处，如果父节点为a[i], 则左子节点为a[2*i], 右子节点为a[2*i+1]
	//前序遍历, 从1开始，父节点为第i个，则左子树为第2i个，右子树为第2i+1个
	public void preScan(int i) {
		int n = bt.length;
		if (i-1 >= n || bt[i-1] == '\0') return;
		//先父节点（当前节点）
		System.out.print(bt[i-1]);
		//再左子树节点
		preScan(2*i);
		//最后右子树节点
		preScan(2*i+1);
	}
	
	//中序遍历, 从1开始，父节点为第i个，则左子树为第2i个，右子树为第2i+1个
	public void midScan(int i) {
		int n = bt.length;
		if (i-1 >= n || bt[i-1] == '\0') return;
		//先左子树节点
		midScan(2*i);
		//再父节点（当前节点）
		System.out.print(bt[i-1]);
		//最后右子树节点
		midScan(2*i+1);
	}
	
	//后序遍历, 从1开始，父节点为第i个，则左子树为第2i个，右子树为第2i+1个
	public void afterScan(int i) {
		int n = bt.length;
		if (i-1 >= n || bt[i-1] == '\0') return;
		afterScan(2*i);
		afterScan(2*i+1);
		System.out.print(bt[i-1]);
	}
	
	
	//递归求树的高度 根节点高度=max(左子树高度，右子树高度)+1
	public int height(int i) {
		int n = bt.length;
		if (i-1 >= n || bt[i-1] == '\0') return 0;
		
		int heightLeft = 0;
		int heightRight = 0;
		int height = 0;
		
		heightLeft = height(2*i);
		heightRight = height(2*i+1);
		height = (heightRight > heightLeft ? heightRight : heightLeft) + 1;
		
		return height;
	}
}
