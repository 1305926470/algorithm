package queue;

//数组实现循环队列
public class CircularQueue {
	private String[] items;
	private int n = 0;
	private int head = 0;
	private int tail = 0;
	private int capacity = 0;
	
	//用数组初始化一个队列
	public CircularQueue(int capacity) {
		items = new String[capacity];
		this.capacity = capacity;
	}
	
	//入队, 需要重点关注队列满和空的边界条件
	public boolean enqueue(String item) {
		if ( (tail + 1) % capacity == head )
			return false; // 队列满
		items[tail++] = item;
		tail = tail % capacity;		
		return true;
	}
	
	//出队
	public String dequeue() {
		if (head == tail)  //队列为空
			return null;
		String ret;
		ret = items[head];
		head ++;
		head = head % capacity;
		return ret;
	}
}
