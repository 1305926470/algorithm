package graph;


import java.util.LinkedList;
//拓扑排序
public class Topology {
	public static void main(String[] args) {
		Topology t = new Topology();
		t.test();
	}
	
	public void test() {
		//{0,1,2,3,4,5,6,7,8} 8个任务
		Graph g = new Graph(9);
		//添加依赖关系
		g.addEdge(5, 2);
		g.addEdge(0, 2);
		g.addEdge(8, 2);
		g.addEdge(2, 6);
		g.addEdge(6, 4);
		g.addEdge(1, 3);
		g.addEdge(7, 3);
		g.addEdge(3, 5);
		topoSortByKahn(9, g);
	}
	
	//拓扑排序，Kahn算法  0->1->7->8->3->5->2->6->4
	public void topoSortByKahn(int v, Graph g) {
		//用于统计每个点的入度
		int[] inDegree = new int[v];
		for (int i = 0; i < v; i++) {
			//统计每个点的入度
			for (int j = 0; j < g.adj[i].size(); j++) {
				int w = g.adj[i].get(j);
				inDegree[w]++;
			}
		}
		
		//把入度为零的点放入队列
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (inDegree[i] == 0)
				queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			//删除入度为0的点
			int i = queue.remove();
			System.out.print("->" + i);
			//同时，把指向的点入度减1
			for (int j = 0; j < g.adj[i].size(); j++) {
				int w = g.adj[i].get(j);
				inDegree[w]--;
				if (inDegree[w] == 0)
					queue.add(w);
			}
		}
	}
		
	public class Graph {
		private int v;	//顶点数
		private LinkedList<Integer> adj[]; //邻接表实现图
		
		public Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];	//初始化每个顶点
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}
		
		//任务s先于t执行
		//添加一个依赖(边)顶点s指向t，t的入度增加1，
		public void addEdge(int s, int t) {
			adj[s].add(t);
		}
		
	}
}
