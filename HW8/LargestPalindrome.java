package Hw8;
import java.util.*;

public class LargestPalindrome 
{
	public int longestPalindrome(String s) 
	{
		int longest = 0; //The return integer initialized to 0
		int onceOnly = 0; //# of characters that only occur once
		
		char [] charArray = new char[s.length()];
		charArray = s.toCharArray();
		
		HashMap <Character, Integer> hashy = new HashMap <>();
		
		for (char c : charArray)
		{
			if(!hashy.containsKey(c))
			{
				hashy.put(c, 1); //Adds a new hashMap entry for each new char with frequency(value) of 1
			}
			
			else
			{
				int freq = hashy.get(c);
				hashy.put(c,freq +1); //If the char was already there, frequency is incremented
			}
		}
		
        Set<Character> keySet = hashy.keySet();
        
		for(char c: keySet) //Traverse through all the keys of the HashMap
		{
			int count = hashy.get(c);
			
			if(count > 1) //If a char has been repeated more than once, it is eligible to be part of the palindrome
			{
				longest = longest + count; // Its frequency is added to longest possible palindrome length
			}
			
			else
			{
				onceOnly ++; //Increments the # of single occurrences
				
			}
		}
		
		if(longest % 2 == 0 && onceOnly > 1) //Give the palindrome is even and there is at least 1 single char
		{
			longest++; // For example: Radar, although d only occurs once, it can be a part of the palindrome because total count without d is even
			
		}
		
		return longest;
    }
	
	public static void main(String[] args)
	{
		LargestPalindrome test = new LargestPalindrome();
		System.out.println(test.longestPalindrome("abccccdd")); //should return 7
		System.out.println(test.longestPalindrome("speediskey")); //should return 5
		System.out.println(test.longestPalindrome("")); //should return 0
		System.out.println(test.longestPalindrome("abcdeeffggh")); // should return 11
		
		
		
	}
	

}
