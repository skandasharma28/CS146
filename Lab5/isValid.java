package Lab3;

import java.util.ArrayList;
import java.util.List;

public class isValid 
{
	public static boolean isValidBST(TreeNode root)
	{
		List <Integer> list2 = new ArrayList<>();
		
		inOrder(root, list2);
		
		for(int i = 0; i< list2.size() - 1; i++)
		{
			if(list2.get(i) >= list2.get( i + 1))
			{
				return false;
			}
		}
		
		return true; 
		
	}
	
	private static void inOrder(TreeNode root, List<Integer> list)
	{
		
		if(root == null)
		{
			return ;
	
		}
		
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
		
		
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
        
        TreeNode root2 = new TreeNode(50);
        root2.left = new TreeNode(40);
        root2.left.left = new TreeNode (35);
        root2.left.right = new TreeNode(49); 
        root2.right = new TreeNode(55);
        root2.right.left = new TreeNode (60); //WRONG NODE, should return false
        root2.right.right = new TreeNode(100);
        
        
        
        List <Integer> empty = new ArrayList <>();
        
        inOrder(root, empty);
        System.out.println("Sorted BST" + empty.toString());
        System.out.println(isValidBST(root)); //TEST 1 -- should return true
        
        
        List <Integer> empty2 = new ArrayList <>();
        inOrder(root2, empty2);
        System.out.println("Sorted BST" + empty2.toString());
        System.out.println(isValidBST(root2)); //Test 2 -- should return false
        
	}
	
}
