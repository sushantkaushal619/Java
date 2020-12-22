package tree;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
public class levelOrderTraversal 
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
		levelTraversal(root,2,3);
		
	}
	public static void levelTraversal(Node root,int min,int max) {
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);	
		int l=1;
	while(true)
	{
		int count =q.size();
		
		if(count==0 )
			break;
		while(count>0)
		{
				Node tempNode=q.remove();
				
				if(l >= min && l <= max)
				{
					System.out.print(tempNode.data+" ");
				}
				if(tempNode.left!=null)
				{
					q.add(tempNode.left);
				}
				if (tempNode.right!=null) 
				{
					q.add(tempNode.right);
				}
				count--;
		}
		l++;
		
		}	
	}
}
