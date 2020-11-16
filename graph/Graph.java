package graph;

import java.util.LinkedList;
import java.util.Queue;

//无向图
public class Graph {
	private int v; //顶点数
	private LinkedList<Integer> adj[]; //邻接表,存储相邻节点
	boolean found = false;
	
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int s, int t) {
		adj[s].add(t);
		adj[t].add(s);
	}
	
	//广度优先搜索, 从顶点s开始到t的路径
	public void bfs(int s, int t) {
		if (s == t) return;
		
		//记录已访问点解, visited[s]=true;表示s已访问过
		boolean[] visited = new boolean[v];		
		Queue<Integer> queue = new LinkedList<>();	//记录已访问，但是还需要通过该点往后搜索的点
		queue.add(s);
		int[] prev = new int[v];	//用于记录到达该节点的来源节点
		
		for (int i = 0; i < v; i++) {//初始化
			prev[i] = -1;
		}
		
		while (queue.size() != 0) {
			int w = queue.poll();	//从待方访问的队列中取出一个点
			for (int i = 0; i < adj[w].size(); i++) {
				int q = adj[w].get(i);	//遍历w点的邻接点表
				if (!visited[q]) {
					
					prev[q] = w;	//记录来到p点的前一个点w
					if (q == t) {
						//找到时，打印出来
						print(prev, s, t);
						return;
					}
					visited[q] = true;	//更新q点的访问状态
					queue.add(q);
				}
			}
		}
		
	}
	
	//深度优先遍历
	public void dfs(int s, int t) {
		found = false;
		boolean[] visited = new boolean[v];
		int[] prev = new int[v];	//用于记录到达该节点的来源节点
		for (int i = 0; i < v; i++) {//初始化
			prev[i] = -1;
		}
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}
	
	//递归遍历（深度搜索）
	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		if (found) return;	//退出递归条件
		if (w == t) {
			found = true;
		}
		visited[w] = true;
		for (int i = 0; i < adj[w].size(); i++) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q, t, visited, prev);
			}
		}
	}
	
	//递归打印s到t的路径
	private void print(int[] prev, int s, int t) {
		if (s == t) {
			System.out.print(s);
			return;
		}
		print(prev, s, prev[t]);
		System.out.print(", ");
		System.out.print(t);
	}
	
}
