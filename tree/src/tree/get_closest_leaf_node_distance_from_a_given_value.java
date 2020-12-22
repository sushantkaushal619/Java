package tree;

public class get_closest_leaf_node_distance_from_a_given_value 
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
		int value=2;
		System.out.print(getClosestDiastanceFromLeaf(root,value));	
	}

	public static int getClosestDiastanceFromLeaf(Node root,int value){
		
		if(root==null)
			return Integer.MAX_VALUE;
		Node arr[]=new Node[10];
		return getClosestDiastanceFromLeafUtil(root,arr,value,0);
	}
	public static int getClosestDiastanceFromLeafUtil(Node root,Node arr[],int value,int level)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		
		int minDist=Integer.MAX_VALUE;
		if(root.data==value)
		{
			minDist=getLevel(root);
			for(int i=level-1;i>=0;i--)
			{
				minDist =Math.min(minDist,level-i+getLevel(arr[i]));
			}
			return minDist;
		}
		arr[level]=root;
		minDist=Math.min(minDist,getClosestDiastanceFromLeafUtil(root.left, arr, value, level+1));
		
		if(minDist!=Integer.MAX_VALUE)
			return minDist;
		return Math.min(minDist,getClosestDiastanceFromLeafUtil(root.right, arr, value, level+1));	
	}
	public static int getLevel(Node root)
	{
		if(root==null)
			return Integer.MAX_VALUE;
		if(root.left==null && root.right==null)
			return 0;
		
		return 1+Math.min(getLevel(root.left),getLevel(root.right));
	}
	
}
