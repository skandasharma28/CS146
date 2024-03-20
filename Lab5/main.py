class Solution:
    def isValidBST(self, root):
        def in_order(node, lst):
            if node is None:
                return
            in_order(node.left, lst)  # Traverse left subtree
            lst.append(node.val)      # Append current node's value
            in_order(node.right, lst) # Traverse right subtree
            
        lst = []

        in_order(root, lst)
        
        for i in range(len(lst) - 1):
            if lst[i] >= lst[i + 1]: 
                return False
        return True
