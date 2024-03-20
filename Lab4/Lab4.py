
class TreeInverter:
    def invertTree(self, root):
        if root is None:
            return None
        
        # Swapping Left and Right sub trees
        temp = root.left
        root.left = self.invertTree(root.right)
        root.right = self.invertTree(temp)
        
        return root

    
    
    
    
    
    
    