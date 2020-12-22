package tree;

import java.util.ArrayList;

public class SerilizableAndDesilizable 
{
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(8);
		root.left.right=obj.createNode(6);
		root.left.right.left=obj.createNode(1);
		root.left.right.right=obj.createNode(11);
		root.right.right=obj.createNode(9);
		root.right.right.left=obj.createNode(4);
		ArrayList<Integer> aList=new ArrayList<Integer>();
		serilizable(root,aList);
		for(int i=0;i<aList.size();i++)
			System.out.print(aList.get(i)+" ");
		System.out.println();
		Node node=deserilizable(aList);
		practice temp=new practice();
		temp.preorder(node);
	}
	static void serilizable(Node root,ArrayList<Integer> al)
	{
		if(root==null)
		{
			al.add(-1);
			return;
		}
		
		
		al.add(root.data);
		
		serilizable(root.left, al);
		serilizable(root.right, al);
	}
	static int index=0;
	static Node deserilizable(ArrayList<Integer> al)
	{
		if(al.get(index)==-1)
		{
			index++;
			return null;
		}
		Node newNode=createNode(al.get(index++));
		newNode.left=deserilizable(al);
		newNode.right=deserilizable(al);
		return newNode;
	}
	static Node createNode(int data)
	{
		BinaryTree res=new BinaryTree();
		Node temp=res.createNode(data);
		return temp;
		
	}
}
