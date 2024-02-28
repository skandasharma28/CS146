class LargestPalindrome:
    def longestPalindrome(self, s):
        longest = 0
        onceOnly = 0
        charArray = list(s)
        hashy = {}
        
        for c in charArray:
            if c not in hashy:
                hashy[c] = 1
                
            else:
                freq = hashy[c]
                hashy[c] = freq + 1
                
        for c in hashy:
            count = hashy [c]
            
            if count > 1:
                longest = longest + count
                
            else:
                onceOnly = onceOnly + 1
                
        if longest % 2 == 0 and onceOnly > 1:
            longest = longest + 1
        
        return longest
    
        
test = LargestPalindrome()
print(test.longestPalindrome("abccccdd"))  # should return 7
print(test.longestPalindrome("speediskey"))  # should return 5
print(test.longestPalindrome(""))  # should return 0
print(test.longestPalindrome("abcdeeffggh"))  # should return 7
        
    
    
    
    