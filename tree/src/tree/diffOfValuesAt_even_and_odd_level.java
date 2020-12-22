package tree;

public class diffOfValuesAt_even_and_odd_level 
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
		
		diff(root,1);	
	}
	public static void diff(Node root,int level) 
	{
		
		if(root==null)
			return ;
		if(level==1)
		{
			System.out.print(root.data+" ");
			return ;
		}
		 diff(root.left,level-1);
		 diff(root.right, level-1);
	}
}
