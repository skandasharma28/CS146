package Lab3;

public class isValid 
{
	public static boolean isValidBST(TreeNode root)
	{
		
		if(root == null)
		{
			return true;
		}
		
		if( root.left == null  || root.right == null)
		{
			return true;
		}
		
		if(root.left.val < root.val && root.right.val > root.val)
		{
			 isValidBST(root.left);
			 isValidBST(root.right);
		}
		
		return false;
	}

	public static void main(String[] args) 
	{
        // Example usage
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        
        System.out.println("Result : " +isValidBST(root));
	}
	
}
