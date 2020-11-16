package graph;

public class Test {
	public static void main(String[] args) {
		Graph g = new Graph(8);
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 7);
		
		
		g.bfs(0, 7); //搜寻0到7的路径
		System.out.println();
		g.dfs(0, 7); //搜寻0到7的路径
		
	}
}
