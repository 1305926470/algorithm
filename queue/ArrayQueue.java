package queue;

//用数组实现的队列
public class ArrayQueue {
	private String[] items;
	private int n = 0;
	private int head = 0;
	private int tail = 0;
	
	//用数组初始化一个队列
	public ArrayQueue(int capacity) {
		items = new String[capacity];
	}
	
	//入队, 时间复杂度是多少？
	public boolean enqueue(String item) {
		if (tail == n) {
			if (head == 0)
				return false; //队列已满
			//把数据往前搬移, tail位置不存数据
			for (int i = head; i < tail; i++) {
				items[i - head] = items[i];
			}
			tail = tail - head;
			head = 0;
		}
		items[++tail] = item;
		return true;
	}
	
	//出队
	public String dequeue() {
		if (head == tail)
			return null;
		return items[head++];
	}
	
	
	
}
