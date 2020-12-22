package tree;

public class BST_To_DLL 
{
	static Node head=null,prev=null;
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(1);
		root.left.right=obj.createNode(6);
		root.left.right.left=obj.createNode(5);
		root.left.right.right=obj.createNode(11);
		root.right.right=obj.createNode(9);
		root.right.right.left=obj.createNode(4);
		
		bstToDLL(root);	
		while(head!=null)
		{
		System.out.print(head.data+" ");
		head=head.right;
		}
	}
	public static void bstToDLL(Node root)
	{
		if(root==null)
			return;
		bstToDLL(root.left);
		if(prev==null)
		{
			head=root;
			prev=root;
		}
		else
		{
		prev.right=root;
		root.left=prev;
		prev=root;
		}
		
		bstToDLL(root.right);
	}
	

}
