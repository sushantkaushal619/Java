package graphh;

import java.util.ArrayList;

public class AdjList_Using_ArrayList 
{
	int vertices;
	ArrayList<ArrayList<Integer>> adj;
	AdjList_Using_ArrayList(int v)
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
	public static void main(String args[])
	{
		AdjList_Using_ArrayList obj= new AdjList_Using_ArrayList(3);
		obj.addEdge(0, 1);
		obj.addEdge(1, 2);
		obj.addEdge(2,0);
		obj.display();
		
	}
	

}
