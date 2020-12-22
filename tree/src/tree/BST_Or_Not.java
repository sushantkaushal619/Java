package tree;

public class BST_Or_Not 
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
		
		System.out.print(isBST(root));	
	}
	static Node prev=null;
	public static boolean isBST(Node root) {
		if(root==null)
			return true;
		if(!isBST(root.left))
			return false;
		if(prev!=null && prev.data>root.data)
			return false;
		
		prev= root;
		
		return isBST(root.right);
		
	}

}
