package Lab3;

public class TreeInverter
{
	  public TreeNode invertTree(TreeNode root)
	  {
		  	
		  if (root == null)
		  {
			  return null;
		  }
		  
		  //Swapping Left and Right sub trees
		  
		  TreeNode temp = root.left;
		  
		  root.left = invertTree(root.right);
		  root.right = invertTree(temp);
		  
		  return root;
	  }
  

}
