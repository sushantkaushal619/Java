package tree;

import java.util.Stack;

public class SpiralView 
{
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
		
		spiralView(root);	
	}
	public static void spiralView(Node root)
	{
		if(root==null)
			return;
		Stack<Node> s1=new Stack<Node>();
		Stack<Node> s2=new Stack<Node>();
		s1.push(root);
		
	while(!s1.isEmpty() || !s2.isEmpty())
	{
		while(!s1.isEmpty())
		{
			Node temp=s1.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
			{
				s2.push(temp.right);
			}
			if(temp.left!=null)
			{
				s2.push(temp.left);	
			}
			
		}
		System.out.println();
		
		
		while(!s2.isEmpty())
		{
			Node temp=s2.pop();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
			{
				s1.push(temp.left);
			}
			if(temp.right!=null)
			{
				s1.push(temp.right);
			}
		}
		System.out.println();
		
	  }	
	}

}
