package tree;

public class Node
{
	int data;
	Node left;
	Node right;
}
class BinaryTree
{
	public Node createNode(int data)
	{
		Node obj=new Node();
		obj.data=data;
		obj.left=null;
		obj.right=null;
		return obj;
	}
	
}