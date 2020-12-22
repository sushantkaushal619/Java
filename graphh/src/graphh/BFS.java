package graphh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS 
{
	int vertices;
	ArrayList<ArrayList<Integer>> adj;
	BFS(int v)
	{
		vertices=v;
		adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<vertices;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int source,int dest)
	{
		adj.get(source).add(dest);
		adj.get(dest).add(source);
	}
	void display()
	{
		for(int i=0;i<vertices;i++)
		{
			if(adj.get(i).size()>0)
			{
				System.out.println("Vertice:" );
				for(int j=0;j<adj.get(i).size();j++)
				{
					System.out.print(adj.get(i).get(j)+" ");
				}
				System.out.println();
			}
		}
	}
	void BFSTraversal(int source) {
		Queue<Integer> q=new LinkedList<Integer>();
		boolean visited[]=new boolean[vertices];
		q.add(source);
		visited[source]=true;
		
		while(q.size()>0)
		{
			int t=q.remove();
			System.out.print(t+" ");
			for(int i=0;i<adj.get(t).size();i++)
			{
				if(!visited[adj.get(t).get(i)])
				{
					visited[adj.get(t).get(i)]=true;
					q.add(adj.get(t).get(i));
				}
			}
		}	
	}
	void dfs(int source)
	{
		Stack<Integer> s= new Stack<Integer>();
		boolean visited[]=new boolean[vertices];
		s.push(source);
		visited[source]=true;
		while(s.size()>0)
		{
			int t=s.pop();
			System.out.print(t+" ");
			for(int i=0;i<adj.get(t).size();i++)
			{
				if(!visited[adj.get(t).get(i)])
				{
					visited[adj.get(t).get(i)]=true;
					s.push(adj.get(t).get(i));	
				}
			}
		}
	}
	public static void main(String args[])
	{
		
		Scanner in=new Scanner(System.in);
		BFS obj= new BFS(5);
		
//		int size=in.nextInt();
//		for(int i=0;i<size;i++)
//		{
//			int source=in.nextInt();
//			int dest=in.nextInt();
//			obj.addEdge(source, dest);
//		}	
		
		obj.addEdge(0, 1);
		obj.addEdge(0,4);
		obj.addEdge(1, 3);
		obj.addEdge(1,2);
		obj.addEdge(2, 3);
		obj.addEdge(3,4);
		
//		obj.BFSTraversal(0);
		obj.dfs(0);
		
	}
	

}
