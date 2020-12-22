package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map;

import javax.swing.RootPaneContainer;

public class leftview 
{
	static int maxlevel=0,minlevel=0;
	
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(2);
		root.left.right=obj.createNode(6);
		root.left.right.left=obj.createNode(5);
		root.left.right.right=obj.createNode(11);
		root.right.right=obj.createNode(9);
		root.right.right.left=obj.createNode(4);
	    
//		left(root,0);
//		right(root, 0);
//		findlevel(root, 2, 1);
//		topView(root);
//	    bottomView(root);
//printBoundary(root);
	printVerticalOrder(root);
		
	}
	
	//print left view of tree
	public static void left(Node root,int level)
	{
		if(root==null)
			return;
		if(level>=maxlevel)
		{
			System.out.print(root.data+" ");
			maxlevel++;
		}
		left(root.left, level+1);
		left(root.right, level+1);
	}
	
	//Print right view of tree
	public static void right(Node root,int level)
	{
		if(root==null)
			return;
		if(level>=maxlevel)
		{
			System.out.print("right" + root.data+" ");
			minlevel++;
		}
		right(root.right, level+1);
		right(root.left, level+1);
		
	}
	
	//find level of given node
	public static void findlevel(Node root,Integer value,int level)
	{
		if(root==null)
			return ;
		if(root.data==value)
			System.out.println("Level is: " +level);
		
		findlevel(root.left, value, level+1);
		findlevel(root.right, value, level+1);
	}
	
	//print TOP view
	public static void topView(Node root)
	{
		if(root==null)
			return;
		class tmpNode
		{
			Node node;
			int height;
			tmpNode(Node node,int height)
			{
				this.node=node;
				this.height=height;
			}
		}
		Queue<tmpNode> q=new LinkedList<tmpNode>();
		TreeMap<Integer, Integer> treeMap= new TreeMap<Integer, Integer>();
		q.add(new tmpNode(root, 0));
		
		while(!q.isEmpty())
		{
			tmpNode temp=q.remove();
			if(!treeMap.containsKey(temp.height))
			{
				treeMap.put(temp.height, temp.node.data);
			}
			if(temp.node.left!=null)
			{
				q.add(new tmpNode(temp.node.left, temp.height-1));
			}
			if(temp.node.right!=null)
			{
				q.add(new tmpNode(temp.node.right, temp.height+1));
			}
		}
		System.out.print("Values"+ treeMap.values());
	}
	
	//print Bottom view
	public static void bottomView(Node root) 
	{
		if(root==null)
			return;
		class tmpNode
		{
			Node node;
			int height;
			tmpNode(Node node,int height)
			{
				this.node=node;
				this.height=height;
			}
		}
		Queue<tmpNode> q=new LinkedList<tmpNode>();
		TreeMap<Integer, Integer> treeMap= new TreeMap<Integer, Integer>();
		q.add(new tmpNode(root, 0));
		
		while(!q.isEmpty())
		{
			tmpNode temp=q.remove();
			if(!treeMap.containsKey(temp.height))
			{
				treeMap.put(temp.height, temp.node.data);
			}
			else 
			{
				treeMap.put(temp.height, temp.node.data);
			}
			if(temp.node.left!=null)
			{
				q.add(new tmpNode(temp.node.left, temp.height-1));
			}
			if(temp.node.right!=null)
			{
				q.add(new tmpNode(temp.node.right, temp.height+1));
			}
		}
		System.out.print("Values"+ treeMap.values());
		
	}
	
	//print boundary Nodes
	public static void printBoundary(Node root)
	{
		if(root!=null)
			System.out.print(root.data+" ");
		printBoundaryLeft(root.left);
	    printLeafNode(root.left);
	    printLeafNode(root.right);
	    printBoundaryRight(root.right);
		
	}
	public static void printBoundaryLeft(Node root)
	{
		if(root==null)
			return;
		if(root.left!=null)
		{
			System.out.print(root.data+" ");
			printBoundaryLeft(root.left);
		}
		else if (root.right!=null) {
			System.out.print(root.data+" ");
			printBoundaryLeft(root.right);
		}
		
	}
	//print leaf node
		public static void printLeafNode(Node root) {
			if(root==null)
				return;
			
			if(root.left==null && root.right==null )
				System.out.print( root.data+" ");
			printLeafNode(root.left);
			printLeafNode(root.right);

		}
		public static void printBoundaryRight(Node root)
		{
			if(root==null)
				return;
			if(root.right!=null)
			{
				printBoundaryLeft(root.right);
				System.out.print(root.data+" ");
				
			}
			else if (root.left!=null) {
				System.out.print(root.data+" ");
				printBoundaryLeft(root.left);
			}
			
		}
	
	public static void printVerticalOrder(Node root)
	{
		if (root == null) {
		      return;
		    }
		    int hd = 0;
		    
		TreeMap<Integer, ArrayList<Integer>> t= new TreeMap<Integer, ArrayList<Integer>>();
		getVerticalOrder(root,hd,t);
		
//		for (Map.Entry<Integer, ArrayList<Integer>> cm : t.entrySet()) {
//		      System.out.println(cm.getValue());
//		    }
		System.out.print("Values"+ t.values());
	}
	public static void getVerticalOrder(Node root,int height,TreeMap<Integer, ArrayList<Integer>> t)
	{
		if(root==null)
			return;
		if(t.get(height)==null)
		{
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(root.data);
			t.put(height, l);
		}
		else {
			ArrayList<Integer> l=t.get(height);
			l.add(root.data);
			t.put(height, l);
		
		}
		getVerticalOrder(root.left, height-1, t);
		getVerticalOrder(root.right, height+1, t);
		
	}

}
