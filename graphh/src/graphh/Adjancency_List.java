package graphh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Adjancency_List 
{
	int vertices;
	LinkedList<Integer> adjList[];
	
	public Adjancency_List(int vertices) {
		this.vertices=vertices;
		adjList=new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]=new LinkedList<>();
		}	
	}
	void addEdge(int source,int dest)
	{
		adjList[source].add(dest);
		adjList[dest].add(source);	
	}
	void display()
	{
		for(int i=0;i<vertices;i++)
		{
			if(adjList[i].size()>0)
			{
				System.out.println("Vertice:"+i );
				for(int j=0;j<adjList[i].size();j++)
				{
					System.out.print(adjList[i].get(j)+" ");
				}
				System.out.println();
			}
		}
	}
	public static void main(String args[])
	{
		Adjancency_List obj= new Adjancency_List(3);
		obj.addEdge(0, 1);
		obj.addEdge(1, 2);
		obj.addEdge(2,0);
		obj.display();
		
	}

}
