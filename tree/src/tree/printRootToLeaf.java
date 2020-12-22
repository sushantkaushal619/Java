package tree;

public class printRootToLeaf 
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
		
		int arr[]=new int[10];
		int index=0;
		print_Root_To_Node(root,arr,index);
		
	}
	public static void print_Root_To_Node(Node root, int arr[],int index)
	{
		if(root==null)
			return;
		
		arr[index]=root.data;
		
		if(root.left==null && root.right==null)//if leaf node , print it
			printArray(arr,index);
		
		print_Root_To_Node(root.left, arr, index+1);
		print_Root_To_Node(root.right, arr, index+1);
		
	}
	public static void printArray(int arr[],int index)
	{
		for(int i=0;i<=index;i++)
			System.out.print(arr[i]+" ");
		
		System.out.println();
	}

}
