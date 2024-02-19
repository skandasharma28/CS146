package Lab2;

import java.util.Arrays;

public class isAnagram 
{
	public static boolean isAnagram(String s, String t)
	{
		s= s.toLowerCase();
		t = t.toLowerCase();
		
		 s = s.replace(" ", "").replace("-", "").replace("+", "").replace("!", "").replace(",", "").replace(".","").replace("?", "").replace("'", "");
		 t = t.replace(" ", "").replace("-", "").replace("+", "").replace("!", "").replace(",", "").replace(".","").replace("?", "").replace("'", "");
		
		char [] sArray = s.toCharArray();
		char [] tArray = t.toCharArray();
		
		if(sArray.length != tArray.length)
		{
			return false;
		}
		
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		return (Arrays.equals(sArray, tArray));
		
		
	}
	
	public static void main(String[]args)
	{
		System.out.println(isAnagram("cat", "tacc"));
		System.out.println(isAnagram("Tea", "Eat"));
		System.out.println(isAnagram("Tea  '.?", "eat"));
		System.out.println(isAnagram("I'll make a wise phrase", "William Shakespeare"));
	}

}
