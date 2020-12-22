package tree;



public class Sum_of_all_nodes 
{
	
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node head=null,temp=null;
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(2);
		root.left.right=obj.createNode(6);
		root.left.right.left=obj.createNode(5);
		root.left.right.right=obj.createNode(11);
		root.right.right=obj.createNode(9);
		root.right.right.left=obj.createNode(4);
		
		int sum=sumOfAllNodes(root);	
		System.out.print(sum);
	}
	public static int sumOfAllNodes(Node root) 
	{
		if(root==null)
			return 0;
		
		return root.data+sumOfAllNodes(root.left)+sumOfAllNodes(root.right);
		
		
	}
	
}
