package tree;

public class LCA 
{
	static boolean isn1=false;
	static boolean isn2=false;
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
		int n1=8,n2=4;
		Node resNode=check(root, n1,n2);
		if(resNode==null)
			System.out.print("Keys not exit");
		else {
			//System.out.println(resNode.data);  //upto here lca is calculated
			int left=distance_from_LCA(resNode,0,n1); //line 25,26,27 is used to calc distance 
													// b/w two given node using lca.
			int right=distance_from_LCA(resNode,0,n2);
			System.out.println(left+right);
		}
	}
	
	public static Node check(Node root,int n1,int n2)
	{
		Node res=lca(root, n1, n2);
		if(isn1 && isn2) //if both  n1 and n2 are   found
		{
			return res;
		}
		
		return null;
		
	}
	public static Node lca(Node root,int n1,int n2) {

		Node temp=null;
		if(root==null)
			return null;
		
		if(root.data==n1)
		{
			isn1=true;
			temp=root;
		}
		if(root.data==n2)
		{
			isn2=true;
			temp= root;	
		}
		
		Node l=lca(root.left, n1, n2);
		Node r=lca(root.right, n1, n2);
		if(temp!=null)
			return temp;
		
		if(l!=null && r!=null)
			return root;
		
		return (l!=null?l:r);
	}

	static int distance_from_LCA(Node root,int dist,int n)
	{
		if(root==null)
			return -1;
		if(root.data==n)
		{
			return dist;
		}
		int d=distance_from_LCA(root.left, dist+1,n);
		if(d!=-1)
			return d;
		d=distance_from_LCA(root.right, dist+1,n);
		return d;
		
		
		
		
	}
	
}

