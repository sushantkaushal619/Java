package tree;

public class checkLeafAtSameLevel_OrNot 
{
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(2);
		root.left.right=obj.createNode(6);
//		root.left.right.left=obj.createNode(5);
//		root.left.right.right=obj.createNode(11);
//		root.right.right=obj.createNode(9);
//		root.right.right.left=obj.createNode(4);
		int height=getHeight(root);
		
		System.out.print(check(root, height));
	}
	public static boolean check(Node root,int height)
	{
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
		{
			if(height==0)
				return true;
			else {
				return false;
			}
		}
		return check(root.left,height-1)&&check(root.right,height-1);
		
	}
	public static int getHeight(Node root)
	{
		if(root==null)
			return -1;
		if(root.left==null && root.right==null)
			return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}



}
