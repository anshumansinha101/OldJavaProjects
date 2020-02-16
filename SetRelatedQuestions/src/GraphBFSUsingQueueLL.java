import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFSUsingQueueLL {
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		Node n1 = new Node(22);
		Node n2 = new Node(23);
		Node n3 = new Node(55);
		Node n4 = new Node(66);
		Node n5 = new Node(6);
		
		g.addEdge(n1, n2);
		g.addEdge(n2, n3);
		g.addEdge(n2, n4);
		g.addEdge(n4, n5);
		g.addEdge(n5, n2);
		
		g.bfs(n1);
	}
	
	
	
}
 class Graph 
{
	int size;
	LinkedList<Node> edge[] ;
	public Graph(int size)
	{
		this.size=size;
		edge = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			edge[i] = new LinkedList<Node>();
		}
	}
	
	public void addEdge(Node n1, Node n2)
	{
		if(n1==null || n2 == null)
			System.out.println("N1 or n2 null" + n1 + " and  "+ n2);
		System.out.println("Nodeid : " + n1.nodeid);
		edge[n1.nodeid].add(n2);
	}
	
	public void bfs(Node startNode)
	{
		
		LinkedList<Node> visitor = new LinkedList();
		visitor.add(startNode);
		startNode.visited = true;
		while(!visitor.isEmpty())
		{
			Node currentNode = visitor.poll();
			currentNode.visited = true;
			System.out.println("   " + currentNode.nodeid + " with value " + currentNode.val);
			Iterator<Node> n = edge[currentNode.nodeid].listIterator();
			while(n.hasNext())
			{
				Node t = n.next();
				if(!t.visited)
					visitor.add(t);
			}
		}
		/*
		 * Iterator<Node> n1 = visitor.listIterator(); while(n1.hasNext()) { Node t =
		 * n1.next(); System.out.print("  " + t.val); }
		 */
		
		
	}
}

  class Node 
{
	static int nodeCnt;
	int val;
	boolean visited;
	int  nodeid;
	public Node(int val)
	{
		
		this.nodeid = nodeCnt;
		this.val  = val;
		nodeCnt = nodeCnt + 1;
		System.out.println("Adding node with nodeid:" + nodeid + " and val:" + val);
	}
}