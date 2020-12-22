package tree;


public class practice 
{
	public Node createNode(int data)
	{
		Node obj=new Node();
		obj.data=data;
		obj.left=null;
		obj.right=null;
		return obj;
	}
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
		
		preorder(root);
//		postorder(root);
	  //inorder(root);	
	}
	public static void preorder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	public static void postorder(Node root)
	{
		if(root==null)
			return;
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	public static void inorder(Node root)
	{
		preorder(root.left);
		System.out.print(root.data);
		preorder(root.right);	
	}
}
