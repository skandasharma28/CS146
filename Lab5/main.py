def is_valid_bst(root):
    def in_order(node, lst):
        if node is None:
            return
        in_order(node,lst)
        lst.append(node.val)
        in_order(node,lst)
        
        
    lst = []
    in_order(root, lst)
    
    for i in range(len(lst) - 1):
        if lst[i] > lst[i + 1]:
            return False
    return True