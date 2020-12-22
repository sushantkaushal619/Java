package tree;

public class find_all_ancestor 
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
		//printAncestor(root,7);
		Node resNode=printSibling(root, 4);
		if(resNode==null)
			System.out.print("Null");
		else {
			System.out.print(resNode.data);	
		}
	}
	public static boolean printAncestor(Node root,int target)
	{
		if(root==null)
			return false;
		if(root.data==target)
		{
			//System.out.print(root.data+" ");
			return true;
		}
		if(printAncestor(root.left, target) || printAncestor(root.right, target))
		{
			System.out.print(root.data+" ");
			return true; //if we write false here it will print parent only.
		}
		return false;
		
	}
	
	//print the sibling
	public static  Node printSibling(Node root,int key) {
		if(root==null || root.data==key )
		{
			return null;
		}
		
		if(root.left!=null && root.left.data==key)
		{
			return root.right;
		}
		if(root.right!=null && root.right.data==key)
		{
			return root.left;
		}
		Node l=printSibling(root.left, key);
		if(l!=null)
			return l;
		
		l=printSibling(root.right, key);
		return l;
		
	}

}
