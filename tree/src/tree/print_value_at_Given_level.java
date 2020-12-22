package tree;

public class print_value_at_Given_level 
{
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
