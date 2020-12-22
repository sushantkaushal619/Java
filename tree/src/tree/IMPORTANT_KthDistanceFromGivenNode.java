package tree;

public class IMPORTANT_KthDistanceFromGivenNode 
{
	public static void main(String args[])
	{
		BinaryTree obj=new BinaryTree();
		Node root=obj.createNode(2);
		root.left=obj.createNode(7);
		root.right=obj.createNode(5);
		root.left.left=obj.createNode(8);
		root.left.right=obj.createNode(6);
		root.left.right.left=obj.createNode(1);
		root.left.right.right=obj.createNode(11);
		root.right.right=obj.createNode(9);
		root.right.right.left=obj.createNode(4);
		Node target=root.left;
		int k=1;
		int res=kth_Distance_fromGivenNode(root,target,k);
		if(res==-1)
			System.out.print("No elemnts found");
	}
	static int kth_Distance_fromGivenNode(Node root,Node target,int k)
	{
		if(root==null || target==null || k<0)
			return -1;
		
		if(root.data==target.data)
		{
			printLevelFromTarget(root,k);
			return 0;
		}
		int leftDist=kth_Distance_fromGivenNode(root.left, target, k);
		
		if(leftDist!=-1)
		{
			if(leftDist+1==k)
				System.out.print(root.data+" ");
			else {
				printLevelFromTarget(root.right, k-2-leftDist);
			}
			return leftDist+1;
		}
		
       int rightDist=kth_Distance_fromGivenNode(root.right, target, k);
		
		if(rightDist!=-1)
		{
			if(rightDist+1==k)
				System.out.print(root.data+" ");
			else {
				printLevelFromTarget(root.left, k-2-rightDist);
			}
			return rightDist+1;
		}
		return -1;
		
	}
	
	static void printLevelFromTarget(Node root,int k)
	{
		if(root==null)
			return;
		if(k==0)
		{
			System.out.print(root.data+" ");
		}
		printLevelFromTarget(root.left, k-1);
		printLevelFromTarget(root.right, k-1);	
	}
	
	
}
