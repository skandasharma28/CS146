package Hw10;

import java.util.*;

public class LevelOrderTraversal 
{

    public List<List<Integer>> levelOrder(TreeNode root) 
    {
    	
    	List <List<Integer>> result = new ArrayList<>();
    	
    	if(root == null)
    	{
    		return result;
    		
    	}
    	
    	Queue <TreeNode> q = new LinkedList <>();
  
    	q.offer(root);
    	
    	while(!q.isEmpty())
    	{
    		List <Integer> currentLevel = new ArrayList <>();
 
    		int size = q.size();
    
    		for(int i = 0; i < size; i++)
    		{
    			TreeNode current = q.poll();
    			
    			currentLevel.add(current.val);
    			
    			if(current.left!= null)
    			{
    				q.offer(current.left);
    			}
    			
    			if(current.right!= null)
    			{
    				q.offer(current.right);
    			}
    			
    		}
    		
    		result.add(currentLevel);
    	}

		return result;
    }
    		
		
//    public static void main(String[] args) {
//        // Example usage:
//        // Create the tree as given in the test case
//        TreeNode root = new TreeNode(400);
//        root.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.right = new TreeNode(8);
//        root.left.left = new TreeNode(1);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(9);
//        root.right.right.right = new TreeNode(900);
//
//        LevelOrderTraversal solution = new LevelOrderTraversal();
//        List<List<Integer>> levelOrderTraversal = solution.levelOrder(root);
//
//        System.out.println(levelOrderTraversal);
//    }
}